<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALTA EMPLEADO</title>
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
			<h2>Alta de un Empleado</h2>
			<fieldset>
				<form action="/rrhh/alta" method="post">
					<div class="box">
						<label>Id de Empleado: </label> <input type="text"
							name="idEmpl" placeholder="id"/>
					</div>
					<br />
					<div class="box">
						<label>nombre: </label> <input type="text" name="nombre"
							placeholder="Nombre" />
					</div>
					<br />
					<div class="box">
						<label>correo: </label> <input type="text" name="correo"
							placeholder="Correo" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Ingreso:</label> <input type="date"
							name="fechaIngreso" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Nacimiento:</label> <input type="date"
							name="fechaNacimiento" />
					</div>
					<br />
					<div class="box">
						<label>Salario: </label> <input type="number"
							name="salario" />
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
