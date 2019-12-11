FROM java:8

COPY src/main/config/startServer.sh usr/deploy/startServer.sh
COPY src/main/config/configuration.yaml /usr/deploy/config.yml
COPY target/product-manager*.jar /usr/deploy/product-manager.jar

WORKDIR /usr/deploy
EXPOSE 9081
RUN chmod a+x ./startServer.sh
CMD ["./startServer.sh"]