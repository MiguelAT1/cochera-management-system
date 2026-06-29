# Sistema de Gestión de Cochera

Proyecto académico para el curso Herramientas de Desarrollo.

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- HTML, CSS y JavaScript
- Jenkins
- Git y GitFlow
- Slack

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
- Pipeline de Jenkins

## Ejecutar backend

```bash
cd backend
mvn spring-boot:run
```

El backend estará disponible en:

```text
http://localhost:8080
```

## Abrir frontend

Abrir el archivo:

```text
frontend/index.html
```

## Endpoints principales

### Vehículos

```http
GET /api/vehiculos
POST /api/vehiculos
PUT /api/vehiculos/{id}
DELETE /api/vehiculos/{id}
```

### Usuarios

```http
GET /api/usuarios
POST /api/usuarios
PUT /api/usuarios/{id}
DELETE /api/usuarios/{id}
```

### Cochera

```http
POST /api/cochera/entrada
POST /api/cochera/salida
GET /api/cochera/registros
GET /api/cochera/promocion/{placa}
```

## Jenkins

El archivo `Jenkinsfile` contiene las etapas:

1. Clonar repositorio
2. Compilar backend
3. Ejecutar pruebas
4. Empaquetar proyecto
