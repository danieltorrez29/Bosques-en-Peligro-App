<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Project logo"></a>
</p>
<h3 align="center">Foro App</h3>
<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center"> Proyecto para la gestión de foros con usuarios y temas, utilizando Spring Boot y MongoDB.
    <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [TODO](../TODO.md)
- [Contributing](../CONTRIBUTING.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>

Este proyecto tiene como propósito proporcionar una plataforma de foros donde los usuarios puedan crear y gestionar temas. Utiliza Spring Boot para el backend y MongoDB como base de datos.

## 🏁 Getting Started <a name = "getting_started"></a>

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas. Consulta la sección de deployment para saber cómo desplegar el proyecto en un sistema en vivo.
### Prerequisites

Necesitas instalar los siguientes softwares:
```
Java 11 o superior
Maven
MongoDB
```

### Installing

Pasos para obtener un entorno de desarrollo en funcionamiento:

```
1. Clona el repositorio
https://github.com/danieltorrez29/Bosques-en-Peligro-App
```
2.Navega al directorio del proyecto
cd tu-repositorio
```
3. Compila el proyecto usando Maven
mvn clean install
4. ejecuta la app
mvn spring-boot:run
```


## 🔧 Running the tests <a name = "tests"></a>

cómo ejecutar las pruebas automatizadas para este sistema.

### Break down into end to end tests

jumm
```
mvn test
```
### And coding style tests

Explain what these tests test and why

```
Give an example
```

## 🎈 Usage <a name="usage"></a>
Notas sobre como usar el sistema.
__________Crear un Usuario_____________
URL: http://localhost:8080/usuarios
Method: POST
Headers: Content-Type: application/json
Body:
json
{
    "nombre": "Usuario 1",
    "correo": "usuario1@example.com",
    "contrasena": "password123"
}
Crear un Tema con Usuario
URL: http://localhost:8080/temas
Method: POST
Headers: Content-Type: application/json
Body:
json
{
    "nombre": "Tema 1",
    "usuario": {
        "id_usuario": "ID_DEL_USUARIO_EXISTENTE"
    }
}
## 🚀 Deployment <a name = "deployment"></a>

Add additional notes about how to deploy this on a live system.

## ⛏️ Built Using <a name = "built_using"></a>

- [MongoDB](https://www.mongodb.com/) - Database
- [Express](https://expressjs.com/) - Server Framework
- [VueJs](https://vuejs.org/) - Web Framework
- [NodeJs](https://nodejs.org/en/) - Server Environment

## ✍️ Authors <a name = "authors"></a>

- [@kylelobo](https://github.com/kylelobo) - Idea & Initial work

See also the list of [contributors](https://github.com/kylelobo/The-Documentation-Compendium/contributors) who participated in this project.

## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- Hat tip to anyone whose code was used
- Inspiration
- References
