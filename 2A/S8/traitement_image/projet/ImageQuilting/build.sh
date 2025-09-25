#!/usr/bin/env bash
#
# build.m – script de compilation pour transfer.cpp et synthese.cpp
#

# Arrête le script si une commande échoue
set -e

# Récupère le répertoire du script (pour appeler les .cpp dans le même dossier)
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Options communes
CXXFLAGS="$(pkg-config --cflags --libs opencv4)"
STD="-std=c++17"

build_transfer() {
  echo "Compilation de transfer.cpp…"
  g++ "${SCRIPT_DIR}/transfer.cpp" -o "${SCRIPT_DIR}/transfer" ${CXXFLAGS} ${STD}
  echo "→ binaire : ${SCRIPT_DIR}/transfer"
}

build_synthese() {
  echo "Compilation de synthese.cpp…"
  g++ "${SCRIPT_DIR}/synthese.cpp" -o "${SCRIPT_DIR}/synthese" ${CXXFLAGS} ${STD}
  echo "→ binaire : ${SCRIPT_DIR}/sythese"
}

case "$1" in
  transfer)
    build_transfer
    ;;
  synthese)
    build_synthese
    ;;
  all|"")
    build_transfer
    build_synthese
    ;;
  *)
    echo "Usage: $0 [transfer|synthese|all]"
    exit 1
    ;;
esac
