# Primera etapa: compilar el proyecto con Maven y Java 21
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar primero el pom para descargar dependencias
COPY pom.xml .

RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Generar el archivo JAR
RUN mvn clean package -DskipTests


# Segunda etapa: ejecutar la aplicación
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/cochera-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]