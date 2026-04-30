Feature: Hacer login en la pagina web
  Como Aprendiz
  Quiero validar el servicio de authentication a la plataforma QAX
  Para acceder a mi cuenta

  Scenario: 1 Login exitoso con credenciales válidas
    Given que existe un aprendiz con credenciales validas
    When envío email y password valido
    Then la respuesta debe tener un status 200
    And la respuesta debe contener access_token
    And la respuesta debe contener refresh_token
    And la respuesta debe contener los datos completos del usuario

  Scenario: 2 Login con usuario no registrado
    Given que el usuario no está registrado
    When envío email y password con formato valido
    Then la respuesta debe tener un status 400
    And la respuesta debe mostrar un msg "Invalid login credentials"

  Scenario: 3 Validación de login exitoso (OK)
    When envío email y password valido
    Then la respuesta debe tener un status 200
    And la respuesta debe contener token_type "bearer"

  Scenario: 4 Login con formato inválido
    When envío email y password con formato inválido
    Then la respuesta debe tener un status 400
    And la respuesta debe mostrar un msg "Invalid login credentials"

  Scenario: 5 Login solo con email
    When envío únicamente el email válido
    Then la respuesta debe tener un status 400
    And la respuesta debe mostrar un msg "Password is required"

  Scenario: 6 Login solo con password
    When envío únicamente el password válido
    Then la respuesta debe tener un status 400
    And la respuesta debe mostrar un msg "Email is required"

  Scenario: 7 Login solo con email sin role
    When envío solo el email
    Then la respuesta debe mostrar un msg "Invalid login credentials"

  Scenario: 8 Login solo con password sin role
    When envío solo el password
    Then la respuesta debe mostrar un msg "Invalid login credentials"

  Scenario: Validación completa de tokens y datos
    When envío email y password valido
    Then la respuesta debe contener access_token
    And la respuesta debe contener refresh_token
    And la respuesta debe contener los campos de los datos completos del usuario
