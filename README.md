# Introducción a Spring Boot 

## Que es Spring Boot?

Spring Boot es un proyecto de código abierto que simplifica la creación de aplicaciones Spring. Proporciona una forma rápida y fácil de configurar una aplicación Spring con un conjunto de opiniones sobre cómo se deben configurar las cosas. Spring Boot elimina la necesidad de configuración manual y la necesidad de un archivo de configuración XML.

## Dependencias Comunes

Spring Web: Proporciona funciones de aplicación web, incluidos controladores y procesamiento de solicitudes, y es compatible con Spring MVC.

Spring Boot DevTools: Proporciona funciones de desarrollo, como la recarga automática de la aplicación.

Lombok: Proporciona anotaciones para reducir la cantidad de código que necesita escribir.

Spring Boot Actuator: Proporciona funciones de supervisión y administración de la aplicación, ejemplo: como la información de la aplicación, la información de la salud, las métricas, etc.

Thymeleaf: Un motor de plantillas que se puede utilizar para generar vistas HTML.


## Desplegar una aplicación Spring Boot

Para desplegar una aplicación Spring Boot, primero debe compilarla en un archivo JAR o WAR. Luego, puede ejecutar el archivo JAR o WAR en un servidor web o en un contenedor de servlets.

1. Primero lo que debemos hacer es crear un archivo JAR o WAR de nuestra aplicación Spring Boot. Para hacer esto, ejecute el siguiente comando que están conformado primero por mvnw que vendría siendo el wrapper de maven y luego clean package que es el comando que se encargar de limpiar el proyecto y empaquetarlo en un archivo JAR o WAR.
Target: es una carpeta que se crea en el proyecto que contiene el archivo JAR o WAR, y sirve para almacenar los archivos generados por el comando mvnw clean package.

./mvnw clean package

2. Luego de que se haya generado el archivo JAR o WAR, puede ejecutarlo en un servidor web o en un contenedor de servlets. Para ejecutar el archivo JAR, ejecute el siguiente comando:

java -jar target/nombre-del-archivo.jar
