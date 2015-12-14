# Cómo configurar Proxy de Maven

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
