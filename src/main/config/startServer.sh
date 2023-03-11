#!/bin/bash
echo 'Run server'
java -jar product-manager.jar db migrate config.yml; java -jar product-manager.jar server config.yml
