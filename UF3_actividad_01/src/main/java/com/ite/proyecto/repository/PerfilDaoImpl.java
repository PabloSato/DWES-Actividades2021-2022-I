package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Perfil;

@Repository
public class PerfilDaoImpl implements IntPerfilDao{
	
	private List<Perfil> lista;
	
	public PerfilDaoImpl() {
		this.lista = new ArrayList<Perfil>();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Perfil(1, "Control de Gestión"));
		lista.add(new Perfil(2, "Jefe de Proyecto"));
		lista.add(new Perfil(3, "Operativo"));
		lista.add(new Perfil(4, "Recursos Humanos"));
		
	}

	@Override
	public List<Perfil> findAll() {
		return lista;
	}

	@Override
	public Perfil findById(int idPerfil) {
		Perfil aux = new Perfil();
		aux.setIdPerfil(idPerfil);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
	}

	@Override
	public int altaPerfile(Perfil perfil) {
		if (lista.contains(perfil))
			return 0;
		else
			return lista.add(perfil) ? 1 : 0;
	}

	@Override
	public int bajaPerfile(Perfil perfil) {
		int pos = lista.indexOf(perfil);
		if (pos == -1)
			return 0;
		else
			return lista.remove(perfil) ? 1 : 0;
	}

	@Override
	public int editPerfile(Perfil perfil) {
		int pos = lista.indexOf(perfil);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, perfil) != null) ? 1 : 0;
	}

}
