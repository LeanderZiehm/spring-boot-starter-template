# ---------- build stage ----------
FROM docker.io/library/maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# copy pom first to leverage Docker cache
COPY pom.xml .
RUN mvn -B -q dependency:go-offline

# copy source and build
COPY src ./src
RUN mvn -B clean package -DskipTests

# ---------- runtime stage ----------
FROM docker.io/library/eclipse-temurin:21-jre

WORKDIR /app

# copy the built jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
