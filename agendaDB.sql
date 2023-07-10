CREATE DATABASE db_agendamedica;

USE db_agendamedica;

CREATE TABLE pacientes (
  id INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  correo VARCHAR(50),
  contrasena VARCHAR(50),
  telefono VARCHAR(15),
  direccion VARCHAR(100),
  fecha_creacion DATE,
  ultimo_inicio_sesion DATE,
  estado BOOLEAN
);

CREATE TABLE medicos (
  id INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  estado BOOLEAN
);

CREATE TABLE horarios (
  id INT PRIMARY KEY,
  hora TIME
);

CREATE TABLE citas (
  id INT PRIMARY KEY,
  paciente_id INT,
  medico_id INT,
  descripcion VARCHAR(100),
  fecha_cita DATE,
  hora_cita TIME,
  FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
  FOREIGN KEY (medico_id) REFERENCES medicos(id)
);

CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  correo VARCHAR(50),
  contrasena VARCHAR(100),
  estado BOOLEAN
);

CREATE TABLE authorities (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  authority VARCHAR(50),
  FOREIGN KEY (user_id) REFERENCES usuarios(id)
);

INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (1, 'Andres', 'Guzman', 'andres@email.com', '12345', '123553', 'cra 50', '2021-08-28', '2023-06-05', true);
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (2, 'Juan', 'Perez', 'juan@example.com', 'abcde', '9876543', 'av. principal', '2022-01-15', '2023-05-25', true);
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (3, 'María', 'López', 'maria@example.com', 'qwerty', '4567890', 'calle 123', '2022-03-10', '2023-06-01', true);
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (4, 'Pedro', 'Ramírez', 'pedro@example.com', 'asdfg', '9876543', 'av. central', '2022-05-20', '2023-06-10', false);
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (5, 'Ana', 'González', 'ana@example.com', 'zxcvb', '1234567', 'calle 456', '2022-07-05', '2023-06-15', true);
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (6, 'Sofía', 'Torres', 'sofia@example.com', 'qazwsx', '3334445', 'avenida 50', '2022-06-18', '2023-06-18', false);
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (7, 'Luis', 'Hernández', 'luis@example.com', 'plokmn', '9876543', 'calle principal', '2021-12-30', '2023-05-30', true);



INSERT INTO medicos (id, nombre, apellido, estado) VALUES (1, 'Martín', 'Iza', true);
INSERT INTO medicos (id, nombre, apellido, estado) VALUES (2, 'Jose', 'Gomez', true);
INSERT INTO medicos (id, nombre, apellido, estado) VALUES (3, 'Pedro', 'Narva', false);

INSERT INTO horarios (id, hora) VALUES(1,'8:20');
INSERT INTO horarios (id, hora) VALUES(2,'8:40');
INSERT INTO horarios (id, hora) VALUES(3,'9:00');
INSERT INTO horarios (id, hora) VALUES(4,'9:20');
INSERT INTO horarios (id, hora) VALUES(5,'9:40');



INSERT INTO citas (id, paciente_id, medico_id, descripcion, fecha_cita,hora_cita) VALUES (1, 1, 2, 'Cita general','2023-07-18', '8:30');
INSERT INTO citas (id, paciente_id, medico_id, descripcion, fecha_cita,hora_cita) VALUES (2, 2, 2, 'Cita general', '2023-07-10', '9:50');
INSERT INTO citas (id, paciente_id, medico_id, descripcion, fecha_cita,hora_cita) VALUES (3, 3, 1, 'Cita general', '2023-07-09', '10:20');


INSERT INTO usuarios (correo,contrasena,estado) VALUES('andres@email.com','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO usuarios (correo,contrasena,estado) VALUES('admin@admin.com','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_USER');