# Backend de Validación de Circulación de Pico y Placa

Este es el backend del proyecto de validación de circulación de pico y placa, desarrollado en **Spring Boot**. El sistema permite procesar la lógica de validación para determinar si un vehículo puede circular según las restricciones de pico y placa.

## **Versión de Spring Boot**

El proyecto utiliza **Spring Boot 3.1.0**. Asegúrate de tener esta versión o una compatible instalada en tu entorno de desarrollo.

## **Requisitos Previos**

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java**: Versión 17 o superior.
- **Maven**: Versión 3.8.1 o superior.
- **Git** (opcional): Para clonar el repositorio.

## **Instalación**

1. Clona el repositorio desde GitHub:
   ```bash
   git clone https://github.com/cpiguave/picoyplaca_backend.git
   cd backend-picoyplaca
   ```

2. Verifica que las dependencias estén correctamente configuradas en el archivo `pom.xml`.

3. Compila y verifica el proyecto:
   ```bash
   mvn clean install
   ```

## **Ejecución del Proyecto**

1. Para ejecutar el servidor localmente, usa el siguiente comando:
   ```bash
   mvn spring-boot:run
   ```

2. El servidor se iniciará en `http://localhost:8080` de forma predeterminada. Puedes probar los endpoints en un cliente como **Postman** o desde tu frontend.

## **Configuración del Servidor**

- El puerto predeterminado del servidor es **8080**. Si necesitas cambiarlo, edita el archivo `src/main/resources/application.properties`:

   ```properties
   server.port=8080
   ```

- Si despliegas el backend en un servidor remoto, asegúrate de configurar correctamente la URL en el frontend.

## **Características Principales**

- **Validación de Restricciones**: Procesa las reglas de pico y placa según el día, la hora, y el último dígito de la placa.
- **Integración RESTful**: Exposición de endpoints para consumir desde el frontend.
- **Validación de Datos**: Valida la entrada para evitar errores en los datos enviados.

## **Tecnologías Utilizadas**

- **Spring Boot**: Framework para desarrollo backend.
- **Maven**: Herramienta de gestión de dependencias y construcción.
- **Java**: Lenguaje principal del proyecto.
- **Jakarta Validation**: Validación de datos de entrada.
- **RESTful Services**: Arquitectura de comunicación.

## **Endpoints del Proyecto**

### **POST /api/validacion**
Valida si un vehículo puede circular según las restricciones de pico y placa.

#### **Ejemplo de Solicitud**
```json
POST http://localhost:8080/api/validacion
Content-Type: application/json

{
  "placa": "ABC-123",
  "fechaHora": "2025-01-17T08:30:00"
}
```

#### **Ejemplo de Respuesta**
```json
{
  "placa": "ABC-123",
  "mensaje": "El vehículo NO puede circular en esta fecha y hora."
}
```

## **Construcción de un JAR**

Si necesitas construir un archivo JAR ejecutable para desplegar el proyecto en un servidor, usa el siguiente comando:

```bash
mvn clean package
```

Esto generará un archivo `backend-picoyplaca-0.0.1-SNAPSHOT.jar` en la carpeta `target/`. Para ejecutarlo:

```bash
java -jar target/backend-picoyplaca-0.0.1-SNAPSHOT.jar
```

## **Notas Adicionales**

- Asegúrate de que el backend esté corriendo antes de probarlo desde el frontend.
- Si necesitas usar la aplicación en producción, configura las variables de entorno adecuadamente.

Para más información, consulta la [documentación oficial de Spring Boot](https://spring.io/projects/spring-boot).
