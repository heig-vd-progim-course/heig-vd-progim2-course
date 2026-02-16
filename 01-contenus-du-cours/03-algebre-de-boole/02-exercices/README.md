# Algèbre de Boole - Exercices

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [contenu principal](../README.md).

## Table des matières

- [Table des matières](#table-des-matières)
- [Exercices](#exercices)
- [Exercices de complétion](#exercices-de-complétion)
  - [Exercice 1 - Déclaration et initialisation de booléens](#exercice-1---déclaration-et-initialisation-de-booléens)
  - [Exercice 2 - Utilisation des opérateurs logiques de base](#exercice-2---utilisation-des-opérateurs-logiques-de-base)
  - [Exercice 3 - Application des lois de De Morgan](#exercice-3---application-des-lois-de-de-morgan)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 4 - Évaluation d'expressions avec court-circuit](#exercice-4---évaluation-dexpressions-avec-court-circuit)
  - [Exercice 5 - Expressions booléennes complexes avec priorités](#exercice-5---expressions-booléennes-complexes-avec-priorités)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 6 - Comparaison de conditions redondantes vs simplifiées](#exercice-6---comparaison-de-conditions-redondantes-vs-simplifiées)
  - [Exercice 7 - Comparaison d'approches pour validation de données](#exercice-7---comparaison-dapproches-pour-validation-de-données)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 8 - Refactorisation d'expressions avec négations multiples](#exercice-8---refactorisation-dexpressions-avec-négations-multiples)
  - [Exercice 9 - Simplification de conditions if-else if-else](#exercice-9---simplification-de-conditions-if-else-if-else)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 10 - Système de validation de formulaire](#exercice-10---système-de-validation-de-formulaire)
  - [Exercice 11 - Système de contrôle d'accès avec règles complexes](#exercice-11---système-de-contrôle-daccès-avec-règles-complexes)

## Exercices

> [!NOTE]
>
> Bien que ces exercices puissent paraître simples et que leur solution est
> disponible dans ce même document, il est fortement recommandé de les réaliser
> sans consulter les solutions au préalable.
>
> Ils ont pour but de vous former et de pratiquer les concepts vus dans le
> contenu de cours.
>
> Il est donc important de les faire par vous-même avant de vérifier vos
> réponses avec les solutions fournies.

## Exercices de complétion

Ces exercices vous permettent de pratiquer la syntaxe et les concepts de base en
complétant du code existant. La difficulté augmente progressivement.

### Exercice 1 - Déclaration et initialisation de booléens

Vous devez créer un programme qui gère l'état d'un capteur IoT (Internet of
Things).

Complétez le code suivant en déclarant et initialisant les variables booléennes
manquantes :

```java
public class SensorStatus {
    public static void main(String[] args) {
        // TODO: Déclarez une variable booléenne 'isActive' initialisée à true


        // TODO: Déclarez une variable booléenne 'hasError' initialisée à false


        // TODO: Déclarez une variable booléenne 'needsMaintenance' initialisée à false


        System.out.println("Capteur actif: " + isActive);
        System.out.println("Erreur détectée: " + hasError);
        System.out.println("Maintenance nécessaire: " + needsMaintenance);
    }
}
```

<details>
<summary>Indice</summary>

En Java, une variable booléenne se déclare avec le mot-clé `boolean` suivi du
nom de la variable. L'initialisation se fait avec `=` suivi de `true` ou
`false`.

Syntaxe : `boolean nomVariable = valeur;`

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class SensorStatus {
    public static void main(String[] args) {
        // Déclaration et initialisation des variables booléennes
        boolean isActive = true;
        boolean hasError = false;
        boolean needsMaintenance = false;

        System.out.println("Capteur actif: " + isActive);
        System.out.println("Erreur détectée: " + hasError);
        System.out.println("Maintenance nécessaire: " + needsMaintenance);
    }
}
```

**Sortie attendue :**

```text
Capteur actif: true
Erreur détectée: false
Maintenance nécessaire: false
```

**Points clés :**

- Le type `boolean` ne peut contenir que `true` ou `false`
- Les noms de variables booléennes commencent généralement par `is`, `has`,
  `can`, `should`
- L'initialisation est obligatoire avant utilisation

</details>

### Exercice 2 - Utilisation des opérateurs logiques de base

Vous devez créer un système de contrôle d'accès pour une salle sécurisée.

Complétez le code suivant en utilisant les opérateurs logiques appropriés (`&&`,
`||`, `!`) :

```java
public class AccessControl {
    public static void main(String[] args) {
        boolean hasBadge = true;
        boolean hasValidCode = true;
        boolean isAuthorized = false;
        boolean isEmergency = false;

        // TODO: L'accès est accordé SI la personne a un badge ET un code valide
        boolean hasNormalAccess = /* votre code ici */;

        // TODO: L'accès d'urgence est accordé SI c'est une urgence OU la personne est autorisée
        boolean hasEmergencyAccess = /* votre code ici */;

        // TODO: L'accès est refusé SI la personne n'a PAS de badge
        boolean isAccessDenied = /* votre code ici */;

        System.out.println("Accès normal autorisé: " + hasNormalAccess);
        System.out.println("Accès d'urgence autorisé: " + hasEmergencyAccess);
        System.out.println("Accès refusé: " + isAccessDenied);
    }
}
```

<details>
<summary>Indice</summary>

- L'opérateur `&&` (AND) requiert que les **deux** conditions soient vraies
- L'opérateur `||` (OR) requiert qu'**au moins une** condition soit vraie
- L'opérateur `!` (NOT) **inverse** la valeur booléenne

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class AccessControl {
    public static void main(String[] args) {
        boolean hasBadge = true;
        boolean hasValidCode = true;
        boolean isAuthorized = false;
        boolean isEmergency = false;

        // Accès normal : badge ET code valide requis
        boolean hasNormalAccess = hasBadge && hasValidCode;

        // Accès d'urgence : urgence OU autorisation spéciale
        boolean hasEmergencyAccess = isEmergency || isAuthorized;

        // Accès refusé : PAS de badge
        boolean isAccessDenied = !hasBadge;

        System.out.println("Accès normal autorisé: " + hasNormalAccess);
        System.out.println("Accès d'urgence autorisé: " + hasEmergencyAccess);
        System.out.println("Accès refusé: " + isAccessDenied);
    }
}
```

**Sortie attendue :**

```text
Accès normal autorisé: true
Accès d'urgence autorisé: false
Accès refusé: false
```

**Explication :**

- `hasNormalAccess = true && true = true` (les deux conditions sont vraies)
- `hasEmergencyAccess = false || false = false` (aucune condition n'est vraie)
- `isAccessDenied = !true = false` (inverse de true)

**Points clés :**

- `&&` : toutes les conditions doivent être vraies
- `||` : au moins une condition doit être vraie
- `!` : inverse le résultat booléen

</details>

### Exercice 3 - Application des lois de De Morgan

Vous devez simplifier des expressions booléennes complexes en utilisant les lois
de De Morgan.

Complétez le code suivant en appliquant les lois de De Morgan pour simplifier
les expressions :

```java
public class DeMorganSimplification {
    public static void main(String[] args) {
        boolean hasConnection = false;
        boolean hasData = false;
        boolean isOffline = true;
        boolean isLowBattery = false;

        // Expression originale complexe : !(hasConnection && hasData)
        // TODO: Appliquez la première loi de De Morgan pour simplifier
        //       !(A && B) = !A || !B
        boolean cannotConnect = /* votre code ici */;

        // Expression originale complexe : !(isOffline || isLowBattery)
        // TODO: Appliquez la deuxième loi de De Morgan pour simplifier
        //       !(A || B) = !A && !B
        boolean isOperational = /* votre code ici */;

        // Vérification : les deux expressions doivent donner le même résultat
        System.out.println("Expression originale : " + !(hasConnection && hasData));
        System.out.println("Expression simplifiée: " + cannotConnect);
        System.out.println("Identiques: " + (!(hasConnection && hasData) == cannotConnect));

        System.out.println();

        System.out.println("Expression originale : " + !(isOffline || isLowBattery));
        System.out.println("Expression simplifiée: " + isOperational);
        System.out.println("Identiques: " + (!(isOffline || isLowBattery) == isOperational));
    }
}
```

<details>
<summary>Indice</summary>

**Lois de De Morgan :**

1. `!(A && B)` est équivalent à `!A || !B`
2. `!(A || B)` est équivalent à `!A && !B`

Pour simplifier une expression :

- Retirez la négation globale
- Inversez l'opérateur (`&&` → `||` ou `||` → `&&`)
- Ajoutez une négation à chaque terme

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class DeMorganSimplification {
    public static void main(String[] args) {
        boolean hasConnection = false;
        boolean hasData = false;
        boolean isOffline = true;
        boolean isLowBattery = false;

        // Première loi de De Morgan : !(A && B) = !A || !B
        boolean cannotConnect = !hasConnection || !hasData;

        // Deuxième loi de De Morgan : !(A || B) = !A && !B
        boolean isOperational = !isOffline && !isLowBattery;

        // Vérification : les deux expressions doivent donner le même résultat
        System.out.println("Expression originale : " + !(hasConnection && hasData));
        System.out.println("Expression simplifiée: " + cannotConnect);
        System.out.println("Identiques: " + (!(hasConnection && hasData) == cannotConnect));

        System.out.println();

        System.out.println("Expression originale : " + !(isOffline || isLowBattery));
        System.out.println("Expression simplifiée: " + isOperational);
        System.out.println("Identiques: " + (!(isOffline || isLowBattery) == isOperational));
    }
}
```

**Sortie attendue :**

```text
Expression originale : true
Expression simplifiée: true
Identiques: true

Expression originale : false
Expression simplifiée: false
Identiques: true
```

**Explication :**

**Premier cas :** `!(hasConnection && hasData)`

- `hasConnection = false`, `hasData = false`
- `!(false && false) = !(false) = true`
- Après De Morgan : `!false || !false = true || true = true` ✓

**Deuxième cas :** `!(isOffline || isLowBattery)`

- `isOffline = true`, `isLowBattery = false`
- `!(true || false) = !(true) = false`
- Après De Morgan : `!true && !false = false && true = false` ✓

**Points clés :**

- Les lois de De Morgan permettent de simplifier des négations complexes
- La version simplifiée est souvent plus lisible
- Les deux formes sont toujours équivalentes logiquement

</details>

## Exercices de prédiction

Ces exercices développent votre compréhension en vous demandant de prédire le
comportement d'un programme avant de l'exécuter.

### Exercice 4 - Évaluation d'expressions avec court-circuit

Sans exécuter le code, prédisez la sortie de ce programme qui démontre
l'évaluation court-circuit avec les opérateurs `&&` et `||`.

```java
public class ShortCircuitDemo {
    private static int counter = 0;

    public static boolean checkCondition(String name, boolean result) {
        counter++;
        System.out.println("  → Évaluation de " + name + " (appel #" + counter + ")");
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: false && checkCondition(\"B\", true)");
        boolean result1 = false && checkCondition("B", true);
        System.out.println("Résultat: " + result1);
        System.out.println();

        counter = 0;
        System.out.println("Test 2: true || checkCondition(\"B\", false)");
        boolean result2 = true || checkCondition("B", false);
        System.out.println("Résultat: " + result2);
        System.out.println();

        counter = 0;
        System.out.println("Test 3: true && checkCondition(\"B\", true)");
        boolean result3 = true && checkCondition("B", true);
        System.out.println("Résultat: " + result3);
    }
}
```

**Questions :**

1. Dans le Test 1, la méthode `checkCondition` sera-t-elle appelée ? Pourquoi ?
2. Dans le Test 2, la méthode `checkCondition` sera-t-elle appelée ? Pourquoi ?
3. Dans le Test 3, la méthode `checkCondition` sera-t-elle appelée ? Pourquoi ?
4. Quelle sera la sortie complète du programme ?

<details>
<summary>Afficher la solution</summary>

**Réponses :**

1. **Test 1 : NON**, `checkCondition` ne sera **pas** appelée
   - Avec `&&`, si la première condition est `false`, le résultat est forcément
     `false`
   - Java n'évalue pas la deuxième condition (court-circuit)

2. **Test 2 : NON**, `checkCondition` ne sera **pas** appelée
   - Avec `||`, si la première condition est `true`, le résultat est forcément
     `true`
   - Java n'évalue pas la deuxième condition (court-circuit)

3. **Test 3 : OUI**, `checkCondition` **sera** appelée
   - Avec `&&`, la première condition est `true`
   - Java doit évaluer la deuxième condition pour connaître le résultat final

**Sortie complète du programme :**

```text
Test 1: false && checkCondition("B", true)
Résultat: false

Test 2: true || checkCondition("B", false)
Résultat: true

Test 3: true && checkCondition("B", true)
  → Évaluation de B (appel #1)
Résultat: true
```

**Points clés :**

- **Court-circuit avec `&&`** : si la première condition est `false`, la seconde
  n'est pas évaluée
- **Court-circuit avec `||`** : si la première condition est `true`, la seconde
  n'est pas évaluée
- Cette optimisation peut éviter des erreurs (ex: vérifier `null` avant
  d'appeler une méthode)
- L'ordre des conditions est donc **très important** pour la performance et la
  sécurité

</details>

### Exercice 5 - Expressions booléennes complexes avec priorités

Sans exécuter le code, prédisez la sortie de ce programme qui utilise des
expressions booléennes complexes avec différents niveaux de priorité.

```java
public class BooleanPriority {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;

        System.out.println("Valeurs: a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
        System.out.println();

        // Expression 1: Priorité des opérateurs
        boolean result1 = a || b && c;
        System.out.println("Expression 1: a || b && c");
        System.out.println("Résultat: " + result1);
        System.out.println();

        // Expression 2: Utilisation de parenthèses
        boolean result2 = (a || b) && c;
        System.out.println("Expression 2: (a || b) && c");
        System.out.println("Résultat: " + result2);
        System.out.println();

        // Expression 3: Expression complexe
        boolean result3 = !a && b || c && !d;
        System.out.println("Expression 3: !a && b || c && !d");
        System.out.println("Résultat: " + result3);
        System.out.println();

        // Expression 4: Avec parenthèses explicites
        boolean result4 = (!a && b) || (c && !d);
        System.out.println("Expression 4: (!a && b) || (c && !d)");
        System.out.println("Résultat: " + result4);
    }
}
```

**Questions :**

1. Quelle sera la valeur de `result1` ? Expliquez l'ordre d'évaluation.
2. Quelle sera la valeur de `result2` ? En quoi diffère-t-elle de `result1` ?
3. Quelle sera la valeur de `result3` ? Décomposez l'évaluation étape par étape.
4. Les expressions 3 et 4 donnent-elles le même résultat ? Pourquoi ?

<details>
<summary>Afficher la solution</summary>

**Priorité des opérateurs (du plus prioritaire au moins prioritaire) :**

1. `!` (NOT)
2. `&&` (AND)
3. `||` (OR)

**Réponses :**

1. **`result1 = true`**
   - Expression : `a || b && c`
   - `&&` est prioritaire sur `||`
   - Évaluation : `a || (b && c)` = `true || (false && true)` = `true || false`
     = `true`

2. **`result2 = true`**
   - Expression : `(a || b) && c`
   - Les parenthèses forcent l'évaluation de `||` en premier
   - Évaluation : `(true || false) && true` = `true && true` = `true`
   - **Différence** : même résultat final, mais ordre d'évaluation différent

3. **`result3 = true`**
   - Expression : `!a && b || c && !d`
   - Ordre naturel : `(!a && b) || (c && !d)`
   - Étape 1 : `!a = !true = false`
   - Étape 2 : `!d = !false = true`
   - Étape 3 : `false && false = false`
   - Étape 4 : `true && true = true`
   - Étape 5 : `false || true = true`

4. **OUI, même résultat**
   - Les expressions 3 et 4 sont équivalentes
   - L'expression 4 utilise des parenthèses **explicites** pour plus de clarté
   - **Bonne pratique** : utiliser des parenthèses rend le code plus lisible

**Sortie complète du programme :**

```text
Valeurs: a=true, b=false, c=true, d=false

Expression 1: a || b && c
Résultat: true

Expression 2: (a || b) && c
Résultat: true

Expression 3: !a && b || c && !d
Résultat: true

Expression 4: (!a && b) || (c && !d)
Résultat: true
```

**Points clés :**

- La priorité des opérateurs affecte l'évaluation des expressions
- `!` > `&&` > `||` en termes de priorité
- Les parenthèses permettent de forcer un ordre d'évaluation spécifique
- Utilisez des parenthèses pour rendre vos intentions claires, même si elles ne
  sont pas nécessaires

</details>

## Exercices de comparaison

Ces exercices développent votre esprit critique en comparant différentes
approches pour résoudre un même problème.

### Exercice 6 - Comparaison de conditions redondantes vs simplifiées

Comparez ces deux implémentations d'une fonction de validation de mot de passe.

**Code A (avec comparaisons redondantes) :**

```java
public class PasswordValidatorA {
    public static boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }

        boolean hasMinLength = false;
        if (password.length() >= 8) {
            hasMinLength = true;
        }

        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c) == true) {
                hasUpperCase = true;
            }
        }

        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c) == true) {
                hasDigit = true;
            }
        }

        if (hasMinLength == true && hasUpperCase == true && hasDigit == true) {
            return true;
        } else {
            return false;
        }
    }
}
```

**Code B (simplifié) :**

```java
public class PasswordValidatorB {
    public static boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }

        boolean hasMinLength = password.length() >= 8;

        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
        }

        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasMinLength && hasUpperCase && hasDigit;
    }
}
```

**Questions :**

1. Lequel est préférable ? Pourquoi ?
2. Quels sont les problèmes du Code A ?
3. Quelles améliorations le Code B apporte-t-il ?
4. Pouvez-vous identifier d'autres améliorations possibles ?

<details>
<summary>Afficher la solution</summary>

**Réponse : Le Code B est préférable.**

**Problèmes du Code A :**

1. **Comparaison redondante** : `== true` est inutile
   - `if (condition == true)` est équivalent à `if (condition)`
   - Plus verbeux sans apporter de valeur

2. **Return redondant** :

   ```java
   if (condition == true) {
       return true;
   } else {
       return false;
   }
   ```

   - Équivalent à simplement `return condition;`

3. **Affectation inutile** :

   ```java
   boolean hasMinLength = false;
   if (password.length() >= 8) {
       hasMinLength = true;
   }
   ```

   - Peut être simplifié en une seule ligne

**Améliorations du Code B :**

1. **Affectation directe** : `boolean hasMinLength = password.length() >= 8;`
2. **Pas de comparaison redondante** : `if (Character.isUpperCase(c))` au lieu
   de `if (Character.isUpperCase(c) == true)`
3. **Return direct** : `return hasMinLength && hasUpperCase && hasDigit;`

**Comparaison :**

| Aspect                | Code A     | Code B     |
| :-------------------- | :--------- | :--------- |
| Lignes de code        | ~30 lignes | ~20 lignes |
| Lisibilité            | Verbosite  | Claire     |
| Maintenabilité        | Complexe   | Simple     |
| Comparaisons `==true` | Oui        | Non        |
| Return conditionnels  | Oui        | Direct     |

**Autres améliorations possibles :**

```java
public class PasswordValidatorC {
    public static boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) {
            return false;  // Validation rapide
        }

        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);

        return hasUpperCase && hasDigit;
    }
}
```

**Points clés :**

- Évitez `== true` et `== false`, utilisez directement les booléens
- `return condition;` est préférable à
  `if (condition) return true; else return false;`
- L'affectation directe est plus concise et claire
- Le code simple est plus facile à maintenir

</details>

### Exercice 7 - Comparaison d'approches pour validation de données

Comparez ces deux implémentations d'un système de validation d'inscription.

**Code A (validation séparée) :**

```java
public class RegistrationValidatorA {
    public static void main(String[] args) {
        String username = "alice";
        String email = "alice@example.com";
        int age = 17;
        boolean acceptedTerms = false;

        System.out.println("Validation avec Code A:");
        boolean isValid = validateRegistration(username, email, age, acceptedTerms);
        System.out.println("Inscription valide: " + isValid);
    }

