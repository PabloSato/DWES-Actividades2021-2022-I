package com.ite.proyecto.repository;

import java.util.List;

import com.ite.proyecto.beans.Factura;

public interface IntFacturaDao {
	
	List<Factura> findAll();
	Factura findById(String idFactura);
	int altaFactura(Factura factura);
	int bajaFactura(Factura factura);
	int editFactura(Factura factura);
}
