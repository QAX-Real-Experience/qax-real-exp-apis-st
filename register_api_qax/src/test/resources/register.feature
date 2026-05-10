Feature: Registro de usuario mediante API

  Como usuario nuevo
  Quiero registrarme mediante un servicio
  Para crear una cuenta dentro de la plataforma

  Scenario: 1 Registrar usuario nuevo exitosamente
    Given que tengo los datos obligatorios de un usuario nuevo
    When envio la solicitud de registro
    Then la respuesta debe tener un status 200
    And la respuesta debe contener el user_id del usuario registrado
    And la respuesta debe contener los datos principales del usuario registrado

  Scenario Outline: 2 Validar errores al registrar usuario con datos invalidos o incompletos
    Given que intento registrar un usuario con email "<email>", password "<password>", nombre completo "<fullname>", pais "<country>" y whatsapp "<whatsapp>"
    When envio la solicitud de registro
    Then la respuesta debe tener un status <statusCode>
    And la respuesta debe mostrar un mensaje de validacion "<message>"

    Examples:
      | email          | password | fullname   | country  | whatsapp     | statusCode | message                 |
      |                | Test1234 | Juan Perez | Colombia | 573001112233 | 400        | Email is required       |
      | test@email.com |          | Juan Perez | Colombia | 573001112233 | 400        | Password is required    |
      | test@email.com | Test1234 |            | Colombia | 573001112233 | 400        | Full name is required   |
      | test@email.com | Test1234 | Juan Perez |          | 573001112233 | 400        | Country is required     |
      | test@email.com | Test1234 | Juan Perez | Colombia |              | 400        | Whatsapp is required    |
      | email-invalido | Test1234 | Juan Perez | Colombia | 573001112233 | 400        | Invalid email format    |
      | test@email.com | 123      | Juan Perez | Colombia | 573001112233 | 400        | Invalid password format |
      | test@email.com | Test1234 | Juan Perez | Colombia | abc123       | 400        | Invalid whatsapp format |

  Scenario: 3 No permitir registrar usuario con correo existente
    Given que ya existe un usuario registrado con un correo definido
    When envio la solicitud de registro
    Then la respuesta debe tener un status 400
    And la respuesta debe mostrar un mensaje de validacion "User already exists"