    public static boolean validateRegistration(String username, String email,
                                                 int age, boolean acceptedTerms) {
        boolean usernameValid = checkUsername(username);
        boolean emailValid = checkEmail(email);
        boolean ageValid = checkAge(age);
        boolean termsValid = checkTerms(acceptedTerms);

        if (usernameValid && emailValid && ageValid && termsValid) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkUsername(String username) {
        if (username != null && username.length() >= 3) {
            return true;
        }
        System.out.println("  Nom d'utilisateur invalide");
        return false;
    }

    public static boolean checkEmail(String email) {
        if (email != null && email.contains("@")) {
            return true;
        }
        System.out.println("  Email invalide");
        return false;
    }

    public static boolean checkAge(int age) {
        if (age >= 18) {
            return true;
        }
        System.out.println("  Âge insuffisant");
        return false;
    }

    public static boolean checkTerms(boolean acceptedTerms) {
        if (acceptedTerms) {
            return true;
        }
        System.out.println("  Conditions non acceptées");
        return false;
    }
}
```

**Code B (validation en court-circuit) :**

```java
public class RegistrationValidatorB {
    public static void main(String[] args) {
        String username = "alice";
        String email = "alice@example.com";
        int age = 17;
        boolean acceptedTerms = false;

        System.out.println("Validation avec Code B:");
        boolean isValid = validateRegistration(username, email, age, acceptedTerms);
        System.out.println("Inscription valide: " + isValid);
    }

