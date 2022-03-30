<%@page import="java.util.List"%>
<%@page import="modelo.beans.Tipo"%>
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
		<%
		/*Recibimos una lista con todos los objetos de tipo Tipo que hay
		*/
		List<Tipo> lista = (List<Tipo>)request.getAttribute("listaTipoFrom");
    	%>
		<header>
			<nav>
				<ul>
					<li><a href="#">Tipos</a></li>
					<li><a href="eventos?opcion=todos">Eventos</a></li><!-- Mediante este enlace mandamos insertado en la URL la opción "todos" -->
					<li><a href="#">Usuarios</a></li>
					<li><a href="eventos?opcion=activos">Eventos/tipo</a></li><!-- Mediante este enlace mandamos insertado en la URL la opción "activos" -->
					<li><a href="#">Login</a></li>
					<li><a href="#">Registro</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
			</nav>
		</header>
		<section>
			<h2>Editar Evento</h2>
			<!-- Creamos un objeto de tipo Evento y lo inicializamos con la infromación que nos veiene en el atributo -->
			<% 
				Evento ev = (Evento)request.getAttribute("evento"); 
				String fecha = (String)request.getAttribute("fechaForm");//Recogemos el string fecha y lo pintamos en su input correspondiente
			
			%>

			<fieldset>
				<form action="eventos?opcion=editar" method="post"><!-- El formulario pasará la información mediante el método post (no será pública en la URL y la acción
																	se realizará en el servlet mediante la opción "editar" -->
					<div class="box">
						<label>id:</label> <input type="text"
							placeholder="<%= ev.getIdEvento() %>" disabled />
						<div style="display: none">
							<input type="text" name="id" value="<%= ev.getIdEvento() %>"
								style="display: hide;" />
						</div>
					</div>
					<br />
					<div class="box">
						<label>Nombre: </label> <input type="text" name="nombre"
							value=" <%= ev.getNombre() %>" />
					</div>
					<br />
					<div class="box">
						<label>Descripción: </label> <input type="text" name="descripcion"
							value=" <%= ev.getDescripcion() %>" />
					</div>
					<br />
					<div class="box">
						<label>Fecha de Inicio:</label> <input type="date"
							name="fechaInicio" value="<%=fecha %>" />
					</div>
					<br />
					<div class="box">
						<label>Duración:</label> <input type="number" name="duracion"
							value="<%=ev.getDuracion()%>" />
					</div>
					<br />
					<div class="box">
						<label>Dirección:</label> <input type="text" name="direccion"
							value="<%= ev.getDireccion() %>" />
					</div>
					<br />
					<div class="box">
						<label>Estado:</label> <input type="text" name="estado"
							value="<%= ev.getEstado() %>" />
					</div>
					<br />
					<div class="box">
						<label>Destacado:</label> 
						
						<% if(ev.getDestacado() == 's'){ %><!-- Si el valor de ev.getDestacado() es igual al carácter 's' -->
						<input type="checkbox" name="destacado"
							value="s" checked/><!-- Hacemos que aparezca con el check puesto -->
							<%}else{%><!-- En caso contrario que aparezca sin el check -->
								<input type="checkbox" name="destacado"
							value="s"/>
							<%} %> 
					</div>
					<br />
					<div class="box">
						<label>Aforo Máximo:</label> <input type="number"
							name="aforoMaximo" value="<%=ev.getAforoMaximo() %>" />
					</div>
					<br />
					<div class="box">
						<label>Mínima Asistencia:</label> <input type="number"
							name="minimaAsistencia" value="<%=ev.getMinimaAsistencia()%>" />
					</div>
					<br />
					<div class="box">
						<label>Precio:</label> <input type="number" name="precio"
							value="<%=ev.getPrecio()%>" />
					</div>
					<br />
					<div class="box">
						<label>Tipo</label> <select name="tipo">
								<!-- Realizamos un for para poder obtener un select con todas las opciones de tipo de eventos que hay, sin que se repitan
									Es por este select, el motivo por el que esta página recibe una lista de tipo Tipo -->
							<% for(Tipo ele : lista){ 
							
								if(ele.getIdTipo() == ev.getTipo().getIdTipo()){ %><<!-- En caso de que el idTipo recibido del objeto Evento sea igual al idTipo del elemento -->
							<option selected value="<%= ele.getIdTipo() %>"><%= ele.getNombre()%></option><!-- Que aparezca seleccinonado desde el principio -->
							<% }else{ %><!-- E caso contrario que sea una opción más -->
							<option value="<%=ele.getIdTipo()%>"><%= ele.getNombre()%></option><!-- Como value del option ponemos el idTipo y como nombre el nombre del Tipo -->

							<%} } %>

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