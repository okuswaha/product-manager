call mvn -Dmaven.test.skip clean install
call java -jar target/product-manager-1.0-SNAPSHOT.jar db migrate configuration.yaml
call java -jar target/product-manager-1.0-SNAPSHOT.jar server configuration.yaml
