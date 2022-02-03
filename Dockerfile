FROM openjdk:8

WORKDIR /usr/src/myapp

CMD ["java","-jar", "App-1.0.jar"]