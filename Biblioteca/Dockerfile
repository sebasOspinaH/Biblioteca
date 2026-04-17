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


COPY --from=builder /app/biblioteca.jar .

VOLUME ["/app/data"]


CMD ["java", "-jar", "biblioteca.jar"]
