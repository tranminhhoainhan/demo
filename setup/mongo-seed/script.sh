#!/bin/bash
for FILE in ./test-collection/*.json;
  do FILENAME=$(echo $FILE | xargs basename -s .json )
  echo "-- Import data for file $FILENAME.json"
  mongoimport --host mongodb --db test --collection $FILENAME --type json --file $FILE --jsonArray
done 
