-- BASE DE DATOS PARA EL PROYECTO GRUPAL

use empresa;

use empresa;

drop table empleados;
drop table fichajes;
drop table piezas;
drop table tareas;

create table empleados(
	id int(4) primary key auto_increment,
 	nombre varchar(100) not null,
	apellidos varchar(100) not null,
	contraseña varchar(100) not null, 
	rango int(2)
);

create table fichajes(
	id int(7) primary key auto_increment,
	id_empleado int(4),
	f_entrada datetime,
	f_salida datetime,
	foreign key (id_empleado) references empleados(id)
);

create table piezas(
	id_pieza varchar(20) primary key,
	nombre varchar(100) not null,
	stock int(20) default 0,
	precio dec(6,2) not null,
	descripcion varchar(5000)
);

create table tareas( 
	id_tarea int(4) unique,
	id_usuario int(4),
	id_pieza varchar(20),
	h_inicio time,
	h_fin time,
	cantidad_pieza int(6),
	cantidad_esperada int(6),
	foreign key (id_usuario) references empleados(id),
	foreign key (id_pieza) references piezas(id_pieza),
	primary key (id_usuario, id_pieza)
);

desc tareas

select datediff(f_salida ,f_entrada) from fichajes where id_empleado =1; 