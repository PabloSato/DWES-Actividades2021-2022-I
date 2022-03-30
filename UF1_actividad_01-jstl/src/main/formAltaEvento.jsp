<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Eventos</title>
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
			<h2>Nuevo Evento</h2>



			<fieldset>
				<form action="eventos?opcion=alta" method="post">
					<!-- El formulario pasará la información mediante el método post (no será pública en la URL y la acción
																	se realizará en el servlet mediante la opción "alta" -->
					<div class="box">
						<label>id:</label> <input type="number" name="id" placeholder="id" />
					</div>
					<br />
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
							name="fechaInicio" pattern="\d{2}-\d{2}-\{4}"
							placeholder="dd-mm-aaaa" />
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
					<div class="box">
						<label>Estado:</label>
						<div>
							<select name="estado">
								<option value="activo">Activo</option>
								<option value="cancelado">Cancelado</option>
								<option disabled selected>--</option>
							</select>
						</div>
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
							<select name="tipo">
								<!-- Realizamos un for para poder obtener un select con todas las opciones de tipo de eventos que hay, sin que se repitan
									-->
								<option disabled selected>--</option>
								<c:forEach var="ele" items="${requestScope.listaTipoFrom}">

									<c:choose>
										<c:when
											test="${(requestScope.evento.tipo.idTipo) == (ele.idTipo)}">
											<option selected value="${ele.idTipo}">${ele.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${ele.idTipo}">${ele.nombre}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>

							</select>
						</div>
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Añadir" name="submit" /> <input
							type="reset" value="Reset" />
					</div>
				</form>
			</fieldset>
		</section>
	</div>
</body>
</html>

</body>
</html>