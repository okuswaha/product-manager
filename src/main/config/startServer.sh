#!/bin/sh
echo 'Run server'
exec java -jar product-manager.jar server config.yml
