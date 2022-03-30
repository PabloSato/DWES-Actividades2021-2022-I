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
			<h2>Nuevo Usuario</h2>
			<fieldset>
				<form action="/clientes/alta" method="post">
					<!-- El formulario pasará la información mediante el método post (no será pública en la URL y la acción
																	se realizará en el servlet mediante la opción "alta" -->
					
					<div class="box">
						<label>Nickname: </label> <input type="text" name="userName"
							placeholder="nickname" />
					</div>
					<br />
					<div class="box">
						<label>Password: </label> <input type="password" name="password"
							placeholder="*****" />
					</div>
					<br />
					<div class="box">
						<label>Email:</label> <input type="text" name="email"
							placeholder="tu@email.com" />
					</div>
					<br />
					<div class="box">
						<label>Nombre: </label> <input type="text" name="nombre"
							placeholder="nombre" />
					</div>
					<br />
					<div class="box">
						<label>Dirección:</label> <input type="text" name="direccion"
							placeholder="direccion" />
					</div>
					<br />
					<div class="hide">
						<label>Enabled:</label> <input type="number" name="enabled"
							value="1" />
					</div>
					<br />

					<br />
					<div class="btnsForm">
						<input type="submit" value="Login" /> <input type="reset"
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