package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Cliente;
import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Proyecto;

@Repository
public class ProyectoDaoImpl implements IntProyectoDao {

	private List<Proyecto> lista;

	public ProyectoDaoImpl() {
		this.lista = new ArrayList<Proyecto>();
		cargarDatos();
	}

	private void cargarDatos() {
		IntClienteDao icli = new ClienteDaoImpl();
		Cliente cli1 = icli.findByCif("10A");
		Cliente cli2 = icli.findByCif("11A");
		Cliente cli3 = icli.findByCif("12A");
		
		IntEmpleadoDao iemp = new EmpleadoDaoImpl();
		Empleado emp = iemp.findById(101);
		Empleado emp1 = iemp.findById(103);
		Empleado emp2 = iemp.findById(104);
		
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.MONTH, 12);
		cl.set(Calendar.DAY_OF_MONTH, 15);
		cl.set(Calendar.YEAR, 2022);
		Date date2 = cl.getTime();
		
		Calendar cl1 = Calendar.getInstance();
		cl.set(Calendar.MONTH, 10);
		cl.set(Calendar.DAY_OF_MONTH, 15);
		cl.set(Calendar.YEAR, 2023);
		Date date1 = cl1.getTime();
		
		lista.add(new Proyecto("PY010", 500, "poyecto1", "activo", date1, date2, 700, cli1, emp));
		lista.add(new Proyecto("PY011", 100, "poyecto2", "activo", date1, date2, 300, cli2, emp1));
		lista.add(new Proyecto("PY012", 1000, "poyecto3", "activo", date1, date2, 1300, cli3, emp1));
		lista.add(new Proyecto("PY013", 2000, "poyecto4", "activo", date1, date2, 2300, cli3, emp1));
		lista.add(new Proyecto("PY014", 3000, "poyecto5", "activo", date1, date2, 3300, cli3, emp1));
		lista.add(new Proyecto("PY015", 1000, "poyecto6", "activo", date1, date2, 1300, cli3, emp1));
		lista.add(new Proyecto("PY016", 2000, "poyecto7", "activo", date1, date2, 2300, cli3, emp1));
		lista.add(new Proyecto("PY017", 3000, "poyecto8", "activo", date1, date2, 3300, cli3, emp1));
		
	}

	@Override
	public List<Proyecto> findActivos() {
		List<Proyecto> listaActivos = new ArrayList<Proyecto>();
		int cantidad = 0;
		for(Proyecto ele: findAll()) {
			if(ele.getEstado().equals("activo")) {
				listaActivos.add(ele);
				cantidad++;
			}
		}
		if(cantidad > 0)
			return listaActivos;
		else
			return null;
	}

	@Override
	public List<Proyecto> findAll() {
		return lista;
	}

	@Override
	public Proyecto findById(String idProyecto) {
		Proyecto aux = new Proyecto();
		aux.setIdProyecto(idProyecto);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
	}

	@Override
	public int altaProyecto(Proyecto proyecto) {
		if (lista.contains(proyecto))
			return 0;
		else
			return lista.add(proyecto) ? 1 : 0;
	}

	@Override
	public int bajaProyecto(Proyecto proyecto) {
		int pos = lista.indexOf(proyecto);
		if (pos == -1)
			return 0;
		else
			return lista.remove(proyecto) ? 1 : 0;
	}

	@Override
	public int editProyecto(Proyecto proyecto) {
		int pos = lista.indexOf(proyecto);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, proyecto) != null) ? 1 : 0;
	}

	@Override
	public List<Proyecto> findByJefe(Empleado empleado) {
		List<Proyecto> listaJefe = new ArrayList<Proyecto>();
		int cantidad = 0;
		for(Proyecto ele: findActivos()) {
			if(ele.getJefeProyecto().equals(empleado)) {
				listaJefe.add(ele);
				cantidad++;
			}
		}
		
		if(cantidad>0)
			return listaJefe;
		else		
			return null;
	}

}
