<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Gestión de Eventos</title>
<link type="text/css" rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<div class="wrap">

		<header>
			<nav>
				<ul>
					<li><a href="#">Tipos</a></li>
					<li><a href="eventos?opcion=todos">Eventos</a></li>
					<!-- Mediante este enlace mandamos insertado en la URL la opción "todos" -->
					<li><a href="#">Usuarios</a></li>
					<li><a href="eventos?opcion=activos">Eventos/tipo</a></li>
					<!-- Mediante este enlace mandamos insertado en la URL la opción "activos" -->
					<li><a href="#">Login</a></li>
					<li><a href="#">Registro</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
			</nav>
		</header>
		<section>
			<h2>Listado de Eventos</h2>

			<div class="btnNuevo">
				<a href="eventos?opcion=alta">Nuevo evento</a>
				<!-- Mediante este enlace mandamos insertado en la URL la opción "alta" -->
			</div>

			<div class="tablas">
				<table>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Estado</th>
						<th>Tipo</th>
						<th>Destacado</th>
					</tr>
					<tr>
						<c:forEach var="ele" items="${requestScope.listaEventos}">

							<tr>
								<td>${ele.idEvento}</td>
								<!-- Obtenemos el Id del Evento -->
								<td>${ele.nombre}</td>
								<!-- Obtenemos el Nombre del Evento -->
								<td>${ele.precio}</td>
								<!-- Obtenemos el Precio del Evento -->
								<td>${ele.estado}</td>
								<!-- Obtenemos el Estado del Evento -->
								<td>${ele.tipo.nombre}</td>
								<!-- Obtenemos el Nombre del Tipo del Evento -->
								<td>${ele.destacado}</td>
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
							<td><a href="eventos?opcion=editar&id=${ele.idEvento}"
								class="edit">Editar</a></td>
							<!-- Es un enlace que pasa por la URL la opcion "eliminar" y el id del Evento-->
							<td><a href="eventos?opcion=eliminar&id=${ele.idEvento}"
								class="eli">Eliminar</a></td>
							<!-- Es un enlace que pasa por la URL la opcion "cancelar" y el id del Evento-->
							<td><a href="eventos?opcion=cancelar&id=${ele.idEvento}"
								class="cancel">Cancelar</a></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</section>
	</div>
</body>
</html>
