package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Cliente;

@Repository
public class ClienteDaoImpl implements IntClienteDao {

	private List<Cliente> lista;

	public ClienteDaoImpl() {
		this.lista = new ArrayList<Cliente>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		lista.add(new Cliente("10A", "Calle 1", 10000.10, "Apple", 10));
		lista.add(new Cliente("11A", "Calle 2", 20000.10, "Microsoft", 15));
		lista.add(new Cliente("12A", "Calle 3", 30000.10, "Google", 20));
		lista.add(new Cliente("13A", "Calle 4", 40000.10, "Telefónica", 5));		
	}

	@Override
	public List<Cliente> findAll() {

		return lista;
	}

	@Override
	public Cliente findByCif(String cif) {
		Cliente aux = new Cliente();
		aux.setCif(cif);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}

	}

	@Override
	public int altaCliente(Cliente cliente) {
		if (lista.contains(cliente))
			return 0;
		else
			return lista.add(cliente) ? 1 : 0;
	}

	@Override
	public int bajaCliente(Cliente cliente) {
		int pos = lista.indexOf(cliente);
		if (pos == -1)
			return 0;
		else
			return lista.remove(cliente) ? 1 : 0;
	}

	@Override
	public int editCliente(Cliente cliente) {
		int pos = lista.indexOf(cliente);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, cliente) != null) ? 1 : 0;
	}

}
