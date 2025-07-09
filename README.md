# 🖨️ Imprenta Tucán - Sistema de Gestión

Este proyecto es un **Trabajo Práctico Integrador (TPI)** para la cátedra **Diseño y Aplicaciones en la Web**, desarrollado por **Ramos Federico** y **Luciano López**.

## 📚 Descripción

**Imprenta Tucán** es un sistema web diseñado para gestionar de forma ágil y organizada los procesos operativos de una imprenta. Permite:
- Registrar y administrar **Clientes**, **Pedidos**, **Provincias** y **Localidades**.
- Realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) para cada entidad.
- Gestionar archivos de diseño asociados a los pedidos.
- Validar datos clave desde el frontend para asegurar la coherencia de la información.

El objetivo principal es reemplazar la gestión manual de pedidos por una solución **moderna**, **escalable** y de **fácil uso**.

---

## 🛠️ Tecnologías utilizadas

- **Java 24**
- **Spring Boot v3.5.3**
- **Thymeleaf** para renderizado de vistas.
- **Tailwind CSS** para el diseño responsivo y moderno.
- **PostgreSQL** como base de datos relacional.
- **Spring Data JPA** para persistencia.
- **PgAdmin** para administrar la base de datos.

---

## ⚙️ Funcionalidades principales

✔️ ABM de Clientes (alta, baja, modificación y detalle)  
✔️ ABM de Pedidos (con posibilidad de adjuntar archivos de diseño)  
✔️ ABM de Provincias y Localidades  
✔️ Validaciones básicas en frontend (campos obligatorios y formatos)  
✔️ Renderizado de detalles de pedidos, con vista previa de imágenes o descarga de archivos.

---

## 🗂️ Estructura del proyecto

    src/
    └── main/
    ├── java/
    │ └── com.imprenta.tucan
    │ ├── controller/
    │ ├── model/
    │ ├── repository/
    │ ├── service/
    │ └── TucanApplication.java
    ├── resources/
    │ ├── templates/
    │ │ ├── clientes/
    │ │ ├── pedidos/
    │ │ ├── localidades/
    │ │ ├── provincias/
    │ │ └── fragmentos/
    │ ├── static/
    │ └── application.properties
    ├── uploads/ # Carpeta para almacenar archivos de diseño

---

## 🗃️ Base de datos

- El proyecto utiliza **PostgreSQL**.
- Configuración de conexión en `application.properties`.
- El esquema incluye tablas para:
  - `cliente`
  - `pedido`
  - `provincia`
  - `localidad`

---

## ⚡ Cómo ejecutar el proyecto

1. Clonar este repositorio:
   ```bash
   git clone https://github.com/federamos17/IntegradorDisenioWeb.git

2. Configurar la base de datos en PostgreSQL:

    - Crear la base de datos: `imprenta_tucan`

    - Ajustar `application.properties` con usuario y contraseña.

3. Crear la carpeta `uploads` en el root del proyecto (o configurar la ruta absoluta).

4. Ejecutar el proyecto:

    `./mvnw spring-boot:run`

    o desde tu IDE favorito.

5. Acceder en navegador:

    `http://localhost:8080/`