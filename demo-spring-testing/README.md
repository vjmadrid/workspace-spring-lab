# demo-spring-testing

Este proyecto representa un ejemplo para aprender a **utilizar y configurar Spring-Test** para probar aplicaciones desarrolladas con Spring en base al proyecto **"project-example-core"**

Esta librería destaca por :

* Proporcionar **clases de configuración XML** 
* Proporcionar **clases de configuración Anotaciones**
* Proporcionar **clases de configuración Java** 
* Proporcionar **clases de Listener** 
* Proporcionar **clases de Initializer**


## Stack Tecnológico

* Java 8
* [Maven 3](https://maven.apache.org/) - Gestión de dependencias
* Spring 4

Dependencias con proyectos de arquitectura

* **architecture-testing** [1.0.0-SNAPSHOT] : Librería de arquitectura para testing utilizada en el ámbito de test
* **architecture-persistence-hibernate** [1.0.0-SNAPSHOT] : Librería de arquitectura para implementar los repositorios genéricos basados en Hibernate y la parte de arquitectura de persistencia global
* **project-example-core** [1.0.0-SNAPSHOT] : Librería de proyecto de ejemplo para realizar diferentes operativas y pruebas


Dependencias terceros

* **spring-test** [4.2.0.RELEASE] : Librería para facilitar los test sobre Spring
* **spring-tx** [4.2.0.RELEASE] : Librería para facilitar la gestión de transacciones
* **spring-orm** [4.2.0.RELEASE] : Librería para facilitar el mapeo de tabla y objeto
* **spring-web** [4.2.0.RELEASE] : Librería para facilitar algunos aspectos relacionados con la web


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
