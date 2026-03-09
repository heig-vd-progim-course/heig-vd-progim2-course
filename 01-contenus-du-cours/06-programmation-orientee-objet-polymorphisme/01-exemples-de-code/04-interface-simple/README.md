# Exemple 04 - Interface simple

## Objectif pédagogique

Comprendre comment définir et implémenter une interface en Java pour créer des
contrats de comportement.

## Concepts illustrés

- Définition d'une interface avec `interface`
- Implémentation d'une interface avec `implements`
- Polymorphisme avec interfaces
- Séparation entre contrat et implémentation

## Description

Cet exemple montre comment créer une interface `Electric` qui définit un contrat
pour tous les objets électriques. Seuls les vélos électriques implémentent cette
interface, permettant un traitement spécifique basé sur les **capacités** plutôt
que sur l'héritage.

L'interface définit "ce qu'un objet peut faire", pas "ce qu'il est".

## Code Java

Le code se trouve dans le fichier `InterfaceDemo.java`.

## Sortie attendue

```
=== Vérification des batteries ===
VanMoof S3 - Batterie: 75%
  Batterie OK
Stromer ST5 - Batterie: 15%
  Attention: batterie faible!
  Charge en cours...
  Batterie chargée à 100%

=== Statistiques ===
Nombre d'appareils électriques : 2
```

## Points clés à retenir

- Une interface définit un **contrat** : des méthodes sans implémentation
- Une classe implémente une interface avec `implements`
- Une classe doit implémenter **toutes** les méthodes de l'interface
- Les méthodes d'interface sont `public` par défaut
- Une variable de type interface peut référencer tout objet implémentant
  l'interface
- Les interfaces permettent le polymorphisme basé sur les **capacités**

## Suggestions d'expérimentation

1. Ajoutez une méthode `getPowerSource()` à l'interface `Electric`

2. Créez une nouvelle classe `ElectricScooter` qui implémente `Electric`

3. Ajoutez une constante dans l'interface :

   ```java
   interface Electric {
       int MAX_BATTERY_LEVEL = 100;  // Constante publique
       // ...
   }
   ```

4. Comparez avec l'exemple 01 : l'interface est plus élégante que `instanceof`

## Pour aller plus loin

- Consultez l'exemple 05 pour voir l'implémentation de plusieurs interfaces
- Lisez le contenu de cours sur interface vs classe abstraite
- Explorez l'exemple 06 pour le polymorphisme avec interfaces dans des
  collections
