package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Producto;
import com.ite.proyecto.beans.Proyecto;
import com.ite.proyecto.beans.ProyectoConProducto;

@Repository
public class ProyectoConProductoDaoImpl implements IntProyConProd {

	// PROPIEDADES
	private List<ProyectoConProducto> lista;

	// CONSTRUCTOR
	public ProyectoConProductoDaoImpl() {
		this.lista = new ArrayList<ProyectoConProducto>();
		cargarDatos();
	}

	private void cargarDatos() {
		IntProductoDao iprod = new ProductoDaoImpl();
		IntProyectoDao iproy = new ProyectoDaoImpl();

		Proyecto proy = iproy.findById("PY011");
		Producto prod1 = iprod.findById(1);
		Producto prod2 = iprod.findById(2);
		Producto prod3 = iprod.findById(3);
		Producto prod4 = iprod.findById(4);
		Producto prod5 = iprod.findById(5);

		lista.add(new ProyectoConProducto(1, 10, 20, prod1, proy));
		lista.add(new ProyectoConProducto(2, 15, 10, prod2, proy));
		lista.add(new ProyectoConProducto(3, 20, 15, prod3, proy));
		lista.add(new ProyectoConProducto(4, 25, 25, prod4, proy));
		lista.add(new ProyectoConProducto(5, 30, 40, prod5, proy));

	}

	@Override
	public List<ProyectoConProducto> findAll() {
		return lista;
	}

	@Override
	public List<ProyectoConProducto> findByProyecto(Proyecto proyecto) {
		List<ProyectoConProducto> pcp = new ArrayList<ProyectoConProducto>();
		int cantidad = 0;
		for (ProyectoConProducto ele : findAll()) {
			if (ele.getProyecto().equals(proyecto)) {
				pcp.add(ele);
				cantidad++;
			}
		}
		return pcp;
	}

	@Override
	public int addProductoProy(Proyecto proyecto, Producto producto) {
		ProyectoConProducto pcp = new ProyectoConProducto();
		pcp.setProducto(producto);
		pcp.setProyecto(proyecto);
		return lista.add(pcp) ? 1 : 0;
	}

	@Override
	public int addProyConProdu(ProyectoConProducto prodConProducto) {
		if (lista.contains(prodConProducto))
			return 0;
		else
			return lista.add(prodConProducto) ? 1 : 0;
	}

	@Override
	public int delProyConProdu(ProyectoConProducto proyectoConProducto) {
		int pos = lista.indexOf(proyectoConProducto);
		if (pos == -1)
			return 0;
		else
			return lista.remove(proyectoConProducto) ? 1 : 0;
	}

	@Override
	public ProyectoConProducto findByProdYProy(Producto producto, Proyecto proyecto) {
		ProyectoConProducto pcp = new ProyectoConProducto();
		int cantidad = 0;
		for (ProyectoConProducto ele : findAll()) {
			if (ele.getProducto().equals(producto) && ele.getProyecto().equals(proyecto)) {
				pcp = ele;
				cantidad++;
			}
		}
		if (cantidad < 1)
			return null;
		else
			return pcp;
	}

	@Override
	public int nextNumOrden() {
		int nextNum = 0;
		for (ProyectoConProducto ele : findAll()) {
			nextNum = ele.getNumeroOrden();
			nextNum++;
		}
		return nextNum;
	}

	@Override
	public List<Producto> findRestoProductos(Proyecto proyecto) {
		IntProductoDao iprod = new ProductoDaoImpl();

		List<ProyectoConProducto> pcp = findByProyecto(proyecto);
		List<Producto> productosIn = new ArrayList<Producto>();
		List<Producto> restoProd = new ArrayList<Producto>();
		int cantidad = 0;

		for (ProyectoConProducto ele : pcp) {
			productosIn.add(ele.getProducto());
			cantidad++;
		}
		if(cantidad >0){
			for(Producto ele: iprod.findAll()) {
				if(!productosIn.contains(ele)) {
					restoProd.add(ele);
				}
			}
		}else{
			restoProd = iprod.findAll();
		}
		return restoProd;
	}
}
