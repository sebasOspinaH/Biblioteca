# 📚 Sistema de Gestión de Biblioteca

Aplicación de consola en Java para gestionar libros, clientes, préstamos, multas y reservas.

---

## 🐳 Requisitos

- [Docker](https://www.docker.com/) instalado

---

## 🚀 Cómo ejecutar

### 1. Construir la imagen

```bash
docker build -t biblioteca .
```

### 2. Ejecutar el contenedor (con persistencia de datos)

```bash
docker run -it -v biblioteca_data:/app/data biblioteca
```

> El flag `-it` es necesario porque la aplicación es interactiva (lee desde consola).  
> El volumen `biblioteca_data` mantiene los datos entre ejecuciones.

---

## 💾 Persistencia de datos

Los datos se guardan en archivos JSON dentro del volumen Docker `/app/data`:

| Archivo | Contenido |
|---|---|
| `clientes.json` | Clientes registrados, historial y multas |
| `libros.json` | Libros, estado y lista de reservas |
| `prestamos.json` | Registro de préstamos con fechas |

Los datos **no se pierden** al detener o eliminar el contenedor.

---

## 📋 Menú del sistema

| Opción | Función |
|---|---|
| 1  | Registrar cliente |
| 2  | Registrar libro |
| 3  | Consultar info de un libro |
| 4  | Listar todos los libros |
| 5  | Listar todos los clientes |
| 6  | Pedir un libro (préstamo) |
| 7  | Devolver un libro |
| 8  | Consultar historial de un cliente |
| 9  | Ver libros más prestados |
| 10 | **Consultar multas de un cliente** *(nuevo)* |
| 11 | **Reservar un libro** *(nuevo)* |
| 12 | **Consultar reservas de un libro** *(nuevo)* |
| 13 | Salir (guarda datos) |

---

## ⚠️ Sistema de Multas

- Cada préstamo tiene una **fecha límite de 7 días**.
- Si se devuelve con retraso, se calcula automáticamente una multa de **$500 por día**.
- La multa se acumula en el perfil del cliente y se puede consultar en la opción 10.

---

## 📅 Sistema de Reservas

- Si un libro está **prestado**, otros clientes pueden **reservarlo** (opción 11).
- Las reservas se organizan en **orden de solicitud** (cola FIFO).
- Al devolver el libro, el sistema **notifica en consola** cuál es el siguiente cliente en espera.
- Se puede consultar la lista de reservas de un libro en la opción 12.

