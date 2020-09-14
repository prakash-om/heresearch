#Run memcache before this 
#docker pull memcached
#docker run --name memcached-server -p 11211:11211 memcached

#Build stage
FROM maven:3.5-jdk-8 AS build
COPY src /home/vagrant/benz/src
COPY pom.xml /home/vagrant/benz
RUN mvn -f /home/vagrant/benz/pom.xml clean package

#
# Package stage
#

FROM memcached
EXPOSE 11211

FROM openjdk:11-jre-slim
COPY --from=build /home/vagrant/benz/target/searchplace-0.0.1-SNAPSHOT.jar /usr/local/lib/searchapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/searchapp.jar"]

Note:
#using run the memcahe container before you start the application

#please choose the src path correctly
#command to run "docker build . searchapp