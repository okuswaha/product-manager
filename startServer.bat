call mvn -Dmaven.test.skip clean install
call java -jar target/product-manager-1.0-SNAPSHOT.jar db migrate configuration.yaml
:: call java -jar target/product-manager-1.0-SNAPSHOT.jar server configuration.yaml
call java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=7896 target/product-manager-1.0-SNAPSHOT.jar server configuration.yaml
