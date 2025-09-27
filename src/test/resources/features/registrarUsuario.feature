@HU01-RegistrarUsuario
Feature: Registrar un usuario en la pagina web de shopify

  @ESC01 @HappyPath @RegistrarUsuario
  Scenario Outline: Registrar un usuario con datos validos de manera exitosa
    Given el actor esta en la pagina de inicio de Shopify
    And selecciona el item de registrar usuario
    When se registra ingresando nombre "<nombre>" apellido "<apellido>" email "<email>" y contrasenia "<contrasenia>"
    Then se realiza el registro del usuario de manera exitosa

    Examples:
      | nombre | apellido | email               | contrasenia |
      | Mario  | Gomez    | mgomez@nttdata.com  | mgomez123   |
      | Luis   | Davila   | ldavila@nttdata.com | ldavila123  |

