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
			<h2>Accede</h2>
			<fieldset>
				<form action="/clientes/login" method="post">

					<div class="box">
						<label>Nickname: </label> <input type="text" name="userName"
							placeholder="nickname" value="${userName}" />
					</div>
					<br />
					<div class="box">
						<label>Password: </label> <input type="password" name="password"
							placeholder="*****" />
					</div>
					<br />
					<div class="btnsForm">
						<input type="submit" value="Login" /> <input type="reset"
							value="Reset" />
					</div>
				</form>
			</fieldset>
			<div class="msj">
				<h3>${requestScope.mensaje}</h3>
			</div>
		</section>
	</div>
</body>
</html>

</body>
</html>