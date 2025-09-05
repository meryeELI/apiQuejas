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
## Modelo de Datos
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

