package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Empleado;

public interface IntEmpleadoDao {
	
	List<Empleado> findAll();
	Empleado findById(int idEmpl);
	int altaEmpleado(Empleado empleado);
	int bajaEmpleado(Empleado empleado);
	int editEmpleado(Empleado empleado);
	Empleado login(int idEmpl, String correo, String password);
	List<Empleado> listaJefeProyecto();
	List<Empleado> listaOperativos();
}
