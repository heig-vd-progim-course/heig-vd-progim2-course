# Solution du mini-projet - Collections Java

Cette solution complète contient tous les fichiers Java nécessaires pour la
partie 4 du mini-projet sur les collections Java.

## Structure des fichiers

```text
solution/
└── src/
    ├── Harvestable.java           (interface - inchangée)
    ├── Waterable.java             (interface - inchangée)
    ├── Growable.java              (interface - inchangée)
    ├── PlantBase.java             (classe abstraite - inchangée)
    ├── VegetablePlant.java        (classe concrète - inchangée)
    ├── FlowerPlant.java           (classe concrète - inchangée)
    ├── TreePlant.java             (classe concrète - inchangée)
    ├── Plot.java                  (modifiée - ArrayList de plantes)
    ├── Gardener.java              (classe utilitaire - inchangée)
    ├── GardenTask.java            (classe utilitaire - inchangée)
    ├── GardenCatalog.java         (nouvelle - HashSet d'espèces)
    ├── GardenRegistry.java        (nouvelle - HashMap jardinière-parcelle)
    └── GardenManagementSystem.java (mis à jour)
```

## Compilation et exécution

```bash
cd src
javac *.java
java GardenManagementSystem
```

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
