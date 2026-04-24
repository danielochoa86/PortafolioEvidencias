# 🎬 Video Rental System

Sistema de alquiler de materiales audiovisuales desarrollado en Java como parte del curso de Programación Orientada a Objetos.

## 📌 Descripción

El sistema modela un Video Rental tradicional, permitiendo gestionar clientes, empleados, materiales audiovisuales y préstamos activos.

El proyecto fue desarrollado aplicando principios de Programación Orientada a Objetos, arquitectura por capas, patrón DAO y persistencia de datos mediante MySQL.

## ⚙️ Funcionalidades

- Registro de clientes y empleados
- Registro de materiales audiovisuales: VHS, DVD y BluRay
- Consulta del catálogo de materiales
- Alquiler de materiales
- Devolución de materiales
- Consulta de préstamos activos
- Persistencia de datos en base de datos MySQL

## 🧱 Arquitectura del proyecto

El proyecto se organiza en capas:

- `bl.model`: clases del dominio, como Usuario, Cliente, Empleado, Material, VHS, DVD, BluRay y Prestamo.
- `bl.dao`: clases DAO encargadas del acceso a datos.
- `bl.logic`: gestores encargados de la lógica de negocio.
- `dl`: clases de conexión y acceso a base de datos.
- `tl`: controlador que comunica la interfaz con la lógica del sistema.
- `ui`: clases de interacción por consola.
- `utils`: utilidades generales y archivo de configuración de base de datos.

## 🗄️ Base de datos

El sistema utiliza MySQL como motor de base de datos.  
El repositorio incluye un archivo SQL con las instrucciones necesarias para crear la base de datos y sus tablas.

Tablas principales:

- `usuario`
- `material`
- `prestamo`

## ▶️ Ejecución

1. Clonar el repositorio.
2. Crear la base de datos utilizando el script SQL incluido.
3. Verificar la configuración del archivo `bd.properties`.
4. Ejecutar la clase `Main`.

## 📚 Contexto

Aunque los Video Rentals son hoy un modelo de negocio obsoleto debido a las plataformas de streaming, representan un dominio adecuado para modelar relaciones entre usuarios, materiales y préstamos.

Además, este sistema fue elegido por su valor nostálgico y por su utilidad para aplicar conceptos fundamentales de Programación Orientada a Objetos.

## 🛠️ Tecnologías

- Java
- MySQL
- JDBC
- Programación Orientada a Objetos
- Patrón DAO
- Arquitectura por capas
