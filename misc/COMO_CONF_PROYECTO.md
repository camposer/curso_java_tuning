# Cómo configurar el Proyecto

## Requerimientos

- JDK 8 (instalar)
- Apache Tomcat 8 (descomprimir
- Apache Derby 10.12 (descomprimir)

## Asunciones

- DERBY_HOME. Ruta donde se ha descomprimido el Apache Derby
- PROYECTO_HOME. Ruta donde del proyecto dentro del workspace de Eclipse

## Instrucciones

1.- Ejecutar el fichero `DERBY_HOME\bin\startNetworkServer.bat`. Dejar consola abierta.

2.- Configurar conexión a la Base de Datos desde Eclipse
- Dentro de la vista *Data source explorer* clic derecho y seleccionar New.
- Seleccionar la última versión de Apache Derby Client
- En la pestaña JAR quitar el JAR preconfigurado y seleccionar el fichero: `DERBY_HOME\lib\derbyclient.jar`
- Ingresar los siguientes datos de conexión a la BD:
	- Nombre de BD: personadb
	- Usuario: user
	- Contraseña: 123456
	- Seleccionar *save password*
	- Clic en Test (debería ser satisfactorio)

3.- Crear la Base de Datos
- Abrir el fichero `PROYECTO_HOME\sql\personadb.sql`
- Configurar Base de Datos en la parte superior del Scrapbook
- Clic derecho sobre el script y seleccionar: Execute all

### Para ejecutar persona-app

1.- Clic derecho sobre la clase App y seleccionar Run As -> Java application

### Para ejecutar persona-web

1.- Configuración del Tomcat
- Dentro de la vista Servers clic en Add new Server
- Seleccionar Apache Tomcat e indicar la carpeta donde se ha descomprimido y finalizar
- Clic derecho sobre el Sevidor -> Add and Remove... Seleccionar el proyecto
- Clic derecho sobre el Servidor -> Start

2.- En el navegador ingresar: `http://localhost:8080/persona-web`. Clic en Persona y navegar por la aplicación.






