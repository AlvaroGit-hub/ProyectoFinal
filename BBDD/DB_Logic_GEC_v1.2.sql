
--                                   ######################## TRIGGERS #######################
-- ######################## Trigger para actualizar el tiempo de los descansos en la tabla fichajes #######################
create TRIGGER act_descanso_au 
after update ON descanso
FOR EACH ROW
begin
	declare tiempo_desc time;
	declare id_desc int;
	if ((select h_salida from descanso where id_descanso = new.id_descanso)= null)
	then
		select id_descanso into id_desc from descanso;
	else 
		select timediff(time(h_salida),time(h_entrada)) into tiempo_desc from descanso where old.id_descanso = new.id_descanso order by h_entrada desc limit 1;
		select id_descanso into id_desc	from descanso where old.id_descanso = new.id_descanso order by h_entrada desc limit 1;
	
		update fichaje 
		set fichaje.total_descanso = tiempo_desc
		where fichaje.id_fichaje = id_desc and fichaje.total_descanso is null;
	end if;
END;

-- ########################  trigger que da por completada una tarea cuando se alcanzan las piezas previstas  #######################
create trigger fin_tarea_au
after update on realizar
for each row 
begin 

	update tarea 
	set finalizado = 1
	where cantidad_realizada >= cantidad_prevista; 

end;

-- ########################  trigger que actualiza el stock de una pieza y llama a un procedimiento que  #######################
-- ########################         actualiza la cantidad de producto realizado de una tarea			 #######################
CREATE trigger actualizar_stock_au
after update on realizar
for each ROW 
begin 
	update pieza 
	set stock = (stock + new.cantidad_realizada)
	where id_pieza = (select id_pieza from tarea inner join realizar where realizar.id_tarea=tarea.id_tarea order by f_inicio desc limit 1);
	
	
	update tarea 
	set cantidad_realizada=(cantidad_realizada+new.cantidad_realizada)
	where tarea.id_tarea = new.id_tarea;

	
	
end;









--                ######################## PROCEDIMIENTOS #######################

-- ######################## Procedimiento para el control de los fichajes #######################
create procedure insertar_fichaje(in id_emp int(4))
begin
	declare trabajando tinyint;
	declare z int;
	declare duracion time;
	declare descansando tinyint;
	select dentro into trabajando from fichaje where id_empleado = id_emp order by f_entrada desc limit 1;
	select id_fichaje into z from fichaje where id_empleado = id_emp order by f_entrada desc limit 1;

	if trabajando = 1
	then	
		select timediff(time(current_timestamp()),time(f_entrada)) into duracion from fichaje where id_empleado = id_emp order by f_entrada desc limit 1;
	
		if duracion >= '08:00:00'
		then
			update fichaje
			set f_salida = current_timestamp(), dentro = false, total_horas = timediff(time(f_salida),time(f_entrada)) 
			where id_fichaje = z;
		else
			call intro_descanso(z);
		end if;
	else
	
		insert into fichaje
			(id_empleado)
		values
			(id_emp);
	end if;
end;



-- ######################## Procedimiento para insertar los descansos #######################
create procedure intro_descanso(in id_fich int(4))
begin 
	declare descansando tinyint;
	declare z int;
	select id_descanso into z from descanso where id_descanso = id_fich;
	select dentro into descansando from descanso where id_descanso=z;
	
		if z is not null
		then
			update descanso
			set h_salida = time(current_timestamp()), dentro = false, total_horas = timediff(time(h_salida),time(h_entrada))
			where id_descanso=z;
		else
			insert into descanso 
				(id_descanso, h_entrada)
			values
				(id_fich, current_timestamp());
		end if;
end;



-- ######################## Preocedimiento para iniciar tareas #######################
create procedure iniciar_tarea(in tarea int(4), in emp int(4))
begin
	if((select finalizado from tarea where id_tarea=tarea) = 0)
	then
		insert into realizar
			(id_tarea,id_empleado)
		values
			(tarea, emp);
	end if;
end



