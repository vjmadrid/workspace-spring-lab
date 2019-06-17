# project-custom-message-core

Este proyecto representa un ejemplo para de operativa básica que se puede realizar para realizar un CRUD completo con una entidad que representa un tipo de mensaje propio

Esta librería destaca por :

* Proporcionar **clases de proyecto** : entidades, factorias, repostiorio, servicio y validaciones

La persistencia se gestiona de varias maneras con Hibernate y otras clases permitiendo el trabajo sobre una base de datos en memoria H2

## Stack Tecnológico

* Java 8
* [Maven 3](https://maven.apache.org/) - Gestión de dependencias
* Spring 4
* Hibernate
* H2
 

Dependencias con proyectos de arquitectura

* **architecture-testing** [1.0.0-SNAPSHOT] : Librería de arquitectura para testing utilizada en el ámbito de test
* **architecture-common** [1.0.0-SNAPSHOT] : Librería de arquitectura para gestionar los elementos comunes a todos los proyectos
* **architecture-persistence-hibernate** [1.0.0-SNAPSHOT] : Librería de arquitectura para implementar los repositorios genéricos y para proprocionar las implementaciones basadas en Hibernate

Dependencias terceros

* **spring-context** [4.2.0.RELEASE] : Framework "core" de Spring en base a la transitividad
* **spring-context-support** [4.2.0.RELEASE] : Librería para proporcionar soporte a Spring
* **spring-test** [4.2.0.RELEASE] : Librería para facilitar los test sobre Spring
* **spring-tx** [4.2.0.RELEASE] : Librería para facilitar la gestión de transacciones
* **spring-orm** [4.2.0.RELEASE] : Librería para facilitar el mapeo de tabla y objeto
* **mssql-jdbc** [6.2.2.jre8] : Librería para conectarse a SQL Server

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
