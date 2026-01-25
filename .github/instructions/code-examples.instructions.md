---
name: Java-Code-Examples
description: Standards and guidelines for creating Java code examples
applyTo: "**/02-exemples-de-code/**/*.java"
---

# Java Code Examples Guidelines

## Code Language and Conventions

- **Code elements in English**: Variable names, method names, class names, and
  parameter names must be in English (universal programming convention)
- Keep examples simple and relatable to student level
- Follow pedagogical progression from simple to complex
- Follow language best practices and conventions
- Include proper package declarations and imports when relevant

## Individual Code Example Structure

Each individual example within `02-exemples-de-code/XX-example-name/` must
follow this structure:

### README Format

Every code example must have a `README.md` that follows this pattern:

```markdown
# Exemple : [Example Title]

Cet exemple illustre [brief description] avec :

- [Feature/concept 1]
- [Feature/concept 2]
- [Feature/concept 3]
- [Additional features as needed]

[Optional: Additional notes about running, compiling, testing, etc.]
```

**Guidelines for README content:**

- Start with "Cet exemple illustre" followed by the main learning goal
- Use bullet points to list specific features demonstrated
- Keep descriptions concise and focused on what students will learn
- Add practical tips (e.g., how to compile, run, expected output) when relevant
- No emojis in code example READMEs

### File Organization Patterns

**Simple Examples** (for basic concepts):

```
XX-example-name/
├── README.md
├── Main.java (or main entry point)
└── [OtherClass].java (as needed)
```

## Code Example Best Practices

1. **Self-Contained**: Each example must be runnable independently without
   external dependencies (except JDK standard library and common build tools)

2. **Progressive Complexity**: Number examples in order of increasing complexity
   (`01-`, `02-`, `03-`, etc.)

3. **Functional Code**: Examples must work out-of-the-box when students compile
   and run them. Include clear instructions for compilation/execution in README

4. **Educational Comments**:

   - Add Javadoc comments for classes and public methods
   - Use inline comments in French to explain complex logic or pedagogical
     points
   - Reference Java documentation when introducing new APIs
   - Example:
     `// Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/`

5. **Modern Java Standards**:

   - Use recent Java features appropriate to the course level (Java 11+)
   - Follow proper encapsulation (private fields, public methods)
   - Use meaningful variable names that reflect purpose
   - Apply proper access modifiers (private, protected, public)
   - Use interfaces and abstract classes when demonstrating OOP concepts
   - Leverage collections framework appropriately
   - Use try-with-resources for resource management

6. **Java Naming Conventions**:

   - Classes: PascalCase (`UserManager`, `BankAccount`)
   - Methods/variables: camelCase (`calculateTotal`, `firstName`)
   - Constants: UPPER_SNAKE_CASE (`MAX_SIZE`, `DEFAULT_VALUE`)
   - Packages: lowercase (`com.example.algorithms`, `models`)

7. **Code Structure**:

   - Include proper package declarations
   - Import only necessary classes (avoid wildcards unless pedagogically
     relevant)
   - One public class per file
   - Organize methods logically (constructors, public methods, private methods)
   - Keep methods focused and reasonably sized

8. **Documentation Standards**:

   - Include Javadoc for all public classes and methods
   - Use `@param`, `@return`, `@throws` tags appropriately
   - Explain the "why" in comments, not just the "what"
   - Example:
     ```java
     /**
      * Calcule le montant total avec la TVA appliquée.
      *
      * @param amount le montant de base avant TVA
      * @param taxRate le taux de TVA (0.077 pour 7.7%)
      * @return le montant total incluant la TVA
      */
     public double calculateWithTax(double amount, double taxRate) {
         return amount * (1 + taxRate);
     }
     ```

