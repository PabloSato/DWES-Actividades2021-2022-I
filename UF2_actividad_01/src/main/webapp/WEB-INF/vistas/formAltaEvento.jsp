<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Eventos</title>
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
			<h2>Nuevo Evento</h2>
			<fieldset>
				<form action="/eventos/alta" method="post">
					<!-- El formulario pasará la información mediante el método post (no será pública en la URL y la acción
																	se realizará en el servlet mediante la opción "alta" -->
					
					<div class="box">
						<label>Nombre: </label> <input type="text" name="nombre"
							placeholder="nombre" />
					</div>
					<br />
					<div class="box">
						<label>Descripción: </label> <input type="text" name="descripcion"
							placeholder="descripción" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" />
					</div>
					<br />
					<div class="box">
						<label>Duración:</label> <input type="number" name="duracion"
							placeholder="duracion" />
					</div>
					<br />
					<div class="box">
						<label>Dirección:</label> <input type="text" name="direccion"
							placeholder="direccion" />
					</div>
					<br />
					<div class="box_radio">
						<label>Destacado:</label>
						<div class="radio">
							<input type="checkbox" name="destacado" value="s" />Si
						</div>
					</div>

					<br />
					<div class="box">
						<label>Aforo Máximo:</label> <input type="number"
							name="aforoMaximo" placeholder="aforo máximo" />
					</div>
					<br />
					<div class="box">
						<label>Mínima Asistencia:</label> <input type="number"
							name="minimaAsistencia" placeholder="minima asistencia" />
					</div>
					<br />
					<div class="box">
						<label>Precio:</label> <input type="number" name="precio"
							placeholder="precio" />
					</div>
					<br />
					<div class="box">
						<label>Tipo</label>
						<div>
							<select name="tipo.nombre">
								<!-- Realizamos un for para poder obtener un select con todas las opciones de tipo de eventos que hay, sin que se repitan
									-->
								<option disabled selected>--</option>
								<c:forEach var="ele" items="${listaTipo}">
									<option value="${ele.idTipo}">${ele.nombre}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Añadir" /> <input type="reset"
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