
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



-- ######################## Trigger para actualizar el tiempo de los descansos en la tabla fichajes #######################



create TRIGGER act_descanso_au 
after update ON descanso
FOR EACH ROW
begin
	declare tiempo_desc time;
	declare id_desc int;
	select timediff(time(h_salida),time(h_entrada)) into tiempo_desc from descanso where old.id_descanso = new.id_descanso;
	select id_descanso into id_desc	from descanso where old.id_descanso = new.id_descanso;

	update fichaje 
	set total_descanso = tiempo_desc
	where id_fichaje = id_desc;
END;



-- ######################## Preocedimiento para insertar los descansos #######################



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
	insert into realizar
		(id_tarea,id_empleado)
	values
		(tarea, emp);
end



-- ########################  procedimiento para finalizar una tarea  #######################



create procedure fin_tarea(in emp int(4), in cantidad int(6))
begin
	update realizar 
	set cantidad_realizada = cantidad, f_final = current_timestamp()
	where id_empleado = emp;
end



-- ######################## tirgger que aztualiza la cantidad que se ha realizado de una tarea  #######################



create trigger set_cant_real_au
after update on realizar
for each row 
begin 
	declare cant int(10);
	declare id int(4);
	select cantidad_realizada into cant from realizar where id_tarea=new.id_tarea order by f_inicio desc limit 1;
	select id_pieza into id from tarea where id_tarea=(select id_tarea from realizar where new.id_tarea order by f_inicio desc limit 1);

	update tarea 
	set cantidad_realizada = cantidad_realizada + cant
	where tarea.id_tarea = id;

	update pieza 
	set stock = stock+cant
	where pieza.id_pieza = id;
end;



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



-- ########################  trigger que actualiza el stock  #######################


