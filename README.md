# 📌 API de Gestión de Quejas

Este proyecto es un microservicio en Spring Boot que implementa un sistema para la gestión de quejas, usuarios y representantes.
Incluye integración con Swagger/OpenAPI para la documentación automática y utiliza SQLite como base de datos.

## 📖 Características

* Gestión de Quejas (crear, listar, actualizar y eliminar).
* Gestión de Usuarios y sus quejas asociadas.
* Gestión de Representantes.
* Documentación automática con Swagger UI.
* Arquitectura organizada por capas: Controller, Service, Repository, DTO, Mapper, Model.
* Persistencia con Spring Data JPA y base de datos SQLite.
* Uso de MapStruct manual para conversión de entidades a DTO.
* Pruebas unitarias básicas con JUnit 5.

## 📂 Estructura del Proyecto
```
src/
 ├── main/
 │   ├── java/com/example/tienda
 │   │   ├── Config/                # Configuración de OpenAPI/Swagger
 │   │   ├── DTO/                   # Objetos de Transferencia de Datos (DTOs)
 │   │   ├── Mapper/                # Conversores entre Entidades y DTOs
 │   │   ├── Repository/            # Interfaces de acceso a datos (JPA)
 │   │   ├── Service/                # Lógica de negocio
 │   │   ├── controller/             # Controladores REST
 │   │   ├── model/                  # Entidades JPA
 │   │   └── Tienda2Application.java # Clase principal Spring Boot
 │   └── resources/
 │       └── application.properties  # Configuración del proyecto
 └── test/java/com/example/tienda
     └── Tienda2ApplicationTests.java
```
## 🗄️ Modelo de Datos
### Usuario

* id (Long, PK)
* email (String, único)
* nombre (String)
* password (String, mínimo 6 caracteres)
* quejas (Lista de quejas asociadas)
* creadoEn (Fecha de creación)

### Representante

* id (Long, PK)
* nombre (String)
* dui (String)
* correo (String)
* quejas (Lista de quejas asignadas)

### Queja

* id (Long, PK)
* descripcion (String)
* estado (String: pendiente, resuelta, etc.)
* representante (Relacionada con un Representante)
* usuario (Relacionada con un Usuario)

🔄 Flujo de Arquitectura

1. Controller recibe la solicitud HTTP.
2. Service procesa la lógica de negocio.
3. Repository accede a la base de datos.
4. Mapper convierte entre Model y DTO.
5. DTO se devuelve al cliente.

## 🌐 Endpoints Principales

### Quejas
```
POST   /api/quejas        → Crear nueva queja
GET    /api/quejas        → Listar todas las quejas
PUT    /api/quejas/{id}   → Actualizar queja por ID
DELETE /api/quejas/{id}   → Eliminar queja por ID
```

### Usuarios
```
POST   /api/usuario               → Crear usuario
GET    /api/usuario               → Listar todos los usuarios
GET    /api/usuario/{id}/quejas   → Listar quejas de un usuario
PUT    /api/usuario/{id}          → Actualizar usuario
DELETE /api/usuario/{id}          → Eliminar usuario
```

### Representantes
```
POST   /api/representante        → Crear representante
GET    /api/representante        → Listar representantes
PUT    /api/representante/{id}   → Actualizar representante
DELETE /api/representante/{id}   → Eliminar representante
```

## ⚙️ Configuración y Ejecución

### Requisitos previos
* Java 17+
* Maven 3.9+
* SQLite (opcional, se genera el archivo automáticamente)

## 🛠 Dependencias Principales

* Spring Boot Starter Web → Creación de API REST.
* Spring Boot Starter Data JPA → Persistencia.
* SQLite JDBC → Base de datos embebida.
* Hibernate → ORM.
* Springdoc OpenAPI UI → Documentación Swagger.
* Jakarta Validation → Validaciones.
* JUnit 5 → Pruebas unitarias.

## 🗃 Base de Datos

Se utiliza SQLite con el archivo quejas.db que se genera automáticamente en la raíz del proyecto.
Configuración en application.properties:

```
spring.datasource.url=jdbc:sqlite:quejas.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
```

## 👨‍💻 Autores

* Equipo de Desarrollo:
     * Mery Acevedo
     * Nestor Ivan Fabian Colocho
     * Alejandro Ernesto Juarez Argumedo
