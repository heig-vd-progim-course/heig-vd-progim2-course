# Solution du mini-projet - Collections Java

Cette solution complète contient tous les fichiers Java nécessaires pour la
partie 5 du mini-projet sur les collections Java.

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
    ├── Plot.java                  (modifiée - ArrayList)
    ├── Gardener.java              (classe utilitaire)
    ├── GardenTask.java            (classe utilitaire)
    ├── GardenCatalog.java         (nouvelle classe - HashSet)
    ├── GardenRegistry.java        (nouvelle classe - HashMap)
    └── GardenManagementSystem.java (programme principal)
```

## Compilation et exécution

```bash
cd src
javac *.java
java GardenManagementSystem
```
