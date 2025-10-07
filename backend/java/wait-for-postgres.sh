#!/usr/bin/env sh
# wait-for-postgres.sh - wait for postgres to be reachable before starting the app
# usage: the script reads POSTGRES_HOST and POSTGRES_PORT env vars

HOST=${POSTGRES_HOST:-postgres}
PORT=${POSTGRES_PORT:-5432}
MAX_WAIT=${WAIT_FOR_POSTGRES_TIMEOUT:-60}

echo "Waiting for Postgres at ${HOST}:${PORT} (timeout ${MAX_WAIT}s) ..."

n=0
while ! nc -z "$HOST" "$PORT"; do
  n=$((n+1))
  if [ "$n" -ge "$MAX_WAIT" ]; then
    echo "Timed out waiting for Postgres after ${MAX_WAIT} seconds"
    exit 1
  fi
  sleep 1
done

echo "Postgres is available, launching app..."
exec java -jar /app/app.jar
