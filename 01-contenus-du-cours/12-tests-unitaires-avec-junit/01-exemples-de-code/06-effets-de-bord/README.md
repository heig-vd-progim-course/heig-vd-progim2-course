# Exemple 06 - Tester les effets de bord

**Objectif pédagogique :** comprendre comment vérifier que l'état interne d'un
objet est correctement mis à jour ou préservé.

**Concepts illustrés :**

- Vérification de l'état interne d'un objet après une opération réussie.
- Vérification qu'une opération échouée ne modifie pas l'état.
- Enchaînement de plusieurs appels dans un seul test (quand c'est justifié).
- Absorption manuelle d'une exception attendue avec `try-catch`.

## Description

`WaterSensor` stocke la dernière valeur de pH lue dans le champ `lastPh`. Ce
test vérifie deux aspects de ce comportement :

- Après une lecture réussie, `lastPh` est mis à jour.
- Après une lecture échouée (format invalide ou valeur hors plage), `lastPh`
  reste inchangé.

## Code

- `WaterSensor.java` : classe de production du capteur de pH.
- `InvalidPhException.java` : exception personnalisée.
- `EffetsDeBordTest.java` : quatre tests sur l'état interne.

## Sortie attendue

```
└─ EffetsDeBordTest ✔
   ├─ readFromString_valeurValide_metAJourLastPh() ✔
   ├─ readFromString_deuxLectures_lastPhEstLaDerniere() ✔
   ├─ readFromString_erreurFormat_lastPhInchange() ✔
   └─ readFromString_erreurPlage_lastPhInchange() ✔

[  4 tests found  |  4 successful  |  0 failed  ]
```

## Points clés à retenir

- Un test peut faire plusieurs appels de méthode si tous contribuent à vérifier
  une seule chose.
- L'absorption manuelle d'une exception avec `try-catch` est justifiée ici : on
  veut continuer le test pour vérifier l'état après l'erreur.
- Tester qu'une erreur ne modifie pas l'état est aussi important que tester le
  cas nominal.
- Ces tests documentent le contrat de `WaterSensor` : les erreurs sont sans
  effet de bord.

---

**Exemple précédent :** [05-assertthrows](../05-assertthrows/)
