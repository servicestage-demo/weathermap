#!/bin/bash

# CMDVAR="-Djava.security.egd=file:/dev/./urandom","java -agentlib:jdwp=transport=dt_socket,address=0:8000,server=y,suspend=n -jar"
JAR=edge-service-1.0.0.jar
if [ ! -e $JAR ]; then
    JAR=target/$JAR
    if [ -e application.yml ]; then
        cp application.yml ./target/
    fi
fi
java $CMDVAR -jar ./$JAR