    public static boolean validateRegistration(String username, String email,
                                                 int age, boolean acceptedTerms) {
        return checkUsername(username)
            && checkEmail(email)
            && checkAge(age)
            && checkTerms(acceptedTerms);
    }

    public static boolean checkUsername(String username) {
        if (username == null || username.length() < 3) {
            System.out.println("  Nom d'utilisateur invalide");
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("  Email invalide");
            return false;
        }
        return true;
    }

    public static boolean checkAge(int age) {
        if (age < 18) {
            System.out.println("  Âge insuffisant");
            return false;
        }
        return true;
    }

    public static boolean checkTerms(boolean acceptedTerms) {
        if (!acceptedTerms) {
            System.out.println("  Conditions non acceptées");
            return false;
        }
        return true;
    }
}
```

**Questions :**

1. Quelle est la différence principale entre les deux approches ?
2. Dans quel cas le Code B est-il plus efficace ?
3. Lequel préférez-vous pour un formulaire d'inscription ? Pourquoi ?
4. Comment modifieriez-vous ces codes pour afficher tous les messages d'erreur à
   la fois ?

<details>
<summary>Afficher la solution</summary>

**Différence principale :**

- **Code A** : Évalue **toutes** les validations, stocke les résultats, puis
  combine
- **Code B** : Utilise **l'évaluation en court-circuit** avec `&&` - s'arrête à
  la première erreur

**Efficacité du Code B :**

Exécutons les deux codes avec les mêmes données invalides :

```text
Validation avec Code A:
  Âge insuffisant
  Conditions non acceptées
Inscription valide: false

Validation avec Code B:
  Âge insuffisant
Inscription valide: false
```

Le Code B s'arrête après la première erreur (`checkAge`), ne vérifiant pas
`checkTerms`.

**Comparaison des approches :**

| Aspect                 | Code A                  | Code B                     |
| :--------------------- | :---------------------- | :------------------------- |
| Évaluation             | Toutes les validations  | Court-circuit              |
| Performance            | Moins efficace          | Plus rapide                |
| Messages d'erreur      | Tous affichés           | Premier seulement          |
| Expérience utilisateur | Meilleure (tout savoir) | Frustrante (une à la fois) |
| Simplicité du code     | Plus verbeux            | Plus concis                |

**Quel code préférer ?**

Pour un formulaire d'inscription : **Ni l'un ni l'autre tel quel !**

- **Code B** : Plus efficace mais frustrant (l'utilisateur doit corriger et
  resoumettre plusieurs fois)
- **Code A** : Meilleur UX mais code redondant avec
  `if-then-return-true-else-return-false`

**Meilleure approche - Code C (validation complète avec messages) :**

```java
public class RegistrationValidatorC {
    public static boolean validateRegistration(String username, String email,
                                                 int age, boolean acceptedTerms) {
        boolean allValid = true;

        // Valider TOUT mais stocker uniquement le résultat final
        allValid = checkUsername(username) & allValid;      // & au lieu de &&
        allValid = checkEmail(email) & allValid;
        allValid = checkAge(age) & allValid;
        allValid = checkTerms(acceptedTerms) & allValid;

        return allValid;
    }

