<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Gestión de Eventos</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">

		<header>
			<nav>
				<ul>
					<li><a href="/tipos/todos">Tipos</a></li>
					<li><a href="/eventos/todos">Eventos</a></li>
					<li><a href="#">Usuarios</a></li>
					<li><a href="/eventos/activos">Eventos/tipo</a></li>
					<li><a href="/clientes/login">Login</a></li>
					<li><a href="/clientes/alta">Registro</a></li>
					<li><a href="/clientes/cerrarSesion">Salir</a></li>
				</ul>
			</nav>
		</header>
		<section>
			<h2>Listado de todos los Eventos</h2>
			<div class="btnNuevo">
				<a href="/eventos/alta">Nuevo evento</a>
				<!-- Mediante este enlace mandamos insertado en la URL la opción "alta" -->
			</div>

			<div class="tablas">
				<table>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Estado</th>
					</tr>
					<tr>
						<c:forEach var="ele" items="${listaEventos}">

							<tr>
								<td>${ele.idEvento}</td>
								<!-- Obtenemos el Id del Evento -->
								<td>${ele.nombre}</td>
								<!-- Obtenemos el Nombre del Evento -->
								<td>${ele.precio}</td>
								<!-- Obtenemos el Precio del Evento -->
								<td>${ele.estado}</td>
							</tr>

						</c:forEach>
					</tr>
				</table>
				<table class="opcs">
					<tr>
						<th colspan="3">Opciones</th>
					</tr>
					<c:forEach var="ele" items="${requestScope.listaEventos}">
						<tr>

							<!-- Generamos tantas filas de opciones como eventos hay en a lista -->
							<!-- Es un enlace que pasa por la URL la opcion "editar" y el id del Evento-->
							<td><a href="/eventos/editar/${ele.idEvento}" class="edit">Editar</a></td>
							<!-- Es un enlace que pasa por la URL la opcion "eliminar" y el id del Evento-->
							<td><a href="/eventos/eliminar?id=${ele.idEvento}"
								class="eli">Eliminar</a></td>
							<!-- Es un enlace que pasa por la URL la opcion "cancelar" y el id del Evento-->
							<td><a href="/eventos/cancelar?id=${ele.idEvento}"
								class="cancel">Cancelar</a></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</section>
	</div>
</body>
</html>
