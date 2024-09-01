# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el JAR de la aplicación al contenedor
COPY target/mi-app.jar app.jar

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]