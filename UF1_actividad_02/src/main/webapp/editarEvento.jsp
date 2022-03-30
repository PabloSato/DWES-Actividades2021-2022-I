<%@page import="modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Eventos</title>
<link type="text/css" rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<div class="wrap">
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
			<h2>Editar Evento</h2>

			<% Evento ev = (Evento)request.getAttribute("evento"); %>

			<fieldset>
				<form action="" method="post">
					<div class="box">
						<label>id:</label> <input type="text" name="id"
							placeholder="<%= ev.getIdEvento() %>" />
					</div>
					<br />
					<div class="box">
						<label>Nombre: </label> <input type="text" name="nombre"
							placeholder=" <%= ev.getNombre() %>" />
					</div>
					<br />
					<div class="box">
						<label>Descripción: </label> <input type="text" name="descripcion"
							placeholder=" <%= ev.getDescripcion() %>" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" placeholder="<%= ev.getFechaInicio() %>" />
					</div>
					<br />
					<div class="box">
						<label>Duración:</label> <input type="number" name="duracion"
							placeholder=" <%= ev.getDuracion() %>" />
					</div>
					<br />
					<div class="box">
						<label>Dirección:</label> <input type="text" name="direccion"
							placeholder="<%= ev.getDireccion() %>" />
					</div>
					<br />
					<div class="box">
						<label>Estado:</label> <input type="text" name="estado"
							placeholder="<%= ev.getEstado() %>" />
					</div>
					<br />
					<div class="box">
						<label>Destacado:</label> <input type="checkbox" name="destacado"
							value="<%= ev.getDestacado() %>" />
					</div>
					<br />
					<div class="box">
						<label>Aforo Máximo:</label> <input type="number"
							name="aforoMaximo" placeholder="<%= ev.getAforoMaximo() %>" />
					</div>
					<br />
					<div class="box">
						<label>Mínima Asistencia:</label> <input type="number"
							name="minimaAsistencia"
							placeholder="<%= ev.getMinimaAsistencia() %>" />
					</div>
					<br />
					<div class="box">
						<label>Precio:</label> <input type="number" name="precio"
							placeholder="<%= ev.getPrecio() %>" />
					</div>
					<br />
					<div class="box">
						<label>Tipo</label> <input type="number" name="tipo"
							placeholder=" <%=ev.getTipo().getIdTipo()%>" />
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Editar" /> <input type="reset"
							value="Reset" />
					</div>
				</form>
			</fieldset>
		</section>
	</div>
</body>
</html>

</body>
</html>