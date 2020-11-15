DROP DATABASE IF EXISTS ourhome;
CREATE DATABASE ourhome;
USE ourhome;

CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surnames VARCHAR(100) DEFAULT NULL,
    url_photo MEDIUMTEXT DEFAULT NULL,
    description MEDIUMTEXT DEFAULT NULL,
    age INT NULL,
    phone INT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role ENUM('search', 'have', 'business', 'admin') NOT NULL,
    default_test_responses MEDIUMTEXT NULL,
    show_phone bit DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NULL
);

INSERT INTO users (name, surnames, age, phone, email, password, role, default_test_responses, show_phone, created_at) VALUES
('Admin', '', 15, null, 'admin@ourhome.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '3', '11000', 0, CURRENT_DATE()),
('Marco', 'Polo', 20, 633254182, 'marcololo@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '01001', 0, CURRENT_DATE()), 			#tengo
('Anna', 'mota', 25, 124512325, 'annamota@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '11001', 1, CURRENT_DATE()), 				#busco
('Maria', 'Aguilea', 34, 489562558, 'mariaguilera@yahoo.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '11011', 1, CURRENT_DATE()), 		#tengo
('Sergi', 'Lopez', 23, 152248621, 'sergilopez@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00011', 1, CURRENT_DATE()), 			#busco
('Jose', 'Pablo', 24, 162584759, 'josepablo@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '11111', 0, CURRENT_DATE()),				#tengo
('Max', 'Ten', 29, 157448526, 'maxten@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00100', 0, CURRENT_DATE()), 					#tengo
('Laura', 'Mandez', 30, 524886695, 'lauramendez@yahoo.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '1', '11000', 1, CURRENT_DATE()), 			#busco
('Amapola', 'Guarana', 18, 188526785, 'amapolaguarana@hotmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00010', 0, CURRENT_DATE()), 	#busco
('Paco', 'Marquez', 19, 632251856, 'pacomarquez@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', '00101', 0, CURRENT_DATE()), 			#busco
('Angel', 'Gracia', 28, 662551449, 'angelgarcia@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '3', '11000', 0, CURRENT_DATE()); 			#business

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
(3, 'https://i.imgur.com/69sudKd.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 500, 4, 2, 'Tarragona','C/ San Pere', 220, 3, CURRENT_DATE(), CURRENT_DATE()),
(11, 'https://i.imgur.com/fuanOPn.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 400, 3, 1, 'Reus', 'C/ Alcalá', 155, 1, CURRENT_DATE(), CURRENT_DATE()),
(5, 'https://i.imgur.com/1V3V5rF.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 350, 3, 1, 'Gerona', 'C/ Larios', 90, 1, CURRENT_DATE(), CURRENT_DATE()),
(6, 'https://i.imgur.com/DFlAUOD.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 390, 4, 1, 'Barcelona', 'C/ de lo Ciegos', 120, 2, CURRENT_DATE(), CURRENT_DATE()),
(11, 'https://i.imgur.com/7GCuLrZ.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 480, 6, 2, 'Lleida', 'C/ Betis', 170, 3, CURRENT_DATE(), CURRENT_DATE()),
(7, 'https://i.imgur.com/NalEEwP.jpg','Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 300, 4, 1, 'Barcelona', 'C/ Alfonso', 100, 1, CURRENT_DATE(), CURRENT_DATE()),
(9, 'https://i.imgur.com/SrLj4LE.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 200, 2, 1, 'Lleida', 'C/ del Ángel', 100, 1, CURRENT_DATE(), CURRENT_DATE()),
(10, 'https://i.imgur.com/baPZUyN.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 525, 6, 3, 'Gerona', 'Avenida Constitución ', 200, 2, CURRENT_DATE(), CURRENT_DATE()),
(11, 'https://i.imgur.com/sJjM1Ck.jpg', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 445, 2, 2, 'Tarragona', 'C/ de la Compañia', 150, 2, CURRENT_DATE(), CURRENT_DATE());

CREATE TABLE processes(
    process_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    home_id INT NOT NULL,
    user_id INT NOT NULL,
    answers MEDIUMTEXT NOT NULL,
    compatibility DECIMAL NOT NULL,
    state ENUM('En Contacto', 'Cancelado', 'Finalizado') NOT NULL,
    created_at DATE DEFAULT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (home_id) REFERENCES homes(home_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);


INSERT INTO processes (home_id, user_id, answers, compatibility, state, created_at , updated_at) VALUES
(3, 2, '0,1', 80, 3, CURRENT_DATE(), CURRENT_DATE()),
(3, 1, '0,1', 60, 1, CURRENT_DATE(), CURRENT_DATE()),
(8, 8, '0,1', 40, 3, CURRENT_DATE(), CURRENT_DATE()),
(7, 2, '0,1', 30, 2, CURRENT_DATE(), CURRENT_DATE()),
(3, 6, '0,1', 50, 1, CURRENT_DATE(), CURRENT_DATE()),
(3, 5, '0,1', 90, 2, CURRENT_DATE(), CURRENT_DATE()),
(7, 9, '0,1', 20, 1, CURRENT_DATE(), CURRENT_DATE()),
(5, 4, '0,1', 100, 2, CURRENT_DATE(), CURRENT_DATE()),
(6, 2, '0,1', 40, 3, CURRENT_DATE(), CURRENT_DATE()),
(3, 10, '0,1', 20, 2, CURRENT_DATE(), CURRENT_DATE());

CREATE TABLE custom_tests(
	custom_test_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    questions MEDIUMTEXT NOT NULL,
    answers MEDIUMTEXT NOT NULL,
    options1 MEDIUMTEXT NOT NULL,
    options2 MEDIUMTEXT NOT NULL,
	created_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO custom_tests (user_id, questions, answers, options1, options2, created_at) VALUES
       (2, 'qwe, ert', '1,2', 'awd, awew', 'awd, awew', CURRENT_DATE()),
       (3, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (4, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (5, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (6, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (7, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (8, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (9, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE()),
       (10, 'qwe, ert', '1,2', 'awd, cvb', 'awd, awew', CURRENT_DATE());

CREATE TABLE notifications(
     notification_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     user_id INT NOT NULL,
     content MEDIUMTEXT NOT NULL,
     created_at DATE DEFAULT NULL,
     FOREIGN KEY (user_id) REFERENCES users(user_id)
);


INSERT INTO notifications (user_id, content, created_at) VALUES
(2, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(3, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(4, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(5, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(6, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(7, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(8, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(9, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE()),
(10, 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', CURRENT_DATE());
