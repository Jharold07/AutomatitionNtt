package com.nttdata.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage extends PageObject {

    public static final Target INP_FIRST_NAME = Target.the("Campo de texto para el nombre")
            .located(By.xpath("//input[@id='first_name'][1]"));

    public static final Target INP_LAST_NAME = Target.the("Campo de texto para el apellido")
            .located(By.xpath("//input[@id='last_name']"));

    public static final Target INP_EMAIL = Target.the("Campo de texto para el email")
            .located(By.xpath("//input[@id='email']"));

    public static final Target INP_CONTRASENIA = Target.the("Campo de texto para la contraseña")
            .located(By.xpath("//input[@id='password']"));

    public static final Target BTN_CREAR_USUARIO = Target.the("Boton para crear usuario")
            .located(By.xpath("//input[@type=\"submit\" and @value=\"Create\"]"));
}
