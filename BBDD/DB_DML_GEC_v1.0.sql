



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
	total_descanso time,
	dentro boolean default true,
	foreign key (id_empleado) references empleado(id_empleado)
);

create table descanso(
	id_descanso int(10) primary key,
	h_entrada datetime default current_timestamp(),
	h_salida datetime,
	total_horas time,
	dentro boolean DEFAULT TRUE,
	foreign key (id_descanso) references fichaje(id_fichaje)
);

create table pieza(
	id_pieza int(4) primary key auto_increment,
	nombre varchar(100) not null,
	stock int(20) default 0,
	precio dec(6,2) not null,
	descripcion varchar(5000)
);

create table tarea( 
	id_tarea int(4) primary key auto_increment,
	id_pieza int(4) not null,
	cantidad_realizada int(6) default 0,
	cantidad_prevista int(6) not null,
	finalizado boolean default false,
	foreign key (id_pieza) references pieza(id_pieza)
);

create table realizar(
	id_tarea int(4) not null,
	id_empleado int(4) not null,
	f_inicio datetime default current_timestamp(),
	f_final datetime,
	cantidad_realizada int(6),
	primary key(id_tarea,id_empleado,f_inicio),
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


call nueva_pieza('tuerca',2.1,'tuerca de 1 cm de largo'); 

select * from pieza;

call nueva_tarea(1, 1000); 

select * from tarea;

call iniciar_tarea(1, 1);

select * from realizar;

call fin_tarea(1, 500);

