#!/bin/bash
# Télécharge JUnit Platform Console Standalone dans le dossier lib/.

JUNIT_VERSION="6.0.3"
JUNIT_JAR="junit-platform-console-standalone-${JUNIT_VERSION}.jar"
MAVEN_URL="https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/${JUNIT_VERSION}/${JUNIT_JAR}"
LIB_DIR="lib"

mkdir -p "${LIB_DIR}"

if [ -f "${LIB_DIR}/${JUNIT_JAR}" ]; then
    echo "JUnit ${JUNIT_VERSION} est déjà présent dans ${LIB_DIR}/."
    exit 0
fi

echo "Téléchargement de JUnit ${JUNIT_VERSION}..."

if command -v curl &> /dev/null; then
    curl -L -o "${LIB_DIR}/${JUNIT_JAR}" "${MAVEN_URL}"
elif command -v wget &> /dev/null; then
    wget -O "${LIB_DIR}/${JUNIT_JAR}" "${MAVEN_URL}"
else
    echo "Erreur : curl ou wget est requis pour télécharger JUnit."
    exit 1
fi

if [ $? -eq 0 ]; then
    echo "JUnit ${JUNIT_VERSION} téléchargé avec succès dans ${LIB_DIR}/."
else
    echo "Erreur lors du téléchargement de JUnit ${JUNIT_VERSION}."
    exit 1
fi
