# Exemples de code - Encapsulation et héritage

Ce dossier contient des exemples de code Java complets pour illustrer les
concepts d'encapsulation et d'héritage en programmation orientée objet.

## Organisation des exemples

Les exemples sont organisés en deux catégories :

### 📗 Bonnes pratiques (00-07)

Exemples démontrant les bonnes pratiques et l'utilisation correcte de
l'encapsulation et de l'héritage, du plus simple au plus complexe.

0. **[00-exemple-complet](00-exemple-complet/)** : Exemple complet d'un système
   de bibliothèque (tutoriel guidé)
1. **[01-encapsulation-basic](01-encapsulation-basic/)** : Encapsulation simple
   avec getters et setters
2. **[02-encapsulation-validation](02-encapsulation-validation/)** :
   Encapsulation avec validation des données
3. **[03-heritage-simple](03-heritage-simple/)** : Héritage simple entre deux
   classes
4. **[04-heritage-abstract](04-heritage-abstract/)** : Classe abstraite et
   méthodes abstraites
5. **[05-modificateur-protected](05-modificateur-protected/)** : Utilisation du
   modificateur `protected`
6. **[06-redefinition-methode](06-redefinition-methode/)** : Redéfinition de
   méthodes avec `@Override`
7. **[07-organisation-fichiers](07-organisation-fichiers/)** : Bonne pratique
   avec un fichier par classe

### 📕 Pratiques à éviter (11-13)

Exemples illustrant les erreurs courantes et les mauvaises pratiques, avec leurs
corrections.

1. **[11-a-eviter-pas-encapsulation](11-a-eviter-pas-encapsulation/)** :
   Attributs directement accessibles sans protection
2. **[12-a-eviter-validation-manquante](12-a-eviter-validation-manquante/)** :
   Encapsulation sans validation appropriée
3. **[13-a-eviter-heritage-inutile](13-a-eviter-heritage-inutile/)** : Héritage
   utilisé incorrectement

## Structure de chaque exemple

Chaque dossier d'exemple contient :

- **README.md** : Documentation pédagogique avec :
  - Objectif de l'exemple
  - Explication du concept illustré
  - Code commenté avec descriptions détaillées
  - Points clés à retenir
- **Main.java** (exemples 00-06) : Fichier Java unique contenant toutes les
  classes
- **Fichiers séparés** (exemple 07) : Organisation professionnelle avec un
  fichier par classe

## Comment utiliser ces exemples

1. **Commencez par l'exemple complet** (`00-exemple-complet`) qui vous guide pas
   à pas dans la construction d'un système complet
2. **Parcourez les exemples dans l'ordre** pour une progression logique
3. **Exécutez chaque exemple** pour voir les concepts en action
4. **Lisez les README** pour comprendre les explications détaillées
5. **Consultez les exemples à éviter** pour apprendre des erreurs courantes

## Principes illustrés

Ces exemples couvrent les principes fondamentaux de la POO :

- **Encapsulation** : Protection des données avec `private`, accès contrôlé avec
  getters/setters
- **Validation** : Contrôle de l'intégrité des données
- **Héritage** : Réutilisation du code et hiérarchie de classes
- **Abstraction** : Classes et méthodes abstraites
- **Polymorphisme** : Traitement uniforme d'objets de types différents
- **Redéfinition** : Personnalisation du comportement dans les sous-classes
- **Organisation** : Structure professionnelle du code

## Pour aller plus loin

Après avoir maîtrisé ces exemples, consultez :

- Les **[exercices](../02-exercices/)** pour pratiquer ces concepts
- Le **[mini-projet](../03-mini-projet/)** pour les appliquer dans un contexte
  réel
- Le **[support de cours](../README.md)** pour la théorie complète
