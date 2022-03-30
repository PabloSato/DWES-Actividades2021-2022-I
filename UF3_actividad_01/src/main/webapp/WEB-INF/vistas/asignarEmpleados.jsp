<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JEFE DE PROYECTO - ASIGNAR EMPLEADOS</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<header class="cab">
			<nav>
				<ul>
					<li><a href="/jefe/inicio">Volver</a></li>
				</ul>
			</nav>
			<div class="user">
				<h6>Bienvenido ${empleado.nombre}</h6>
			</div>
		</header>

		<section>
			<h2>
				Gestión Empleados en Proyecto <span>${proyecto.idProyecto}</span>
			</h2>
			<div class="tablas">
				<div class="tabla_1">
					<h4>Listado de Empleados Asignados</h4>

					<table>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Perfil</th>
							<th>Horas Asignadas</th>
							<th>Incorporación</th>
							<th>Acción</th>
						</tr>
						<c:forEach var="ele" items="${listaEmplProy}">
							<tr>
								<td>${ele.empleado.idEmpl}</td>
								<td>${ele.empleado.nombre}</td>
								<td>${ele.empleado.perfil.nombre}</td>
								<td>${ele.horasAsignadas}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${ele.fechaIncorporacion}" /></td>
								<td><a href="/jefe/desasignar/${proyecto.idProyecto}/${ele.empleado.idEmpl}"
									class="cancel">desasignar</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="tabla_1">
					<h4>Listado de Empleados Sin Asignar</h4>
						<div class="empl tab">
							<p>Id</p>
							<p>Nombre</p>
							<p>Perfil</p>
							<p>Horas Asignadas</p>
							<p>Incorporación</p>
							<p>Acción</p>
						</div>
					<c:forEach var="ele" items="${restoEmpleados}">
						<form action="/jefe/asignarEmpleados/${requestScope.proyecto.idProyecto}" method="post">
						<input class="hide" type="number" name="idEmpl" value="${ele.idEmpl}">
							<div class="empl">
								<p>${ele.idEmpl}</p>
								<p>${ele.nombre}</p>
								<p>${ele.perfil.nombre}</p>
								<input type="number" name="horasAsignadas">
								<input type="date" name="fechaIncorporacion">
								<input type="submit" value="asignar">
							</div>
						</form>
					</c:forEach>

				</div>
			</div>
		</section>

	</div>
</body>
</html>
