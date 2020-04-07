#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

#echo "Checking if hub is ready - $HUB_HOST"

#while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
#do
#	sleep 1
#done

# start the java command
#java -cp sdt-pega.jar:sdt-pega-tests.jar:libs/* \
#    -DDEVICE_KEY=$DEVICE_KEY \
#    -Dcucumber.options=\"--tags $TAG\" \
#    org.testng.TestNG $MODULE

java -cp sdt-pega.jar:sdt-pega-tests.jar:libs/* \
    -DDEVICE_KEY=$DEVICE_KEY \
    -Dcucumber.options="--tags @$TAG" \
    org.testng.TestNG $MODULE