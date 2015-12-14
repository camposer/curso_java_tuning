# Cómo configurar Maven

1.- Crear el archivo `settings.xml` con el siguiente contenido:

```
<settings>
  <proxies>
    <proxy>
      <id>myproxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.empresa.com</host>
      <port>8080</port>
      <username>USUARIO</username>
      <password>CONTRASEÑA</password>
    </proxy>
  </proxies>
</settings>
```

NOTA: La estructura de este archivo puede descargarla de: [Settings](https://maven.apache.org/settings.html) -> Proxies

2.- Especificar *settings* de Maven en Eclipse. 
- Ir a Window -> Preferences -> Maven -> User settings
- Especificar fichero `settings.xml`
- Clic en Update settings

3.- Para ejecutar comandos de Maven dentro del Eclipse.
- Cambiar JRE por JDK. Ir a Window -> Preferences -> Java -> Installed JRE. Añadir el JDK (indicar carpeta raíz)

4.- Reconstruir el proyecto.
- Clic derecho sobre el proyecto -> Run As -> maven install
- Clic derecho sobre el proyecto -> Maven -> Update (seleccionar update references)

 











