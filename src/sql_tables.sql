DROP DATABASE IF EXISTS videorental;
CREATE DATABASE videorental;
USE videorental;

CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    tipo VARCHAR(20),
    email VARCHAR(100),
    puesto VARCHAR(100)
);

CREATE TABLE material (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    year INT,
    tipo VARCHAR(20),
    disponible BOOLEAN,
    region_code INT,
    resolucion VARCHAR(50),
    duracion_min INT
);

CREATE TABLE prestamo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT,
    material_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (material_id) REFERENCES material(id)
);