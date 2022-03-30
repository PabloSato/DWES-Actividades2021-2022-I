<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Eventos</title>
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
			<h2>Editar Evento</h2>
			<!-- Creamos un objeto de tipo Evento y lo inicializamos con la infromación que nos veiene en el atributo -->


			<fieldset>
				<form action="/eventos/editar" method="post">
					<!-- El formulario pasará la información mediante el método post (no será pública en la URL y la acción
																	se realizará en el servlet mediante la opción "editar" -->
					<div class="box">
						<label>id:</label> <input type="text"
							placeholder="${evento.idEvento}" disabled />
						<div style="display: none">
							<input type="text" name="idEvento" value="${evento.idEvento}"
								style="display: hide;" />
						</div>
					</div>
					<br />
					<div class="box">
						<label>Nombre: </label> <input type="text" name="nombre"
							value="${evento.nombre}" />
					</div>
					<br />
					<div class="box">
						<label>Descripción: </label> <input type="text" name="descripcion"
							value="${evento.descripcion}" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" value='${fecha}' />
					</div>
					<br />
					<div class="box">
						<label>Duración:</label> <input type="number" name="duracion"
							value="${evento.duracion}" />
					</div>
					<br />
					<div class="box">
						<label>Dirección:</label> <input type="text" name="direccion"
							value="${evento.direccion}" />
					</div>
					<br />
					<div class="box">
						<label>Estado:</label>
						
							<select name="estado">
							<c:choose>
								<c:when test="${evento.estado eq 'activo' }">
									<option value="activo" selected>Activo</option>
									<option value="cancelado" >Cancelado</option>
								</c:when>
								<c:otherwise>
									<option value="activo">Activo</option>
									<option value="cancelado" selected>Cancelado</option>
								</c:otherwise>
							</c:choose>
							</select>
					</div>
					<br />

					<div class="box_radio">
						<label>Destacado:</label>
						<div class="radio">
							<c:choose>
								<c:when test="${evento.destacado eq 's'.charAt(0)}">
									<input type="checkbox" name="destacado" value="s" checked />Si
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="destacado" value="s" />Si
								</c:otherwise>
							</c:choose>
						</div>

					</div>
					<br />
					<div class="box">
						<label>Aforo Máximo:</label> <input type="number"
							name="aforoMaximo" value="${evento.aforoMaximo}" />
					</div>
					<br />
					<div class="box">
						<label>Mínima Asistencia:</label> <input type="number"
							name="minimaAsistencia" value="${evento.minimaAsistencia}" />
					</div>
					<br />
					<div class="box">
						<label>Precio:</label> <input type="number" name="precio"
							value="${evento.precio}" />
					</div>
					<br />
					<div class="box">
						<label>Tipo</label> <select name="tipo.idTipo">
							<!-- Realizamos un for para poder obtener un select con todas las opciones de tipo de eventos que hay, sin que se repitan
									Es por este select, el motivo por el que esta página recibe una lista de tipo Tipo -->

							<c:forEach var="ele" items="${listaTipo}">

								<c:choose>
									<c:when test="${(evento.tipo.idTipo) == (ele.idTipo)}">
										<option selected value="${ele.idTipo}">${ele.nombre}</option>
									</c:when>
									<c:otherwise>
										<option value="${ele.idTipo}">${ele.nombre}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>

						</select>

					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Editar" name="submit" /> <input
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