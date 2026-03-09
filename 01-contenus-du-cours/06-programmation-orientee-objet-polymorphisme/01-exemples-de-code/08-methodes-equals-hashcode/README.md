# Exemple 08 - Méthodes equals() et hashCode()

## Objectif pédagogique

Comprendre comment implémenter correctement les méthodes `equals()` et
`hashCode()` pour comparer des objets de manière significative.

## Concepts illustrés

- Redéfinition de `equals()` pour comparaison par contenu
- Implémentation de `hashCode()` en cohérence avec `equals()`
- Contrat entre `equals()` et `hashCode()`
- Utilisation dans les collections (`HashSet`, `HashMap`)

## Description

Cet exemple montre pourquoi et comment redéfinir `equals()` et `hashCode()`
ensemble. Par défaut, `equals()` compare les références (adresses mémoire), pas
le contenu. Une bonne implémentation permet de comparer des objets de manière
logique.

**Règle d'or** : si vous redéfinissez `equals()`, vous DEVEZ aussi redéfinir
`hashCode()`.

## Code Java

Le code se trouve dans le fichier `EqualsHashCodeDemo.java`.

## Sortie attendue

```
=== Comparaison avec == ===
bike1 == bike2 : false (adresses différentes)
bike1 == bike3 : true (même adresse)

=== Comparaison avec equals() ===
bike1.equals(bike2) : true (même contenu)
bike1.equals(bike3) : true (même objet)
bike1.equals(bike4) : false (contenu différent)

=== HashCode ===
bike1.hashCode() : 1234567
bike2.hashCode() : 1234567 (même valeur car equals = true)
bike4.hashCode() : 7654321 (valeur différente)

=== Test avec HashSet ===
Ajout de bike1 : true
Ajout de bike2 : false (considéré comme doublon)
Ajout de bike4 : true
Taille du HashSet : 2
```

## Points clés à retenir

- `==` compare les **références** (adresses mémoire)
- `equals()` compare le **contenu** (si bien implémenté)
- Si deux objets sont égaux selon `equals()`, ils DOIVENT avoir le même
  `hashCode()`
- `hashCode()` est utilisé par `HashSet`, `HashMap`, etc.
- Sans `hashCode()` correct, les collections ne fonctionnent pas correctement
- Toujours utiliser `@Override` pour éviter les erreurs

## Suggestions d'expérimentation

1. Commentez la méthode `hashCode()` et testez avec un `HashSet` pour voir le
   problème

2. Modifiez `equals()` pour comparer seulement la marque (pas le modèle)

3. Ajoutez un attribut `year` et mettez à jour `equals()` et `hashCode()`

4. Testez avec une `HashMap` :
   ```java
   HashMap<Bike, String> map = new HashMap<>();
   map.put(bike1, "Location A");
   System.out.println(map.get(bike2));  // Doit retourner "Location A"
   ```

## Pour aller plus loin

- Consultez l'exemple 07 pour `toString()`
- Lisez le contenu de cours sur le contrat `equals()`/`hashCode()`
- Explorez la documentation Java sur `Object.equals()` et `Object.hashCode()`
