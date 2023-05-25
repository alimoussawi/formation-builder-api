# Use an OpenJDK 17 base image
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

# Install prerequisites
RUN apt-get update && apt-get install -y \
curl
CMD /bin/bash

ARG MAVEN_VERSION=3.8.8
ARG USER_HOME_DIR="/root"
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
 && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
 && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
 && rm -f /tmp/apache-maven.tar.gz \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME=/usr/share/maven
ENV MAVEN_CONFIG="$USER_HOME_DIR/.m2"

# Set the working directory in the container
WORKDIR /app/formation-builder

# Copy the child modules and their pom.xml files
COPY model model
COPY web web
COPY service service
COPY persistence persistence

# Copy the parent module's pom.xml and build it with dependencies
COPY pom.xml pom.xml
RUN mvn dependency:go-offline -B

# Build the application using Maven
RUN mvn package -DskipTests

# Set environment variables
ENV db_name=formationbuilder
ENV db_host=localhost
ENV db_port=27017
ENV db_auth=admin
ENV db_user=rootuser
ENV db_pass=rootpass

# Copy the JAR file into the container
COPY web/target/web-1.0.0-SNAPSHOT.jar .

# Expose the port that the Spring Boot application listens on
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "web-1.0.0-SNAPSHOT.jar"]
