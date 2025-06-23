# Descripción del Código

Este documento complementa la arquitectura general con detalles sobre las clases principales del proyecto y los puntos claves en el código.

## Estructura de Paquetes

- `com.example.demo`
  - `DemoApplication` – clase principal que arranca Spring Boot.
  - `controller` – controladores REST y de vistas.
  - `entity` – entidades JPA que representan tablas de la base de datos.
  - `repository` – interfaces de acceso a datos con Spring Data JPA.

## Clases Principales

### `DemoApplication`

Inicia la aplicación mediante `SpringApplication.run`. No contiene lógica adicional.

### `HomeController`

Controlador de tipo `@Controller` que redirige la ruta raíz `/` a la plantilla `index`. Sirve la página principal de la aplicación.

### `LocationController`

Controlador REST (`@RestController`) que maneja el endpoint `/api/locations`.

- `GET /api/locations` – devuelve la lista completa de ubicaciones almacenadas.
- `POST /api/locations` – recibe un objeto `Location` en formato JSON y lo guarda mediante `LocationRepository`.

### `Location`

Entidad JPA que mapea la tabla `locations`. Contiene campos como `name`, `description`, `latitude`, `longitude` y marcas de tiempo `createdAt` y `updatedAt`.

### `LocationRepository`

Extiende `JpaRepository<Location, Long>` y hereda las operaciones CRUD básicas.

## Puntos Clave

- La aplicación está pensada para ejecutarse en contenedores Docker junto con una base de datos PostgreSQL definida en `docker-compose.yml`.
- `application.properties` configura la conexión a la base de datos y el comportamiento de Hibernate.
- `index.html` contiene código JavaScript que llama a la API REST para mostrar y añadir ubicaciones en un mapa de Google.

