# Base Image
FROM openjdk:8

# Maintainer
MAINTAINER DEVARAKONDA CHAKRADHAR

# Create DIR
RUN mkdir -p /usr/src/myapp

# COPY APPLICTAION COde
COPY target/CookieProblem-0.0.1-SNAPSHOT.jar    /usr/src/myapp

# Setup Working DIR
WORKDIR /usr/src/myapp

#EXPOSE
EXPOSE 8080

# Start the Bot Service
CMD ["java", "-jar", "CookieProblem-0.0.1-SNAPSHOT.jar"]
