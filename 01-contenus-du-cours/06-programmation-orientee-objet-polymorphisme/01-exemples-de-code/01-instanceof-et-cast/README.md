# Exemple 01 - instanceof et cast

## Objectif pédagogique

Comprendre l'utilisation de l'opérateur `instanceof` pour vérifier le type d'un
objet et effectuer un cast (conversion de type) de manière sécurisée.

## Concepts illustrés

- Vérification de type avec `instanceof`
- Cast (conversion de type) sécurisé
- Accès aux membres spécifiques après le cast
- Gestion des différents types dans une hiérarchie

## Description

Cet exemple montre comment utiliser `instanceof` pour vérifier si un objet est
d'un type particulier avant d'effectuer un cast. Cela permet d'accéder aux
attributs et méthodes spécifiques d'une sous-classe de manière sûre.

L'exemple utilise une hiérarchie de vélos (identique au contenu de cours) pour
illustrer ces concepts.

## Code Java

Le code se trouve dans le fichier `BikeDemo.java`.

## Sortie attendue

```
=== Test de instanceof ===
bike1 est un Bike: true
bike1 est un ElectricBike: true
bike1 est un HumanPoweredBike: false

bike2 est un Bike: true
bike2 est un ElectricBike: false
bike2 est un HumanPoweredBike: true

=== Gestion spécifique par type ===
Vélo électrique VanMoof S3
  Niveau batterie: 75%

Vélo classique Decathlon Riverside
  Nombre de vitesses: 21

Vélo électrique Stromer ST5
  Niveau batterie: 50%
```

## Points clés à retenir

- `instanceof` vérifie si un objet est une instance d'un type (classe ou
  interface)
- `instanceof` retourne `true` si l'objet est du type vérifié ou d'un sous-type
- `instanceof` retourne `false` si l'objet est `null` (pas d'exception)
- Toujours vérifier avec `instanceof` **avant** de faire un cast
- Le cast permet d'accéder aux membres spécifiques de la sous-classe

## Suggestions d'expérimentation

1. Testez `instanceof` avec `null` :

   ```java
   Bike bike = null;
   System.out.println(bike instanceof ElectricBike);  // false, pas d'exception
   ```

2. Essayez de faire un cast sans vérification pour voir l'erreur :

   ```java
   Bike bike = new HumanPoweredBike("Trek", "FX", 18);
   ElectricBike electric = (ElectricBike) bike;  // ClassCastException !
   ```

3. Ajoutez un nouveau type de vélo (CargoBike) et adaptez le code

4. Créez une méthode qui compte combien de vélos électriques sont dans une liste

## Pour aller plus loin

- Consultez l'exemple 02 pour voir le polymorphisme comme alternative à
  `instanceof`
- Lisez le contenu de cours sur les limites de l'utilisation excessive de
  `instanceof`
- Explorez l'exemple 04 pour voir les interfaces comme alternative
