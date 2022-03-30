<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JEFE DE PROYECTO - ASIGNAR PRODUCTOS</title>
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
				Gestión Productos en Proyecto <span>${proyecto.idProyecto}</span>
			</h2>
			<div class="tablas">
				<div class="tabla_1">
					<h4>Listado de Productos Asignados</h4>

					<table>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Precio Asignado</th>
							<th>Cantidad</th>
							<th>Acción</th>
						</tr>
						<c:forEach var="ele" items="${productos}">
							<tr>
								<td>${ele.producto.idProducto}</td>
								<td>${ele.producto.descripcionBreve}</td>
								<td>${ele.producto.descripcionLarga}</td>
								<td>${ele.precioAsignado} €</td>
								<td>${ele.cantidad}</td>
								<td><a href="/jefe/desasignarProd/${proyecto.idProyecto}/${ele.producto.idProducto}"
									class="cancel">desasignar</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="tabla_1">
					<h4>Listado de Productos Sin Asignar</h4>
						<div class="empl tab">
							<p>Id</p>
							<p>Nombre</p>
							<p>Descripción</p>
							<p>Precio Asignado</p>
							<p>Cantidad</p>
							<p>Acción</p>
						</div>
					<c:forEach var="ele" items="${restoProd}">
						<form action="/jefe/asignarProducto/${proyecto.idProyecto}" method="post">
						<input class="hide" type=number name="idProducto" value="${ele.idProducto}">
						<div class="empl">
								<p>${ele.idProducto}</p>
								<p>${ele.descripcionBreve}</p>
								<p>${ele.descripcionLarga}</p>
								<input type="number" name="precioAsignado">
								<input type="number" name="cantidad">
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
