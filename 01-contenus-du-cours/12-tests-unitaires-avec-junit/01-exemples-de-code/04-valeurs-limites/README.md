# Exemple 04 - Tester les valeurs limites

**Objectif pédagogique :** comprendre l'importance de tester les bornes d'une
plage valide et les premières valeurs hors plage.

**Concepts illustrés :**

- Tests des bornes inférieures et supérieures d'une plage autorisée.
- Tests des premières valeurs en dessous et au-dessus de la plage.
- Test d'une valeur nominale (cas normal).
- Utilisation combinée de `assertEquals` et `assertThrows`.

## Description

Pour `WaterSensor`, la plage autorisée est `[0.0, 14.0]`. Ce sont les bornes qui
sont les plus susceptibles de contenir des bugs : une condition `<` au lieu de
`<=`, ou une constante légèrement mal saisie.

Ce test vérifie systématiquement les cinq valeurs critiques :

- `0.0` : borne minimale, doit être acceptée.
- `7.0` : valeur nominale, doit être acceptée.
- `14.0` : borne maximale, doit être acceptée.
- `-0.1` : première valeur sous la borne, doit être refusée.
- `14.1` : première valeur au-dessus de la borne, doit être refusée.

## Code

- `WaterSensor.java` : classe de production du capteur de pH.
- `InvalidPhException.java` : exception personnalisée.
- `ValeursLimitesTest.java` : cinq tests couvrant les valeurs critiques.

## Sortie attendue

```
└─ ValeursLimitesTest ✔
   ├─ readFromString_borneMinimale_accepte() ✔
   ├─ readFromString_valeurNominale_accepte() ✔
   ├─ readFromString_borneMaximale_accepte() ✔
   ├─ readFromString_sousLaBorne_leveException() ✔
   └─ readFromString_audessusLaBorne_leveException() ✔

[  5 tests found  |  5 successful  |  0 failed  ]
```

## Points clés à retenir

- Tester une borne, c'est tester les deux côtés : la valeur exacte (acceptée) et
  la première valeur hors plage (refusée).
- Un bug `< 0.0` au lieu de `<= 0.0` serait détecté par le test
  `readFromString_borneMinimale_accepte`.
- Une valeur nominale (7.0) teste le cas le plus courant.
- Les tests de valeurs limites et les tests nominaux se complètent.

---

**Exemple précédent :** [03-assertions-courantes](../03-assertions-courantes/)

**Exemple suivant :** [05-assertthrows](../05-assertthrows/)
