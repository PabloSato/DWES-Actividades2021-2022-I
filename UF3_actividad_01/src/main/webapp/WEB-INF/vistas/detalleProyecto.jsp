<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JEFE DE PROYECTO - DETALLE PROYECTO</title>
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
			<h2>Detalle del Proyecto Seleccionado</h2>
			<div class="tablas">
				<div class="tabla_1">
					<h4>Proyecto</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Descripción</th>
							<th>Coste Previsto</th>
							<th>Inicio</th>
							<th>Fin</th>
							<th>Venta</th>
							<th>Cliente</th>
						</tr>
						<tr>
							<td><span>${proyecto.idProyecto}</span></td>
							<td><span>${proyecto.descripcion}</span></td>
							<td><span>${proyecto.costesPrevisto}</span>€</td>
							<td><span><fmt:formatDate pattern="dd/MM/yyyy"
										value="${proyecto.fechaInicio}" /></span></td>
							<td><span><fmt:formatDate pattern="dd/MM/yyyy"
										value="${proyecto.fechaFinPrevisto}" /></span></td>
							<td><span>${proyecto.ventaPrevisto}</span>€</td>
							<td><span>${proyecto.cliente.nombre}</span></td>
						</tr>
					</table>
				</div>
				<div class="tabla_1">
					<h4>Empleados</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Correo</th>
							<th>Departamento</th>
							<th>Perfil</th>
							<th>Horas Asignadas</th>
						</tr>
						<c:forEach var="ele" items="${listaEmplProy}">
							<tr>
								<td><span>${ele.empleado.idEmpl}</span></td>
								<td><span>${ele.empleado.nombre}</span></td>
								<td><span>${ele.empleado.correo}</span></td>
								<td><span>${ele.empleado.departamento.nombre}</span></td>
								<td><span>${ele.empleado.perfil.nombre}</span></td>
								<td><span>${ele.horasAsignadas}</span> horas</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="tabla_1">
					<h4>Productos</h4>
					<table>
						<tr>
							<th>Id</th>
							<th>Producto</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Stock</th>
							<th>Cantidad</th>
						</tr>
						<c:forEach var="ele" items="${listaProduc}">
							<tr>
								<td><span>${ele.producto.idProducto}</span></td>
								<td><span>${ele.producto.descripcionBreve}</span></td>
								<td><span>${ele.producto.descripcionLarga}</span></td>
								<td><span>${ele.producto.precioUnitario}</span></td>
								<td><span>${ele.producto.stock}</span></td>
								<td><span>${ele.cantidad}</span> horas</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