    // Méthodes de vérification simplifiées
    public static boolean checkUsername(String username) {
        boolean valid = username != null && username.length() >= 3;
        if (!valid) {
            System.out.println("  Nom d'utilisateur invalide");
        }
        return valid;
    }

    public static boolean checkEmail(String email) {
        boolean valid = email != null && email.contains("@");
        if (!valid) {
            System.out.println("  Email invalide");
        }
        return valid;
    }

    public static boolean checkAge(int age) {
        boolean valid = age >= 18;
        if (!valid) {
            System.out.println("  Âge insuffisant");
        }
        return valid;
    }

    public static boolean checkTerms(boolean acceptedTerms) {
        if (!acceptedTerms) {
            System.out.println("  Conditions non acceptées");
        }
        return acceptedTerms;
    }
}
```

**Sortie du Code C avec données invalides :**

```text
Validation avec Code C:
  Âge insuffisant
  Conditions non acceptées
Inscription valide: false
```

**Points clés :**

- `&&` : Évaluation en court-circuit (s'arrête à false) → **performant mais
  incomplet**
- `&` : Évaluation complète (toujours) → **affiche tous les problèmes**
- Pour les validations utilisateur : préférez afficher **tous** les messages
  d'erreur
- Pour les vérifications de sécurité : le court-circuit suffit (un échec =
  rejet)
- Simplifiez toujours les patterns `if-condition-return-true-else-return-false`

</details>

## Exercices de modification

Ces exercices vous entraînent à adapter du code existant pour répondre à de
nouvelles exigences.

### Exercice 8 - Refactorisation d'expressions avec négations multiples

Le code suivant fonctionne mais contient des expressions booléennes complexes
avec de nombreuses négations. Refactorisez-le pour le rendre plus lisible.

**Code initial :**

```java
public class SecurityChecker {
    public static void main(String[] args) {
        // Scénario 1
        boolean isGuest = true;
        boolean hasPermission = false;
        boolean isBlocked = false;

        System.out.println("Scénario 1 - Utilisateur invité sans permission:");
        checkAccess(isGuest, hasPermission, isBlocked);

        // Scénario 2
        isGuest = false;
        hasPermission = true;
        isBlocked = false;

        System.out.println("\nScénario 2 - Utilisateur authentifié avec permission:");
        checkAccess(isGuest, hasPermission, isBlocked);

        // Scénario 3
        isGuest = false;
        hasPermission = true;
        isBlocked = true;

        System.out.println("\nScénario 3 - Utilisateur bloqué:");
        checkAccess(isGuest, hasPermission, isBlocked);
    }

    public static void checkAccess(boolean isGuest, boolean hasPermission,
                                    boolean isBlocked) {
        // Expression complexe avec multiples négations
        if (!(isGuest == true) && !(hasPermission == false) && !(isBlocked == true)) {
            System.out.println("Accès autorisé");
        } else {
            System.out.println("Accès refusé");

            // Messages d'erreur avec négations complexes
            if (!(isGuest == false)) {
                System.out.println("   Raison: Compte invité");
            }
            if (!(hasPermission == true)) {
                System.out.println("   Raison: Pas de permission");
            }
            if (!(isBlocked == false)) {
                System.out.println("   Raison: Compte bloqué");
            }
        }
    }
}
```

**Tâche :** Simplifiez les expressions booléennes en :

1. Éliminant les comparaisons inutiles (`== true`, `== false`)
2. Réduisant les doubles négations (`!(x == false)`)
3. Utilisant des noms de variables ou expressions plus claires

<details>
<summary>Indice</summary>

- `!(isGuest == true)` est équivalent à `!isGuest`
- `!(hasPermission == false)` est équivalent à `hasPermission`
- `!(isBlocked == true)` est équivalent à `!isBlocked`
- `!(isGuest == false)` est équivalent à `isGuest`
- `!(hasPermission == true)` est équivalent à `!hasPermission`
- `!(isBlocked == false)` est équivalent à `isBlocked`

</details>

<details>
<summary>Afficher la solution</summary>

**Code refactorisé :**

```java
public class SecurityChecker {
    public static void main(String[] args) {
        // Scénario 1
        boolean isGuest = true;
        boolean hasPermission = false;
        boolean isBlocked = false;

        System.out.println("Scénario 1 - Utilisateur invité sans permission:");
        checkAccess(isGuest, hasPermission, isBlocked);

        // Scénario 2
        isGuest = false;
        hasPermission = true;
        isBlocked = false;

        System.out.println("\nScénario 2 - Utilisateur authentifié avec permission:");
        checkAccess(isGuest, hasPermission, isBlocked);

        // Scénario 3
        isGuest = false;
        hasPermission = true;
        isBlocked = true;

        System.out.println("\nScénario 3 - Utilisateur bloqué:");
        checkAccess(isGuest, hasPermission, isBlocked);
    }

