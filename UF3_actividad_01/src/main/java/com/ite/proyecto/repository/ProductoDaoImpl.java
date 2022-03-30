package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Producto;

@Repository
public class ProductoDaoImpl implements IntProductoDao{
	
	private List<Producto> lista;
	
	public ProductoDaoImpl() {
		this.lista = new ArrayList<Producto>();
		cargarDatos();
	}

	private void cargarDatos() {
		
		lista.add(new Producto(1, "producto1", "producto1", 10, 100));
		lista.add(new Producto(2, "producto2", "producto2", 20, 100));
		lista.add(new Producto(3, "producto3", "producto3", 30, 100));
		lista.add(new Producto(4, "producto4", "producto4", 40, 100));
		lista.add(new Producto(5, "producto5", "producto5", 50, 100));
		lista.add(new Producto(6, "producto6", "producto6", 60, 100));
		lista.add(new Producto(7, "producto7", "producto7", 70, 100));
		lista.add(new Producto(8, "producto8", "producto8", 80, 100));
		lista.add(new Producto(9, "producto9", "producto9", 90, 100));
		lista.add(new Producto(10, "producto10", "producto10", 100, 100));
	}

	@Override
	public List<Producto> findAll() {
		return lista;
	}

	@Override
	public Producto findById(int idProducto) {
		Producto aux = new Producto();
		aux.setIdProducto(idProducto);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
	}

	@Override
	public int altaProducto(Producto producto) {
		if (lista.contains(producto))
			return 0;
		else
			return lista.add(producto) ? 1 : 0;
	}

	@Override
	public int bajaProducto(Producto producto) {
		int pos = lista.indexOf(producto);
		if (pos == -1)
			return 0;
		else
			return lista.remove(producto) ? 1 : 0;
	}

	@Override
	public int editProducto(Producto producto) {
		int pos = lista.indexOf(producto);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, producto) != null) ? 1 : 0;
	}

}
