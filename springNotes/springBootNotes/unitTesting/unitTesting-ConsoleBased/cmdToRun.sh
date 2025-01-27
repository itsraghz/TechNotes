#!/bin/bash
mvn clean package && FILENAME="consoleOutput_$(date '+%d-%m-%Y-%a-%H%M%S')-IST.txt" && java -jar target/unit-test-demo-1.0.0.jar | tee $FILENAME

