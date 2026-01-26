# Templates

This directory contains templates for various course resources.

These templates can be used as a starting point for creating new course
materials, ensuring consistency and quality across different courses and
sessions.

## Course metadata

Use the following information for your course materials, replacing the example
values with those specific to your course:

- GitHub repository URL (`GITHUB_REPOSITORY_URL`):
  <https://github.com/heig-vd-progim-course/heig-vd-progim2-course>
- GitHub Pages URL (`GITHUB_PAGES_URL`):
  <https://heig-vd-progim-course.github.io/heig-vd-progim2-course>
- Course title (`COURSE_TITLE`): Programmation 2
- Course code (`COURSE_CODE`): ProgIM2
- Course language (`COURSE_LANGUAGE`): Français
- Course author (`AUTHOR`): V. Guidoux, avec l'aide de
  [GitHub Copilot](https://github.com/features/copilot)
- Institution (`INSTITUTION`): HEIG-VD
- Institution URL (`INSTITUTION_URL`): <https://heig-vd.ch>
- Academic year (`ACADEMIC_YEAR`): 2025-2026
- License (`LICENSE_NAME`): CC BY-SA 4.0
- License URL (`LICENSE_URL`): `{GITHUB_REPOSITORY_URL}/blob/main/LICENSE.md`

## Repository structure

The repository should follow the following structure:

```txt
./
├── 01-contenus-de-cours/
│   └── ...
├── 02-evaluations/
├── 03-autres-ressources/
│   └── ...
├── generate-diagrams.sh
├── generate-presentations.sh
├── ATTRIBUTION.md
├── LICENSE.md
└── README.md
```

Folder and file names should follow the course content (`COURSE_CONTENT` - see
[Course contents structure](#course-contents-structure)) and use the course
language (`COURSE_LANGUAGE`) for consistency.

The folders and subfolders are named with a two-digit prefix followed by a
descriptive title, all in lowercase without any special characters, separated by
hyphens, to ensure proper ordering.

When creating new folders or files, always use full names without abbreviations
to ensure clarity.

### Examples

Examples of proper folder naming conventions:

- `01-introduction-a-la-programmation` (French).
- `02-programmation-orientee-objet` (French).
- `03-modalites-devaluation` (French) - Note the omission of the apostrophe.

Examples of improper folder naming conventions:

- `01-intro-a-la-prog` (French).
- `02-poo` (French).
- `03-modalities-eval` (French).

## Course contents structure

The directory `01-contenus-de-cours/` (`COURSE_CONTENTS_FOLDER`) contains all
course materials, organized into subdirectories for each content.

Each content folder contains:

- A README file (`README.md`) that contains detailed explanations and examples
  related to the content to be covered.
- A presentation file (`PRESENTATION.md`) that provides an overview of the
  content, a summarized version of the main points issued from the README file.
- A quiz file (`QUIZ.md`) that contains questions to test students' knowledge on
  the content.
- A directory for exercises (`02-exercices/`) that contains practical exercises
  related to the content with their answers.
- A directory for the mini-project (`03-mini-projet/`) that contains the
  mini-project to be completed by students, including instructions,
  requirements, and expected outcomes.
- Images, PlantUML diagrams, and other multimedia elements to enhance
  understanding are stored in a `images/` subdirectory within the content
  folder.

When creating new course content, always read and follow the structure of all
relevant template files in the templates directory, including:

- [The main content template](./contenu-de-cours/README.md)
- [The presentation template](./contenu-de-cours/PRESENTATION.md)
- [The quiz template](./contenu-de-cours/QUIZ.md)
- [The exercises template](./contenu-de-cours/02-exercices/README.md)
- [The mini-project template](./contenu-de-cours/03-mini-projet/README.md)
- [The solution template](./contenu-de-cours/03-mini-projet/solution/README.md)

When updating a course content, ensure that all related files and resources are
also updated accordingly to maintain consistency.

## Other resources structure

The directory `03-autres-ressources/` (`OTHER_RESOURCES_FOLDER`) contains any
additional resources that may be useful for the course, such as templates,
reference materials, or supplementary readings.

This directory is mostly used by the teaching staff and does not usually contain
materials for students.
