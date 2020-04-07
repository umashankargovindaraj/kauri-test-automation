#!/bin/bash

cat sdt-pega-automation-build/src/test/java/features/OnlineReporting/onlineReporting.feature| grep -i 'Scenario:\|Scenario outline:' | cut -d ':' -f2 >> scenario.txt
#scenarioCount=1
#for scenario in ${scenarios}
#        do
#                echo "Scenario ${scenarioCount} : ${scenario}"
#                let "scenarioCount++"
       # done
echo ${scenarios}
