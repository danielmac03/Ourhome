DROP DATABASE IF EXISTS ourhome;
CREATE DATABASE ourhome;
USE ourhome;

CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surnames VARCHAR(100) DEFAULT NULL,
    age INT NOT NULL,
    phone INT NULL,
    mail VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('tengo_casa', 'busco_casa', 'admin') NOT NULL,
    default_test_responses MEDIUMTEXT NOT NULL,
    show_phone bit DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL
);

INSERT INTO users (name, surname, age, phone, mail, password, role, default_test_responses, show_phone, created_at, updated_at) VALUES
('Daniel', 'Rodrigues', 15, 699873544, 'danielrodrigues@gmail.com', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', '2', 'as', 1, CURRENT_DATE(), CURRENT_DATE()),
('Marco', 'Polo', 20, 633254182, 'marcololo@hotmail.com', 'marco00', '1', 'sa', 0, CURRENT_DATE(), CURRENT_DATE()),
('Anna', 'mota', 25, 124512325, 'annamota@gmail.com', 'anna00', '2', 'as', 1, CURRENT_DATE(), CURRENT_DATE()),
('Maria', 'Aguilea', 34, 489562558, 'mariaguilera@yahoo.com', 'maria00', '1', 'sa', 1, CURRENT_DATE(), CURRENT_DATE()),
('Sergi', 'Lopez', 23, 152248621, 'sergilopez@hotmail.com', 'sergi00', '2', 'as', 1, CURRENT_DATE(), CURRENT_DATE()),
('Jose', 'Pablo', 24, 162584759, 'josepablo@hotmail.com', 'jose00', '1', 'sa', 0, CURRENT_DATE(), CURRENT_DATE()),
('Max', 'Ten', 29, 157448526, 'maxten@gmail.com', 'max00', '2', 'as', 0, CURRENT_DATE(), CURRENT_DATE()),
('Laura', 'Mandez', 30, 524886695, 'lauramendez@yahoo.com', 'laura00', '1', 'sa', 1, CURRENT_DATE(), CURRENT_DATE()),
('Amapola', 'Guarana', 18, 188526785, 'amapolaguarana@hotmail.com', 'amapola00', '2', 'sa', 0, CURRENT_DATE(), CURRENT_DATE()),
('Paco', 'Marquez', 19, 632251856, 'pacomarquez@gmail.com', 'paco00', '2', 'sa', 0, CURRENT_DATE(), CURRENT_DATE());

CREATE TABLE homes(
    home_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    url_photos MEDIUMTEXT DEFAULT NULL,
    description MEDIUMTEXT DEFAULT NULL,
    price DOUBLE NOT NULL,
    num_bedrooms INT NOT NULL,
    num_bathroom INT NOT NULL,
    direction VARCHAR(100) DEFAULT NULL,
    meters DECIMAL DEFAULT NULL,
    floors INT NOT NULL,
    additional MEDIUMTEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO casas (user_id, url_photos, description, price, num_bedrooms, num_bathroom, direction, meters, floors, additional, created_at, updated_at) VALUES
(10, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 350, 2, 1, 'C/ Tarragona', 120, 1, CURRENT_DATE(), CURRENT_DATE()),
(8, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 500, 4, 2, 'C/ San Pere', 220, 3, CURRENT_DATE(), CURRENT_DATE()),
(5, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 400, 3, 1, 'C/ Alcalá', 155, 1, CURRENT_DATE(), CURRENT_DATE()),
(3, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 350, 3, 1, 'C/ Larios', 90, 1, CURRENT_DATE(), CURRENT_DATE()),
(6, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 390, 4, 1, 'C/ de lo Ciegos', 120, 2, CURRENT_DATE(), CURRENT_DATE()),
(4, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 480, 6, 2, 'C/ Betis', 170, 3, CURRENT_DATE(), CURRENT_DATE()),
(7, 'https://imgur.com/a/9kTvflF','Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 300, 4, 1, 'C/ Alfonso', 100, 1, CURRENT_DATE(), CURRENT_DATE()),
(1, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 200, 2, 1, 'C/ del Ángel', 100, 1, CURRENT_DATE(), CURRENT_DATE()),
(9, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 525, 6, 3, 'Avenida Constitución ', 200, 2, CURRENT_DATE(), CURRENT_DATE()),
(2, 'https://imgur.com/a/9kTvflF', 'Lorem Ipsum es simplemente texto de relleno de la industria de la impresión y la composición tipográfica.', 445, 2, 2, 'C/ de la Compañia', 150, 2, CURRENT_DATE(), CURRENT_DATE());

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

CREATE TABLE custom_test(
	custom_test_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    correct_answers MEDIUMTEXT NOT NULL,
    minimum_correct_responses INT NOT NULL,
	created_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO custom_test (user_id, correct_answers, minimum_correct_responses, created_at) VALUES
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
    FOREIGN KEY (custom_test_id) REFERENCES custom_test(custom_test_id)
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

