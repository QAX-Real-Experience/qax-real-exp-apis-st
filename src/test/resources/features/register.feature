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
      | email          | password | fullname   | country  | whatsapp     | statusCode | message                                           |
      |                | 12345678 | Juan Perez | Colombia | +573001112233 | 422        | Anonymous sign-ins are disabled                  |
      | random         |          | Juan Perez | Colombia | +573001112233 | 400        | Signup requires a valid password                 |
      | random         | 12345678 |            | Colombia | +573001112233 | 400        | Full name is required                            |
      | random         | Test1234 | Juan Perez |          | +573001112233 | 400        | Country is required                              |
      | random         | Test1234 | Juan Perez | Colombia |               | 400        | Whatsapp is required                             |
      | email-invalid  | Test1234 | Juan Perez | Colombia | +573001112233 | 400        | Unable to validate email address: invalid format |
      | random         | 123@     | Juan Perez | Colombia | +573001112233 | 422        | Password should be at least 6 characters.        |
      | random         | Test1234 | Juan Perez | Colombia | AA73001112233 | 400        | Invalid whatsapp format                          |

  Scenario: 3 No permitir registrar usuario con correo existente
    Given que ya existe un usuario registrado con un correo definido
    When envio la solicitud de registro
    Then la respuesta debe tener un status 422
    And la respuesta debe mostrar un mensaje de validacion "User already registered"