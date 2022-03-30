<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JEFE DE PROYECTO</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">

		<header>
			<nav>
				<ul>
					<li><a href="">..</a></li>
					<li><a href="">..</a></li>
					<li><a href="">..</a></li>
					<li><a href="">..</a></li>
					<li><a href="/empleados/cerrarSesion">Salir</a></li>
				</ul>
			</nav>
			<div class="user">
				<h6>id: ${empleado.idEmpl} - ${empleado.perfil.nombre}</h6>
			</div>
		</header>
		<section>
			<h2>Bienvenidos a Gestión de Proyectos, ${empleado.nombre}</h2>

			<div class="tablas">
				<div class="tabla_1">
					<h4>Proyectos</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Estado</th>
							<th>Detalle</th>
							<th>Empleados</th>
							<th>Productos</th>
						</tr>
						<tr>
							<c:forEach var="ele" items="${listaJefe}">

								<tr>
									<td>${ele.idProyecto}</td>
									<td>${ele.descripcion}</td>
									<td>${ele.estado}</td>
									<td><a class="edit" href="/jefe/verDetalle/${ele.idProyecto}">ver Detalle</a></td>
									<td><a class="eli" href="/jefe/asignarEmpleados/${ele.idProyecto}">asignar</a></td>
									<td><a class="eli" href="/jefe/asignarProducto/${ele.idProyecto}">asignar</a></td>
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

</body>
</html>