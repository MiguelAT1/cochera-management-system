# Sistema de Gestión de Cochera

Proyecto académico desarrollado para el curso Herramientas de Desarrollo Profesional. El sistema permite administrar el ingreso y salida de vehículos, el registro de usuarios y la gestión de promociones de una cochera, aplicando buenas prácticas de control de versiones, integración continua y contenerización.

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- HTML, CSS y JavaScript
- Git y GitFlow
- GitHub Actions
- Docker
- Docker Compose
- Jenkins

## Funcionalidades

- CRUD de vehículos
- CRUD de usuarios
- Registro de entrada de vehículos
- Registro de salida de vehículos
- Control de capacidad máxima de 40 autos
- Promociones por visitas:
  - 20 visitas: 50% de descuento
  - 40 visitas: estacionamiento gratis
- Pruebas automatizadas
- Integración continua con GitHub Actions
- Contenerización con Docker
- Orquestación de servicios mediante Docker Compose
- Pipeline de Jenkins

## Ejecución con Docker

Construir las imágenes:

```bash
docker compose build
```

Levantar los contenedores:

```bash
docker compose up
```

Detener los contenedores:

```bash
docker compose down
```

## Acceso a la aplicación

Frontend:

```text
http://localhost:8087
```

Backend:

```text
http://localhost:8086
```



## Integración Continua

El proyecto utiliza GitHub Actions para:

- Compilar automáticamente el backend.
- Ejecutar las pruebas automatizadas.
- Validar la estructura del frontend.
- Verificar los cambios en cada Push y Pull Request.

## Jenkins

El archivo `Jenkinsfile` contiene las siguientes etapas:

1. Clonar el repositorio.
2. Compilar el backend.
3. Ejecutar las pruebas.
4. Empaquetar el proyecto.
