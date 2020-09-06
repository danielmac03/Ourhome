
CREATE DATABASE IF NOT EXISTS ourhome;
USE ourhome;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS test_respuestas;
DROP TABLE IF EXISTS respuestas_usuarios;
DROP TABLE IF EXISTS questionarios;
DROP TABLE IF EXISTS casas;
DROP TABLE IF EXISTS relaciones;


CREATE TABLE IF NOT EXISTS usuarios(
	id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) DEFAULT NULL,
    edad INT NOT NULL,
    telefono INT (9) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    rol ENUM('Con Casa', 'Sin Casa') NOT NULL,
    fecha_registro date DEFAULT NULL,
    contacto ENUM('Mostrar Correo', 'Mostrar Telefono') NOT NULL,
    respuestas_test_defecto VARCHAR(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS test_respuestas(
	id_test_respuestas INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_test INT NOT NULL,
    id_respuestas_usuario INT NOT NULL,
    respuestas VARCHAR(100) NOT NULL,
    compatibilidad INT
);

CREATE TABLE IF NOT EXISTS respuestas_usuarios(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_test_respuestas INT NOT NULL,
	FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_test_respuestas) REFERENCES test_respuestas(id_test_respuestas)
);

CREATE TABLE IF NOT EXISTS questionarios(
	id_test INT PRIMARY KEY,
    id_usuario_creador INT NOT NULL,
    respuestas_correctas VARCHAR(100),
    FOREIGN KEY (id_usuario_creador) REFERENCES usuarios(id_usuario)
);

CREATE TABLE IF NOT EXISTS casas(
	id_casa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_usuario INT NOT NULL,
    descripcion VARCHAR(500) DEFAULT NULL,
    precio DOUBLE NOT NULL,
    numero_habitaciones INT NOT NULL,
    numero_baños INT NOT NULL,
    direccion VARCHAR(100) DEFAULT NULL,
    metros2 INT DEFAULT NULL,
    pisos INT NOT NULL,
    parquing ENUM('Si', 'No') NOT NULL,
    calefaccion ENUM('Si', 'No') NOT NULL,
    ascensor ENUM('Si', 'No') NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE IF NOT EXISTS relaciones(
	id_relacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario_1 INT NOT NULL,
    id_usuario_2 INT NOT NULL,
    proceso ENUM('En Contacto', 'Cancelado', 'Finalizado') NOT NULL
);