    public static void checkAccess(boolean isGuest, boolean hasPermission,
                                    boolean isBlocked) {
        // Expression simplifiée et claire
        if (!isGuest && hasPermission && !isBlocked) {
            System.out.println("Accès autorisé");
        } else {
            System.out.println("Accès refusé");

            // Messages d'erreur simplifiés
            if (isGuest) {
                System.out.println("   Raison: Compte invité");
            }
            if (!hasPermission) {
                System.out.println("   Raison: Pas de permission");
            }
            if (isBlocked) {
                System.out.println("   Raison: Compte bloqué");
            }
        }
    }
}
```

**Sortie attendue :**

```text
Scénario 1 - Utilisateur invité sans permission:
Accès refusé
   Raison: Compte invité
   Raison: Pas de permission

Scénario 2 - Utilisateur authentifié avec permission:
Accès autorisé

Scénario 3 - Utilisateur bloqué:
Accès refusé
   Raison: Compte bloqué
```

**Simplifications appliquées :**

| Expression originale        | Expression simplifiée | Explication               |
| :-------------------------- | :-------------------- | :------------------------ |
| `!(isGuest == true)`        | `!isGuest`            | Élimination de `== true`  |
| `!(hasPermission == false)` | `hasPermission`       | Double négation → positif |
| `!(isBlocked == true)`      | `!isBlocked`          | Élimination de `== true`  |
| `!(isGuest == false)`       | `isGuest`             | Double négation → positif |
| `!(hasPermission == true)`  | `!hasPermission`      | Élimination de `== true`  |
| `!(isBlocked == false)`     | `isBlocked`           | Double négation → positif |

**Version alternative avec condition positive :**

Si vous préférez une logique positive, vous pouvez renommer les variables :

```java
public static void checkAccess(boolean isGuest, boolean hasPermission,
                                boolean isBlocked) {
    boolean isAuthenticated = !isGuest;
    boolean isAllowed = !isBlocked;

    if (isAuthenticated && hasPermission && isAllowed) {
        System.out.println("Accès autorisé");
    } else {
        System.out.println("Accès refusé");

        if (!isAuthenticated) {
            System.out.println("   Raison: Non authentifié");
        }
        if (!hasPermission) {
            System.out.println("   Raison: Pas de permission");
        }
        if (!isAllowed) {
            System.out.println("   Raison: Compte bloqué");
        }
    }
}
```

**Points clés :**

- Évitez les comparaisons inutiles avec `true` ou `false`
- Les doubles négations (`!(x == false)`) sont équivalentes à `x`
- Préférez des noms de variables qui évitent les négations multiples
- Le code simple est plus facile à comprendre et à maintenir

</details>

### Exercice 9 - Simplification de conditions if-else if-else

Le code suivant détermine le statut d'une commande en ligne. Il fonctionne mais
contient des conditions redondantes et complexes. Simplifiez-le.

**Code initial :**

```java
public class OrderStatus {
    public static void main(String[] args) {
        // Test différents scénarios
        System.out.println("Scénario 1:");
        checkOrder(true, true, false);

        System.out.println("\nScénario 2:");
        checkOrder(true, false, false);

        System.out.println("\nScénario 3:");
        checkOrder(false, true, false);

        System.out.println("\nScénario 4:");
        checkOrder(true, true, true);
    }

    public static void checkOrder(boolean isPaid, boolean isInStock, boolean isCanceled) {
        System.out.println("État: payé=" + isPaid + ", stock=" + isInStock +
                           ", annulé=" + isCanceled);

        // Conditions complexes et redondantes
        if (isCanceled == true) {
            System.out.println("→ Commande annulée");
        } else {
            if (isPaid == true) {
                if (isInStock == true) {
                    if (isCanceled == false) {
                        System.out.println("→ Commande prête à expédier");
                    }
                } else {
                    if (isCanceled == false) {
                        System.out.println("→ En attente de stock");
                    }
                }
            } else {
                if (isInStock == true) {
                    if (isCanceled == false) {
                        System.out.println("→ En attente de paiement");
                    }
                } else {
                    if (isCanceled == false) {
                        System.out.println("→ En attente de paiement et de stock");
                    }
                }
            }
        }
    }
}
```

**Tâche :** Refactorisez ce code en :

1. Éliminant les comparaisons inutiles avec `true` et `false`
2. Réduisant l'imbrication des conditions
3. Éliminant les vérifications redondantes de `isCanceled`
4. Utilisant une structure plus lisible

<details>
<summary>Indice 1</summary>

Si la commande est annulée, on peut retourner immédiatement sans vérifier les
autres conditions (early return).

</details>

<details>
<summary>Indice 2</summary>

Les quatre cas non-annulés peuvent être représentés par une combinaison de deux
booléens :

- `isPaid && isInStock` → "Prête à expédier"
- `isPaid && !isInStock` → "En attente de stock"
- `!isPaid && isInStock` → "En attente de paiement"
- `!isPaid && !isInStock` → "En attente de paiement et de stock"

</details>

<details>
<summary>Afficher la solution</summary>

**Code refactorisé (Version 1 - avec if-else) :**

```java
public class OrderStatus {
    public static void main(String[] args) {
        // Test différents scénarios
        System.out.println("Scénario 1:");
        checkOrder(true, true, false);

        System.out.println("\nScénario 2:");
        checkOrder(true, false, false);

        System.out.println("\nScénario 3:");
        checkOrder(false, true, false);

        System.out.println("\nScénario 4:");
        checkOrder(true, true, true);
    }

    public static void checkOrder(boolean isPaid, boolean isInStock, boolean isCanceled) {
        System.out.println("État: payé=" + isPaid + ", stock=" + isInStock +
                           ", annulé=" + isCanceled);

        // Vérification d'annulation en premier (early return)
        if (isCanceled) {
            System.out.println("→ Commande annulée");
            return;
        }

        // Structure simplifiée avec conditions claires
        if (isPaid && isInStock) {
            System.out.println("→ Commande prête à expédier");
        } else if (isPaid) {  // && !isInStock est implicite
            System.out.println("→ En attente de stock");
        } else if (isInStock) {  // && !isPaid est implicite
            System.out.println("→ En attente de paiement");
        } else {  // !isPaid && !isInStock
            System.out.println("→ En attente de paiement et de stock");
        }
    }
}
```

**Code refactorisé (Version 2 - encore plus concis) :**

```java
public class OrderStatus {
    public static void main(String[] args) {
        System.out.println("Scénario 1:");
        System.out.println("→ " + getOrderStatus(true, true, false));

        System.out.println("\nScénario 2:");
        System.out.println("→ " + getOrderStatus(true, false, false));

        System.out.println("\nScénario 3:");
        System.out.println("→ " + getOrderStatus(false, true, false));

        System.out.println("\nScénario 4:");
        System.out.println("→ " + getOrderStatus(true, true, true));
    }

