package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Proyecto;
import com.ite.proyecto.beans.ProyectoConEmpleado;

public interface IntProyConEmpl {
	
	List<ProyectoConEmpleado> findAll();
	List<ProyectoConEmpleado> findByProyecto(Proyecto proyecto);
	List<Empleado> findRestoEmpleados(Proyecto proyecto);
	int addEmpleadoProy(Proyecto proyecto, Empleado empleado);
	int addProyConEmpl(ProyectoConEmpleado proyectoConEmpleado);
	int delProyConEmpl(ProyectoConEmpleado proyectoConEmpleado);
	ProyectoConEmpleado findByEmplYProy(Empleado empleado, Proyecto proyecto);
	int nextNumOrden();

}
