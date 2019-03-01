# project-example-common

Este proyecto representa un ejemplo para de operativa básica que se puede realizar en un banco

Esta librería destaca por :

* Proporcionar **clases de proyecto** : entidades, factorias, repostiorio, servicio y validaciones

Para no complicar el ejercicio la parte relacionada con el acceso a base de datos se ha implementado de forma básica para hacer uso de la memoria (NO de una base de datos en memoria)


## Stack Tecnológico

* Java 8
* [Maven 3](https://maven.apache.org/) - Gestión de dependencias
* Spring 4

Dependencias con proyectos de arquitectura

* **architecture-testing** [1.0.0-SNAPSHOT] : Librería de arquitectura para testing utilizada en el ámbito de test
* **architecture-persistence** [1.0.0-SNAPSHOT] : Librería de arquitectura para implementar los repositorios genéricos y para proprocionar las implementaciones basadas en memoria

Dependencias terceros

* **spring-context** [4.2.0.RELEASE] : Framework "core" de Spring en base a la transitividad
* **spring-context-support** [4.2.0.RELEASE] : Librería para proporcionar soporte a Spring
* **spring-test** [4.2.0.RELEASE] : Librería para facilitar los test sobre Spring


## Prerrequisitos

Se definen que elementos se necesitan para instalar el software

* Tener instalado Java 8 (Se requiere versión 1.5+)
* Tener instalado Maven (Se aconseja que sea 3+)


### Instalación

Pasos a seguir 

* Arrancar la consola
* Situarse en el PATH de instalación (el lugar donde se encuentra el proyecto)
* Verificar que se encuentra disponible el fichero "pom.xml"

Ejecutar el siguiente comando

```bash
mvn clean install
```

El resultado será la generación de un artefacto en tu repositorio maven


## Testing

Este proyecto dispone de test

Nota : utilizar todos los comandos de maven

## Despliegue

No aplica


## Versionado

**Nota :** Se utiliza [SemVer](http://semver.org/) para el versionado. 
Para ver las versiones disponibles acceder a los tags del repositorio

## Autores

* **Víctor Madrid**