    public static String getOrderStatus(boolean isPaid, boolean isInStock,
                                         boolean isCanceled) {
        if (isCanceled) {
            return "Commande annulée";
        }

        if (isPaid && isInStock) {
            return "Commande prête à expédier";
        }

        if (isPaid) {
            return "En attente de stock";
        }

        if (isInStock) {
            return "En attente de paiement";
        }

        return "En attente de paiement et de stock";
    }
}
```

**Sortie attendue (toutes versions) :**

```text
Scénario 1:
État: payé=true, stock=true, annulé=false
→ Commande prête à expédier

Scénario 2:
État: payé=true, stock=false, annulé=false
→ En attente de stock

Scénario 3:
État: payé=false, stock=true, annulé=false
→ En attente de paiement

Scénario 4:
État: payé=true, stock=true, annulé=true
→ Commande annulée
```

**Simplifications appliquées :**

| Aspect                       | Code original       | Code refactorisé |
| :--------------------------- | :------------------ | :--------------- |
| Comparaisons `== true/false` | Présentes partout   | Éliminées        |
| Vérifications `isCanceled`   | Dans chaque branche | Une seule fois   |
| Niveaux d'imbrication        | 4 niveaux           | 1 niveau         |
| Lignes de code               | ~30 lignes          | ~15 lignes       |
| Lisibilité                   | Difficile           | Claire           |

**Table de vérité simplifiée :**

| `isCanceled` | `isPaid` | `isInStock` | Résultat                           |
| :----------- | :------- | :---------- | :--------------------------------- |
| `true`       | -        | -           | Commande annulée                   |
| `false`      | `true`   | `true`      | Commande prête à expédier          |
| `false`      | `true`   | `false`     | En attente de stock                |
| `false`      | `false`  | `true`      | En attente de paiement             |
| `false`      | `false`  | `false`     | En attente de paiement et de stock |

**Points clés :**

- **Early return** : Évacuer les cas spéciaux en premier réduit l'imbrication
- **Éliminer les comparaisons redondantes** : `== true` et `== false` sont
  inutiles
- **Conditions mutuellement exclusives** : Avec `else if`, pas besoin de répéter
  les négations
- **Retourner des valeurs** : Préférez retourner un résultat plutôt que
  d'afficher directement

</details>

## Exercices de transfert

Ces exercices vous demandent d'appliquer les concepts appris dans de nouveaux
contextes, démontrant une maîtrise approfondie.

### Exercice 10 - Système de validation de formulaire

Créez un système de validation pour un formulaire d'inscription à un événement.
Le formulaire doit vérifier plusieurs critères et afficher des messages d'erreur
appropriés.

**Spécifications :**

Un·e participant·e peut s'inscrire si **toutes** les conditions suivantes sont
remplies :

1. Le nom n'est pas vide (au moins 2 caractères)
2. L'email contient un `@` et un `.`
3. L'âge est entre 16 et 100 ans (inclus)
4. Si la personne est mineure (< 18 ans), elle doit avoir une autorisation
   parentale
5. La personne doit accepter les conditions d'utilisation

**Tâche :** Implémentez la méthode `validateRegistration` qui :

- Retourne `true` si l'inscription est valide
- Retourne `false` sinon
- Affiche tous les messages d'erreur pertinents

**Code à compléter :**

```java
public class EventRegistration {
    public static void main(String[] args) {
        System.out.println("=== Test 1 : Inscription valide (majeur·e) ===");
        boolean result1 = validateRegistration("Alice Dupont", "alice@email.com",
                                                 25, false, true);
        System.out.println("Résultat: " + (result1 ? "VALIDE" : "INVALIDE") + "\n");

        System.out.println("=== Test 2 : Mineur·e avec autorisation ===");
        boolean result2 = validateRegistration("Bob Martin", "bob@email.com",
                                                 17, true, true);
        System.out.println("Résultat: " + (result2 ? "VALIDE" : "INVALIDE") + "\n");

        System.out.println("=== Test 3 : Mineur·e sans autorisation ===");
        boolean result3 = validateRegistration("Charlie Petit", "charlie@email.com",
                                                 16, false, true);
        System.out.println("Résultat: " + (result3 ? "VALIDE" : "INVALIDE") + "\n");

        System.out.println("=== Test 4 : Multiples erreurs ===");
        boolean result4 = validateRegistration("D", "invalid-email",
                                                 150, false, false);
        System.out.println("Résultat: " + (result4 ? "VALIDE" : "INVALIDE") + "\n");
    }

    public static boolean validateRegistration(String name, String email, int age,
                                                 boolean hasParentalConsent,
                                                 boolean acceptsTerms) {
        // TODO: Implémenter la validation complète
        return false;
    }
}
```

<details>
<summary>Indice 1</summary>

Utilisez l'opérateur `&` (ET binaire) au lieu de `&&` pour évaluer **toutes**
les conditions même si certaines sont fausses. Cela permet d'afficher tous les
messages d'erreur.

</details>

<details>
<summary>Indice 2</summary>

Pour la validation email, vous pouvez utiliser :

```java
email != null && email.contains("@") && email.contains(".")
```

</details>

<details>
<summary>Indice 3</summary>

Pour l'autorisation parentale, pensez à l'implication logique :

- Si `age >= 18` : pas besoin d'autorisation
- Si `age < 18` : l'autorisation est requise (`hasParentalConsent` doit être
  `true`)

Cela peut s'écrire : `age >= 18 || hasParentalConsent`

</details>

<details>
<summary>Afficher la solution</summary>

**Solution complète :**

```java
public class EventRegistration {
    public static void main(String[] args) {
        System.out.println("=== Test 1 : Inscription valide (majeur·e) ===");
        boolean result1 = validateRegistration("Alice Dupont", "alice@email.com",
                                                 25, false, true);
        System.out.println("Résultat: " + (result1 ? "VALIDE" : "INVALIDE") + "\n");

        System.out.println("=== Test 2 : Mineur·e avec autorisation ===");
        boolean result2 = validateRegistration("Bob Martin", "bob@email.com",
                                                 17, true, true);
        System.out.println("Résultat: " + (result2 ? "VALIDE" : "INVALIDE") + "\n");

        System.out.println("=== Test 3 : Mineur·e sans autorisation ===");
        boolean result3 = validateRegistration("Charlie Petit", "charlie@email.com",
                                                 16, false, true);
        System.out.println("Résultat: " + (result3 ? "VALIDE" : "INVALIDE") + "\n");

        System.out.println("=== Test 4 : Multiples erreurs ===");
        boolean result4 = validateRegistration("D", "invalid-email",
                                                 150, false, false);
        System.out.println("Résultat: " + (result4 ? "VALIDE" : "INVALIDE") + "\n");
    }

