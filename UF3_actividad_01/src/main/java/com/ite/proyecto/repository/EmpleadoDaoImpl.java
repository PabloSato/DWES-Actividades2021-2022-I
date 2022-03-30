package com.ite.proyecto.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyecto.beans.Departamento;
import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Perfil;

@Repository
public class EmpleadoDaoImpl implements IntEmpleadoDao {

	private List<Empleado> lista;

	public EmpleadoDaoImpl() {
		this.lista = new ArrayList<Empleado>();
		cargarDatos();
	}

	private void cargarDatos() {

		IntPerfilDao iper = new PerfilDaoImpl();
		IntDepartamentoDao idep = new DepartamentoDaoImpl();

		Departamento dep1 = idep.findById(100);
		Departamento dep2 = idep.findById(101);
		Departamento dep3 = idep.findById(102);

		Perfil contGes = iper.findById(1);
		Perfil jefProy = iper.findById(2);
		Perfil operativo = iper.findById(3);
		Perfil rrHh = iper.findById(4);

		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.MONTH, 12);
		cl.set(Calendar.DAY_OF_MONTH, 15);
		cl.set(Calendar.YEAR, 1986);
		Date date1 = cl.getTime();

		Empleado jefp1 = new Empleado(101, "juan@info.com", "1234", new Date(), date1, "Juan", 35000, dep1, jefProy);
		Empleado jefp2 = new Empleado(103, "pepe@info.com", "1234", new Date(), date1, "Pepe", 35000, dep2, jefProy);
		Empleado jefp3 = new Empleado(104, "patricia@info.com", "1234", new Date(), date1, "Patricia", 35000, dep3,
				jefProy);

		lista.add(jefp1);
		lista.add(jefp2);
		lista.add(jefp3);
		lista.add(new Empleado(100, "pablo@info.com", "1234", new Date(), date1, "Pablo", 32000, dep2, contGes));
		lista.add(new Empleado(102, "lola@info.com", "1234", new Date(), date1, "Lola", 35000, dep1, rrHh));
		lista.add(new Empleado(105, "patricia@info.com", "1234", new Date(), date1, "Jose Pedro", 25000, dep3,
				operativo));
		lista.add(new Empleado(106, "patricia@info.com", "1234", new Date(), date1, "David", 25000, dep3, operativo));
		lista.add(new Empleado(107, "patricia@info.com", "1234", new Date(), date1, "Jorge", 25000, dep3, operativo));
		lista.add(new Empleado(108, "patricia@info.com", "1234", new Date(), date1, "Sergio", 25000, dep3, operativo));
		lista.add(new Empleado(109, "patricia@info.com", "1234", new Date(), date1, "Pilar", 25000, dep3, operativo));
		lista.add(new Empleado(110, "patricia@info.com", "1234", new Date(), date1, "Miguel", 25000, dep3, operativo));

		dep1.setJefeDepar(jefp1);
		dep2.setJefeDepar(jefp2);
		dep3.setJefeDepar(jefp3);

	}

	@Override
	public List<Empleado> findAll() {
		return lista;
	}

	@Override
	public Empleado findById(int idEmpl) {

		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
	}

	@Override
	public int altaEmpleado(Empleado empleado) {
		if (lista.contains(empleado))
			return 0;
		else
			return lista.add(empleado) ? 1 : 0;
	}

	@Override
	public int bajaEmpleado(Empleado empleado) {
		int pos = lista.indexOf(empleado);
		if (pos == -1)
			return 0;
		else
			return lista.remove(empleado) ? 1 : 0;
	}

	@Override
	public int editEmpleado(Empleado empleado) {
		int pos = lista.indexOf(empleado);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, empleado) != null) ? 1 : 0;
	}

	@Override
	public Empleado login(int idEmpl, String correo, String password) {
		Empleado aux = new Empleado();
		boolean flag = false;
		for (Empleado ele : findAll()) {
			if ((ele.getIdEmpl() == idEmpl) && (ele.getCorreo().equals(correo))
					&& (ele.getPassword().equals(password))) {
				aux = ele;
				flag = true;
			}
		}
		if (flag != true)
			return null;
		else
			return aux;
	}

	@Override
	public List<Empleado> listaJefeProyecto() {
		List<Empleado> listaJefes = new ArrayList<Empleado>();
		int cantidad = 0;
		for (Empleado ele : findAll()) {
			if (ele.getPerfil().getIdPerfil() == 2) {
				listaJefes.add(ele);
				cantidad++;
			}
		}

		if (cantidad > 0) {
			return listaJefes;
		} else {
			return null;
		}

	}

	@Override
	public List<Empleado> listaOperativos() {
		List<Empleado> listaOpera = new ArrayList<Empleado>();
		int cantidad = 0;
		for (Empleado ele : findAll()) {
			if (ele.getPerfil().getIdPerfil() == 3) {
				listaOpera.add(ele);
				cantidad++;
			}
		}
		if (cantidad > 0) {
			return listaOpera;
		} else {
			return null;
		}
	}

}
