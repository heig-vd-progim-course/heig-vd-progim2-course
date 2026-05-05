# Exemple 01 - Programme fragile

**Objectif pédagogique :** observer ce qui se passe quand une exception n'est
pas gérée.

**Concepts illustrés :**

- Comportement par défaut de Java face à une exception non capturée.
- Arrêt brutal du programme.
- Trace de pile (_stack trace_) affichée dans le terminal.
- La ligne après l'erreur n'est jamais atteinte.

## Description

Ce programme tente de lire des valeurs de pH depuis un tableau de chaines de
caractères. L'une des valeurs, `"abc"`, n'est pas un nombre valide.

Sans gestion d'erreurs, `Double.parseDouble()` lève une `NumberFormatException`
qui remonte la pile d'appels jusqu'à la JVM, qui arrête alors le programme
brutalement en affichant la trace de pile.

## Code

Le fichier `ProgrammeFragile.java` contient le programme complet.

## Sortie attendue

```
=== Lecture des valeurs de pH ===
pH lu : 7.2
Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
	at java.base/java.lang.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
	at java.base/java.lang.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
	at java.base/java.lang.Double.parseDouble(Double.java:543)
	at ProgrammeFragile.main(ProgrammeFragile.java:18)
```

La ligne `"pH lu : 13.5"` et `"Lecture terminée."` ne sont jamais affichées.

## Points clés à retenir

- Une exception non capturée arrête le programme à la ligne exacte où elle est
  levée.
- La trace de pile indique précisément quelle ligne a causé le problème.
- L'exception `NumberFormatException` est levée par `Double.parseDouble()`.
- Sans gestion d'erreurs, aucun message métier utile n'est affiché.

---

**Exemple suivant :** [02-try-catch-base](../02-try-catch-base/)
