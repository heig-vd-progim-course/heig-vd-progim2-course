#!/usr/bin/env bash

## Variables
WORKDIR=$(pwd)
MANIM_DOCKER_IMAGE="manimcommunity/manim:v0.18.1"

## Script
# Check if Manim is installed locally
if command -v "manim" > /dev/null 2>&1; then
    echo "Manim installed locally, using it..."
    MANIM_CMD=(manim)
    USE_DOCKER=false
else
    echo "Manim not installed, using its Docker image..."
    MANIM_DOCKER_BASE=(
        docker run --rm
        --volume="${WORKDIR}:/manim"
        --user="$(id -u):$(id -g)"
        "$MANIM_DOCKER_IMAGE"
    )
    USE_DOCKER=true
fi

# Enable for recursive globbing
shopt -s globstar nullglob

echo "Removing all previous generated animations..."
rm -rf **/animations/videos/**
rm -rf **/animations/__pycache__/**

# Render all animation files
echo "Rendering animations..."
for animation_file in **/*_animation.py; do
    if [ -f "$animation_file" ]; then
        echo "Processing: $animation_file"
        animation_dir=$(dirname "$animation_file")
        
        # Render with medium quality (-qm) and all scenes (-a)
        # Change -qm to -qh for high quality
        if [ "$USE_DOCKER" = true ]; then
            # Docker requires relative path from mounted volume
            "${MANIM_DOCKER_BASE[@]}" manim render -qm -a "/manim/$animation_file" \
                --media_dir "/manim/$animation_dir/animations"
        else
            # Local installation
            manim render -qm -a "$animation_file" \
                --media_dir "$animation_dir/animations"
        fi
        
        if [ $? -eq 0 ]; then
            echo "✓ Successfully rendered: $animation_file"
        else
            echo "✗ Failed to render: $animation_file"
        fi
    fi
done

echo "Animation rendering complete!"
