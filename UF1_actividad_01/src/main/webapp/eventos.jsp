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
		/*Recibimos una lista con todos los Eventos (tanto activos como cancelados). Si se eliminase alguno de los que aparecen en esta lista, la lista se actualiza
		*y el objeto deja de aparecer
		*/
    		List<Evento> lista = (List<Evento>)request.getAttribute("listaEventos");
    	%>

		<header>
			<nav>
				<ul>
					<li><a href="#">Tipos</a></li>
					<li><a href="eventos?opcion=todos">Eventos</a></li><!-- Mediante este enlace mandamos insertado en la URL la opción "todos" -->
					<li><a href="#">Usuarios</a></li>
					<li><a href="eventos?opcion=activos">Eventos/tipo</a></li><!-- Mediante este enlace mandamos insertado en la URL la opción "activos" -->
					<li><a href="#">Login</a></li>
					<li><a href="#">Registro</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
			</nav>
		</header>
		<section>
			<h2>Listado de Eventos</h2>

			<div class="btnNuevo">
				<a href="eventos?opcion=alta">Nuevo evento</a><!-- Mediante este enlace mandamos insertado en la URL la opción "alta" -->
			</div>

			<div class="tablas">
				<table>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Estado</th>
						<th>Tipo</th>
					</tr>
					<tr>
					<!--Mediante este forEach vamos recorriendo a lista pintando cada objeto de ella  -->
						<% for(Evento ele : lista){ %>
					
					<tr>
						<td><%= ele.getIdEvento() %></td><!-- Obtenemos el Id del Evento -->
						<td><%= ele.getNombre() %></td><!-- Obtenemos el Nombre del Evento -->
						<td><%= ele.getPrecio() %></td><!-- Obtenemos el Precio del Evento -->
						<td><%= ele.getEstado() %></td><!-- Obtenemos el Estado del Evento -->
						<td><%= ele.getTipo().getNombre() %></td><!-- Obtenemos el Nombre del Tipo del Evento -->
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
						<!-- Generamos tantas filas de opciones como eventos hay en a lista -->
						<!-- Es un enlace que pasa por la URL la opcion "editar" y el id del Evento-->
						<td><a href="eventos?opcion=editar&id=<%= ele.getIdEvento() %>" class="edit">Editar</a></td>
						<!-- Es un enlace que pasa por la URL la opcion "eliminar" y el id del Evento-->
						<td><a href="eventos?opcion=eliminar&id=<%= ele.getIdEvento() %>"class="eli" >Eliminar</a></td>
						<!-- Es un enlace que pasa por la URL la opcion "cancelar" y el id del Evento-->
						<td><a href="eventos?opcion=cancelar&id=<%= ele.getIdEvento() %>"class="cancel" >Cancelar</a></td>
					</tr>
						<% } %>
					
				</table>
			</div>
		</section>
	</div>
</body>
</html>
