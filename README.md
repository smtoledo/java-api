"# ttps-server-api" 
"# java-api" 

* Para crear un Usuario:
----------------------------------------------------------------
POST a URL: "localhost:8080/usuarios"
Header: Content-Type - application/json
Datos ejemplo Body:
{
	"username": "sebastian",
	"password":"java",
	"nombre": "Sebastian",
	"apellido": "Toledo",
	"perfil": "ADMINISTRADOR",
	"email": "stoledo@gmail.com",
	"dni":"32517214"
}
Respuesta exitosa: 	+ 201 CREATED
Respuesta error: 	+ 400 BAD REQUEST

* Login / Autenticacion
----------------------------------------------------------------
POST a URL "localhost:8080/autenticacion"
Header:
	username - sebastian
	password - java

Respuesta para login correcto:  
			+ 200 OK 
			+ token - {idUsuario}+123456 
Respuesta para usuario o password incorrecto:
			+ 403 FORBIDDEN

* Listado de Carteleras para usuarios autenticados
----------------------------------------------------------------
GET a URL "localhost:8080/carteleras"
Header:
	token - {idUsuario}+123456

Respuesta token valido: 	+ 200 OK 
							+ listado de carteleras
Respuesta token invalido/usuario inexistente: 	
							+ 403 FORBIDDEN

* Alta de Nueva Cartelera
----------------------------------------------------------------
POST a URL "localhost:8080/carteleras"
Header:
	Header: Content-Type - application/json
	token - {idUsuarioADMIN}+123456
Datos ejemplo Body:
{
	"titulo": "TTPS - JAVA 2018",
	"descripcion":"cartelera de taller de java",
	"tipoCartelera": "EDUCATIVA"
}

Respuesta token invalido:	+ 403 FORBIDDEN
Respuesta para token con id usuario con perfil NO ADMINISTRADOR:
							+ 401 UNAUTHORIZED
Repuesta OK: 				+ 200 OK