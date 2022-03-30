<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Gestión de Eventos - Cliente</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<header class="cab">
			<div class="h3_cliente">
				<h3>Eventos</h3>
			</div>
		</header>

		<section id="cliente">
			<aside>
				<div class="logo">
					<h4>Logo</h4>
				</div>
			</aside>
			<article>
				<header>
					<nav>
						<ul>
							<li>
								<ul class="inUl">
									<li><a href="/clientes/destacados">Destacados</a></li>
									<li><a href="/clientes/activos">Activos</a></li>
								</ul>
							</li>
							<li><a href="#">Tipo de evento</a></li>
							<li><a href="#">Mis reservas</a></li>
							<li><a href="/clientes/login">Login</a></li>
							<li><a href="/clientes/alta">Registro</a></li>
							<li><a href="/clientes/cerrarSesion">Salir</a></li>
						</ul>
					</nav>
            <div class="user">
              <h6>Bienvenido ${usuario.nombre}</h6>
            </div>
          </header>
          <h2>Detalle del Evento Seleccionado</h2>
          <div class="detalles">
            <div class="acciones">
              <ul>
                <li>Nombre: <span>${evento.nombre}</span></li>
                <li>Descripción: <span>${evento.descripcion}</span></li>
                <li>Dirección: <span>${evento.direccion}</span></li>
                <li>Fecha inicio: <span><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.fechaInicio}"/></span></li>
                <li>Duración: <span>${evento.duracion}</span> días</li>
                <li>Aforo máximo: <span>${evento.aforoMaximo}</span> personas</li>
                <li>Mín asistencia: <span>${evento.minimaAsistencia}</span> personas</li>
                <li>Precio Unitario: <span>${evento.precio}</span> euros</li>
              </ul>
            </div>
            <div class="reservas">
              <div class="reserCant">
                <div class="quedan">
                  <p>Quedan: ${quedan}</p>
                </div>
                <form class="cantidad" action="/clientes/reservar/${evento.idEvento}" method="post">
                	
                  <input type="number" name="cantidad" autofocus/>
                  <input type="submit" value="Reservar" />
                </form>
                <h4 class="${clase}">${mensaje}</h4>
              </div>
              <div class="img">
                <img src='<c:url value="/css/img/img.png" />' alt="img" />
              </div>
            </div>
          </div>
        </article>
      </section>
    </div>
  </body>
</html>
