<section align="center">

# Tienda de Productos por Departamento
## Prueba técnica - Nov, 2022
### Autor:
 Héctor José Vásquez López -
 0801-1999-07541 -
 [Contacto](mailto:vasquezlopezhectorjose@gmail.com)

 ### Aplicacion:
[Probar aplicación](https://products-per-department-demo.herokuapp.com/)
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
Se utiliza MySQL como SGBD hosteado en google cloud por lo que se obtiene como resultado el siguiente _ConnectionString_: `jdbc:mysql://34.70.211.84:3306/db_ppd`, por favor comunicarme si la base de datos no funciona de modo que pueda revisar si los creditos que google provee se han terminado. Adicionalmente se puede utilizar un hosting gratuito como *freemysqlhosting.net* lo que tendriamos como _ConnectionString_: `jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10530136`, sin embargo esta solucion es inestable y muy limitada

### DDL de la BD
La base de datos fue definida de la siguiente forma:
<details>
  <summary>Ver definición</summary>
  
```
CREATE TABLE IF NOT EXISTS tbl_usuario(
	  id_usuario INT NOT NULL AUTO_INCREMENT COMMENT "Id del usuario",
    username VARCHAR(50) NOT NULL COMMENT "Nombre de usuario unico",
    nombre_usuario VARCHAR(50) COMMENT "Nombre del usuario",
    apellido VARCHAR(50) COMMENT "Apellido del usuario",
    email VARCHAR(50) NOT NULL COMMENT "correo del usuario",
    contrasenia VARCHAR(50) NOT NULL COMMENT "Contrasenia del usuario, encriptada",
    CONSTRAINT tbl_usuario_pk PRIMARY KEY (id_usuario),
    CONSTRAINT tbl_usuario_uk UNIQUE (username)
)COMMENT "Tabla de usuarios";

CREATE TABLE IF NOT EXISTS tbl_categoria(
	  id_categoria INT NOT NULL AUTO_INCREMENT COMMENT "Id de la categoria",
    nombre_categoria VARCHAR(50) NOT NULL COMMENT "Nombre de la categoria",
    descripcion_categoria VARCHAR(250) NOT NULL COMMENT "Descripcion de la categoria",
    CONSTRAINT tbl_categoria_pk PRIMARY KEY (id_categoria)
)COMMENT "Tabla de categorias";

CREATE TABLE IF NOT EXISTS tbl_producto(
    id_producto INT NOT NULL AUTO_INCREMENT COMMENT "Id del usuario",
    id_categoria INT NOT NULL COMMENT "Id de la categoria a la que pertenece",
    cantidad INT NOT NULL COMMENT "Cantidad en stock del producto",
    precio DOUBLE  NOT NULL COMMENT "Precio del producto",
    nombre_producto VARCHAR(50) NOT NULL COMMENT "Nombre del producto",
    img_dir VARCHAR(150) NOT NULL COMMENT "direccion de la imagen",
    descripcion_producto VARCHAR(250) NOT NULL COMMENT "Descripcion del producto",
    CONSTRAINT tbl_producto_pk PRIMARY KEY (id_producto),
    CONSTRAINT 
		tbl_categoria_tbl_producto_fk FOREIGN KEY (id_categoria) 
			REFERENCES tbl_categoria(id_categoria) ON UPDATE CASCADE ON DELETE CASCADE
)COMMENT "Tabla de productos";
```
## Deploy

El deploy se realizó en heroku, alojado como: `https://products-per-department-demo.herokuapp.com/`

</details>

</section>