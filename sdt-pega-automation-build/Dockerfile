FROM openjdk:8u201-jre-alpine3.9

RUN apk add curl jq

#Workspace
WORKDIR /usr/share/sdt-pega-automation

#Copying main, test jar files
ADD target/online-reporting.jar         sdt-pega.jar
ADD target/online-reporting-tests.jar   sdt-pega-tests.jar

#Copying libs files on to the container
ADD target/libs                         libs

#Copying configurations
ADD src                                 src
ADD configuration                       configuration
ADD executionConfiguration              executionConfiguration
                        
#Copying testng XML file
ADD pega-OnlineForm-mobile.xml          pega-OnlineForm-mobile.xml
ADD pega-OnlineForm.xml                 pega-OnlineForm.xml

ADD healthcheck.sh                      healthcheck.sh

#execution
ENTRYPOINT sh healthcheck.sh


