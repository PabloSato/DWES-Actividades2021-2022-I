<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Gestión de Eventos</title>
<link type="text/css" rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<div class="wrap">

		<%
    		List<Evento> lista = (List<Evento>)request.getAttribute("listaActivos");
    	%>

		<header>
			<nav>
				<ul>
					<li><a href="#">Tipos</a></li>
					<li><a href="eventos?opcion=todos">Eventos</a></li>
					<li><a href="#">Usuarios</a></li>
					<li><a href="eventos?opcion=activos">Eventos/tipo</a></li>
					<li><a href="#">Login</a></li>
					<li><a href="#">Registro</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
			</nav>
		</header>
		<section>
			<h2>Listado de Eventos Activos</h2>

			<div class="btnNuevo">
				<a href="eventos?opcion=alta">Nuevo evento</a>
			</div>

			<div class="tablas">
				<table>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Precio</th>
					</tr>
					<tr>
						<% for(Evento ele : lista){ %>
					
					<tr>
						<td><%= ele.getIdEvento() %></td>
						<td><%= ele.getNombre() %></td>
						<td><%= ele.getPrecio() %></td>
					</tr>

					<%} %>
					</tr>
				</table>
				<table class="opcs">
					<tr>
						<th colspan="3">Opciones</th>
					</tr>
					<tr>
						<% for(Evento ele : lista){ %>
						<td><a href="eventos?opcion=editar&id=<%= ele.getIdEvento() %>" class="edit">Editar</a></td>
						<td><a href="eventos?opcion=eliminar&id=<%= ele.getIdEvento() %>"class="eli" >Eliminar</a></td>
						<td><a href="eventos?opcion=cancelar&id=<%= ele.getIdEvento() %>"class="cancel" >Cancelar</a></td>
					</tr>
						<% } %>
					
				</table>
			</div>
		</section>
	</div>
</body>
</html>
