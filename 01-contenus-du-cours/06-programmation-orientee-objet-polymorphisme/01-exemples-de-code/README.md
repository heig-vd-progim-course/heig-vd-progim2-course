# Exemples de code - Programmation orientée objet : Polymorphisme

Ce dossier contient des exemples de code Java complets pour illustrer les
concepts du polymorphisme en programmation orientée objet (POO).

## Organisation des exemples

Les exemples sont organisés de manière progressive, du plus simple au plus
complexe :

### Bonnes pratiques (01-10)

1. **[01-instanceof-et-cast](01-instanceof-et-cast/)** : Vérification de type
   avec `instanceof` et conversion (cast)
2. **[02-polymorphisme-heritage](02-polymorphisme-heritage/)** : Références de
   type parent et liaison dynamique
3. **[03-redefinition-methodes](03-redefinition-methodes/)** : Redéfinition de
   méthodes avec `@Override`
4. **[04-interface-simple](04-interface-simple/)** : Définition et
   implémentation d'une interface
5. **[05-interfaces-multiples](05-interfaces-multiples/)** : Implémentation de
   plusieurs interfaces
6. **[06-polymorphisme-interfaces](06-polymorphisme-interfaces/)** : Utilisation
   du polymorphisme avec les interfaces
7. **[07-methode-tostring](07-methode-tostring/)** : Redéfinition de la méthode
   `toString()`
8. **[08-methodes-equals-hashcode](08-methodes-equals-hashcode/)** :
   Implémentation de `equals()` et `hashCode()`
9. **[09-collections-polymorphes](09-collections-polymorphes/)** : Collections
   avec types polymorphes
10. **[10-exemple-complet](10-exemple-complet/)** : Exemple complet intégrant
    tous les concepts

## Structure de chaque exemple

Chaque dossier d'exemple contient :

- **README.md** : Documentation pédagogique avec :
  - Objectif pédagogique
  - Concepts illustrés
  - Description détaillée
  - Sortie attendue du programme
  - Points clés à retenir
  - Suggestions d'expérimentation
- **Fichiers .java** : Code Java exécutable et commenté

## Comment utiliser ces exemples

### Pour l'apprentissage

1. Lisez le README.md pour comprendre l'objectif
2. Étudiez le code Java avec ses commentaires
3. Compilez et exécutez le programme
4. Expérimentez en modifiant le code
5. Comparez avec les autres exemples

### Pour l'enseignement

- Utilisez les exemples comme support de démonstration
- Adaptez les exercices selon les besoins
- Encouragez les personnes qui étudient à expérimenter

## Compilation et exécution

Pour compiler et exécuter un exemple :

```bash
# Se placer dans le dossier de l'exemple
cd 01-instanceof-et-cast

# Compiler
javac *.java

# Exécuter
java BikeDemo
```

## Concepts clés illustrés

- **instanceof** : vérification du type d'un objet
- **Cast** : conversion de type sécurisée
- **Polymorphisme d'héritage** : références de type parent
- **Liaison dynamique** : résolution à l'exécution
- **Redéfinition** : adaptation du comportement dans les sous-classes
- **Interfaces** : contrats de comportement
- **Méthodes Object** : `toString()`, `equals()`, `hashCode()`
- **Collections polymorphes** : gestion uniforme d'objets variés

## Pour aller plus loin

Après avoir étudié ces exemples, consultez :

- Les [exercices](../02-exercices/) pour pratiquer
- Le [mini-projet](../03-mini-projet/) pour un projet complet
- Le [contenu de cours](../) pour la théorie complète

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