9. **Real-World Scenarios**: Use relatable examples with ecological and low-tech
   values:

   - Student grade systems
   - Library book management and sharing
   - Community resource sharing (tool libraries, repair cafés)
   - Local food networks and permaculture planning
   - Public transport and bike-sharing systems
   - Energy consumption tracking and reduction
   - Waste reduction and composting management
   - Community event planning and local initiatives
   - Repair tracking (fixing instead of buying new)
   - Second-hand exchange platforms

   **Avoid**: E-commerce, banking with interest, mass consumption scenarios,
   car-centric examples, growth-focused metrics

10. **Diversity in naming**: Use diverse, internationally representative names
    in code examples to reflect the multicultural reality of programming.

    **Principles:**

    - Prefer non-gendered names that are commonly neutral in their cultural
      context
    - Reflect global diversity naturally by mixing names from various regions
    - Avoid overused unisex clichés (Alex, Sam, Chris, Taylor)
    - Keep examples readable: short names, easy to type, minimal diacritics
    - Respect cultural context: some names are neutral in one region but
      gendered in another

**Recommended Neutral Names (non-exhaustive):**

- **East Asian**: Min, Jin, Ren, Sora, Lin, Jing
- **South Asian**: Aadi, Kiran, Shaan, Amal, Tanu
- **Middle Eastern / North African**: Noor, Iman, Rayane, Nahil
- **Sub-Saharan African**: Lebo, Nyasha, Tariro, Khaya, Ayo
- **Latin American**: Amaru, Inti, Ariel, Suyu
- **Pacific / South-East Asian**: Ari, Mika, Koa, Nalu
- **European**: Sacha, Sasha, Elian, Rune, Marin, Nox, Zhenya

11. **Input/Output Patterns**:

    - Use `System.out.println()` for simple output demonstrations
    - Use `Scanner` for console input when needed
    - Format output clearly for students to understand results
    - **NEVER use `System.out.printf()`** - it is not taught in the course
      theory
    - For formatted output, use `String.format()` combined with
      `System.out.println()`, or simple string concatenation
    - **NEVER use ternary operators (`condition ? value1 : value2`)** - they are
      too advanced for beginners and not taught in theory
    - Always use explicit `if-else` statements for conditional assignments

    Example:

    ```java
    System.out.println("=== Résultats ===");
    System.out.println("Montant total: " + total + " CHF");
    // OR for formatting:
    System.out.println(String.format("Montant total: %.2f CHF", total));

    // For conditional values, use if-else:
    String status;
    if (condition) {
        status = "valeur1";
    } else {
        status = "valeur2";
    }
    ```

12. **Main Method Pattern**:

    ```java
    public class Main {

        public static void demonstrateConcept() {
            // Implementation
        }

        public static void main(String[] args) {
            System.out.println("=== Exemple : [Title] ===\n");

            // Démonstration du concept
            demonstrateConcept();

            System.out.println("\n=== Fin de l'exemple ===");
        }
    }
    ```

13. **Build Instructions in README**: Always include compilation and execution
    instructions:

    ````markdown
    ## Compilation et exécution

    ### Sans package

    ```bash
    javac Main.java
    java Main
    ```
    ````

## Naming Conventions for Examples

- Use descriptive folder names with hyphens: `01-classe-simple`,
  `02-heritage-et-polymorphisme`
- Start with a number to indicate order
- Use French for folder names (aligning with course language)
- Be specific about what the example demonstrates
- Examples:
  - `01-variables-et-types`
  - `02-structures-de-controle`
  - `03-tableaux-et-collections`
  - `04-programmation-orientee-objet`
  - `05-interfaces-et-abstraction`
  - `06-gestion-des-exceptions`
  - `07-fichiers-et-serialisation`

## What NOT to Include

- No complex build processes, even Maven/Gradle basics
- No heavy frameworks (Spring, JavaFX, etc.)
- No excessive abstractions that obscure learning objectives
- No deprecated Java features (avoid `Vector`, `Hashtable`, etc.)
- No GUI code
- No database connections in early examples (keep them simple)
- No external libraries unless absolutely necessary for the concept