    public static boolean validateRegistration(String name, String email, int age,
                                                 boolean hasParentalConsent,
                                                 boolean acceptsTerms) {
        boolean isValid = true;

        // Validation du nom
        boolean nameValid = name != null && name.length() >= 2;
        if (!nameValid) {
            System.out.println("Le nom doit contenir au moins 2 caractères");
            isValid = false;
        }

        // Validation de l'email
        boolean emailValid = email != null && email.contains("@") && email.contains(".");
        if (!emailValid) {
            System.out.println("L'email doit contenir @ et .");
            isValid = false;
        }

        // Validation de l'âge
        boolean ageValid = age >= 16 && age <= 100;
        if (!ageValid) {
            System.out.println("L'âge doit être entre 16 et 100 ans");
            isValid = false;
        }

        // Validation de l'autorisation parentale (uniquement si mineur·e)
        boolean consentValid = age >= 18 || hasParentalConsent;
        if (age < 18 && !hasParentalConsent) {
            System.out.println("Autorisation parentale requise pour les mineur·es");
            isValid = false;
        }

        // Validation de l'acceptation des conditions
        if (!acceptsTerms) {
            System.out.println("Vous devez accepter les conditions d'utilisation");
            isValid = false;
        }

        return isValid;
    }
}
```

**Sortie attendue :**

```text
=== Test 1 : Inscription valide (majeur·e) ===
Résultat: VALIDE

=== Test 2 : Mineur·e avec autorisation ===
Résultat: VALIDE

=== Test 3 : Mineur·e sans autorisation ===
Autorisation parentale requise pour les mineur·es
Résultat: INVALIDE

=== Test 4 : Multiples erreurs ===
Le nom doit contenir au moins 2 caractères
L'email doit contenir @ et .
L'âge doit être entre 16 et 100 ans
Vous devez accepter les conditions d'utilisation
Résultat: INVALIDE
```

**Solution alternative (plus concise) :**

```java
public static boolean validateRegistration(String name, String email, int age,
                                             boolean hasParentalConsent,
                                             boolean acceptsTerms) {
    boolean allValid = true;

    // Utiliser & pour forcer l'évaluation de toutes les conditions
    allValid = validateName(name) & allValid;
    allValid = validateEmail(email) & allValid;
    allValid = validateAge(age) & allValid;
    allValid = validateConsent(age, hasParentalConsent) & allValid;
    allValid = validateTerms(acceptsTerms) & allValid;

    return allValid;
}

private static boolean validateName(String name) {
    boolean valid = name != null && name.length() >= 2;
    if (!valid) {
        System.out.println("Le nom doit contenir au moins 2 caractères");
    }
    return valid;
}

private static boolean validateEmail(String email) {
    boolean valid = email != null && email.contains("@") && email.contains(".");
    if (!valid) {
        System.out.println("L'email doit contenir @ et .");
    }
    return valid;
}

private static boolean validateAge(int age) {
    boolean valid = age >= 16 && age <= 100;
    if (!valid) {
        System.out.println("L'âge doit être entre 16 et 100 ans");
    }
    return valid;
}

private static boolean validateConsent(int age, boolean hasParentalConsent) {
    boolean valid = age >= 18 || hasParentalConsent;
    if (!valid) {
        System.out.println("Autorisation parentale requise pour les mineur·es");
    }
    return valid;
}

private static boolean validateTerms(boolean acceptsTerms) {
    if (!acceptsTerms) {
        System.out.println("Vous devez accepter les conditions d'utilisation");
    }
    return acceptsTerms;
}
```

**Concepts appliqués :**

- **Expressions booléennes complexes** : Combinaison de multiples conditions
- **Opérateur `&`** : Pour évaluer toutes les conditions (vs `&&` qui
  court-circuite)
- **Implication logique** : `age >= 18 || hasParentalConsent` (si majeur·e OU a
  autorisation)
- **Validation complète** : Afficher tous les problèmes en une fois
- **Early validation** : Vérifier tous les critères même en cas d'erreur

**Points clés :**

- Utilisez `&` au lieu de `&&` pour afficher tous les messages d'erreur
- L'implication "si A alors B" s'écrit `!A || B` en logique booléenne
- Décomposer en méthodes améliore la lisibilité et la testabilité
- Pour l'UX, mieux vaut afficher toutes les erreurs que une par une

</details>

### Exercice 11 - Système de contrôle d'accès avec règles complexes

Créez un système de contrôle d'accès pour un système informatique avec des
règles de sécurité complexes. Le système doit gérer différents niveaux d'accès
et conditions de sécurité.

**Contexte :**

Un système informatique utilise les règles suivantes pour autoriser l'accès :

- **Authentification de base** :
  - La personne doit être authentifiée
  - Le compte ne doit pas être verrouillé
  - Le mot de passe ne doit pas être expiré

- **Règles d'accès selon le niveau** :
  - **Niveau 1 (Public)** : Accessible à toute personne authentifiée
  - **Niveau 2 (Interne)** : Requiert d'être employé·e OU avoir un badge
    visiteur valide
  - **Niveau 3 (Confidentiel)** : Requiert d'être employé·e ET avoir une
    habilitation de sécurité
  - **Niveau 4 (Secret)** : Requiert niveau 3 ET être dans la liste approuvée

- **Règles temporelles** :
  - Les visiteur·ses peuvent accéder uniquement en heures ouvrables (8h-18h)
  - Le personnel peut accéder 24/7

**Tâche :** Implémentez la méthode `checkAccess` qui détermine si l'accès doit
être accordé.

**Code à compléter :**

```java
public class AccessControl {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Employé·e avec habilitation (Niveau 3) ===");
        checkAccess(
            true,  // isAuthenticated
            false, // isLocked
            false, // isPasswordExpired
            3,     // securityLevel
            true,  // isEmployee
            false, // hasVisitorBadge
            true,  // hasClearance
            false, // isOnApprovedList
            14     // currentHour
        );

        System.out.println("\n=== Test 2: Visiteur·se avec badge (Niveau 2, heures ouvrables) ===");
        checkAccess(true, false, false, 2, false, true, false, false, 10);

        System.out.println("\n=== Test 3: Visiteur·se hors heures ouvrables ===");
        checkAccess(true, false, false, 2, false, true, false, false, 20);

        System.out.println("\n=== Test 4: Accès niveau 4 sans approbation ===");
        checkAccess(true, false, false, 4, true, false, true, false, 14);

        System.out.println("\n=== Test 5: Multiples problèmes de sécurité ===");
        checkAccess(true, true, true, 3, false, false, false, false, 14);
    }

    public static void checkAccess(boolean isAuthenticated, boolean isLocked,
                                    boolean isPasswordExpired, int securityLevel,
                                    boolean isEmployee, boolean hasVisitorBadge,
                                    boolean hasClearance, boolean isOnApprovedList,
                                    int currentHour) {
        // TODO: Implémenter le système de contrôle d'accès
    }
}
```

<details>
<summary>Indice 1</summary>

Commencez par vérifier l'authentification de base :

```java
boolean basicAuthOK = isAuthenticated && !isLocked && !isPasswordExpired;
```

</details>

<details>
<summary>Indice 2</summary>

Pour les heures ouvrables des visiteur·ses :

```java
boolean isBusinessHours = currentHour >= 8 && currentHour < 18;
boolean timeAccessOK = isEmployee || isBusinessHours;
```

</details>

<details>
<summary>Indice 3</summary>

Créez une condition pour chaque niveau de sécurité :

- Niveau 1 : pas de conditions supplémentaires
- Niveau 2 : `isEmployee || hasVisitorBadge`
- Niveau 3 : `isEmployee && hasClearance`
- Niveau 4 : `isEmployee && hasClearance && isOnApprovedList`

</details>

</details>

<details>
<summary>Afficher la solution</summary>

**Solution complète :**

```java
public class AccessControl {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Employé·e avec habilitation (Niveau 3) ===");
        checkAccess(true, false, false, 3, true, false, true, false, 14);

        System.out.println("\n=== Test 2: Visiteur·se avec badge (Niveau 2, heures ouvrables) ===");
        checkAccess(true, false, false, 2, false, true, false, false, 10);

        System.out.println("\n=== Test 3: Visiteur·se hors heures ouvrables ===");
        checkAccess(true, false, false, 2, false, true, false, false, 20);

        System.out.println("\n=== Test 4: Accès niveau 4 sans approbation ===");
        checkAccess(true, false, false, 4, true, false, true, false, 14);

