FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

COPY src/ ./src/

RUN mkdir -p out && \
    javac -d out src/Cliente.java \
                 src/Libro.java \
                 src/Prestamo.java \
                 src/Persistencia.java \
                 src/Controlador_cliente.java \
                 src/GestionLibros.java \
                 src/PrestamoLibro.java \
                 src/Main.java

RUN cd out && jar cfe ../biblioteca.jar Main .

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar el JAR generado
COPY --from=builder /app/biblioteca.jar .

# Crear carpeta data (será sobreescrita por el volumen Docker)
RUN mkdir -p /app/data

# Volumen para persistencia de datos JSON
VOLUME ["/app/data"]

# Ejecutar la aplicación de forma interactiva
CMD ["java", "-jar", "biblioteca.jar"]
