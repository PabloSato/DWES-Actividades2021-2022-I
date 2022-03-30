package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Cliente;

public interface IntClienteDao {
	
	List<Cliente> findAll();
	Cliente findByCif(String cif);
	int altaCliente(Cliente cliente);
	int bajaCliente(Cliente cliente);
	int editCliente(Cliente cliente);

}
