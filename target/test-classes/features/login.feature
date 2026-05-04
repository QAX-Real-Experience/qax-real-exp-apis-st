Feature: Hacer login en la pagina web
  Como Aprendiz
  Quiero validar el servicio de authentication a la plataforma QAX
  Para acceder a mi cuenta

  Scenario: 1 Login exitoso con credenciales válidas
    Given que existe un aprendiz con credenciales validas
    When envio la solicitud de login
    Then la respuesta debe tener un status 200
    And la respuesta debe contener access_token
    And la respuesta debe contener refresh_token
    And la respuesta debe contener token_type "bearer"
    And la respuesta debe contener los datos completos del usuario

  Scenario: 2 Login con usuario no registrado
    Given que el usuario no está registrado
    When envio la solicitud de login
    Then la respuesta debe tener un status 400
    And la respuesta debe mostrar un msg "Invalid login credentials"


  Scenario Outline: 3 Validar errores de login con credenciales inválidas
    Given que intento iniciar sesion con email "<email>" y password "<password>"
    When envio la solicitud de login
    Then la respuesta debe tener un status <statusCode>
    And la respuesta debe mostrar un msg "<message>"

    Examples:
      | email              | password  | statusCode | message         |
      | wrong@test.com     | 123456    | 400        | Invalid login credentials  |
      | user@test.com      | wrongpass | 400        | Invalid login credentials  |
      |                    | 123456    | 400        | missing email or phone   |
      | user@test.com      |           | 400        | Invalid login credentials  |
      |                    |           | 400        | missing email or phone  |
