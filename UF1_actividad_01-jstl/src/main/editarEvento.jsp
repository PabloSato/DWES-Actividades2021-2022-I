<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h2>Editar Evento</h2>
			<!-- Creamos un objeto de tipo Evento y lo inicializamos con la infromación que nos veiene en el atributo -->


			<fieldset>
				<form action="eventos?opcion=editar" method="post">
					<!-- El formulario pasará la información mediante el método post (no será pública en la URL y la acción
																	se realizará en el servlet mediante la opción "editar" -->
					<div class="box">
						<label>id:</label> <input type="text"
							placeholder="${requestScope.evento.idEvento}" disabled />
						<div style="display: none">
							<input type="text" name="id"
								value="${requestScope.evento.idEvento}" style="display: hide;" />
						</div>
					</div>
					<br />
					<div class="box">
						<label>Nombre: </label> <input type="text" name="nombre"
							value="${requestScope.evento.nombre}" />
					</div>
					<br />
					<div class="box">
						<label>Descripción: </label> <input type="text" name="descripcion"
							value="${requestScope.evento.descripcion}" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" value="${requestScope.fechaForm}" />
					</div>
					<br />
					<div class="box">
						<label>Duración:</label> <input type="number" name="duracion"
							value="${requestScope.evento.duracion}" />
					</div>
					<br />
					<div class="box">
						<label>Dirección:</label> <input type="text" name="direccion"
							value="${requestScope.evento.direccion}" />
					</div>
					<br />
					<div class="box">
						<label>Estado:</label> <input type="text" name="estado"
							value="${requestScope.evento.estado}" />
					</div>
					<br />

					<div class="box_radio">
						<label>Destacado:</label>
						<div class="radio">
							<c:choose>
								<c:when test="${requestScope.evento.destacado eq 's'.charAt(0)}">
									<input type="checkbox" name="destacado" value="s" checked />Si
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="destacado" value="s"/>Si
								</c:otherwise>
							</c:choose>
						</div>

					</div>
					<br />
					<div class="box">
						<label>Aforo Máximo:</label> <input type="number"
							name="aforoMaximo" value="${requestScope.evento.aforoMaximo}" />
					</div>
					<br />
					<div class="box">
						<label>Mínima Asistencia:</label> <input type="number"
							name="minimaAsistencia"
							value="${requestScope.evento.minimaAsistencia}" />
					</div>
					<br />
					<div class="box">
						<label>Precio:</label> <input type="number" name="precio"
							value="${requestScope.evento.precio}" />
					</div>
					<br />
					<div class="box">
						<label>Tipo</label> <select name="tipo">
							<!-- Realizamos un for para poder obtener un select con todas las opciones de tipo de eventos que hay, sin que se repitan
									Es por este select, el motivo por el que esta página recibe una lista de tipo Tipo -->

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