# Ressources pour le corps enseignant

Ce document et ce répertoire contiennent toutes les ressources pour le corps
enseignant.

Il est destiné à être utilisé comme référence pour le corps enseignant afin de
préparer et donner le cours.

## Table des matières

- [Table des matières](#table-des-matières)
- [Configuration de la manette 8bitdo Micro](#configuration-de-la-manette-8bitdo-micro)
  - [Comment utiliser le fichier de configuration](#comment-utiliser-le-fichier-de-configuration)

## Configuration de la manette 8bitdo Micro

Pour les besoins du cours, nous allons utiliser une manette de jeu 8bitdo. Voici
la configuration recommandée pour les boutons de la manette, qui correspond à
l'utilisation dans le cadre du cours. Les boutons sont configurés pour faciliter
la navigation et les interactions pendant les sessions de cours.

Il s'agit de cette manette : [8bitdo Micro](https://www.8bitdo.com/micro/)

### Comment utiliser le fichier de configuration

Le fichier `./configuration-manette.gamecontroller.amgp` est un profil à charger
dans l'application AntiMicroX.

Pour reproduire la configuration :

- Branchez ou associez la manette 8bitdo Micro à l'ordinateur.
- Ouvrez AntiMicroX.
- Sélectionnez la manette détectée dans l'application.
- Chargez le profil `./configuration-manette.gamecontroller.amgp` depuis le menu
  d'ouverture de profil de l'application.
- Vérifiez que les boutons correspondent bien au schéma ci-dessous, puis
  enregistrez si vous devez adapter localement la configuration.

```
 L1 L2            R2 R1
   U      -  +      X
 L   R            Y   A
   D      S  H      B
```

**Légende**

- Côté gauche.
  - L1 : <kbd>Ctrl</kbd> + <kbd>Alt</kbd> + <kbd>Plus (+)</kbd>.
  - L2 : <kbd>Ctrl</kbd> + <kbd>Alt</kbd> + <kbd>Minus (-)</kbd>.
  - U : <kbd>Left</kbd>.
  - L : <kbd>Page Up</kbd>.
  - R : <kbd>Page Down</kbd>.
  - D : <kbd>Right</kbd>.
- Milieu.
  - \- : <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>Tab</kbd>.
  - \+ : <kbd>Ctrl</kbd> + <kbd>Tab</kbd>.
  - S : Aucun.
  - H : <kbd>F</kbd>.
- Côté droit.
  - R2 : <kbd>Ctrl</kbd> + <kbd>Minus (-)</kbd>.
  - R1 : <kbd>Ctrl</kbd> + <kbd>Plus (+)</kbd>.
  - X : <kbd>Left</kbd>.
  - Y : <kbd>Down</kbd>.
  - A : <kbd>Up</kbd>.
  - B : <kbd>Right</kbd>.
