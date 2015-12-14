<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
	<style>
		h1 {
			text-align: center;
		}
		
		.tabla-centrada {
			margin-left: auto;
			margin-right: auto;
		}
		
		.tabla-datos th {
			background-color: gray;
		}
		
		.tabla-datos tr:nth-child(odd) td {
			background-color: lightgray;
		}
		
		.tabla-datos tr:nth-child(odd) td {
			background-color: darkgray;
		}
		
		.tabla-datos a {
			color: black;
		}
		.errores {
			background-color: red;
		}
		
		#tabla-form tr:last-child td {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Personas</h1>
	
	<c:if test="${!empty errores}">
		<div class="errores">
			<ul>
				<c:forEach var="e" items="${errores}">
					<li>${e}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	
	
	<form:form action="guardar.do" method="post" commandName="personaForm">
		<form:errors path="*" cssClass="errores"></form:errors>
	
		<form:hidden path="id"/>
		<table id="tabla-form" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><form:input path="apellido"/></td>
			</tr>
			<tr>
				<td>
					Fecha de nacimiento<br>
					(Ej. 2012-01-01)
				</td>
				<td><form:input path="fechaNacimiento"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Guardar">
				</td>
			</tr>
		</table>
	</form:form>
	<hr>
	<table class="tabla-centrada tabla-datos">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Fecha de nacimiento</th>
				<th>Ordenadores</th>
				<th>Mostrar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${personas}">
				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.apellido}</td>
					<td>${p.fechaNacimiento}</td>
					<td>
						<c:forEach var="o" items="${p.ordenadores}">
							${o.nombre} - ${o.serial}<br>
						</c:forEach>
					</td>
					<td><a href="mostrar.do?id=${p.id}">mostrar</a></td>
					<td>
						<a href="eliminar.do?id=${p.id}" onclick="return confirm('Eliminar?')" >
							eliminar
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>