#!/usr/bin/env sh
set -eu
PROJECT_DIR=$(CDPATH= cd -- "$(dirname -- "$0")/.." && pwd)
cd "$PROJECT_DIR"
if [ ! -f target/decorator-lab-1.0.0.jar ]; then
  mvn -q -DskipTests package
fi
exec java -jar target/decorator-lab-1.0.0.jar
