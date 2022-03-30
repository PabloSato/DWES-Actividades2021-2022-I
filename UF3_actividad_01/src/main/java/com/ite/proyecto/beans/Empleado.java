package com.ite.proyecto.beans;

import java.io.Serializable;
import java.util.Date;


public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	//PROPIEDADES
	private int idEmpl;

	private String correo;
	
	private String password;
	
	private Date fechaIngreso;

	
	private Date fechaNacimiento;

	private String nombre;

	private double salario;

	
	private Departamento departamento;

	
	private Perfil perfil;

	//CONSTUCTOR	
	public Empleado() {
	}

	

	public Empleado(int idEmpl, String correo, String password, Date fechaIngreso, Date fechaNacimiento, String nombre,
			double salario, Departamento departamento, Perfil perfil) {
		super();
		this.idEmpl = idEmpl;
		this.correo = correo;
		this.password = password;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
		this.perfil = perfil;
	}



	//GETTER Y SETTER
	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Perfil getPerfil() {
		return perfil;
	}



	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}



	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	//HASHCODE & EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpl != other.idEmpl)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", correo=" + correo + ", password=" + password + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", salario=" + salario
				+ ", perfil=" + perfil + "]";
	}

	//METODOS

	

}