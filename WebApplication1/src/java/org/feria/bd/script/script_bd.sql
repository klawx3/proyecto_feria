CREATE DATABASE bd_feria;
USE bd_feria;

CREATE TABLE tipo(
	id_tipo INT AUTO_INCREMENT,
	descripcion_tipo VARCHAR(100),
    PRIMARY KEY(id_tipo)
);

CREATE TABLE sensor(
	id_sensor INT AUTO_INCREMENT,
    pin_sensor INT,
    nombre_sensor VARCHAR(100),
    fk_tipo_id INT,
    descripcion VARCHAR(100),
    FOREIGN KEY(fk_tipo_id) REFERENCES tipo(id_tipo),
    PRIMARY KEY(id_sensor)
);

CREATE TABLE actuador(
	id_actuador INT AUTO_INCREMENT,
    pin_actuador INT,
    nombre_actuador VARCHAR(100),
    fk_tipo_id INT,
    descripcion_actuador VARCHAR(100),
    FOREIGN KEY(fk_tipo_id) REFERENCES tipo(id_tipo),
    PRIMARY KEY(id_actuador)
);

CREATE TABLE usuario(
	email_usuario VARCHAR(100),
    password_usuario VARCHAR(80),
	PRIMARY KEY(email_usuario)
);

CREATE TABLE historial_sensor(
	id_historial INT AUTO_INCREMENT,
    fk_sensor INT,
    fecha_historial DATE,
    valor_historial INT,
    FOREIGN KEY(fk_sensor) REFERENCES sensor(id_sensor),
    PRIMARY KEY(id_historial)
);

CREATE TABLE historial_actuador(
	id_historial INT AUTO_INCREMENT,
    fk_actuador INT,
    fecha_historial DATE,
    valor_historial INT,
    fk_usuario VARCHAR(100),
    FOREIGN KEY(fk_actuador) REFERENCES actuador(id_actuador),
    FOREIGN KEY(fk_usuario) REFERENCES usuario(email_usuario),
    PRIMARY KEY(id_historial)
);