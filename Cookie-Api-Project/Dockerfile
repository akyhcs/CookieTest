# Base Image
FROM openjdk:8
FROM tomcat:9.0

# COPY APPLICTAION COde
COPY target/CookieProblem-0.0.1-SNAPSHOT.jar    /usr/local/tomcat/webapps/ROOT.war

# Setup Working DIR
WORKDIR /usr/local/tomcat/webapps/

#EXPOSE
EXPOSE 8080

# Start the Bot Service
CMD ["java", "-jar", "CookieProblem-0.0.1-SNAPSHOT.jar"]
