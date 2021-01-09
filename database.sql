DROP DATABASE IF EXISTS ourhome;
CREATE DATABASE ourhome;
USE ourhome;

CREATE TABLE users
(
    user_id                INT                                          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                   VARCHAR(100)                                 NULL,
    surnames               VARCHAR(100)                                 NULL,
    company                VARCHAR(100)                                 NULL,
    direction              VARCHAR(100)                                 NULL,
    profile_picture        LONGBLOB                                     NULL,
    description            MEDIUMTEXT                                   NULL,
    birthdate              DATE                                         NULL,
    phone                  INT                                          NULL,
    email                  VARCHAR(100)                                 NOT NULL UNIQUE,
    password               VARCHAR(100)                                 NOT NULL,
    role                   ENUM ('search', 'have', 'business', 'admin') NOT NULL,
    default_test_responses MEDIUMTEXT                                   NULL,
    show_phone             BIT                                          NULL,
    remaining_publications INT                                          NULL,
    created_at             DATETIME                                     NOT NULL,
    updated_at             DATETIME                                     NULL
);

CREATE TABLE homes
(
    home_id         INT AUTO_INCREMENT PRIMARY KEY,
    user_id         INT          NOT NULL,
    photos          LONGBLOB     NULL,
    description     MEDIUMTEXT   NULL,
    price           DOUBLE       NOT NULL,
    num_bedrooms    INT          NOT NULL,
    num_bathrooms   INT          NOT NULL,
    direction       VARCHAR(100) NULL,
    meters          DECIMAL      NULL,
    floors          INT          NOT NULL,
    characteristics MEDIUMTEXT   NULL,
    active          BIT DEFAULT TRUE,
    created_at      DATETIME     NOT NULL,
    updated_at      DATETIME     NULL,
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
    created_at    DATETIME                                        NULL,
    updated_at    DATETIME                                        NULL,
    FOREIGN KEY (home_id) REFERENCES homes (home_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE custom_tests
(
    custom_test_id INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id        INT        NOT NULL,
    questions      MEDIUMTEXT NOT NULL,
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
    created_at      DATETIME   NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE tokens
(
    token_id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id    INT          NOT NULL,
    token      VARCHAR(255) NOT NULL,
    created_at DATETIME     NULL,
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
    surnames               VARCHAR(100)                                 NULL,
    company                VARCHAR(100)                                 NULL,
    direction              VARCHAR(100)                                 NULL,
    profile_picture        LONGBLOB                                     NULL,
    description            MEDIUMTEXT                                   NULL,
    birthdate              DATE                                         NULL,
    phone                  INT                                          NULL,
    email                  VARCHAR(100)                                 NULL,
    password               VARCHAR(100)                                 NULL,
    role                   ENUM ('search', 'have', 'business', 'admin') NULL,
    default_test_responses MEDIUMTEXT                                   NULL,
    show_phone             BIT                                          NULL,
    remaining_publications INT                                          NULL,
    created_at             DATETIME                                     NULL,
    updated_at             DATETIME                                     NULL,
    rev                    INT                                          NOT NULL,
    revtype                TINYINT                                      NOT NULL,
    PRIMARY KEY (user_id, rev),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

CREATE TABLE homes_aud
(
    home_id         INT          NOT NULL AUTO_INCREMENT,
    user_id         INT          NULL,
    photos          LONGBLOB     NULL,
    description     MEDIUMTEXT   NULL,
    price           DOUBLE       NULL,
    num_bedrooms    INT          NULL,
    num_bathrooms   INT          NULL,
    direction       VARCHAR(100) NULL,
    meters          DECIMAL      NULL,
    floors          INT          NULL,
    characteristics MEDIUMTEXT   NULL,
    active          BIT DEFAULT TRUE,
    created_at      DATETIME     NULL,
    updated_at      DATETIME     NULL,
    rev             INT          NOT NULL,
    revtype         TINYINT      NOT NULL,
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
    created_at    DATETIME                                        NULL,
    updated_at    DATETIME                                        NULL,
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
    created_at      DATETIME   NULL,
    rev             INT        NOT NULL,
    revtype         TINYINT    NOT NULL,
    PRIMARY KEY (notification_id, rev),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

CREATE TABLE tokens_aud
(
    token_id   INT          NOT NULL AUTO_INCREMENT,
    user_id    INT          NULL,
    token      VARCHAR(255) NULL,
    created_at DATETIME     NULL,
    rev        INT          NOT NULL,
    revtype    TINYINT      NOT NULL,
    PRIMARY KEY (token_id, rev),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (rev) REFERENCES revinfo (rev)
);