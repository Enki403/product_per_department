<section align="center">

# Tienda de Productos por Departamento
## Prueba técnica - Nov, 2022
### Autor
 Héctor José Vásquez López
 0801-1999-07541
 [Contacto](mailto:vasquezlopezhectorjose@gmail.com)
</section>

---

<section>

# Enunciado
## Proyecto de Sitio Web para una Tienda de productos por Departamento

### Instrucciones Generales.
1. El proyecto debe realizarlo de forma individual sin la colaboración de otra persona.
1. Podrá utilizar Bases de Datos relacionales (MySQL, Postgress)
1. Podra utilizar el servidor de aplicaciones de su preferencia (nginx, IIS, Tomcat,
Apache, ...)
1. Se deberá programar la solución en lenguaje java (SpringBoot).
1. Para el desarrollo del frontEnd(interfaces) es requerido que desarrolle funciones,
clases o código en JavaScript, por ejemplo para despliegue de mensajes,
validaciones de campos y llamados Ajax.
1. Deberá desarrollar al menos un servicio web que por medio de Ajax lo pueda
invocar y obtener información en json para el despliegue de datos
correspondiente.
1. La interfaz del sitio debe ser visualmente atractiva, puede utilizar bootstrap.
1. Debe de trabajar el proyecto en capas (Interfaz, lógica y acceso a los datos) 

### Detalles del proyecto:
Debe diseñar una base de datos que contenga las siguientes tablas:
1. Usuario
1. Categoría de Productos (debe haber eliminación en cascada de
productos)
1. Productos

Debe diseñar un sitio web que contenga los siguientes módulos:
1. Pantalla de Login
2. Mantenimiento de Categorías
3. Mantenimiento de Productos

#### Adicionalmente
1. Para el Login, deberá poder crearse el usuario si es primer ingreso y guardar la contraseña encriptada en la base de datos.
1. Para el mantenimiento de productos se deberá hacer una  ista de los mismos por categoría. Debe haber una búsqueda de productos por el campo de descripción.
1. De la lista debe tener una opción para mostrar el detalle de un producto, incluyendo una imagen del mismo.
1. Las imágenes se deben de almacenar en un directorio y en la base de datos solo almacenar la ruta de la misma.
1. Para el repositorio de fuentes debe crear un proyecto público en GitHub, donde deberán de quedar las diferentes etapas de la evolución del proyecto identificadas por branch. 

</section>

---

<section>

## Base de Datos
Se utiliza MySQL como SGBD hosteado gratiuitamente en [Free MySQL Hosting](https://www.freemysqlhosting.net/) por lo que se obtiene como resultado el siguiente _ConnectionString_: `jdbc:mysql://sql10.freemysqlhosting.net:3306/?user=sql10530136`

### DDL de la BD
La base de datos fue definida de la siguiente forma:
<details>
  <summary>Ver definición</summary>
  
```
CREATE TABLE IF NOT EXISTS tblUsuario(
	idUsuario INT AUTO_INCREMENT COMMENT "Id del usuario",
    username VARCHAR(50) NOT NULL COMMENT "Nombre de usuario unico",
    nombreUsuario VARCHAR(50) COMMENT "Nombre del usuario",
    apellido VARCHAR(50) COMMENT "Apellido del usuario",
    email VARCHAR(50) NOT NULL COMMENT "correo del usuario",
    pass VARCHAR(50) NOT NULL COMMENT "Contrasenia del usuario, encriptada",
    CONSTRAINT tblUsuario_PK PRIMARY KEY (idUsuario),
    CONSTRAINT tblUsuario_UK UNIQUE (username)
)ENGINE=InnoDB COLLATE = utf8_unicode_ci AUTO_INCREMENT = 1 COMMENT "Tabla de usuarios";

CREATE TABLE IF NOT EXISTS tblCategoria(
	idCategoria INT AUTO_INCREMENT COMMENT "Id de la categoria",
    creadoPor INT NOT NULL COMMENT "FK1 de tblUsuario determina quien creo la categoria",
    modificadoPor INT NOT NULL COMMENT "FK2 de tblUsuario determina quien hizo la ultima modificacion a la categoria",
    nombreCategoria VARCHAR(50) NOT NULL COMMENT "Nombre de la categoria",
    descripcionCategoria VARCHAR(250) NOT NULL COMMENT "Descripcion de la categoria",
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP() COMMENT "Fecha de creacion",
    fechaModificacion TIMESTAMP COMMENT "Ultima fecha de modificacion",
    CONSTRAINT tblCategoria_PK PRIMARY KEY (idCategoria),
    CONSTRAINT 
		tblUsuario_tblCategoria_FK1 FOREIGN KEY (creadoPor) 
			REFERENCES tblUsuario(idUsuario) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT 
		tblUsuario_tblCategoria_FK2 FOREIGN KEY (modificadoPor) 
			REFERENCES tblUsuario(idUsuario) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB COLLATE = utf8_unicode_ci AUTO_INCREMENT = 1 COMMENT "Tabla de categorias";

CREATE TABLE IF NOT EXISTS tblProducto(
	idProducto INT AUTO_INCREMENT COMMENT "Id del usuario",
	idCategoria INT COMMENT "Id de la categoria a la que pertenece",
    creadoPor INT NOT NULL COMMENT "FK1 de tblUsuario determina quien creo la categoria",
    modificadoPor INT NOT NULL COMMENT "FK2 de tblUsuario determina quien hizo la ultima modificacion a la categoria",
    cantidad INT NOT NULL COMMENT "Cantidad en stock del producto",
    precio INT NOT NULL COMMENT "Precio del producto",
    nombreProducto VARCHAR(50) NOT NULL COMMENT "Nombre del producto",
    imgDir VARCHAR(150) NOT NULL COMMENT "direccion de la imagen",
    descripcionProducto VARCHAR(250) NOT NULL COMMENT "Descripcion del producto",
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP() COMMENT "Fecha de creacion",
    fechaModificacion TIMESTAMP COMMENT "Ultima fecha de modificacion",
    CONSTRAINT tblProducto_PK PRIMARY KEY (idProducto),
    CONSTRAINT 
		tblCategoria_tblProducto_FK FOREIGN KEY (idCategoria) 
			REFERENCES tblCategoria(idCategoria) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT 
		tblUsuario_tblProducto_FK1 FOREIGN KEY (creadoPor) 
			REFERENCES tblUsuario(idUsuario) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT 
		tblUsuario_tblProducto_FK2 FOREIGN KEY (modificadoPor) 
			REFERENCES tblUsuario(idUsuario) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB COLLATE = utf8_unicode_ci AUTO_INCREMENT = 1 COMMENT "Tabla de productos";
```

</details>

</section>