package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Factura;

@Repository
public class FacturaDaoImpl implements IntFacturaDao{

	private List<Factura> lista;
	
	public FacturaDaoImpl() {
		this.lista = new ArrayList<Factura>();
	}

	@Override
	public List<Factura> findAll() {
		return lista;
	}

	@Override
	public Factura findById(String idFactura) {
		Factura aux = new Factura();
		aux.setIdFactura(idFactura);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
	}

	@Override
	public int altaFactura(Factura factura) {
		if (lista.contains(factura))
			return 0;
		else
			return lista.add(factura) ? 1 : 0;
	}

	@Override
	public int bajaFactura(Factura factura) {
		int pos = lista.indexOf(factura);
		if (pos == -1)
			return 0;
		else
			return lista.remove(factura) ? 1 : 0;
	}

	@Override
	public int editFactura(Factura factura) {
		int pos = lista.indexOf(factura);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, factura) != null) ? 1 : 0;
	}
}
