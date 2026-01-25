---
description:
  Instructions when working with Marp presentations in this repository.
applyTo: "**/PRESENTATION.md, **/QUIZ.md"
---

# Marp guidelines

All presentations must follow the exact structure in the templates directory:

- Course presentations:
  `03-autres-ressources/01-templates/contenu-de-cours/PRESENTATION.md`
- Quiz presentations:
  `03-autres-ressources/01-templates/contenu-de-cours/QUIZ.md`

## Frontmatter rules

- Never use `:` in frontmatter values without quotes.
- Always use `headingDivider: 6` to automatically create slides from `##`
  headings.
- Use `theme: custom-marp-theme` for consistent styling.
- For quizzes, include the `url` field pointing to GitHub Pages.

## Slide separation (critical rule)

**Never use `---` to separate slides** after the frontmatter. The only `---`
allowed are:

1. Line 1: opening frontmatter delimiter.
2. After the last frontmatter line: closing frontmatter delimiter.

All other slides are automatically created by `##` headings thanks to
`headingDivider: 6`.

❌ **Wrong**:

```markdown
## Slide 1

Content here

---

## Slide 2

More content
```

✅ **Correct**:

```markdown
## Slide 1

Content here

## Slide 2

More content
```

## Slide content density guidelines

Critical: maximum characters per slide is ~800 characters (including code).

This is approximately:

- 10-12 lines of text (prose).
- OR 15-20 lines of code with minimal text.
- OR 6-8 lines of text + 10 lines of code.

When to split a slide into multiple parts:

- Character count: if total content exceeds ~800 characters.
- Text-heavy slides: if explanatory text exceeds ~100 words (excluding code).
- Mixed content: when combining significant text (>80 words) and code examples.
- Long lists: when bullet point lists exceed 5-6 items.
- Multiple code blocks: when showing 2+ code examples (>8 lines each).
- Complex explanations: when explaining 3+ distinct concepts on one slide.

Count all content: headings, text, code, comments, bullet points.

Multi-part slide format:

```markdown
## Title (1/n)

[First part of content]

## Title (2/n)

[Second part of content]
```

Splitting strategies:

- Text + Code: put explanatory text on (1/2), code example on (2/2).
- Long lists: group related items (e.g., 2-3 items per slide max).
- Before/After examples: split into separate slides with clear labels.
- Definitions: one concept per slide when explaining vocabulary.
- Code variations: one approach per slide (e.g., "with for" vs "with while").

## Content guidelines

- No emojis: never use emojis in presentations (use text warnings like
  "Attention :" or "Note :").
- Language: all course presentations must be in French.
- Code: all code examples must be in Java with English identifiers.
- Apostrophes: always use simple apostrophes (`'`) instead of typographic
  apostrophes (`'`, `'`).

## Quiz presentations (special format)

For quiz/revision presentations, use the "Question/Answer" format:

- Use `## Question X - Donnée` for the question slide.
- Use `## Question X - Réponse` for single-slide answers.
- Use `## Question X - Réponse (1/2)` and `## Question X - Réponse (2/2)` when
  the answer needs multiple slides.
- Always include a blockquote (`>`) for the actual question text.
- End with a `## Questions` slide (with `_class: lead`).
- Include a `## Sources` slide with illustration credits.

### Example quiz structure

```markdown
## Question 1 - Donnée

> What is polymorphism in Java?

## Question 1 - Réponse

Polymorphism allows objects of different classes to be treated as objects of a
common superclass.

## Question 2 - Donnée

> Explain the difference between interfaces and abstract classes.

## Question 2 - Réponse (1/2)

Interfaces:

- Cannot have instance variables.
- All methods are abstract by default.
- Support multiple inheritance.

## Question 2 - Réponse (2/2)

Abstract classes:

- Can have instance variables.
- Can have concrete methods.
- Support single inheritance only.
```
