---
description: Instructions when working with Java files in this repository.
applyTo: "**/*.java"
---

# Java guidelines

## General coding conventions

- Follow Java naming conventions strictly.
- Use English for all code identifiers (class names, method names, variable
  names, constants, etc.).
- Use French for all comments, documentation, and string literals displayed to
  users.
- Maintain consistent indentation (4 spaces, no tabs).
- Keep line length under 100 characters when possible for better readability.

## Naming conventions

### Classes and interfaces

- Use PascalCase for class and interface names (e.g., `User`,
  `VehicleInterface`, `AbstractShape`).
- Class names should be nouns (e.g., `Product`, `Customer`, `Order`).
- Interface names can use adjectives with `-able` suffix or nouns (e.g.,
  `Comparable`, `Serializable`, `Vehicle`).
- Abstract classes should be prefixed with `Abstract` (e.g., `AbstractShape`,
  `AbstractVehicle`).

### Methods

- Use camelCase for method names (e.g., `calculateArea()`, `getFullName()`,
  `isAdult()`).
- Method names should be verbs or verb phrases (e.g., `start()`, `stop()`,
  `displayInfo()`).
- Boolean methods should start with `is`, `has`, `can` (e.g., `isAdult()`,
  `hasPermission()`, `canStart()`).
- Getters start with `get` (e.g., `getName()`), setters with `set` (e.g.,
  `setName()`).

### Variables and constants

- Use camelCase for variable names (e.g., `firstName`, `maxSpeed`, `isRunning`).
- Use UPPER_SNAKE_CASE for constants (e.g., `MAX_VALUE`, `DEFAULT_SIZE`,
  `PI_VALUE`).
- Use descriptive names; avoid single-letter variables except for loop counters
  (i, j, k) or mathematical formulas (x, y, z).

### Packages

- Use lowercase for package names (e.g., `ch.heigvd.progim2.example`).
- Follow reverse domain naming (e.g., `ch.heigvd.progim2.utils`,
  `ch.heigvd.progim2.models`).

## Code structure

### Class organization

Organize class members in this order:

1. Static constants
2. Static variables
3. Instance variables (fields)
4. Constructors
5. Static methods
6. Instance methods (getters, setters, business logic)
7. Overridden methods (`equals()`, `hashCode()`, `toString()`)

### Visibility modifiers

- Use `private` for fields by default to ensure encapsulation.
- Use `public` for methods that form the class's public API.
- Use `protected` sparingly, only when needed for inheritance.
- Avoid package-private (default) visibility unless intentionally designing
  package-level access.

### Fields

- Always declare fields as `private` unless there is a compelling reason.
- Initialize fields in constructors or with inline initialization.
- Mark fields as `final` when they should not change after construction.

Example:

```java
private final String id;
private String name;
private int age;
private boolean active = true;
```

## Documentation and comments

### File headers

Do not include file headers or copyright notices unless specifically required.

### Javadoc

Use Javadoc for all public classes, interfaces, and public methods:

```java
/**
 * Représente une personne utilisatrice du système.
 * <p>
 * Cette classe encapsule les informations de base d'une personne
 * et fournit des méthodes pour manipuler ces données.
 */
public class User {
    /**
     * Crée une nouvelle personne utilisatrice.
     *
     * @param firstName le prénom de la personne
     * @param lastName le nom de famille de la personne
     * @param age l'âge de la personne (doit être positif)
     * @throws IllegalArgumentException si l'âge est négatif
     */
    public User(String firstName, String lastName, int age) {
        // ...
    }
}
```

Key Javadoc rules:

- Write Javadoc in French.
- Use `@param` for parameters, `@return` for return values, `@throws` for
  exceptions.
- Use `<p>` to separate paragraphs in longer descriptions.
- Use `{@code}` for inline code references.

### Inline comments

```java
// Commentaire sur une seule ligne en français

/* Commentaire sur plusieurs lignes
   en français */
```

Use inline comments to:

- Explain complex logic or algorithms.
- Clarify non-obvious design decisions.
- Reference external documentation (e.g., API docs, tutorials).

