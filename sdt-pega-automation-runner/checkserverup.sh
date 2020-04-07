#!/bin/bash

count=1
while [ "$( curl -s -o /dev/null -w "%{http_code}" http://10.0.3.5:81 )" != "200" ]
	do
            sleep 1
	    echo "Waiting for app container to be up. Retry count : ${count}"
	    count=$((${count}+1))
done
