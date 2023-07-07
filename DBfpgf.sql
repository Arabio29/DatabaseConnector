CREATE DATABASE DatabaseConnector;
USE DatabaseConnector;

-- Creación de la tabla "Usuarios"
CREATE TABLE Usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  apellido VARCHAR(255),
  email VARCHAR(255),
  contrasena VARCHAR(255),
  telefono VARCHAR(20),
  direccion VARCHAR(255),
  ciudad VARCHAR(255),
  pais VARCHAR(255),
  codigo_postal VARCHAR(10)
);

-- Creación de la tabla "Donaciones"
CREATE TABLE Donaciones (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  fecha DATE,
  monto DECIMAL(10, 2),
  descripcion TEXT,
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

-- Creación de la tabla "Proyectos"
CREATE TABLE Proyectos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  descripcion TEXT,
  fecha_inicio DATE,
  fecha_fin DATE
);

-- Creación de la tabla "Usuarios_Proyectos"
CREATE TABLE Usuarios_Proyectos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  proyecto_id INT,
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
  FOREIGN KEY (proyecto_id) REFERENCES Proyectos(id)
);