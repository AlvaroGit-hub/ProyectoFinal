-- ZONA DE PRUEBAS

-- metodo para crear usuarios
-- nuevo_empleado(nombre,apellidos,contrasena,categoria(jefe,encargado o trabajador)
call nuevo_empleado ('Luis','Sañudo Perez','123456','encargado');

select * from empleado;


-- llamada al metodo para fichar
-- call insertar_fichaje(id_empleado); 
call insertar_fichaje(1); 

select * from fichaje;

select * from descanso;

-- llamada al metodo para crear nuevas piezas
-- call nueva_pieza('nombre_pieza',precio,'descripcion');
call nueva_pieza('Hembrilla',0.32,'Hembrilla abierta 20x90mm'); 

select * from pieza;


-- llamada al procedimiento para crear tareas
-- call nueva_tarea(id_pieza, cantidad_deseada);
call nueva_tarea(6, 900); 

select * from tarea;

-- llamada al procedimiento para iniciar las tareas
-- call iniciar_tarea(id_tarea, id_empleado);
call iniciar_tarea(3, 9);

select * from realizar;

-- llamada al procedimiento para finalizar las tareas
-- call fin_tarea(id_empleado, cantidad_realizada);
call fin_tarea(9, 1235);


call piezas_usuario_fechas (1, '2021-05-01');



