<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Gestión de Eventos - Cliente</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<header class="cab">
			<div class="h3_cliente">
				<h3>Eventos</h3>
			</div>
		</header>

		<section id="cliente">
			<aside>
				<div class="logo">
					<h4>Logo</h4>
				</div>
			</aside>
			<article>
				<header>
					<nav>
						<ul>
							<li>
								<ul class="inUl">
									<li><a href="/clientes/destacados">Destacados</a></li>
									<li><a href="/clientes/activos">Activos</a></li>
								</ul>
							</li>
							<li><a href="">Tipo de evento</a></li>
							<li><a href="#">Mis reservas</a></li>
							<li><a href="/clientes/login">Login</a></li>
							<li><a href="/clientes/alta">Registro</a></li>
							<li><a href="/clientes/cerrarSesion">Salir</a></li>
						</ul>
					</nav>
					<div class="user">
						<h6>Bienvenido ${usuario.nombre}</h6>
					</div>
				</header>
				<h2>Listado de Eventos Activos</h2>

				<div class="tablas2">
					<table>
						<tr>
							<th>Nombre</th>
						</tr>
						<tr>
							<c:forEach var="ele" items="${listaActivos}">
								<tr>
									<td>${ele.tipo.nombre}</td>
								</tr>
							</c:forEach>
						</tr>
					</table>
					<table class="opcs">
						<tr>
							<th>Aforo</th>
							<th>Fecha inicio</th>
							<th>Opciones</th>
						</tr>
						<tr>
							<c:forEach var="ele" items="${listaActivos}">
								<tr>
									<td>${ele.aforoMaximo}</td>
									<td>02-06-2022</td>
									<td><a href="/clientes/detalle/${ele.idEvento}" class="eli">Detalle</a></td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</div>
			</article>
		</section>
	</div>
</body>
</html>
