<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Control de Gestión</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">

		<header>
			<nav>
				<ul>
					<li><a href="/gestion/altaProyecto">Alta Proyecto</a></li>
					<li><a href="">..</a></li>
					<li><a href="/gestion/altaProducto">Alta Producto</a></li>
					<li><a href="">..</a></li>
					<li><a href="/empleados/cerrarSesion">Salir</a></li>
				</ul>
			</nav>
			<div class="user">
				<h6>id: ${empleado.idEmpl} - ${empleado.perfil.nombre}</h6>
			</div>
		</header>
		<section>
			<h2>Bienvenidos a Control de Gestión, ${empleado.nombre}</h2>

			<div class="tablas">
				<div class="tabla_1">
				<h4>Proyectos</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Estado</th>
							<th>Opción</th>
						</tr>
						<tr>
							<c:forEach var="ele" items="${listaProyectos}">

								<tr>
									<td>${ele.idProyecto}</td>
									<td>${ele.descripcion}</td>
									<td>${ele.estado}</td>
									<td><a href="/gestion/terminarProyecto/${ele.idProyecto}"
										class="cancel">Terminar</a></td>
								</tr>

							</c:forEach>
						</tr>
					</table>
				</div>
				<div class="tabla_1">
				<h4>Productos</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Stock</th>
						</tr>
						<tr>
							<c:forEach var="ele" items="${listaProductos}">

								<tr>
									<td>${ele.idProducto}</td>
									<td>${ele.descripcionBreve}</td>
									<td>${ele.precioUnitario}</td>
									<td>${ele.stock}</td>
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