-- ########################  procedimiento para finalizar una tarea  #######################
create procedure fin_tarea(in emp int(4), in cantidad int(6))
begin
		update realizar 
		set realizar.cantidad_realizada = cantidad, realizar.f_final = current_timestamp()
		where realizar.id_empleado=emp and realizar.f_final is null;
end



-- ########################  procedimiento para crear nueva tarea  #######################
create procedure nueva_tarea(in pieza int(4), in cant_necesaria int(6))
begin
	insert into tarea 
		(id_pieza, cantidad_prevista)
	values
		(pieza,cant_necesaria);
end



-- ########################  procedimiento para crear una nueva pieza  #######################
create procedure nueva_pieza(in nom varchar(100), in prec dec(6,2), in descr varchar(5000))
begin
	insert into pieza 
		(nombre, precio, descripcion)
	values
		(nom,prec,descr);
end



-- ########################  procedimiento que actualiza la cantidad realizada de una tarea ##
CREATE PROCEDURE act_cantidadrealizada_tarea(in id int(4), in cant int(10))
begin
	update tarea 
	set cantidad_realizada=(cantidad_realizada+cant)
	where tarea.id_tarea = id;
end

-- ########################  procedimiento para crear una nueva pieza  #######################
create procedure nuevo_empleado(in nom varchar(100),in ape varchar(100), in contra varchar(100),in cat varchar(10))
begin
	insert into empleado 
		(nombre,apellidos,contrasena,categoria)
	values
		(nom,ape,contra,cat);
end


-- ########################  procedimiento para realizar el join de dos tablas  #######################
-- ########################              REQUISITO DEL PROYECTO             #######################
create procedure produccion_usuario(in n_empleado int(4))
begin
	select empleado.id_empleado as ID, empleado.nombre as Nombre, apellidos as Apellidos, 
		id_tarea as Tarea, cantidad_realizada as Realizadas, pieza.nombre as Pieza,
		f_inicio as Fecha
	from realizar
	inner join empleado, pieza
	where empleado.id_empleado = n_empleado and empleado.id_empleado = realizar.id_empleado
	order by f_inicio desc limit 15; 
end;



-- ########################  procedimiento para realizar el join de dos tablas  #######################
-- ########################              REQUISITO DEL PROYECTO             #######################
create procedure piezas_usuario_fechas(in id_emp int(4),in desde date)
begin
	select empleado.id_empleado as 'Numero de presonal', concat(empleado.nombre,' ',empleado.apellidos) as Nombre,
		tarea.id_pieza as 'ID de Pieza',pieza.nombre as Pieza,
		sum(realizar.cantidad_realizada) as total, date(realizar.f_inicio) as fecha
	from realizar
	left join empleado
	on empleado.id_empleado = realizar.id_empleado
	left join tarea
	on tarea.id_tarea = realizar.id_tarea
	left join pieza
	on pieza.id_pieza = tarea.id_pieza
	where date(realizar.f_inicio) between date(desde) and date(curdate()) 
	and empleado.id_empleado = id_emp
	group by tarea.id_pieza;
end;






--                ######################## FUNCIONES #######################

-- ########################  funcion para ver la produccion de un trabajador  #######################
-- ########################         en un rango de fechas determinado         #######################
-- ########################              REQUISITO DEL PROYECTO               #######################
create function produccion_entre_fechas(f_inicio date, f_fin date, id int(4))
returns int(10)
begin 
	declare total int(10);
	select sum(realizar.cantidad_realizada) into total from realizar
	where id_empleado = id and 
	date(realizar.f_inicio) between date(f_inicio) and date(f_fin);
	return total;
end;




create function login_usuario(nombre_user varchar(30), contraseña_user varchar(30))
returns tinyint 
begin
	declare login tinyint;
	declare n varchar(50);
	declare c varchar(50);
	
	set n = (select nombre from empleado where nombre = nombre_user and contrasena=contrasena_user);
	set c = (select contrasena from empleado where contrasena=contrasena_user and nombre=nombre_user);
	
	if 	(n is null)and(c is null) then 
		set login=0;
	else
		set login=1;
	end if;


	return login;
end;
