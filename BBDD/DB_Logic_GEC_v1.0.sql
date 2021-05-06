
-- ######################## Procedimiento para el control de los fichajes #######################

create procedure insertar_fichaje(in id_emp int(4))
begin
	select dentro into @x from fichaje where id_empleado = id_emp order by f_entrada desc limit 1;
	select id_fichaje into @z from fichaje where id_empleado = id_emp order by f_entrada desc limit 1;
	if @x = true
	then
	
		update fichaje
		set f_salida = current_timestamp(), dentro = false, total_horas = timediff(time(f_salida),time(f_entrada)) 
		where id_fichaje = @z; 
		
		select total_horas into @h from fichaje where id_fichaje = @z;
		if @h < '07:00:00'
		then
			insert into descanso 
				(id_fichaje)
			values
				(@z);
		end if;
	
	else
	
		insert into fichaje
			(id_empleado)
		values
			(id_emp);
		
		select dentro into @h from descanso where descanso.id_fichaje=@z;
	
		if @h = true
		then
		
			update descanso
			set h_salida = time(current_timestamp()), dentro = false
			where descanso.id_fichaje=@z;
		
		end if;
	
	end if;
end;


-- ######################## Trigger para el control de los descansos #######################


create TRIGGER descanso_bi 
BEFORE INSERT ON descanso
FOR EACH ROW
begin
	select total_horas into @h from fichaje where new.id_fichaje = (select id_fichaje from fichaje where new.id_fichaje=id_fichaje);
	IF @h < '07:00:00'
		THEN
			SET new.h_entrada = time(current_timestamp());
		END IF;
END;

