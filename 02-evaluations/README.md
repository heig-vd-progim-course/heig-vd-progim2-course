# Évaluations

Ce dossier contient toutes les évaluations pour le cours _"Programmation 2
(ProgIM2)"_.

## Génération des PDF

Les fichiers `.typ` sont compilés avec [Typst](https://typst.app/).

### Aperçu rapide (un seul fichier)

Pour générer un PDF sans solutions (version étudiante) :

```bash
typst compile exam-debut-semestre-2026-partie-1.typ apercu-partie-1.pdf \
  --input show_official_answer="false"

typst compile exam-debut-semestre-2026-partie-2.typ apercu-partie-2.pdf \
  --input show_official_answer="false"
```

Pour générer un PDF avec les solutions (version corrigée) :

```bash
typst compile exam-debut-semestre-2026-partie-1.typ correction-partie-1.pdf \
  --input show_official_answer="true"

typst compile exam-debut-semestre-2026-partie-2.typ correction-partie-2.pdf \
  --input show_official_answer="true"
```

### Génération pour tous les étudiants

Utiliser le script `generate.sh` avec un fichier CSV au format
`nom,prenom,salle` :

```bash
./generate.sh students.csv
```

Les PDF sont générés dans le dossier `output/`. Ensuite, pour fusionner les PDF
par salle :

```bash
./merge-by-room.sh
```