Do not comment obvious code:

```java
// ❌ Mauvais : commentaire évident
int age = 25; // Définit l'âge à 25

// ✅ Bon : commentaire utile
// L'âge minimum légal pour conduire en Suisse
int minDrivingAge = 18;
```

### Documentation references

When referencing external documentation, use French and provide URLs:

```java
// Documentation : https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
String formattedName = String.format("%s %s", firstName, lastName);
```

## Type safety and validation

### Type declarations

- Always specify types explicitly; avoid relying on type inference when it
  reduces clarity.
- Use primitive types (`int`, `double`, `boolean`) for simple values.
- Use wrapper classes (`Integer`, `Double`, `Boolean`) only when nullability is
  needed.

### Input validation

Validate constructor and setter parameters:

```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("L'âge ne peut pas être négatif");
    }
    this.age = age;
}
```

Alternative with defensive copying:

```java
public void setRadius(double radius) {
    // Garantit que le rayon est toujours positif
    this.radius = Math.max(0, radius);
}
```

## Object methods

### equals() and hashCode()

Override `equals()` and `hashCode()` together for value objects:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    User user = (User) obj;
    return age == user.age &&
           Objects.equals(firstName, user.firstName) &&
           Objects.equals(lastName, user.lastName);
}

@Override
public int hashCode() {
    return Objects.hash(firstName, lastName, age);
}
```

### toString()

Provide meaningful `toString()` implementations for debugging:

```java
@Override
public String toString() {
    return String.format("User{firstName='%s', lastName='%s', age=%d}",
                         firstName, lastName, age);
}
```

## Code examples structure

### Main class demonstration

Each code example should include a main class for demonstration:

```java
public class Main {
    public static void main(String[] args) {
        // Démonstration de la classe User
        User user = new User("Marie", "Dupont", 25);
        System.out.println(user.getFullName());
        System.out.println("Majeur : " + user.isAdult());
    }
}
```

### Utility classes

For utility/helper functions, use static methods in a utility class:

```java
public final class MathUtils {
    // Empêche l'instanciation
    private MathUtils() {
        throw new AssertionError("Classe utilitaire non instanciable");
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
```

## Best practices

### Encapsulation

- Keep fields private and provide public getters/setters only when needed.
- Return defensive copies of mutable objects when necessary.
- Use immutability when appropriate (final fields, no setters).

### Method design

- Keep methods short and focused (single responsibility).
- Limit parameters to 3-4 when possible; use objects for more complex data.
- Prefer return values over modifying parameters.

### String handling

Use `String.format()` for complex string formatting:

```java
String message = String.format("Nom complet : %s\nEmail : %s\nÂge : %d ans",
                               getFullName(), email, age);
```

### Constants

Define constants for magic numbers and repeated strings:

```java
private static final int ADULT_AGE = 18;
private static final double DEFAULT_RADIUS = 1.0;
private static final String DEFAULT_COLOR = "noir";
```

## Specific to pedagogical examples

### Clarity over cleverness

- Write simple, readable code that beginners can understand.
- Avoid advanced features unless they are the learning focus.
- Prefer explicit code over implicit behavior.

### Progressive complexity

- Start with simple examples (fields, constructors, getters/setters).
- Build up to more complex topics (inheritance, interfaces, polymorphism).
- Each example should focus on one main concept.

### Comments for learning

Use comments to explain concepts to students:

```java
// L'encapsulation protège les données en les rendant privées
private String name;

// Le constructeur initialise l'objet lors de sa création
public User(String name) {
    this.name = name;
}

// Le getter permet d'accéder à la propriété de manière contrôlée
public String getName() {
    return name;
}
```

## File organization in examples

Organize code examples following this structure:

```
01-example-name/
├── README.md
└── src/
    ├── Main.java
    ├── User.java
    └── utils/
        └── Helper.java
```

For more complex examples with packages:

```
01-example-name/
├── README.md
└── src/
    └── ch/
        └── heigvd/
            └── progim2/
                ├── Main.java
                ├── models/
                │   └── User.java
                └── utils/
                    └── Helper.java
```
