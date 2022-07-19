#!/usr/bin/bash

for i in {1..10000}
 do
    curl "192.168.49.2:30033/logger?count=1000&sleep=100"
    sleep "$1"
    echo "$i"
done
