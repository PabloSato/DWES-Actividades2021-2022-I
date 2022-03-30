package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Proyecto;

public interface IntProyectoDao {

	List<Proyecto> findAll();
	List<Proyecto> findActivos();
	List<Proyecto> findByJefe(Empleado empleado);
	Proyecto findById(String idProyecto);
	int altaProyecto(Proyecto proyecto);
	int bajaProyecto(Proyecto proyecto);
	int editProyecto(Proyecto proyecto);
}

