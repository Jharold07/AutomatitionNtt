@Demoblaze @Registro
Feature: Registro en Demoblaze
  Como visitante quiero crear una cuenta

  Scenario Outline: Registro válido
    Given que el actor abre Demoblaze
    When se registra con el usuario "<usuario>" y password "<password>"
    Then veo el mensaje de registro exitoso

    Examples:
      | usuario | password |
      | Jharold | 123      |