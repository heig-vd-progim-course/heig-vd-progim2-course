# Exemple 02 - Polymorphisme d'héritage

## Objectif pédagogique

Comprendre comment le polymorphisme d'héritage permet de traiter différents
objets de manière uniforme via des références de type parent.

## Concepts illustrés

- Références de type parent pour objets de type enfant
- Liaison dynamique (résolution à l'exécution)
- Collections polymorphes
- Avantages du polymorphisme vs `instanceof`

## Description

Cet exemple montre la puissance du polymorphisme d'héritage : au lieu d'utiliser
`instanceof` et des cascades de `if`, on laisse Java appeler automatiquement la
bonne méthode grâce à la liaison dynamique.

Même code, mais le comportement change selon le type réel de l'objet.

## Code Java

Le code se trouve dans le fichier `FleetDemo.java`.

## Sortie attendue

```
=== Réparation de tous les vélos ===
Réparation vélo classique : ajustement des freins et vitesses
Réparation vélo électrique : vérification batterie et moteur
Réparation vélo électrique : vérification batterie et moteur

=== Informations de la flotte ===
Bike{brand='Decathlon', model='Riverside'}
Bike{brand='VanMoof', model='S3'}
Bike{brand='Stromer', model='ST5'}

=== Traitement uniforme ===
Vélo disponible : Decathlon Riverside
Vélo disponible : VanMoof S3
Vélo disponible : Stromer ST5

Total de vélos : 3
```

## Points clés à retenir

- Une variable de type parent peut référencer un objet de type enfant
- La méthode appelée est déterminée par le **type réel** de l'objet (liaison
  dynamique)
- Collections polymorphes permettent de stocker différents types
- Le code est plus court, plus clair et plus extensible
- Ajouter un nouveau type ne nécessite aucune modification du code existant
  (principe ouvert/fermé)

## Suggestions d'expérimentation

1. Ajoutez un nouveau type de vélo (CargoBike) et observez que le code existant
   fonctionne sans modification

2. Créez une méthode `printAllInfo()` qui affiche les informations de tous les
   vélos

3. Implémentez une méthode `getTotalValue()` qui calcule la valeur totale de la
   flotte

4. Comparez la complexité de cette approche avec l'exemple 01 utilisant
   `instanceof`

## Pour aller plus loin

- Consultez l'exemple 03 pour voir la redéfinition de méthodes avec `@Override`
- Lisez le contenu de cours sur la liaison dynamique
- Explorez l'exemple 04 pour découvrir le polymorphisme avec interfaces
