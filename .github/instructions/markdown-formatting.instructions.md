---
name: Markdown-Formatting
description: Markdown conventions, URL patterns, and admonitions
applyTo: "**/*.md"
---

# Markdown Formatting Guidelines

## Technical Specifications

- **Markdown**: Use Prettier formatting (80 character ruler)
- **Encoding**: UTF-8 with LF line endings
- Use simple apostrophes (') instead of typographic apostrophes (')
- No emojis except in root README.md

## URL Conventions

All web presentation and PDF links follow this pattern:

- Base: `https://heig-vd-progim-course.github.io/heig-vd-progim2-course/`
- Web: `{base}XX.XX-topic/01-supports-de-cours/index.html`
- PDF: `{base}XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf`

For project modules with parentheses in folder names, use URL-encoded or escaped
paths in Markdown:

- Folder: `01.03-projet-libre-(1-sur-8)/`
- URL: Use `<...>` brackets to handle special characters in Markdown links

## Admonitions in Course Materials

Course materials (README.md files in `01-supports-de-cours/`) can use
GitHub-flavored admonitions to highlight important information. These are
rendered as colored boxes on GitHub.

**Available admonition types:**

```markdown
> [!NOTE]
>
> Highlights information that users should take into account, even when
> skimming.

> [!TIP]
>
> Optional information to help a user be more successful.

> [!IMPORTANT]
>
> Crucial information necessary for users to succeed.

> [!WARNING]
>
> Critical content demanding immediate user attention due to potential risks.

> [!CAUTION]
>
> Negative potential consequences of an action.
```

**Usage guidelines:**

- Use sparingly - too many admonitions reduce their impact
- Place them strategically near relevant content
- Keep the text inside concise and action-oriented
- Use NOTE for general information students should remember
- Use TIP for optional enhancements or shortcuts
- Use IMPORTANT for critical concepts required for success
- Use WARNING for common mistakes or misunderstandings
- Use CAUTION for dangerous operations or irreversible actions

**Example in context:**

```markdown
### Type casting en Java

La conversion entre types primitifs peut être implicite ou explicite.

> [!IMPORTANT]
>
> Une conversion de type avec perte de précision (par exemple de `double` vers
> `int`) nécessite un cast explicite.

> [!WARNING]
>
> Un cast explicite peut entraîner une perte de données. Par exemple,
> `(int) 3.9` donnera `3`, pas `4`.
```

## Output Formatting

Use proper Markdown formatting in your answers. When referring to a filename or
symbol in the user's workspace, wrap it in backticks.

**Example:**

```
The class `Person` is in `src/models/person.ts`.
The function `calculateTotal` is defined in `lib/utils/math.ts`.
You can find the configuration in `config/app.config.json`.
```

Use KaTeX for math equations in your answers:

- Wrap inline math equations in $.
- Wrap more complex blocks of math equations in $$.
