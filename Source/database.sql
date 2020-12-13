DROP DATABASE IF EXISTS ourhome;
CREATE DATABASE ourhome;
USE ourhome;

CREATE TABLE users
(
    user_id                INT                                          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                   VARCHAR(100)                                 NOT NULL,
    surnames               VARCHAR(100) DEFAULT NULL,
    profile_picture        LONGBLOB         DEFAULT NULL,
    description            MEDIUMTEXT   DEFAULT NULL,
    age                    INT                                          NULL,
    phone                  INT                                          NULL,
    email                  VARCHAR(100)                                 NOT NULL UNIQUE,
    password               VARCHAR(100)                                 NOT NULL,
    role                   ENUM ('search', 'have', 'business', 'admin') NOT NULL,
    default_test_responses MEDIUMTEXT                                   NULL,
    show_phone             bit          DEFAULT NULL,
    created_at             DATETIME                                     NOT NULL,
    updated_at             DATETIME                                     NULL
);

CREATE TABLE homes
(
    home_id      INT AUTO_INCREMENT PRIMARY KEY,
    user_id      INT      NOT NULL,
    url_photos   MEDIUMTEXT   DEFAULT NULL,
    description  MEDIUMTEXT   DEFAULT NULL,
    price        DOUBLE   NOT NULL,
    num_bedrooms INT      NOT NULL,
    num_bathroom INT      NOT NULL,
    city         VARCHAR(100) DEFAULT NULL,
    direction    VARCHAR(100) DEFAULT NULL,
    meters       DECIMAL      DEFAULT NULL,
    floors       INT      NOT NULL,
    additional   MEDIUMTEXT   DEFAULT NULL,
    active       BIT          DEFAULT TRUE,
    created_at   DATETIME NOT NULL,
    updated_at   DATETIME     DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE processes
(
    process_id    INT                                             NOT NULL AUTO_INCREMENT PRIMARY KEY,
    home_id       INT                                             NOT NULL,
    user_id       INT                                             NOT NULL,
    answers       MEDIUMTEXT                                      NOT NULL,
    compatibility DECIMAL                                         NOT NULL,
    state         ENUM ('En Contacto', 'Cancelado', 'Finalizado') NOT NULL,
    created_at    DATETIME DEFAULT NULL,
    updated_at    DATETIME DEFAULT NULL,
    FOREIGN KEY (home_id) REFERENCES homes (home_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE custom_tests
(
    custom_test_id INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id        INT        NOT NULL,
    questions      MEDIUMTEXT NOT NULL,
    answers        MEDIUMTEXT NOT NULL,
    options1       MEDIUMTEXT NOT NULL,
    options2       MEDIUMTEXT NOT NULL,
    created_at     DATETIME   NULL,
    updated_at     DATETIME   NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE notifications
(
    notification_id INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id         INT        NOT NULL,
    content_text    MEDIUMTEXT NOT NULL,
    content_img     MEDIUMTEXT NULL,
    content_url     MEDIUMTEXT NULL,
    created_at      DATETIME DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

#Tables to envers
CREATE TABLE revinfo
(
    rev      INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    revtstmp BIGINT
);

CREATE TABLE users_aud
(
    user_id                INT                                          NOT NULL AUTO_INCREMENT,
    name                   VARCHAR(100)                                 NULL,
    surnames               VARCHAR(100) DEFAULT NULL,
    profile_picture        LONGBLOB         DEFAULT NULL,
    description            MEDIUMTEXT   DEFAULT NULL,
    age                    INT                                          NULL,
    phone                  INT                                          NULL,
    email                  VARCHAR(100)                                 NULL,
    password               VARCHAR(100)                                 NULL,
    role                   ENUM ('search', 'have', 'business', 'admin') NULL,
    default_test_responses MEDIUMTEXT                                   NULL,
    show_phone             bit          DEFAULT NULL,
    created_at             DATETIME                                     NULL,
    updated_at             DATETIME                                     NULL,
    rev                    INT                                          NOT NULL,
    revtype                TINYINT                                      NOT NULL,
    PRIMARY KEY (user_id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

CREATE TABLE homes_aud
(
    home_id      INT      NOT NULL AUTO_INCREMENT,
    user_id      INT      NULL,
    url_photos   MEDIUMTEXT   DEFAULT NULL,
    description  MEDIUMTEXT   DEFAULT NULL,
    price        DOUBLE   NULL,
    num_bedrooms INT      NULL,
    num_bathroom INT      NULL,
    city         VARCHAR(100) DEFAULT NULL,
    direction    VARCHAR(100) DEFAULT NULL,
    meters       DECIMAL      DEFAULT NULL,
    floors       INT      NULL,
    additional   MEDIUMTEXT   DEFAULT NULL,
    active       BIT          DEFAULT TRUE,
    created_at   DATETIME NULL,
    updated_at   DATETIME     DEFAULT NULL,
    rev          INT      NOT NULL,
    revtype      TINYINT  NOT NULL,
    PRIMARY KEY (home_id, rev),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

CREATE TABLE processes_aud
(
    process_id    INT                                             NOT NULL AUTO_INCREMENT,
    home_id       INT                                             NULL,
    user_id       INT                                             NULL,
    answers       MEDIUMTEXT                                      NULL,
    compatibility DECIMAL                                         NULL,
    state         ENUM ('En Contacto', 'Cancelado', 'Finalizado') NULL,
    created_at    DATETIME DEFAULT NULL,
    updated_at    DATETIME DEFAULT NULL,
    rev           INT                                             NOT NULL,
    revtype       TINYINT                                         NOT NULL,
    PRIMARY KEY (process_id, rev),
    FOREIGN KEY (home_id) REFERENCES homes (home_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

CREATE TABLE custom_tests_aud
(
    custom_test_id INT        NOT NULL AUTO_INCREMENT,
    user_id        INT        NULL,
    questions      MEDIUMTEXT NULL,
    answers        MEDIUMTEXT NULL,
    options1       MEDIUMTEXT NULL,
    options2       MEDIUMTEXT NULL,
    created_at     DATETIME   NULL,
    updated_at     DATETIME   NULL,
    rev            INT        NOT NULL,
    revtype        TINYINT    NOT NULL,
    PRIMARY KEY (custom_test_id, rev),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

CREATE TABLE notifications_aud
(
    notification_id INT        NOT NULL AUTO_INCREMENT,
    user_id         INT        NOT NULL,
    content_text    MEDIUMTEXT NOT NULL,
    content_img     MEDIUMTEXT NULL,
    content_url     MEDIUMTEXT NULL,
    created_at      DATETIME DEFAULT NULL,
    rev             INT        NOT NULL,
    revtype         TINYINT    NOT NULL,
    PRIMARY KEY (notification_id, rev),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

#Inserts
INSERT INTO `revinfo`
VALUES (1, 1605882726713),
       (2, 1605882734877),
       (3, 1605882743252),
       (4, 1605882750280),
       (5, 1605882758142),
       (6, 1605882765179),
       (7, 1605882772053),
       (8, 1605882780139),
       (9, 1605882787693),
       (10, 1605882794747),
       (11, 1605882820981),
       (12, 1605882827526),
       (13, 1605882834899),
       (14, 1605882841741),
       (15, 1605882914062),
       (16, 1605883140439),
       (17, 1605883187775),
       (18, 1605883227364),
       (19, 1605883281989),
       (20, 1605883318614),
       (23, 1605885687087),
       (24, 1605885793020),
       (25, 1605885864851),
       (26, 1605885907069),
       (27, 1605886095109),
       (28, 1605886120447),
       (29, 1605886305953),
       (30, 1605886323069),
       (31, 1605886368106),
       (32, 1605886440202),
       (33, 1605886470890),
       (34, 1605899514078),
       (35, 1605899540402),
       (36, 1605899561961),
       (37, 1605899578008),
       (38, 1605899593552),
       (39, 1605899610945),
       (40, 1605899626670);

INSERT INTO `users`
VALUES (1, 'admin', '', '', NULL, 0, NULL, 'admin@ourhome.es',
        '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', 'admin', NULL, _binary '\0', '2020-11-20',
        '2020-11-20'),
       (2, 'Marco', 'Polo', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        20, 633254182, 'marcopolo@ourhome.es', '$2a$10$LG6m0k/emEcXKbjtoprGreiKGaBvMHcAQC4fB4ezPx6HUWBpRf4NS', 'search',
        '{"p1":1,"p2":0,"p3":1,"p4":1,"p5":1,"p6":0,"p7":0,"p8":0}', _binary '', '2020-11-20', '2020-11-20'),
       (3, 'Anna', 'Mota', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        25, 124523556, 'annamota@ourhome.es', '$2a$10$rQs/QNGT8dXvT0SI2gMdLu4UvNoa8ujKziBFLw3xeFH2oLwf8fR16', 'have',
        '{"p1":0,"p2":1,"p3":1,"p4":1,"p5":0,"p6":1,"p7":0,"p8":1}', _binary '\0', '2020-11-20', '2020-11-20'),
       (4, 'Maria', 'Aguilea', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        34, 665334585, 'mariaaguilea@ourhome.es', '$2a$10$25RlqGN/tGuqHGrDFF2KN.LUAejX0673EexFAKS9ZB1bg9jGvmJwW',
        'business', '{"p1":1,"p2":1,"p3":0,"p4":0,"p5":0,"p6":1,"p7":1,"p8":1}', _binary '', '2020-11-20',
        '2020-11-20'),
       (5, 'Sergi', 'Rober', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        23, 665334585, 'sergirober@ourhome.es', '$2a$10$1uEPF91Y0LjGXyazdqzGA.zzUO49ny1t5ZPAmhZ.iNhxxFDzwB52y',
        'search', '{"p1":1,"p2":0,"p3":1,"p4":0,"p5":0,"p6":0,"p7":1,"p8":0}', _binary '', '2020-11-20', '2020-11-20'),
       (6, 'Laura', 'Mendz', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        21, 465235596, 'lauramendz@ourhome.es', '$2a$10$TGtbsgQpuepnvw7unCTPcOZQSOEe5Enwox2C0nTvGIqNHDTdR.CMW', 'have',
        '{"p1":0,"p2":1,"p3":0,"p4":1,"p5":1,"p6":0,"p7":1,"p8":0}', _binary '\0', '2020-11-20', '2020-11-20'),
       (7, 'David', 'Lopez', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        24, 564335486, 'davidlopez@ourhome.es', '$2a$10$jLNrixFIoOzyyWZAqIAH1ums.e2/YeVXfPQ4V8PFUxvErZmssmvL.', 'have',
        '{"p1":1,"p2":0,"p3":1,"p4":0,"p5":0,"p6":1,"p7":1,"p8":1}', _binary '', '2020-11-20', '2020-11-20'),
       (8, 'Angel', 'Gracia', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        28, 664325998, 'davidgracia@ourhome.es', '$2a$10$goGXfVpqk2SqAEBKz6ZBseLKmnZKM458KaQZoxVvNOrFSpKlYsjWG',
        'search', '{"p1":0,"p2":1,"p3":0,"p4":1,"p5":1,"p6":1,"p7":0,"p8":0}', _binary '\0', '2020-11-20',
        '2020-11-20'),
       (9, 'Nuria', 'Gimenez', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        22, 675556422, 'nuriagimenez@ourhome.es', '$2a$10$76/RLNiLtbZqRpSxBykYAOnvDcqiI7.CGNxNG4veEJFa6WcDi6Oz2',
        'have', '{"p1":1,"p2":0,"p3":1,"p4":0,"p5":1,"p6":0,"p7":0,"p8":1}', _binary '', '2020-11-20', '2020-11-20'),
       (10, 'Marc', 'Agoro', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        26, 687245699, 'marcagoro@ourhome.es', '$2a$10$rHKp0thQM31b8BiRYoX9WekqgjlmwDcanNE./OB2pdCxH7vNy5UqK', 'search',
        '{"p1":1,"p2":1,"p3":0,"p4":1,"p5":0,"p6":1,"p7":1,"p8":0}', _binary '\0', '2020-11-20', '2020-11-20'),
       (11, 'Lara', 'Palandra', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        21, 445335586, 'larapalandra@ourhome.es', '$2a$10$J22iD.9j1RBLjLoi3wH8zulTUU4kNKZ57jwFaNZW3Y96cwQTwcCIm',
        'search', '{"p1":0,"p2":1,"p3":0,"p4":1,"p5":0,"p6":1,"p7":0,"p8":1}', _binary '\0', '2020-11-20',
        '2020-11-20'),
       (12, 'Alberto', 'Casanuevas', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        23, 678559985, 'albertocasanuevas@ourhome.es', '$2a$10$ASyixm1li6rHdLqdwGjqp..pKPL01NogBUe2W9ymWIryZeWBF/39S',
        'have', '{"p1":1,"p2":1,"p3":1,"p4":0,"p5":1,"p6":1,"p7":1,"p8":0}', _binary '', '2020-11-20', '2020-11-20'),
       (13, 'Marcelo', 'Oros', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        24, 645511288, 'marcelooros@ourhome.es', '$2a$10$NK.b/lE1qHIUUdz06eW28O23bNvrK.LJPPO.7W/c82atYugdXUfAO',
        'search', '{"p1":1,"p2":0,"p3":1,"p4":1,"p5":0,"p6":0,"p7":0,"p8":1}', _binary '', '2020-11-20', '2020-11-20'),
       (14, 'Marta', 'Cielos', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        31, 996543996, 'martacielos@ourhome.es', '$2a$10$xAbevLR9CHeMBE0zinGWquDLXGO8ZoyxRTdW.mjpHryrNLXdK7PMK', 'have',
        '{"p1":0,"p2":1,"p3":0,"p4":0,"p5":1,"p6":1,"p7":0,"p8":1}', _binary '\0', '2020-11-20', '2020-11-20');

INSERT INTO `users_aud`
VALUES (1, 'admin', '', '', NULL, 0, NULL, 'admin@ourhome.es',
        '$2a$10$xdYjfdzP1/9biTTl02pXWu9ruZIbZ53UIoFDhrhNs7x6tX08R/NU6', 'admin', NULL, _binary '\0', '2020-11-20',
        '2020-11-20', 1, 0),
       (2, 'Marco', 'Polo', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        20, 633254182, 'marcopolo@ourhome.es', '$2a$10$LG6m0k/emEcXKbjtoprGreiKGaBvMHcAQC4fB4ezPx6HUWBpRf4NS', 'search',
        '{"p1":1,"p2":0,"p3":1,"p4":1,"p5":1,"p6":0,"p7":0,"p8":0}', _binary '', '2020-11-20', '2020-11-20', 2, 0),
       (3, 'Anna', 'Mota', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        25, 124523556, 'annamota@ourhome.es', '$2a$10$rQs/QNGT8dXvT0SI2gMdLu4UvNoa8ujKziBFLw3xeFH2oLwf8fR16', 'have',
        '{"p1":0,"p2":1,"p3":1,"p4":1,"p5":0,"p6":1,"p7":0,"p8":1}', _binary '\0', '2020-11-20', '2020-11-20', 3, 0),
       (4, 'Maria', 'Aguilea', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        34, 665334585, 'mariaaguilea@ourhome.es', '$2a$10$25RlqGN/tGuqHGrDFF2KN.LUAejX0673EexFAKS9ZB1bg9jGvmJwW',
        'business', '{"p1":1,"p2":1,"p3":0,"p4":0,"p5":0,"p6":1,"p7":1,"p8":1}', _binary '', '2020-11-20',
        '2020-11-20', 4, 0),
       (5, 'Sergi', 'Rober', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        23, 665334585, 'sergirober@ourhome.es', '$2a$10$1uEPF91Y0LjGXyazdqzGA.zzUO49ny1t5ZPAmhZ.iNhxxFDzwB52y',
        'search', '{"p1":1,"p2":0,"p3":1,"p4":0,"p5":0,"p6":0,"p7":1,"p8":0}', _binary '', '2020-11-20', '2020-11-20',
        5, 0),
       (6, 'Laura', 'Mendz', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        21, 465235596, 'lauramendz@ourhome.es', '$2a$10$TGtbsgQpuepnvw7unCTPcOZQSOEe5Enwox2C0nTvGIqNHDTdR.CMW', 'have',
        '{"p1":0,"p2":1,"p3":0,"p4":1,"p5":1,"p6":0,"p7":1,"p8":0}', _binary '\0', '2020-11-20', '2020-11-20', 6, 0),
       (7, 'David', 'Lopez', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        24, 564335486, 'davidlopez@ourhome.es', '$2a$10$jLNrixFIoOzyyWZAqIAH1ums.e2/YeVXfPQ4V8PFUxvErZmssmvL.', 'have',
        '{"p1":1,"p2":0,"p3":1,"p4":0,"p5":0,"p6":1,"p7":1,"p8":1}', _binary '', '2020-11-20', '2020-11-20', 7, 0),
       (8, 'Angel', 'Gracia', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        28, 664325998, 'davidgracia@ourhome.es', '$2a$10$goGXfVpqk2SqAEBKz6ZBseLKmnZKM458KaQZoxVvNOrFSpKlYsjWG',
        'search', '{"p1":0,"p2":1,"p3":0,"p4":1,"p5":1,"p6":1,"p7":0,"p8":0}', _binary '\0', '2020-11-20', '2020-11-20',
        8, 0),
       (9, 'Nuria', 'Gimenez', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        22, 675556422, 'nuriagimenez@ourhome.es', '$2a$10$76/RLNiLtbZqRpSxBykYAOnvDcqiI7.CGNxNG4veEJFa6WcDi6Oz2',
        'have', '{"p1":1,"p2":0,"p3":1,"p4":0,"p5":1,"p6":0,"p7":0,"p8":1}', _binary '', '2020-11-20', '2020-11-20', 9,
        0),
       (10, 'Marc', 'Agoro', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        26, 687245699, 'marcagoro@ourhome.es', '$2a$10$rHKp0thQM31b8BiRYoX9WekqgjlmwDcanNE./OB2pdCxH7vNy5UqK', 'search',
        '{"p1":1,"p2":1,"p3":0,"p4":1,"p5":0,"p6":1,"p7":1,"p8":0}', _binary '\0', '2020-11-20', '2020-11-20', 10, 0),
       (11, 'Lara', 'Palandra', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        21, 445335586, 'larapalandra@ourhome.es', '$2a$10$J22iD.9j1RBLjLoi3wH8zulTUU4kNKZ57jwFaNZW3Y96cwQTwcCIm',
        'search', '{"p1":0,"p2":1,"p3":0,"p4":1,"p5":0,"p6":1,"p7":0,"p8":1}', _binary '\0', '2020-11-20', '2020-11-20',
        11, 0),
       (12, 'Alberto', 'Casanuevas', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        23, 678559985, 'albertocasanuevas@ourhome.es', '$2a$10$ASyixm1li6rHdLqdwGjqp..pKPL01NogBUe2W9ymWIryZeWBF/39S',
        'have', '{"p1":1,"p2":1,"p3":1,"p4":0,"p5":1,"p6":1,"p7":1,"p8":0}', _binary '', '2020-11-20', '2020-11-20',
        12, 0),
       (13, 'Marcelo', 'Oros', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        24, 645511288, 'marcelooros@ourhome.es', '$2a$10$NK.b/lE1qHIUUdz06eW28O23bNvrK.LJPPO.7W/c82atYugdXUfAO',
        'search', '{"p1":1,"p2":0,"p3":1,"p4":1,"p5":0,"p6":0,"p7":0,"p8":1}', _binary '', '2020-11-20', '2020-11-20',
        13, 0),
       (14, 'Marta', 'Cielos', NULL,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        31, 996543996, 'martacielos@ourhome.es', '$2a$10$xAbevLR9CHeMBE0zinGWquDLXGO8ZoyxRTdW.mjpHryrNLXdK7PMK', 'have',
        '{"p1":0,"p2":1,"p3":0,"p4":0,"p5":1,"p6":1,"p7":0,"p8":1}', _binary '\0', '2020-11-20', '2020-11-20', 14, 0);

INSERT INTO `custom_tests`
VALUES (1, 2, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20'),
       (2, 3, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20'),
       (3, 6, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20'),
       (4, 7, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20'),
       (5, 9, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20'),
       (6, 12, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20'),
       (7, 14, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20');

INSERT INTO `custom_tests_aud`
VALUES (1, 2, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 34, 0),
       (2, 3, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 35, 0),
       (3, 6, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 36, 0),
       (4, 7, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 37, 0),
       (5, 9, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 38, 0),
       (6, 12, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 39, 0),
       (7, 14, 'qwe, ert', '1, 2', 'a, b', 'a, b', '2020-11-20', '2020-11-20', 40, 0);

INSERT INTO `homes`
VALUES (1, 3, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        350, 3, 1, 'Reus', 'C/ Sant Joan', 160, 1, null, true, '2020-11-20', '2020-11-20'),
       (2, 6, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        150, 2, 1, 'Reus', 'C/ Botarell', 200, 1, null, false, '2020-11-20', '2020-11-20'),
       (3, 4, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        380, 5, 2, 'Reus', 'C/ Tarragona', 350, 2, null, true, '2020-11-20', '2020-11-20'),
       (4, 9, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        220, 3, 2, 'Reus', 'C/ Barcelona', 100, 1, null, false, '2020-11-20', '2020-11-20'),
       (5, 4, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        210, 4, 1, 'Reus', 'C/ Girona', 120, 1, null, true, '2020-11-20', '2020-11-20'),
       (6, 4, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        200, 10, 1, 'Reus', 'C/ Lleida', 130, 1, null, true, '2020-11-20', '2020-11-20');

INSERT INTO `homes_aud`
VALUES (1, 3, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        350, 3, 1, 'Reus', 'C/ Sant Joan', 160, 1, null, true, '2020-11-20', '2020-11-20', 15, 0),
       (2, 6, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        150, 2, 1, 'Reus', 'C/ Botarell', 200, 1, null, false, '2020-11-20', '2020-11-20', 16, 0),
       (3, 4, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        380, 5, 2, 'Reus', 'C/ Tarragona', 350, 2, null, true, '2020-11-20', '2020-11-20', 17, 0),
       (4, 9, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        220, 3, 2, 'Reus', 'C/ Barcelona', 100, 1, null, false, '2020-11-20', '2020-11-20', 18, 0),
       (5, 4, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        210, 4, 1, 'Reus', 'C/ Girona', 120, 1, null, true, '2020-11-20', '2020-11-20', 19, 0),
       (6, 4, '',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus convallis sapien sit amet ipsum aliquet ultrices. Suspendisse lectus purus, aliquam sit amet augue non, pellentesque malesuada erat.',
        200, 4, 1, 'Reus', 'C/ Lleida', 130, 1, null, true, '2020-11-20', '2020-11-20', 20, 0);

INSERT INTO `processes`
VALUES (3, 1, 2, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20'),
       (4, 2, 5, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20'),
       (5, 2, 4, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20'),
       (6, 3, 2, '1,0', 80, 'En Contacto', '2020-11-20', '2020-11-20'),
       (7, 3, 4, '1,0', 30, 'En Contacto', '2020-11-20', '2020-11-20'),
       (8, 4, 8, '1,0', 70, 'En Contacto', '2020-11-20', '2020-11-20'),
       (9, 4, 8, '1,0', 30, 'En Contacto', '2020-11-20', '2020-11-20'),
       (10, 5, 4, '1,0', 30, 'En Contacto', '2020-11-20', '2020-11-20'),
       (11, 5, 10, '1,0', 90, 'En Contacto', '2020-11-20', '2020-11-20'),
       (12, 6, 10, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20'),
       (13, 6, 8, '1,0', 70, 'En Contacto', '2020-11-20', '2020-11-20');

INSERT INTO `processes_aud`
VALUES (3, 1, 2, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20', 23, 0),
       (4, 2, 5, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20', 24, 0),
       (5, 2, 4, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20', 25, 0),
       (6, 3, 2, '1,0', 80, 'En Contacto', '2020-11-20', '2020-11-20', 26, 0),
       (7, 3, 4, '1,0', 30, 'En Contacto', '2020-11-20', '2020-11-20', 27, 0),
       (8, 4, 8, '1,0', 70, 'En Contacto', '2020-11-20', '2020-11-20', 28, 0),
       (9, 4, 8, '1,0', 30, 'En Contacto', '2020-11-20', '2020-11-20', 29, 0),
       (10, 5, 4, '1,0', 30, 'En Contacto', '2020-11-20', '2020-11-20', 30, 0),
       (11, 5, 10, '1,0', 90, 'En Contacto', '2020-11-20', '2020-11-20', 31, 0),
       (12, 6, 10, '1,0', 50, 'En Contacto', '2020-11-20', '2020-11-20', 32, 0),
       (13, 6, 8, '1,0', 70, 'En Contacto', '2020-11-20', '2020-11-20', 33, 0);