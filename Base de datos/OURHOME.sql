DROP DATABASE IF EXISTS ourhome;
CREATE DATABASE ourhome;
USE ourhome;

CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surnames VARCHAR(100) DEFAULT NULL,
    age INT NULL,
    phone INT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role ENUM('busco_casa', 'tengo_casa', 'admin') NOT NULL,
    default_test_responses MEDIUMTEXT NULL,
    show_phone bit DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NULL
);

INSERT INTO users (name, surnames, age, phone, email, password, role, default_test_responses, show_phone, created_at) VALUES
('Admin', '', 15, 000000000, 'admin@ourhome.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '3', '', 0, CURRENT_DATE()),
('Marco', 'Polo', 20, 633254182, 'marcololo@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '01001', 0, CURRENT_DATE()), 			#busco
('Anna', 'mota', 25, 124512325, 'annamota@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '11001', 1, CURRENT_DATE()), 				#tengo
('Maria', 'Aguilea', 34, 489562558, 'mariaguilera@yahoo.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '11011', 1, CURRENT_DATE()), 		#busco
('Sergi', 'Lopez', 23, 152248621, 'sergilopez@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00011', 1, CURRENT_DATE()), 			#tengo
('Jose', 'Pablo', 24, 162584759, 'josepablo@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '11111', 0, CURRENT_DATE()),				#tengo
('Max', 'Ten', 29, 157448526, 'maxten@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00100', 0, CURRENT_DATE()), 					#busco
('Laura', 'Mandez', 30, 524886695, 'lauramendez@yahoo.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '11000', 1, CURRENT_DATE()), 			#tengo
('Amapola', 'Guarana', 18, 188526785, 'amapolaguarana@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00010', 0, CURRENT_DATE()), 	#busco
('Paco', 'Marquez', 19, 632251856, 'pacomarquez@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00101', 0, CURRENT_DATE()), 			#busco
('Angel', 'Gracia', 28, 662551449, 'angelgarcia@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '11200', 0, CURRENT_DATE()); 			#busco

CREATE TABLE homes(
    home_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    url_photos MEDIUMTEXT DEFAULT NULL,
    description MEDIUMTEXT DEFAULT NULL,
    price DOUBLE NOT NULL,
    num_bedrooms INT NOT NULL,
    num_bathroom INT NOT NULL,
    city VARCHAR(100) DEFAULT NULL,
    direction VARCHAR(100) DEFAULT NULL,
    meters DECIMAL DEFAULT NULL,
    floors INT NOT NULL,
    additional MEDIUMTEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO homes (user_id, url_photos, description, price, num_bedrooms, num_bathroom, city, direction, meters, floors, created_at, updated_at) VALUES
(2, 'https://i.imgur.com/I50hiEl.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 350, 2, 1, 'Reus', 'C/ Tarragona', 120, 1, CURRENT_DATE(), CURRENT_DATE()),
(4, 'https://i.imgur.com/69sudKd.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 500, 4, 2, 'Tarragona','C/ San Pere', 220, 3, CURRENT_DATE(), CURRENT_DATE()),
(5, 'https://i.imgur.com/fuanOPn.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 400, 3, 1, 'Reus', 'C/ Alcalá', 155, 1, CURRENT_DATE(), CURRENT_DATE()),
(7, 'https://i.imgur.com/1V3V5rF.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 350, 3, 1, 'Gerona', 'C/ Larios', 90, 1, CURRENT_DATE(), CURRENT_DATE()),
(4, 'https://i.imgur.com/DFlAUOD.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 390, 4, 1, 'Barcelona', 'C/ de lo Ciegos', 120, 2, CURRENT_DATE(), CURRENT_DATE()),
(7, 'https://i.imgur.com/7GCuLrZ.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 480, 6, 2, 'Lleida', 'C/ Betis', 170, 3, CURRENT_DATE(), CURRENT_DATE()),
(7, 'https://i.imgur.com/NalEEwP.jpg','Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 300, 4, 1, 'Barcelona', 'C/ Alfonso', 100, 1, CURRENT_DATE(), CURRENT_DATE()),
(5, 'https://i.imgur.com/SrLj4LE.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 200, 2, 1, 'Lleida', 'C/ del Ángel', 100, 1, CURRENT_DATE(), CURRENT_DATE()),
(2, 'https://i.imgur.com/baPZUyN.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 525, 6, 3, 'Gerona', 'Avenida Constitución ', 200, 2, CURRENT_DATE(), CURRENT_DATE()),
(2, 'https://i.imgur.com/sJjM1Ck.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 445, 2, 2, 'Tarragona', 'C/ de la Compañia', 150, 2, CURRENT_DATE(), CURRENT_DATE()),
(4, 'https://i.imgur.com/RrmknIT.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 550, 3, 1, 'tarragona', 'C/ Rapita', 180, 1, CURRENT_DATE(), CURRENT_DATE());

CREATE TABLE processes(
    process_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id_1 INT NOT NULL,
    user_id_2 INT NOT NULL,
    state ENUM('En Contacto', 'Cancelado', 'Finalizado') NOT NULL,
    created_at DATE DEFAULT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id_1) REFERENCES users(user_id),
    FOREIGN KEY (user_id_2) REFERENCES users(user_id)
);

INSERT INTO processes (user_id_1 , user_id_2, state, created_at , updated_at) VALUES
(3, 1, 1, CURRENT_DATE(), CURRENT_DATE()),
(9, 7, 2, CURRENT_DATE(), CURRENT_DATE()),
(8, 8, 1, CURRENT_DATE(), CURRENT_DATE()),
(7, 2, 3, CURRENT_DATE(), CURRENT_DATE()),
(2, 6, 2, CURRENT_DATE(), CURRENT_DATE()),
(10, 5, 1, CURRENT_DATE(), CURRENT_DATE()),
(6, 9, 2, CURRENT_DATE(), CURRENT_DATE()),
(5, 4, 3, CURRENT_DATE(), CURRENT_DATE()),
(4, 3, 3, CURRENT_DATE(), CURRENT_DATE()),
(1, 10, 1, CURRENT_DATE(), CURRENT_DATE());

CREATE TABLE custom_tests(
	custom_test_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    correct_answers MEDIUMTEXT NOT NULL,
    minimum_correct_responses INT NOT NULL,
	created_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO custom_tests (user_id, correct_answers, minimum_correct_responses, created_at) VALUES
(3, 'a', 1, CURRENT_DATE()),
(3, 'a', 5, CURRENT_DATE()),
(3, 'a', 6, CURRENT_DATE()),
(3, 'a', 4, CURRENT_DATE()),
(3, 'a', 7, CURRENT_DATE()),
(3, 'a', 2, CURRENT_DATE()),
(3, 'a', 10, CURRENT_DATE()),
(3, 'a', 8, CURRENT_DATE()),
(3, 'a', 3, CURRENT_DATE()),
(3, 'a', 9, CURRENT_DATE());

CREATE TABLE custom_tests_responses(
	custom_test_response_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    custom_test_id INT NOT NULL,
    answers MEDIUMTEXT NOT NULL,
    compatibility DECIMAL NOT NULL,
	created_at DATE DEFAULT NULL,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (custom_test_id) REFERENCES custom_tests(custom_test_id)
);

INSERT INTO custom_tests_responses (user_id, custom_test_id, answers, compatibility, created_at) VALUES 
(1, 10, 'a', 90, CURRENT_DATE()),
(2, 9, 'a', 30, CURRENT_DATE()),
(3, 8, 'a', 60, CURRENT_DATE()),
(4, 7, 'a', 70, CURRENT_DATE()),
(5, 6, 'a', 85, CURRENT_DATE()),
(6, 5, 'a', 44, CURRENT_DATE()),
(7, 4, 'a', 23, CURRENT_DATE()),
(8, 3, 'a', 95, CURRENT_DATE()),
(9, 2, 'a', 34, CURRENT_DATE()),
(10, 1, 'a', 77, CURRENT_DATE());
