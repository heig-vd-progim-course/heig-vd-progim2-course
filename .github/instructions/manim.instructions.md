---
description:
  Instructions when working with Manim animation files in this repository.
applyTo: "**/*_animation.py"
---

# Manim guidelines

- Always use the `_animation.py` suffix for Manim animation files.
- Use Manim Community Edition (not ManimGL).

## Technical specifications

- Location: store in course content subdirectories (e.g., in
  `01-exemples-de-code/` or `images/`).
- Rendering: generate using Docker image or local installation.
- Build process: generate animations using `./build-all-animations.sh` script.
- Quality: medium quality by default (`-qm`), high quality (`-qh`) for final
  versions.

## File organization

Each course module with animations should follow this structure:

```
XX-topic-name/
├── PRESENTATION.md
├── README.md
├── 01-exemples-de-code/
│   └── YY-example-name/
│       ├── example_animation.py
│       └── animations/
│           ├── Example.mp4
│           └── partial/
└── images/
    └── diagram.svg
```

Animation source files (`*_animation.py`) are converted to MP4 format and stored
in the `animations/` subfolder.

## Manim best practices

- Keep animations focused: one concept per animation.
- Use French text: all text in animations should be in French to match course
  language.
- Clear naming: use descriptive file names (e.g., `bubble_sort_animation.py`,
  `insertion_sort_animation.py`).
- Multiple scenes: create multiple Scene classes in one file for variations
  (e.g., full version and simplified version).
- Performance: optimize render time by limiting unnecessary animations.

## Animation file structure

All Manim files must follow this standard structure:

```python
"""
Titre de l'animation

Description courte de ce que l'animation illustre.
"""

from manim import *


class ConceptAnimation(Scene):
    """Description de la scène."""

    def construct(self):
        # Titre
        title = Text("Titre en français", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))
        self.wait(0.5)

        # Contenu de l'animation
        # ...

        self.wait(2)
```

**Required elements:**

1. Module docstring in French explaining the animation purpose
2. Import `from manim import *`
3. Scene class with descriptive name (e.g., `BubbleSortAnimation`)
4. Class docstring describing the scene
5. `construct(self)` method with animation logic
6. Wait periods for viewer comprehension

**Key principles:**

- Use descriptive class names following PascalCase
- Include docstrings in French
- Use English for variable names and code (following Python conventions)
- Add appropriate wait times between animation steps
- Use color coding to highlight important elements
- Keep animations between 30 seconds and 2 minutes

## Common animation patterns

For this programming course, commonly used patterns include:

- **Array visualizations**: rectangles or bars representing array elements
- **Comparison highlighting**: color changes to show comparisons
- **Movement animations**: swapping elements, moving data
- **Step-by-step execution**: showing algorithm progression
- **Color coding**:
  - BLUE: default/unsorted elements
  - YELLOW: elements being compared
  - RED: elements being swapped
  - GREEN: sorted/final elements

## Rendering commands

- **Preview**: `manim -pql filename.py SceneName` (low quality, auto-play)
- **Medium quality**: `manim -qm filename.py SceneName`
- **High quality**: `manim -qh filename.py SceneName`
- **All scenes**: `manim -qm filename.py` (renders all Scene classes)

## Integration with course materials

- Reference animations in README.md files using relative links
- Embed videos in presentations using HTML video tags or convert to GIF
- Keep source files in version control
- Exclude generated video files via .gitignore (they can be regenerated)
- Document which scene names correspond to which concepts

## Color palette

Use consistent colors across all animations:

```python
colors = {
    "default": BLUE,
    "comparing": YELLOW,
    "swapping": RED,
    "sorted": GREEN,
    "highlight": ORANGE,
    "background": "#1e1e1e",  # Dark background
}
```
