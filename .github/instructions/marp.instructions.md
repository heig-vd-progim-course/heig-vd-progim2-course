---
description:
  Instructions when working with Marp presentations in this repository.
applyTo: "**/PRESENTATION.md, **/QUIZ.md"
---

# Marp guidelines

All presentations MUST follow the exact structure in
`00.00-template/01-supports-de-cours/PRESENTATION.md`.

## Frontmatter Structure (MANDATORY)

```markdown
---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
title: HEIG-VD ProgIM2 Course - [Topic]
description: [Brief description] pour l'unité d'enseignement ProgIM2 enseigné à la HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/XX.XX-topic/01-supports-de-cours/index.html
header: "**[Topic]**"
footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2 2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) - [CC BY-SA 4.0](https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md)'
headingDivider: 2
math: mathjax
-->
```

**CRITICAL**:

- Use `theme: custom-marp-theme` (NOT `theme: default`)
- NEVER use `<style>` tag with `@import url('.marp/theme.css')`
- NEVER use `:` in value without quotes
- Set `headingDivider: 2` to auto-create slides from `##` headings
- Use `[license]` (NOT `[licence]`) for consistency

## Slide Separation (CRITICAL RULE)

**NEVER use `---` to separate slides** after the frontmatter. The only `---`
allowed are:

1. Line 1: Opening frontmatter delimiter
2. Line 3: Closing frontmatter delimiter

All other slides are automatically created by `##` headings thanks to
`headingDivider: 2`.

❌ **WRONG**:

```markdown
## Slide 1

## Content here

## Slide 2

More content
```

✅ **CORRECT**:

```markdown
## Slide 1

Content here

## Slide 2

More content
```

## Required Sections (in order)

1. **Title slide** with complete structure:

```markdown
# [Topic Title]

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-progim-course/heig-vd-progim2-course>

[Support de cours][cours] · [Présentation (web)][presentation-web] ·
[Présentation (PDF)][presentation-pdf]

<small>V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Ce travail est sous licence [CC BY-SA 4.0][license].</small>

![bg brightness:2 opacity:0.2][illustration-principale]
```

2. **"Retrouvez plus de détails dans le support de cours"** section with
   `_class: lead`:

```markdown
## _Retrouvez plus de détails dans le support de cours_

<!-- _class: lead -->

_Cette présentation est un résumé du support de cours. Pour plus de détails,
consultez le [support de cours][cours]._
```

3. **Objectifs** starting with "À la fin de cette séance, vous devriez être
   capable de :" with `![bg right:40%][illustration-objectifs]`
4. **Content sections** (as many `##` headings as needed)
5. **"À vous de jouer !"** with standard bullets and
   `![bg right:40%][illustration-a-vous-de-jouer]`
6. **Questions** with `_class: lead`
7. **Sources** with illustration credits ONLY (list format with links to
   illustration references):

```markdown
## Sources

- [Illustration objectifs][illustration-objectifs] par
  [Author Name](https://unsplash.com/@username) sur
  [Unsplash](https://unsplash.com/photos/photoId)
- [Illustration à vous de jouer][illustration-a-vous-de-jouer] par
  [Author Name](https://unsplash.com/@username) sur
  [Unsplash](https://unsplash.com/photos/photoId)
```

**IMPORTANT**: Do NOT include a "Références" section or documentation links in
Sources. Only list illustration credits.

## Footer URL Structure (MANDATORY)

All presentations must include these URL references at the end:

```markdown
<!-- URLs -->

[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/XX.XX-topic/01-supports-de-cours/index.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf
[cours]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/XX.XX-topic/01-supports-de-cours
[exercices]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/XX.XX-topic/03-exercices
[license]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]: ./images/home.jpg
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
```

Replace `XX.XX-topic` with actual module folder name.

## Slide Content Density Guidelines

**CRITICAL: Maximum characters per slide: ~800 characters (including code)**

This is approximately:

- 10-12 lines of text (prose)
- OR 15-20 lines of code with minimal text
- OR 6-8 lines of text + 10 lines of code

**When to split a slide into multiple parts:**

- **Character count**: If total content exceeds ~800 characters
- **Text-heavy slides**: If explanatory text exceeds ~100 words (excluding code)
- **Mixed content**: When combining significant text (>80 words) AND code
  examples
- **Long lists**: When bullet point lists exceed 5-6 items
- **Multiple code blocks**: When showing 2+ code examples (>8 lines each)
- **Complex explanations**: When explaining 3+ distinct concepts on one slide

**Count ALL content**: headings, text, code, comments, bullet points

**Multi-part slide format:**

```markdown
## Title (1/n)

[First part of content]

## Title (2/n)

[Second part of content]
```

**Splitting strategies:**

- **Text + Code**: Put explanatory text on (1/2), code example on (2/2)
- **Long lists**: Group related items (e.g., 2-3 items per slide max)
- **Before/After examples**: Split into separate slides with clear labels
- **Definitions**: One concept per slide when explaining vocabulary
- **Code variations**: One approach per slide (e.g., "with for" vs "with while")

**No emojis**: Never use emojis in presentations (use text warnings like
"Attention :" or "Note :")

## Quiz Presentations (Special Format)

For quiz/revision presentations, use the "Question/Answer" format:

- Use `## Question X - Donnée` for the question slide
- Use `## Question X - Réponse` for single-slide answers
- Use `## Question X - Réponse (1/2)` and `## Question X - Réponse (2/2)` when
  the answer needs multiple slides

## Common Mistakes to Avoid

1. ❌ Using `theme: default` instead of `theme: custom-marp-theme`
2. ❌ Adding `<style>` tag with `@import` (theme is already configured)
3. ❌ Using `---` to separate slides (breaks with `headingDivider: 2`)
4. ❌ Using `[licence]` instead of `[license]`
5. ❌ Using `headingDivider: 6` instead of `headingDivider: 2`
6. ❌ Forgetting `![bg right:40%][illustration-objectifs]` on objectives slide
7. ❌ Not including "À la fin de cette séance, vous devriez être capable de :"
8. ❌ Using simplified title slide instead of complete template with links and
   attributions
9. ❌ Missing "_Retrouvez plus de détails dans le support de cours_" section
   with proper formatting
10. ❌ Not creating `images/` folder with `home.jpg` placeholder
11. ❌ Including "Références" or documentation links in Sources slide (only
    illustration credits allowed)
