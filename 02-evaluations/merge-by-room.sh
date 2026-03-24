#!/bin/bash

####################
# This script merges PDF files by room and exam part
# Author: V. Guidoux with the help of GitHub Copilot and Claude (Anthropic)
# Date: 2026-03-24
####################

# Output directory
output_dir="output"

# Check if output directory exists
if [ ! -d "$output_dir" ]; then
    echo "Error: Output directory '$output_dir' not found."
    echo "Please run ./generate.sh first to generate individual PDFs."
    exit 1
fi

cd "$output_dir" || exit 1

echo "=========================================="
echo "Merging PDFs by room and part"
echo "=========================================="
echo ""

# Get unique room numbers from filenames
rooms=$(ls exam-debut-semestre-2026-partie-*_*.pdf 2>/dev/null | \
        sed -E 's/.*_([A-Z0-9]+)_[A-Z]+_[^_]+\.pdf/\1/' | \
        sort -u)

if [ -z "$rooms" ]; then
    echo "Error: No exam PDFs found in $output_dir"
    echo "Please run ./generate.sh first."
    exit 1
fi

echo "Rooms detected: $rooms"
echo ""

# Counter for merged files
merged_count=0

# For each room, merge Part 1 and Part 2 separately
for room in $rooms; do
    echo "Processing room: $room"
    
    # Merge Part 1 for this room
    part1_files=$(ls exam-debut-semestre-2026-partie-1_${room}_*.pdf 2>/dev/null | sort)
    if [ -n "$part1_files" ]; then
        output_part1="exam-debut-semestre-2026-partie-1_${room}_merged.pdf"
        pdfunite $part1_files "$output_part1" 2>/dev/null
        if [ $? -eq 0 ]; then
            count=$(echo "$part1_files" | wc -l)
            echo "  ✓ Part 1: $count PDFs merged → $output_part1"
            ((merged_count++))
        else
            echo "  ✗ Part 1: Failed to merge"
        fi
    else
        echo "  ✗ Part 1: No files found"
    fi
    
    # Merge Part 2 for this room
    part2_files=$(ls exam-debut-semestre-2026-partie-2_${room}_*.pdf 2>/dev/null | sort)
    if [ -n "$part2_files" ]; then
        output_part2="exam-debut-semestre-2026-partie-2_${room}_merged.pdf"
        pdfunite $part2_files "$output_part2" 2>/dev/null
        if [ $? -eq 0 ]; then
            count=$(echo "$part2_files" | wc -l)
            echo "  ✓ Part 2: $count PDFs merged → $output_part2"
            ((merged_count++))
        else
            echo "  ✗ Part 2: Failed to merge"
        fi
    else
        echo "  ✗ Part 2: No files found"
    fi
    
    echo ""
done

echo "=========================================="
echo "Merge completed!"
echo "=========================================="
echo ""
echo "Merged files created: $merged_count"
echo ""
echo "Merged files:"
ls -lh *_merged.pdf 2>/dev/null | awk '{print "  " $5 "\t" $9}'

if [ $merged_count -eq 0 ]; then
    echo ""
    echo "⚠️  Warning: No files were merged. Check that PDFs exist in the output directory."
fi

echo ""
echo "These files are ready for printing."
