#!/bin/bash

for filename in docker-compose-files/*; do
	build=${BUILD_NUMBER} docker-compose -f ${filename} up
done
