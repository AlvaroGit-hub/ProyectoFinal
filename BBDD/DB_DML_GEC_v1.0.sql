



-- ######################## CREAR LA BASE DE DATOS #######################

DROP DATABASE IF EXISTS empresa;
CREATE DATABASE empresa;
use empresa;

-- ######################## BORRADO DE TABLAS POR SI LA BBDD YA ESTA CREADA #######################

DROP TABLE IF EXISTS fichaje;
DROP TABLE IF EXISTS realizar;
DROP TABLE IF EXISTS tarea;
DROP TABLE IF EXISTS pieza;
DROP TABLE IF EXISTS empleado;

-- ######################## CREACION DE LAS TABLAS #######################

create table empleado(
	id_empleado int(4) primary key auto_increment,
 	nombre varchar(100) not null,
	apellidos varchar(100) not null,
	contraseña varchar(100) not null, 
	categoria varchar(9) not null,
	check(categoria='jefe' or categoria='encargado' or categoria='trabajador')
);

create table fichaje(
	id_fichaje int(10) primary key auto_increment,
	id_empleado int(4),
	f_entrada datetime default current_timestamp(),
	f_salida datetime,
	total_horas time,
	dentro boolean default true,
	foreign key (id_empleado) references empleado(id_empleado)
);

create table descanso(
	id_fichaje int(10) primary key,
	h_entrada time,
	h_salida time,
	dentro boolean DEFAULT TRUE,
	foreign key (id_fichaje) references fichaje(id_fichaje)
);

create table pieza(
	id_pieza varchar(20) primary key,
	nombre varchar(100) not null,
	stock int(20) default 0,
	precio dec(6,2) not null,
	descripcion varchar(5000)
);

create table tarea( 
	id_tarea int(4) primary key,
	id_pieza varchar(20) not null,
	cantidad_realizada int(6) default 0,
	cantidad_prevista int(6) not null,
	finalizado boolean default false,
	foreign key (id_pieza) references pieza(id_pieza)
);

create table realizar(
	id_tarea int(4) not null primary key,
	id_empleado int(4) not null,
	f_inicio datetime,
	f_final datetime,
	cantidad_realizada int(6),
	foreign key (id_tarea) references tarea(id_tarea),
	foreign key (id_empleado) references empleado(id_empleado),
	check (cantidad_realizada > 0)
);


-- ZONA DE PRUEBAS


insert into empleado 
	(nombre,apellidos,contraseña,categoria)
values
	('Jorge','Pardo Pacheco','12345','Jefe');
	
delete from empleado;

select * from empleado;



call insertar_fichaje(1); 

select * from fichaje;

select * from descanso;

delete from fichaje;
