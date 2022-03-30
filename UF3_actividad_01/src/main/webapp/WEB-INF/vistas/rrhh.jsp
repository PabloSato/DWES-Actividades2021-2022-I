<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recursos Humanos</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">

		<!-- Esta es la página inicial de la aplicación web. Solo contiene un título de bienvenida y el navegador de ventanas -->

		<header>
			<nav>
				<ul>
					<li><a href="/rrhh/alta">Alta</a></li>
					<li><a href="/clientes/cerrarSesion">Salir</a></li>
				</ul>
			</nav>
			<div class="user">
				<h6>id: ${empleado.idEmpl} - ${empleado.nombre}</h6>
			</div>
		</header>
		<section>
			<h2>Bienvenidos a Recursos Humanos</h2>

			<div class="tablas">
				<div class="tabla_1">
					<h4>Proyectos</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Correo</th>
							<th>Fecha Ingreso</th>
							<th>Salario</th>
							<th>Departamento</th>
							<th>Perfil</th>
							<th>Acción</th>
							<th>Modificar</th>
						</tr>
						<tr>
							<c:forEach var="ele" items="${listaEmpleados}">

								<tr>
									<td>${ele.idEmpl}</td>
									<td>${ele.nombre}</td>
									<td>${ele.correo}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${ele.fechaIngreso }" /></td>
									<td>${ele.salario }</td>
									<td>${ele.departamento.nombre }</td>
									<td>${ele.perfil.nombre }</td>
									<td><a href="/rrhh/eliminar/${ele.idEmpl }">eliminar</a></td>
									<td><a href="/rrhh/modificar/${ele.idEmpl }">eliminar</a></td>
								</tr>

							</c:forEach>
						</tr>
					</table>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
