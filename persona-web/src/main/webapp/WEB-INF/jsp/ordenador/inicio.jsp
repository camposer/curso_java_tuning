<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ordenadores</title>
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
	<h1>Ordenadores</h1>
	
	<form:form action="guardar.do" method="post" commandName="ordenadorForm">
		<form:errors path="*" cssClass="errores"></form:errors>
	
		<form:hidden path="id"/>
		<table id="tabla-form" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" value="${ordenadorForm.nombre}"></td>
			</tr>
			<tr>
				<td>Serial</td>
				<td><form:input path="serial"/></td>
			</tr>
			<tr>
				<td>Dueño</td>
				<td>
					<select name="personaId">
						<option value=""></option>
						<c:forEach var="p" items="${personas}">
							<c:set var="selected" value=""/>
							<c:if test="${p.id == ordenadorForm.personaId }">
								<c:set var="selected" value="selected"/>
							</c:if>
							
							<option value="${p.id}" ${selected}>${p.nombreCompleto}</option>
						</c:forEach>
					</select>
				</td>
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
				<th>Serial</th>
				<th>Dueño</th>
				<th>Mostrar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${ordenadores}">
				<tr>
					<td>${o.id}</td>
					<td>${o.nombre}</td>
					<td>${o.serial}</td>
					<td>${o.persona.nombreCompleto}</td>
					<td><a href="mostrar.do?id=${o.id}">mostrar</a></td>
					<td>
						<a href="eliminar.do?id=${o.id}" onclick="return confirm('Eliminar?')" >
							eliminar
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>