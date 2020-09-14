FROM maven:3.5-jdk-8 AS build
COPY src /home/vagrant/benz/src
COPY pom.xml /home/vagrant/benz
RUN mvn -f /home/vagrant/benz/pom.xml clean package

#
# Package stage
#

FROM openjdk:11-jre-slim
COPY --from=build /home/vagrant/benz/target/searchplace-0.0.1-SNAPSHOT.jar /usr/local/lib/searchapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/searchapp.jar"]

#please choose the src path correctly
#command to run "docker build . searchapp