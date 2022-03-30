<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDITAR EMPLEADO</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<header>
			<nav>
				<ul>
					<li><a href="/gestion/inicio">Volver</a></li>
				</ul>
			</nav>
			<div class="user">
				<h6>id: ${empleado.idEmpl} - ${empleado.nombre}</h6>
			</div>
		</header>
		<section>
			<h2>Modificar un Empleado</h2>
			<fieldset>
				<form action="/rrhh/modificar/${empleadoEdit.idEmpl}" method="post">
					<div class="hide">
						<label>Id de Empleado: </label> <input type="text"
							name="idEmpl" value="${empleadoEdit.idEmpl}"/>
					</div>
					<div class="box">
						<label>Id de Empleado: </label> <input type="text"
							name="idEmpl" placeholder="id" disabled/>
					</div>
					<br />
					<div class="box">
						<label>nombre: </label> <input type="text" name="nombre"
							value="${empleadoEdit.nombre}" />
					</div>
					<br />
					<div class="box">
						<label>correo: </label> <input type="text" name="correo"
							value="${empleadoEdit.correo}" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Ingreso:</label> <input type="date"
							name="fechaIngreso" value="${empleadoEdit.fechaIngreso}"/>
					</div>
					<br />
					<div class="box">
						<label>Fecha de Nacimiento:</label> <input type="date"
							name="fechaNacimiento" value="${empleadoEdit.fechaNacimiento}"/>
					</div>
					<br />
					<div class="box">
						<label>Salario: </label> <input type="number"
							name="salario" value="${empleadoEdit.salario}"/>
					</div>
					<br />
					<div class="box">
						<label>Perfil</label>
						<div>
							<select name="perfil.idPerfil">
								<option disabled selected>--</option>
								<c:forEach var="ele" items="${listaPerfil}">
									<option value="${ele.idPerfil}">${ele.nombre}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<br />
					<div class="box">
						<label>Departamento</label>
						<div>
							<select name="departamento.idDepar">
								<option disabled selected>--</option>
								<c:forEach var="ele" items="${listaDepart}">
									<c:choose>
										
									</c:choose>
									<option value="${ele.idDepar}">${ele.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Alta" /> <input type="reset"
							value="Reset" />
					</div>
				</form>
			</fieldset>

		</section>
	</div>
</body>
</html>
