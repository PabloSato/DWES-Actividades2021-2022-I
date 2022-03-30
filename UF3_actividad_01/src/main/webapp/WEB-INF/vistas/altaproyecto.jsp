<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALTA PROYECTO</title>
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
			<h2>Alta de un Proyecto</h2>
			<fieldset>
				<form action="/gestion/altaProyecto" method="post">
					<div class="box">
						<label>Codigo de Proyecto: </label> <input type="text"
							name="idProyecto" placeholder="PY000"/>
					</div>
					<br />
					<div class="box">
						<label>Descripcion: </label> <input type="text" name="descripcion"
							placeholder="Descripcion del proyecto" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Fin Previsto:</label> <input type="date"
							name="fechaFinPrevisto" />
					</div>
					<br />
					<div class="box">
						<label>Coste Previsto: </label> <input type="number"
							name="costesPrevisto" />
					</div>
					<br />
					<div class="box">
						<label>Venta Previsto: </label> <input type="number"
							name="ventaPrevisto" />
					</div>
					<br />
					<div class="box">
						<label>Cliente</label>
						<div>
							<select name="cliente.cif">
								<option disabled selected>--</option>
								<c:forEach var="ele" items="${listaCliente}">
									<option value="${ele.cif}">${ele.nombre}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<br />
					<div class="box">
						<label>Jefe de Proyecto</label>
						<div>
							<select name="jefeProyecto.idEmpl">
								<option disabled selected>--</option>
								<c:forEach var="ele" items="${listaJefes}">
									<option value="${ele.idEmpl}">id: ${ele.idEmpl} -
										${ele.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Alta" /> <input type="reset"
							value="Reset" />
					</div>
				</form>
			</fieldset>

		</section>
	</div>
</body>
</html>
