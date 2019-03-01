# project-example-common

Este proyecto representa a una **librería de proyecto** relacionada con **project-example-common** para desarrollar un ejemplo para representar la operativa básica que se puede realizar en un banco

Esta librería destaca por :

* Proporcionar **clases de constantes específicas** de forma que puedas ser reutilizadas en otros proyectos de banca
* Proporcionar **clases de utilidades** que facilitarán el trabajo con diferentes elementos : tipos enumerados, conversores, transformadores, etc.
* Proporcionar una **excepción específica** "ExampleException" que en este caso dependen de la excepción genérica de arquitectura, sirve para identificar las excepciones que se puedan producir en esta aplicación en concreto
También facilita  disponer de un tipo de excepción diferenciadora en el proyecto (el resto de excepciones deberían de heredar de ella)
* Proporciona un **tipo enumerado con diferentes tipos de excepción** de forma que se pueda establecer excepciones de negocio que se resuelvan en sus puntos de control 


## Stack Tecnológico

* Java 8
* [Maven 3](https://maven.apache.org/) - Gestión de dependencias

Dependencias con proyectos de arquitectura

* **architecture-testing** [1.0.0-SNAPSHOT] : Librería de arquitectura para testing utilizada en el ámbito de test
* **architecture-common** [1.0.0-SNAPSHOT] : Librería de arquitectura para gestionar los elementos comunes entre todos los proyectos


Dependencias terceros

Las heredadas por las librerías de arquitectura


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
