package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Proyecto;
import com.ite.proyecto.beans.ProyectoConEmpleado;

@Repository
public class ProyectoConEmpleadoDaoImpl implements IntProyConEmpl {

	// PROPIEDADES
	private List<ProyectoConEmpleado> lista;

	// CONSTRUCTOR
	public ProyectoConEmpleadoDaoImpl() {
		this.lista = new ArrayList<ProyectoConEmpleado>();
		cargarDatos();
	}

	private void cargarDatos() {
		IntEmpleadoDao iemp = new EmpleadoDaoImpl();
		IntProyectoDao iproy = new ProyectoDaoImpl();

		Proyecto proy = iproy.findById("PY011");
		Empleado emp1 = iemp.findById(105);
		Empleado emp2 = iemp.findById(106);
		Empleado emp3 = iemp.findById(107);

		lista.add(new ProyectoConEmpleado(1, new Date(), 20, emp1, proy));
		lista.add(new ProyectoConEmpleado(2, new Date(), 50, emp2, proy));
		lista.add(new ProyectoConEmpleado(3, new Date(), 40, emp3, proy));
	}

	@Override
	public List<ProyectoConEmpleado> findAll() {

		return lista;
	}

	@Override
	public List<ProyectoConEmpleado> findByProyecto(Proyecto proyecto) {
		List<ProyectoConEmpleado> aux = new ArrayList<ProyectoConEmpleado>();
		int cantidad = 0;
		for (ProyectoConEmpleado ele : findAll()) {
			if (ele.getProyecto().equals(proyecto)) {
				aux.add(ele);
				cantidad++;
			}
		}
		return aux;
	}

	@Override
	public int addEmpleadoProy(Proyecto proyecto, Empleado empleado) {
		ProyectoConEmpleado pce = new ProyectoConEmpleado();
		pce.setEmpleado(empleado);
		pce.setProyecto(proyecto);
		return lista.add(pce) ? 1 : 0;
	}

	@Override
	public List<Empleado> findRestoEmpleados(Proyecto proyecto) {
		IntEmpleadoDao iemp = new EmpleadoDaoImpl();
		
		List<ProyectoConEmpleado> pce = findByProyecto(proyecto);
		List<Empleado> empleadosIn = new ArrayList<Empleado>(); 
		List<Empleado> restoEmpleados = new ArrayList<Empleado>();
		int cantidad = 0;
		//llenamos una lista con los empleados que SI que están
		for(ProyectoConEmpleado ele: pce) {
			empleadosIn.add(ele.getEmpleado());
			cantidad++;
		}
		//comprobams si la lista contiene algun empleado
		if(cantidad > 0) {
			//En ese caso, recorremos todos los operativos comparando con los q si q están
			for(Empleado ele: iemp.listaOperativos()) {
				if(!empleadosIn.contains(ele)) {
					restoEmpleados.add(ele);
				}
			}
		}else {//Si no, pasamos todos los empleados
			restoEmpleados = iemp.listaOperativos();
		}
		return restoEmpleados;
	}
	
	@Override
	public int nextNumOrden() {
		int nextNum = 0;
		for (ProyectoConEmpleado ele : findAll()) {
			nextNum = ele.getNumeroOrden();
			nextNum++;
		}
		return nextNum;
	}

	@Override
	public int addProyConEmpl(ProyectoConEmpleado proyectoConEmpleado) {
		if (lista.contains(proyectoConEmpleado))
			return 0;
		else
			return lista.add(proyectoConEmpleado) ? 1 : 0;
	}

	@Override
	public int delProyConEmpl(ProyectoConEmpleado proyectoConEmpleado) {
		int pos = lista.indexOf(proyectoConEmpleado);
		if (pos == -1)
			return 0;
		else
			return lista.remove(proyectoConEmpleado) ? 1 : 0;
	}

	@Override
	public ProyectoConEmpleado findByEmplYProy(Empleado empleado, Proyecto proyecto) {
		ProyectoConEmpleado aux = new ProyectoConEmpleado();
		int cantidad = 0;
		for (ProyectoConEmpleado ele : findAll()) {
			if (ele.getEmpleado().equals(empleado) && ele.getProyecto().equals(proyecto)) {
				aux = ele;
				cantidad++;
			}
		}
		if (cantidad < 1)
			return null;
		else
			return aux;
	}

}
