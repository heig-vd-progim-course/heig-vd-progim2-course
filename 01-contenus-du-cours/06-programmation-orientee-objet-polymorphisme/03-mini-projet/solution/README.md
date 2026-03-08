# Solution du mini-projet - Polymorphisme

Cette solution complète contient tous les fichiers Java nécessaires pour la
partie 3 du mini-projet sur le polymorphisme.

## Structure des fichiers

```
solution/
└── src/
    ├── Harvestable.java           (interface)
    ├── Waterable.java             (interface)
    ├── Growable.java              (interface)
    ├── PlantBase.java             (classe abstraite)
    ├── VegetablePlant.java        (classe concrète)
    ├── FlowerPlant.java           (classe concrète)
    ├── TreePlant.java             (classe concrète)
    ├── Plot.java                  (classe utilitaire)
    ├── Gardener.java              (classe utilitaire)
    ├── GardenTask.java            (classe utilitaire)
    └── GardenManagementSystem.java (classe principale)
```

## Compilation et exécution

### En ligne de commande

Depuis le dossier `src/`, exécutez :

```bash
# Compilation de tous les fichiers Java
javac *.java

# Exécution de la classe principale
java GardenManagementSystem
```

### Avec un IDE (IntelliJ IDEA, Eclipse, VS Code)

1. Ouvrez votre IDE préféré
2. Importez le dossier `src/` comme projet Java
3. Exécutez la classe `GardenManagementSystem`

## Concepts démontrés

### Interfaces

- `Harvestable` : définit le comportement pour les plantes récoltables
- `Waterable` : définit le comportement pour les plantes arrosables
- `Growable` : définit le comportement pour les plantes qui grandissent

### Implémentation multiple

- `VegetablePlant` : implémente les 3 interfaces
- `FlowerPlant` : implémente `Waterable` et `Growable`
- `TreePlant` : implémente les 3 interfaces

### Polymorphisme

La classe `GardenTask` démontre le polymorphisme en utilisant les interfaces
pour traiter différents types de plantes de manière uniforme.

### Redéfinition de méthodes Object

- `toString()` : représentation textuelle des objets
- `equals()` : comparaison d'objets basée sur le nom et l'espèce
- `hashCode()` : code de hachage cohérent avec equals()

## Sortie attendue

Le programme affiche :

1. Démonstration de `toString()` pour différents types de plantes
2. Rapport du jardin (nombre de plantes par type)
3. Simulation d'arrosage avec polymorphisme
4. Simulation de croissance
5. Récolte des plantes prêtes
6. État final détaillé de toutes les plantes
7. Test de `equals()` et `hashCode()`

## Notes pédagogiques

Cette solution illustre :

- La **définition** et **implémentation** d'interfaces
- L'utilisation du **polymorphisme** avec des tableaux d'interfaces
- La **redéfinition** de méthodes avec `@Override`
- L'utilisation de `instanceof` pour la vérification de type
- La **séparation des responsabilités** entre classes
- Les **bonnes pratiques** Java (encapsulation, validation, documentation)
