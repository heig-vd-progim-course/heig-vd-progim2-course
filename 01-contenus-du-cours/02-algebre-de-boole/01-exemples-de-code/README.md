# Exemples de code - Algèbre de Boole

Ce dossier contient des exemples de code Java complets pour illustrer les
concepts d'algèbre de Boole et les bonnes pratiques de programmation.

## Organisation des exemples

Les exemples sont organisés en deux catégories :

### 📗 Bonnes pratiques (01-08)

Exemples démontrant les bonnes pratiques et l'utilisation correcte des concepts
d'algèbre de Boole, du plus simple au plus complexe.

1. **[01-declaration-boolean](01-declaration-boolean/README.md)** : Déclaration
   et initialisation de variables booléennes
2. **[02-operateurs-base](02-operateurs-base/README.md)** : Opérateurs de base
   (NOT, AND, OR) avec tables de vérité
3. **[03-operateur-xor](03-operateur-xor/README.md)** : Opérateur XOR et ses
   applications
4. **[04-court-circuit](04-court-circuit/README.md)** : Évaluation court-circuit
   et optimisation
5. **[05-lois-demorgan](05-lois-demorgan/README.md)** : Application des lois de
   De Morgan
6. **[06-condition-simple](06-condition-simple/README.md)** : Structure `if`
   simple
7. **[07-condition-if-else](07-condition-if-else/README.md)** : Structure
   `if-else`
8. **[08-condition-complexe](08-condition-complexe/README.md)** : Structure
   `if-else if-else`

### ⚠️ Pratiques à éviter (11-16)

Exemples illustrant les erreurs courantes et les mauvaises pratiques, avec leurs
corrections.

11. **[11-a-eviter-affectation-condition](11-a-eviter-affectation-condition/README.md)**
    : Confusion entre `=` et `==`
12. **[12-a-eviter-comparaison-redondante](12-a-eviter-comparaison-redondante/README.md)**
    : Comparaisons redondantes (`if (x == true)`)
13. **[13-a-eviter-type-non-booleen](13-a-eviter-type-non-booleen/README.md)** :
    Types non booléens dans les conditions
14. **[14-a-eviter-negations-multiples](14-a-eviter-negations-multiples/README.md)**
    : Négations multiples difficiles à lire
15. **[15-a-eviter-ordre-court-circuit](15-a-eviter-ordre-court-circuit/README.md)**
    : Ordre incorrect avec court-circuit
16. **[16-a-eviter-expression-complexe](16-a-eviter-expression-complexe/README.md)**
    : Expressions complexes sans décomposition

## Structure de chaque exemple

Chaque dossier d'exemple contient :

- **README.md** : Documentation pédagogique avec :
  - Objectif pédagogique
  - Concepts illustrés
  - Description détaillée
  - Sortie attendue du programme
  - Points clés à retenir
  - Suggestions d'expérimentation
- **Example.java** : Code Java exécutable et commenté

## Comment utiliser ces exemples

### Pour l'apprentissage

1. Lisez le README.md pour comprendre l'objectif
2. Étudiez le code Java avec ses commentaires
3. Compilez et exécutez le programme
4. Expérimentez en modifiant les valeurs

### Pour la compilation et l'exécution

```bash
# Se déplacer dans le dossier de l'exemple
cd 01-declaration-boolean

# Compiler le fichier Java
javac Example.java

# Exécuter le programme
java Example01DeclarationBoolean
```

### Pour l'enseignement

- Utilisez les bonnes pratiques (01-08) pour introduire les concepts
- Utilisez les contre-exemples (11-16) pour illustrer les erreurs courantes
- Les README.md peuvent servir de support de cours
- Les codes peuvent être projetés et discutés en classe

## Liens avec le support de cours

Ces exemples complètent le [support de cours principal](../README.md) en
fournissant :

- Des cas d'usage concrets et exécutables
- Des démonstrations pratiques des concepts théoriques
- Des illustrations des bonnes et mauvaises pratiques
- Du matériel pour l'auto-apprentissage et la révision

## Progression conseillée

Pour une meilleure compréhension, suivez cet ordre :

1. Exemples de bonnes pratiques dans l'ordre (01 → 08)
2. Contre-exemples correspondants pour contraster (11 → 16)
3. Retour au support de cours pour approfondir la théorie
4. Expérimentation libre avec vos propres modifications

---

**Retour au support de cours :** [README principal](../README.md)
