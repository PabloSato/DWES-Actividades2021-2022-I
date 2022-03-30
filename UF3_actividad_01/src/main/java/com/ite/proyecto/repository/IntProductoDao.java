package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Producto;

public interface IntProductoDao {

	List<Producto> findAll();
	Producto findById(int idProducto);
	int altaProducto(Producto producto);
	int bajaProducto(Producto producto);
	int editProducto(Producto producto);
}
