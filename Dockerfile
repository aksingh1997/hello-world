FROM openjdk:17-alpine
WORKDIR /app
COPY target/BookStore-0.0.1-SNAPSHOT.war BookStore.war
EXPOSE 9081
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev" ,"/app/BookStore.war"]