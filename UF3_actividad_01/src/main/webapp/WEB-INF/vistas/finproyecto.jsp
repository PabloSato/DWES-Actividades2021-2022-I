<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TERMINAR PROYECTO</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<header>
			<nav>
				<ul>
					<li><a href="/gestion/inicio">Volver</a></li>
				</ul>
			</nav>
			<div class="user">
				<h6>id: ${empleado.idEmpl} - ${empleado.perfil.nombre}</h6>
			</div>
		</header>
		<section>
			<h2>Terminar un Proyecto</h2>
			<fieldset>
				<form action="/gestion/terminarProyecto" method="post">
					<div class="hide">
						<label>Codigo de Proyecto: </label> <input type="text"
							name="idProyecto" value="${proyecto.idProyecto}"/>
					</div>
					<br />
					<div class="box">
						<label>Codigo de Proyecto: </label> <input type="text"
							value="${proyecto.idProyecto}" disabled/>
					</div>
					<br />
					<div class="box">
						<label>Descripcion: </label> <input type="text" name="descripcion"
							value="${proyecto.descripcion}" disabled />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" value="${fechaInicio}" disabled />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Fin:</label> <input type="date"
							name="fechaFinReal" />
					</div>
					<br />
					<div class="box">
						<label>Coste Real: </label> <input type="number" name="costeReal" />
					</div>
					<br />
					<div class="box">
						<label>Venta Previsto: </label> <input type="number"
							name="ventaPrevisto" value="${proyecto.ventaPrevisto}" disabled />
					</div>
					<br />
					<div class="box">
						<label>Cliente: </label> <input type="text" name="descripcion"
							value="${proyecto.cliente.nombre}" disabled />
					</div>
					<br />
					<div class="box">
						<label>Jefe de Proyecto: </label> <input type="text"
							name="descripcion" value="${proyecto.jefeProyecto.nombre}"
							disabled />
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Terminar" /> <input type="reset"
							value="Reset" />
					</div>
				</form>
			</fieldset>

		</section>
	</div>
</body>
</html>
