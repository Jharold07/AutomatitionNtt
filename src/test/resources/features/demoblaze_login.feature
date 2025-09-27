@Demoblaze @Login
Feature: Inicio de sesión en Demoblaze
  Como usuario registrado quiero iniciar sesión

  Background:
    Given que el actor abre Demoblaze

  Scenario Outline: Login válido
    And existe el usuario "<usuario>" con password "<password>"
    When inicia sesión con el usuario "<usuario>" y password "<password>"
    Then veo el saludo de bienvenida con el usuario "<usuario>"

    Examples:
      | usuario        | password |
      | qa_login_user  | 12345    |