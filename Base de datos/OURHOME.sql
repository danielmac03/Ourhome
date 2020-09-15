DROP DATABASE IF EXISTS ourhome;
CREATE DATABASE ourhome;
USE ourhome;

CREATE TABLE usuarios(
	id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) DEFAULT NULL,
    edad INT NOT NULL,
    telefono INT NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    rol ENUM('Con Casa', 'Sin Casa') NOT NULL,
	respuestas_test_defecto MEDIUMTEXT NOT NULL,
    mostrar_correo bit DEFAULT NULL,
	mostrar_telefono bit DEFAULT NULL,
	fecha_creacion DATE DEFAULT NULL,
	fecha_actualizacion DATE DEFAULT NULL
);

CREATE TABLE casas(
	id_casa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_usuario INT NOT NULL,
    descripcion MEDIUMTEXT DEFAULT NULL,
    precio DOUBLE NOT NULL,
    numero_habitaciones INT NOT NULL,
    numero_baños INT NOT NULL,
    direccion VARCHAR(100) DEFAULT NULL,
    metros DECIMAL DEFAULT NULL,
    plantas INT NOT NULL,
	extras MEDIUMTEXT DEFAULT NULL,
	fecha_creacion DATE DEFAULT NULL,
	fecha_actualizacion DATE DEFAULT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE procesos(
	id_proceso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario_1 INT NOT NULL,
    id_usuario_2 INT NOT NULL,
    estado ENUM('En Contacto', 'Cancelado', 'Finalizado') NOT NULL,
	fecha_creacion DATE DEFAULT NULL,
	fecha_actualizacion DATE DEFAULT NULL,
    FOREIGN KEY (id_usuario_1) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_usuario_2) REFERENCES usuarios(id_usuario)
);

CREATE TABLE test_personalizados(
	id_test_personalizados INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario_creador INT NOT NULL,
    respuestas_correctas MEDIUMTEXT NOT NULL,
    minimas_respuestas_correctas INT NOT NULL,
	fecha_creacion DATE DEFAULT NULL,
    FOREIGN KEY (id_usuario_creador) REFERENCES usuarios(id_usuario)
);

CREATE TABLE respuestas_tests_personalizados(
	id_respuestas_test_personalizado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_test_personalizado INT NOT NULL,
    respuestas MEDIUMTEXT NOT NULL,
    compatibilidad DECIMAL NOT NULL,
	fecha_creacion DATE DEFAULT NULL,
	FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_test_personalizado) REFERENCES test_personalizados(id_test_personalizados)
);