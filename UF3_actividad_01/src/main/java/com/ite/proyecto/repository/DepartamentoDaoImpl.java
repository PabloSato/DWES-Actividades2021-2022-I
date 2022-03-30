package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Departamento;
import com.ite.proyecto.beans.Empleado;

@Repository
public class DepartamentoDaoImpl implements IntDepartamentoDao {

	private List<Departamento> lista;

	public DepartamentoDaoImpl() {
		this.lista = new ArrayList<Departamento>();
		cargarDatos();
	}

	private void cargarDatos() {
		
		lista.add(new Departamento(100, "Calle Alba", "Recursos Humanos", null));
		lista.add(new Departamento(101, "Calle Alba", "Gestion", null));
		lista.add(new Departamento(102, "Calle Alba", "Operaciones", null));
		
	}

	@Override
	public List<Departamento> findAll() {
		return lista;
	}

	@Override
	public Departamento findById(int idDepar) {

		Departamento aux = new Departamento();
		aux.setIdDepar(idDepar);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
	}

	@Override
	public int altaDepartamento(Departamento depart) {

		if (lista.contains(depart))
			return 0;
		else
			return lista.add(depart) ? 1 : 0;
	}

	@Override
	public int bajaDepartamento(Departamento depart) {
		int pos = lista.indexOf(depart);
		if (pos == -1)
			return 0;
		else
			return lista.remove(depart) ? 1 : 0;
	}

	@Override
	public int editDepartamento(Departamento depart) {
		int pos = lista.indexOf(depart);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, depart) != null) ? 1 : 0;
	}

}
