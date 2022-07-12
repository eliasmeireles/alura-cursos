#!/usr/bin/bash

for i in {1..100000}
 do
    curl "192.168.49.2:30033/logger?count=100&sleep=10"
    sleep "$1"
    echo "$i"
done