        System.out.println("\n=== Test 5: Multiples problèmes de sécurité ===");
        checkAccess(true, true, true, 3, false, false, false, false, 14);
    }

    public static void checkAccess(boolean isAuthenticated, boolean isLocked,
                                    boolean isPasswordExpired, int securityLevel,
                                    boolean isEmployee, boolean hasVisitorBadge,
                                    boolean hasClearance, boolean isOnApprovedList,
                                    int currentHour) {
        System.out.println("Vérification d'accès pour niveau " + securityLevel + ":");

        boolean accessGranted = true;

        // 1. Vérification de l'authentification de base
        if (!isAuthenticated) {
            System.out.println("  Non authentifié·e");
            accessGranted = false;
        }

        if (isLocked) {
            System.out.println("  Compte verrouillé");
            accessGranted = false;
        }

        if (isPasswordExpired) {
            System.out.println("  Mot de passe expiré");
            accessGranted = false;
        }

        // Si l'authentification de base échoue, arrêter ici
        if (!accessGranted) {
            System.out.println("→ ACCÈS REFUSÉ");
            return;
        }

        // 2. Vérification des contraintes temporelles
        boolean isBusinessHours = currentHour >= 8 && currentHour < 18;
        if (!isEmployee && !isBusinessHours) {
            System.out.println("  Les visiteur·ses ne peuvent accéder qu'entre 8h et 18h");
            System.out.println("     (Heure actuelle: " + currentHour + "h)");
            accessGranted = false;
        }

        // 3. Vérification du niveau de sécurité
        boolean levelAccessOK = false;

        switch (securityLevel) {
            case 1:  // Public
                levelAccessOK = true;
                break;

            case 2:  // Interne
                levelAccessOK = isEmployee || hasVisitorBadge;
                if (!levelAccessOK) {
                    System.out.println("  Niveau 2 requiert: employé·e OU badge visiteur");
                }
                break;

            case 3:  // Confidentiel
                levelAccessOK = isEmployee && hasClearance;
                if (!isEmployee) {
                    System.out.println("  Niveau 3 requiert: être employé·e");
                }
                if (!hasClearance) {
                    System.out.println("  Niveau 3 requiert: habilitation de sécurité");
                }
                break;

            case 4:  // Secret
                levelAccessOK = isEmployee && hasClearance && isOnApprovedList;
                if (!isEmployee) {
                    System.out.println("  Niveau 4 requiert: être employé·e");
                }
                if (!hasClearance) {
                    System.out.println("  Niveau 4 requiert: habilitation de sécurité");
                }
                if (!isOnApprovedList) {
                    System.out.println("  Niveau 4 requiert: être sur la liste approuvée");
                }
                break;

            default:
                System.out.println("  Niveau de sécurité invalide");
                levelAccessOK = false;
        }

        accessGranted = accessGranted && levelAccessOK;

        // 4. Résultat final
        if (accessGranted) {
            System.out.println("→ ACCÈS ACCORDÉ");
        } else {
            System.out.println("→ ACCÈS REFUSÉ");
        }
    }
}
```

**Sortie attendue :**

```text
=== Test 1: Employé·e avec habilitation (Niveau 3) ===
Vérification d'accès pour niveau 3:
→ ACCÈS ACCORDÉ

=== Test 2: Visiteur·se avec badge (Niveau 2, heures ouvrables) ===
Vérification d'accès pour niveau 2:
→ ACCÈS ACCORDÉ

=== Test 3: Visiteur·se hors heures ouvrables ===
Vérification d'accès pour niveau 2:
  Les visiteur·ses ne peuvent accéder qu'entre 8h et 18h
     (Heure actuelle: 20h)
→ ACCÈS REFUSÉ

=== Test 4: Accès niveau 4 sans approbation ===
Vérification d'accès pour niveau 4:
  Niveau 4 requiert: être sur la liste approuvée
→ ACCÈS REFUSÉ

=== Test 5: Multiples problèmes de sécurité ===
Vérification d'accès pour niveau 3:
  Compte verrouillé
  Mot de passe expiré
→ ACCÈS REFUSÉ
```

**Table de vérité pour les niveaux :**

| Niveau | Condition                                        |
| :----- | :----------------------------------------------- |
| 1      | `true` (authentification de base suffit)         |
| 2      | `isEmployee \|\| hasVisitorBadge`                |
| 3      | `isEmployee && hasClearance`                     |
| 4      | `isEmployee && hasClearance && isOnApprovedList` |

**Expressions booléennes clés :**

```java
// Authentification de base (toutes requises)
basicAuth = isAuthenticated && !isLocked && !isPasswordExpired

// Contrainte temporelle (visiteur·ses seulement)
timeOK = isEmployee || (currentHour >= 8 && currentHour < 18)

// Niveau 2 (au moins une des deux)
level2 = isEmployee || hasVisitorBadge

// Niveau 3 (les deux requises)
level3 = isEmployee && hasClearance

// Niveau 4 (les trois requises)
level4 = isEmployee && hasClearance && isOnApprovedList

// Accès final (tout doit être OK)
access = basicAuth && timeOK && levelAccess
```

**Solution alternative (plus modulaire) :**

```java
public static void checkAccess(/* ... paramètres ... */) {
    System.out.println("Vérification d'accès pour niveau " + securityLevel + ":");

    boolean hasBasicAuth = checkBasicAuth(isAuthenticated, isLocked, isPasswordExpired);
    if (!hasBasicAuth) {
        System.out.println("→ ACCÈS REFUSÉ");
        return;
    }

    boolean hasTimeAccess = checkTimeAccess(isEmployee, currentHour);
    boolean hasLevelAccess = checkLevelAccess(securityLevel, isEmployee,
                                               hasVisitorBadge, hasClearance,
                                               isOnApprovedList);

    if (hasTimeAccess && hasLevelAccess) {
        System.out.println("→ ACCÈS ACCORDÉ");
    } else {
        System.out.println("→ ACCÈS REFUSÉ");
    }
}

private static boolean checkBasicAuth(boolean isAuthenticated, boolean isLocked,
                                       boolean isPasswordExpired) {
    boolean ok = true;
    if (!isAuthenticated) {
        System.out.println("  Non authentifié·e");
        ok = false;
    }
    if (isLocked) {
        System.out.println("  Compte verrouillé");
        ok = false;
    }
    if (isPasswordExpired) {
        System.out.println("  Mot de passe expiré");
        ok = false;
    }
    return ok;
}

private static boolean checkTimeAccess(boolean isEmployee, int currentHour) {
    boolean isBusinessHours = currentHour >= 8 && currentHour < 18;
    if (!isEmployee && !isBusinessHours) {
        System.out.println("  Les visiteur·ses ne peuvent accéder qu'entre 8h et 18h");
        System.out.println("     (Heure actuelle: " + currentHour + "h)");
        return false;
    }
    return true;
}

private static boolean checkLevelAccess(int level, boolean isEmployee,
                                         boolean hasVisitorBadge, boolean hasClearance,
                                         boolean isOnApprovedList) {
    switch (level) {
        case 1: return true;
        case 2: return checkLevel2(isEmployee, hasVisitorBadge);
        case 3: return checkLevel3(isEmployee, hasClearance);
        case 4: return checkLevel4(isEmployee, hasClearance, isOnApprovedList);
        default:
            System.out.println("  Niveau de sécurité invalide");
            return false;
    }
}

// Méthodes checkLevel2, checkLevel3, checkLevel4 similaires
```

**Concepts appliqués :**

- **Expressions booléennes complexes** : `&&`, `||`, `!` combinés
- **Court-circuit** : Arrêt précoce si authentification échoue
- **Validation en couches** : Authentification → Temps → Niveau
- **Logique implicative** : "Si visiteur·se alors heures ouvrables"
- **Conditions hiérarchiques** : Niveau 4 inclut niveau 3 + conditions
  supplémentaires

**Points clés :**

- Structurez les vérifications par ordre de priorité (base → spécifique)
- Utilisez des variables intermédiaires pour améliorer la lisibilité
- Les conditions complexes bénéficient d'une décomposition en méthodes
- Early return évite l'imbrication excessive de conditions
- Pensez à la sécurité : mieux vaut refuser par défaut que permettre

</details>

<!-- URLs -->

[licence]: https://creativecommons.org/licenses/by-sa/4.0/
