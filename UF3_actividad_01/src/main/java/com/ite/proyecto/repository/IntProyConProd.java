package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Producto;
import com.ite.proyecto.beans.Proyecto;
import com.ite.proyecto.beans.ProyectoConProducto;

public interface IntProyConProd {

	List<ProyectoConProducto> findAll();
	List<ProyectoConProducto> findByProyecto(Proyecto proyecto);
	List<Producto> findRestoProductos(Proyecto proyecto);
	int addProductoProy(Proyecto proyecto, Producto producto);
	int addProyConProdu(ProyectoConProducto prodConProducto);
	int delProyConProdu(ProyectoConProducto proyectoConProducto);
	ProyectoConProducto findByProdYProy(Producto producto, Proyecto proyecto);
	int nextNumOrden();
	
}
