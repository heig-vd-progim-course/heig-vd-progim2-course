# Exemples de code - Programmation orientée objet : Classes et objets

Ce dossier contient des exemples de code Java complets pour illustrer les
concepts fondamentaux de la programmation orientée objet (POO).

## Organisation des exemples

Les exemples sont organisés de manière progressive, du plus simple au plus
complexe :

### Bonnes pratiques (01-08)

1. **[01-classe-simple](01-classe-simple/)** : Déclaration d'une classe avec des
   attributs (**deux classes dans un fichier**)
2. **[02-classe-avec-methodes](02-classe-avec-methodes/)** : Ajout de méthodes à
   une classe (**deux classes dans un fichier**)
3. **[03-constructeur-simple](03-constructeur-simple/)** : Création d'un
   constructeur pour initialiser les objets
4. **[04-instanciation-objets](04-instanciation-objets/)** : Créer et utiliser
   plusieurs objets
5. **[05-mot-cle-this](05-mot-cle-this/)** : Utilisation du mot-clé `this` pour
   référencer l'instance
6. **[06-methodes-retour](06-methodes-retour/)** : Méthodes avec valeurs de
   retour
7. **[07-modification-etat](07-modification-etat/)** : Méthodes qui modifient
   l'état d'un objet
8. **[08-exemple-complet](08-exemple-complet/)** : Exemple complet intégrant
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
4. Expérimentez en modifiant les valeurs

### Pour la compilation et l'exécution

```bash
# Se déplacer dans le dossier de l'exemple
cd 01-classe-simple

# Compiler le(s) fichier(s) Java
javac *.java

# Exécuter le programme principal
java Main
```

### Pour l'enseignement

- Suivez l'ordre des exemples (01 → 08) pour une progression logique
- Les README.md peuvent servir de support de cours
- Les codes peuvent être projetés et discutés en classe
- Encouragez la modification du code pour l'expérimentation

## Liens avec le support de cours

Ces exemples complètent le [support de cours principal](../) en fournissant :

- Des cas d'usage concrets et exécutables
- Des démonstrations pratiques des concepts théoriques
- Du code à manipuler et modifier
- Du matériel pour l'auto-apprentissage et la révision

## Progression conseillée

Pour une meilleure compréhension, suivez cet ordre :

1. **Exemples 01-03** : comprendre les bases (classe, méthodes, constructeur)
2. **Exemples 04-05** : manipuler les objets (`new`, `this`)
3. **Exemples 06-07** : utiliser les méthodes avancées (retour, modification)
4. **Exemple 08** : synthèse complète
5. **Exercices** : pratiquer avec les [exercices](../02-exercices/)
6. **Mini-projet** : appliquer avec le [mini-projet](../03-mini-projet/)

## Concepts couverts

Ces exemples illustrent les concepts suivants :

- Déclaration de classes
- Attributs (variables d'instance)
- Méthodes (sans et avec paramètres)
- Constructeurs
- Instanciation avec le mot-clé `new`
- Accès aux attributs et méthodes avec l'opérateur point (`.`)
- Utilisation du mot-clé `this`
- Méthodes avec valeur de retour
- Modification de l'état d'un objet

---

**Retour au support de cours :** [README principal](../)
