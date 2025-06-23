# Arquitectura del Sistema

Este documento describe la arquitectura general de la aplicación **Location Map Application**. El proyecto utiliza Spring Boot como base para exponer un API REST, Hibernate para la persistencia de datos y PostgreSQL como base de datos. La interfaz de usuario se sirve desde una página web (index.html) que interactúa con el API a través de JavaScript.

## Componentes Principales

1. **Interfaz de Usuario (JSF/HTML)**
   - Página `index.html` ubicada en `src/main/resources/templates`.
   - Contiene un mapa de Google y un formulario para registrar nuevas ubicaciones.
   - Realiza peticiones HTTP al API REST para consultar o crear ubicaciones.

2. **Lógica de Negocio (Spring Boot)**
   - Arranca desde `DemoApplication.java`.
   - Controladores REST en `com.example.demo.controller` gestionan las peticiones.
   - Utiliza Spring MVC para exponer los endpoints.

3. **Capa de Persistencia (Hibernate/JPA)**
   - Entidad `Location` mapeada a la tabla `locations`.
   - Repositorio `LocationRepository` extiende `JpaRepository` para operaciones CRUD.
   - Spring Data JPA delega a Hibernate para la interacción con la base de datos.

4. **Base de Datos (PostgreSQL)**
   - Definida en `docker-compose.yml` como servicio `db`.
   - `data.sql` inicializa la tabla con un registro de ejemplo.

## Flujo General

```
Usuario -> Interfaz JSF/HTML -> API REST (Spring Boot) -> Hibernate/JPA -> PostgreSQL
```

1. El usuario abre la página `index.html` en su navegador.
2. Desde la página se envían solicitudes HTTP (GET/POST) al API REST para cargar o crear ubicaciones.
3. Los controladores de Spring Boot reciben la solicitud y la delegan al repositorio.
4. Hibernate ejecuta la operación correspondiente en PostgreSQL.
5. Los resultados (por ejemplo, la lista de ubicaciones) se devuelven a la página y se muestran en el mapa.

## Diagrama de Arquitectura (Simplificado)

```
+------------+            +-----------------+             +-----------------------+           +--------------+
| Navegador  | <--------> | Interfaz JSF/   | <---------> |  API REST             | <------> | PostgreSQL   |
| Web        |            | HTML (index)    |             |  Spring Boot /        |           | (Hibernate)  |
|            |            |                 |             |  Controladores        |           |              |
+------------+            +-----------------+             +-----------------------+           +--------------+
```

Este diagrama muestra cómo el navegador interactúa con la página web (implementada con JSF o HTML), la cual se comunica con el API REST. El API utiliza Hibernate para acceder a la base de datos PostgreSQL.

## Despliegue con Docker

1. **Docker Compose** define dos servicios: `web` (aplicación Java) y `db` (PostgreSQL).
2. `docker-compose up --build` compila la aplicación y levanta ambos contenedores.
3. La aplicación queda disponible en `http://localhost:8080/index.xhtml` (o `index.html`).

## Archivos Relevantes

- `src/main/resources/application.properties` – configuración de la base de datos.
- `src/main/resources/data.sql` – inserción de datos iniciales.
- `src/main/java/com/example/demo/entity/Location.java` – entidad JPA.
- `src/main/java/com/example/demo/controller` – controladores Spring.
- `docker-compose.yml` – orquestación de contenedores.

Con esta estructura se puede comprender el flujo completo de la aplicación desde la interfaz de usuario hasta el almacenamiento de datos en PostgreSQL.
