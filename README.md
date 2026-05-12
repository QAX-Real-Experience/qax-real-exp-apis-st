# QAX Real Experience · APIs Java Rest Assured

Repositorio de automatización para pruebas de **APIs** usando **Java**, **Maven**, **Rest Assured**,**Cucumber (BDD)** y **Serenity**, dentro del programa **QAX Real Experience** de **QAXpert**.

Este proyecto contiene la automatización de pruebas para el servicio de autenticación (login) de la plataforma QAX, utilizando **Java**, **Rest Assured**, **Cucumber (BDD)** y **Serenity Reports**.
## Objetivo

El objetivo es validar el comportamiento del endpoint de login de 1 aprendiz mediante distintos escenarios funcionales y negativos, asegurando la calidad del servicio.

## Alcance
En este repositorio se desarrollan automatizaciones orientadas a cubrir los siguientes casos:

- Login exitoso con credenciales válidas  
- Usuario no registrado  
- Credenciales inválidas  
- Campos obligatorios faltantes  
- Validación de formato  
- Validación de campos de respuesta

## Estructura base del proyecto

```
src
├── main
└── test
    ├── java
    │   └── com/qaxpert
    │       ├── config
    │       │   ├── Config.java
    │       │   └── Endpoints.java
    │       ├── models
    │       │   ├── AppMetaData.java
    │       │   └── Identity.java
	│       │   └── IdentityData.java
	│       │   └── LoginRequest.java
	│       │   └── LoginResponse.java
	│       │   └── User.java
	│       │   └── UserMetaData.java
    │       ├── runners
    │       │   └── LoginTestRunner.java
    │       ├── steps
    │       │   └── LoginSteps.java
    │       └── utils
    │           └── DataFactory.java
    └── resources
        └── features
            └── login.feature


```

## Instalación

- Java
- Maven instalado
- IntelliJ IDEA
- Rest Assured library added as a dependency
- Cucumber added as a dependency

---

## Ejecución

1. Localizar runners package
2. Localizar LoginTestRunner.java
3. Click derecho sobre la clase "LoginTestRunner"
4. Click en "Run LoginTestRunner" 

---

## Reportes

Después de ejecutar las pruebas, Cucumber genera automáticamente un reporte HTML con el detalle de la ejecución.

1. Navegar al directorio donde se espera que se cree el reporte
2. Localizar el folder "target"
3. Localizar el folder "cucumber-reports"
4. Localizar el file "login-report.html"
5. Arrastrar el archivo login-report.html al navegador (Chrome recomendado)
---

## Referencias
- [QAX Real Experience Wiki](https://github.com/QAX-Real-Experience/.github/wiki)
- [QAXpert](https://qaxpert.com)
