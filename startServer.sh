#!/usr/bin/env bash
mvn -Dmaven.test.skip clean install
java -jar target/product-manager-1.0-SNAPSHOT.jar db migrate configuration.yaml
java -jar target/product-manager-1.0-SNAPSHOT.jar server configuration.yaml