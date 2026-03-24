#!/bin/bash

####################
# This script generates all the PDF files for the exam
# Author: V. Guidoux with the help of GitHub Copilot and Claude (Anthropic)
# Date: 2026-03-24
####################

# Check if the correct number of arguments are provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <csv_students_list>"
    echo ""
    echo "Example: $0 students.csv"
    echo ""
    echo "The CSV file should have the format: last_name,first_name,room"
    exit 1
fi

# Input CSV file containing last names, first names, and rooms
csv_file=$1

# Check if the CSV file exists
if [ ! -f "$csv_file" ]; then
    echo "Error: CSV file '$csv_file' not found."
    exit 1
fi

# Hardcoded output directory
output_directory="output"

# Check if the output directory exists, create if not
if [ ! -d "$output_directory" ]; then
    mkdir -p "$output_directory"
    echo "Created output directory: $output_directory"
fi

echo "=========================================="
echo "Generating exam PDFs for all students"
echo "=========================================="
echo ""

# Counter for generated files
count=0

# Loop through each line in the CSV file (skip header if present)
while IFS=, read -r last_name first_name room
do
    # Skip header line if it contains "last_name" or "nom"
    if [[ "$last_name" == "last_name" ]] || [[ "$last_name" == "nom" ]]; then
        continue
    fi
    
    # Skip empty lines
    if [[ -z "$last_name" ]] || [[ -z "$first_name" ]] || [[ -z "$room" ]]; then
        continue
    fi
    
    # Concatenate last name and first name into the desired format
    student_last_name_first_name="${last_name^^} $first_name"
    
    # Generate output file names for both parts
    output_file_part1="exam-debut-semestre-2026-partie-1_${room}_${last_name^^}_${first_name}.pdf"
    output_file_part2="exam-debut-semestre-2026-partie-2_${room}_${last_name^^}_${first_name}.pdf"
    
    # Log the output file names
    echo "[$((count + 1))] Generating for: $student_last_name_first_name (Room: $room)"
    
    # Compile Part 1 (without solutions)
    typst compile "exam-debut-semestre-2026-partie-1.typ" \
        "$output_directory/$output_file_part1" \
        --input student_last_name_first_name="$student_last_name_first_name" \
        --input room="$room" \
        --input show_official_answer="false" \
        2>&1 | grep -i "error" && echo "  ⚠️  Error compiling Part 1" || echo "  ✓ Part 1 generated"
    
    # Compile Part 2 (without solutions)
    typst compile "exam-debut-semestre-2026-partie-2.typ" \
        "$output_directory/$output_file_part2" \
        --input student_last_name_first_name="$student_last_name_first_name" \
        --input room="$room" \
        --input show_official_answer="false" \
        2>&1 | grep -i "error" && echo "  ⚠️  Error compiling Part 2" || echo "  ✓ Part 2 generated"
    
    ((count++))
done < "$csv_file"

echo ""
echo "=========================================="
echo "Generation completed!"
echo "=========================================="
echo "Total students: $count"
echo "Total PDFs generated: $((count * 2)) (Part 1 + Part 2)"
echo ""
echo "You can now run ./merge-by-room.sh to merge PDFs by room."
