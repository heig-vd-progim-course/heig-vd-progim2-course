# Exemple 05 - Le mot-clé this

**Objectif pédagogique :** comprendre les différentes utilisations du mot-clé
`this` en Java.

**Concepts illustrés :**

- Utilisation de `this` pour différencier attributs et paramètres
- Utilisation de `this` pour appeler d'autres méthodes de la classe
- Référence à l'instance courante
- Clarté du code avec `this`

## Description

Cet exemple approfondit l'utilisation du mot-clé `this`. Le mot-clé `this` fait
référence à l'instance courante de la classe.

Il est utilisé dans trois cas principaux :

1. Différencier les attributs des paramètres (surtout dans les constructeurs)
2. Appeler une autre méthode de la même classe
3. Clarifier qu'on accède à un membre de l'instance

## Code

Les fichiers contiennent :

- `Student.java` : classe avec diverses utilisations de `this`
- `Main.java` : programme de démonstration

## Sortie attendue

```text
Création de la personne qui étudie: Alice Dupont

=== Informations de la personne qui étudie ===
Nom: Alice Dupont
Âge: 20 ans
Moyenne: 5.2
========================================

La personne qui étudie a changé de nom: Alice Martin

=== Informations de la personne qui étudie ===
Nom: Alice Martin
Âge: 20 ans
Moyenne: 5.2
========================================
```

## Points clés à retenir

- `this` fait référence à l'objet courant
- `this.attribut` accède à un attribut de l'instance
- `this.methode()` appelle une méthode de la classe
- `this` est obligatoire quand un paramètre a le même nom qu'un attribut
- `this` améliore la lisibilité du code

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Retirer `this.` devant les appels de méthodes et observer que ça fonctionne
   toujours
2. Retirer `this.` dans le constructeur et voir les erreurs
3. Ajouter d'autres méthodes qui s'appellent mutuellement avec `this`
4. Créer une méthode `updateAllInfo()` qui utilise plusieurs méthodes avec
   `this`

---

**Exemple précédent :**
[04-instanciation-objets](../04-instanciation-objets/README.md)

**Exemple suivant :** [06-methodes-retour](../06-methodes-retour/README.md)
