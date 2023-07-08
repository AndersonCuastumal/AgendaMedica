
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (1, 'Andres', 'Guzman', 'andres@email.com', '12345', '123553', 'cra 50', '2021-08-28', '2023-06-05', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (2, 'Juan', 'Perez', 'juan@example.com', 'abcde', '9876543', 'av. principal', '2022-01-15', '2023-05-25', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (3, 'María', 'López', 'maria@example.com', 'qwerty', '4567890', 'calle 123', '2022-03-10', '2023-06-01', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (4, 'Pedro', 'Ramírez', 'pedro@example.com', 'asdfg', '9876543', 'av. central', '2022-05-20', '2023-06-10', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (5, 'Ana', 'González', 'ana@example.com', 'zxcvb', '1234567', 'calle 456', '2022-07-05', '2023-06-15', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (6, 'Sofía', 'Torres', 'sofia@example.com', 'qazwsx', '3334445', 'avenida 50', '2022-06-18', '2023-06-18', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (7, 'Luis', 'Hernández', 'luis@example.com', 'plokmn', '9876543', 'calle principal', '2021-12-30', '2023-05-30', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (8, 'Carolina', 'García', 'carolina@example.com', 'yhnjmk', '1234567', 'av. 123', '2022-02-05', '2023-06-05', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (9, 'Roberto', 'Díaz', 'roberto@example.com', 'edcwsx', '9876543', 'calle 789', '2022-04-12', '2023-06-12', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (10, 'Laura', 'Martínez', 'laura@example.com', 'rfvtgb', '1234567', 'av. central', '2021-09-28', '2023-05-28', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (11, 'Diego', 'Rojas', 'diego@example.com', 'yhnujm', '9876543', 'calle 456', '2022-01-15', '2023-05-25', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (12, 'Fernanda', 'Sánchez', 'fernanda@example.com', 'iklopl', '1234567', 'calle 789', '2022-03-20', '2023-06-01', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (13, 'Ricardo', 'Gómez', 'ricardo@example.com', 'edcrfv', '9876543', 'av. principal', '2022-05-10', '2023-06-10', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (14, 'Paula', 'Herrera', 'paula@example.com', 'tgbnhy', '1234567', 'calle central', '2022-07-25', '2023-06-15', 'activo');
INSERT INTO pacientes (id, nombre, apellido, correo, contrasena, telefono, direccion, fecha_creacion, ultimo_inicio_sesion, estado) VALUES (15, 'Martín', 'Lara', 'martin@example.com', 'polkiu', '9876543', 'cra 123', '2022-06-08', '2023-06-08', 'activo');


INSERT INTO medicos (id, nombre, apellido, estado) VALUES (1, 'Martín', 'Iza', 'activo');
INSERT INTO medicos (id, nombre, apellido, estado) VALUES (2, 'Jose', 'Gomez', 'activo');
INSERT INTO medicos (id, nombre, apellido, estado) VALUES (3, 'Pedro', 'Narva', 'activo');


INSERT INTO usuarios (username,contrasena,estado) VALUES('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO usuarios (username,contrasena,estado) VALUES('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_USER');

INSERT INTO citas (id, paciente_id, medico_id, descripcion, hora_atencion, dia_atencion) VALUES (1, 1, 2, 'Cita general', '9:30', '2023-07-18');
INSERT INTO citas (id, paciente_id, medico_id, descripcion, hora_atencion, dia_atencion) VALUES (2, 2, 2, 'Cita general', '9:50', '2023-07-10');
INSERT INTO citas (id, paciente_id, medico_id, descripcion, hora_atencion, dia_atencion) VALUES (3, 3, 1, 'Cita general', '10:20', '2023-07-09');
