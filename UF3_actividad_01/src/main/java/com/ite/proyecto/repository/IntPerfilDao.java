package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Perfil;

public interface IntPerfilDao {

	List<Perfil> findAll();
	Perfil findById(int idPerfil);
	int altaPerfile(Perfil perfil);
	int bajaPerfile(Perfil perfil);
	int editPerfile(Perfil perfil);

}
