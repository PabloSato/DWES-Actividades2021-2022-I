package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Departamento;

public interface IntDepartamentoDao {

	List<Departamento> findAll();
	Departamento findById(int idDepar);
	int altaDepartamento(Departamento depart);
	int bajaDepartamento(Departamento depart);
	int editDepartamento(Departamento depart);

}
