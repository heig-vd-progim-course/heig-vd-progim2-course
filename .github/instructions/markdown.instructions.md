---
description: Instructions when working with Markdown files in this repository.
applyTo: "**/*.md"
---

# Markdown guidelines

## General formatting

- Always separate headings, paragraphs, and lists with a blank line.
- When using apostrophes, always use typings apostrophes (`'`, `"`) instead of
  typographic apostrophes (`’`, `“`, `”`).
- Wrap long paragraphs to a maximum of 80 characters per line for better
  readability in plain text editors. Reformat as needed when editing.
- Never use emojis in the text.
- When referencing files, folders, or documents in the repository, always use
  relative paths/links.
- Avoid highlighting text using bold or italics.
- When using colon (`:`) in sentences, start with a lowercase letter unless it
  is a quote or a proper noun (e.g. _Note: this is an example._ instead of
  _Note: This is an example._, _I said : "This is an example."_ instead of _"I
  said: "this is an example."_).

### Headings

- Do not use title case for headings; use sentence case instead (e.g., _"General
  guidelines"_ instead of _"General Guidelines"_).

### Lists

- Always use a period at the end of each list item.
- Use consistent indentation (2 spaces) for nested lists.

### Code blocks

- Use code blocks (triple backticks ` ``` `) for code examples, specifying the
  language for syntax highlighting (e.g., `java`).

### Tables

- Always ensure proper alignment of columns using colons (`:`) for left, right,
  or center alignment. When using numbers in tables, align them to the right for
  better readability.

## Admonitions in course materials

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

- Use sparingly - too many admonitions reduce their impact
- Place them strategically near relevant content
- Keep the text inside concise and action-oriented
- Use NOTE for general information students should remember
- Use TIP for optional enhancements or shortcuts
- Use IMPORTANT for critical concepts required for success
- Use WARNING for common mistakes or misunderstandings
- Use CAUTION for dangerous operations or irreversible actions
