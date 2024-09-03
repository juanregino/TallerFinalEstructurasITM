# Proyecto de Gestión de Citas Médicas (Taller Final Esturcturas de Datos ITM)

Este proyecto es una aplicación Spring Boot para la gestión de citas médicas. Utiliza una base de datos PostgreSQL y PGAdmin para la administración de la base de datos, corriendo en contenedores Docker.

## Tecnologías Utilizadas

- **Spring Boot**: Framework de Java para el desarrollo rápido de aplicaciones web.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional.
- **PGAdmin**: Herramienta de administración de PostgreSQL.
- **Docker & Docker Compose**: Plataforma para desarrollar, desplegar y ejecutar aplicaciones en contenedores.
- **Swagger**: Documentación de la API REST.
- **GitFlow**: Flujo de trabajo de Git.

## Prerrequisitos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- [Java 17](https://adoptium.net/) o superior
- [Maven](https://maven.apache.org/) 
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Instalación

Sigue estos pasos para poner en marcha el proyecto:

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tu-usuario/tu-proyecto.git
   cd tu-proyecto
2. **Instala las dependencias:**

   ```bash
   mvn clean install
   ```

3. **Ejecuta el contenedor de PostgreSQL:**

   ```bash
   docker-compose up -d
   ```


4. **Ejecuta el proyecto:**

   ```bash
   mvn spring-boot:run
   ```

5. **Accede a la documentación de la API REST:**

   ```bash
   http://localhost:8080/api/v1/swagger-ui/index.html
   ```