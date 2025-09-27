package com.nttdata.tasks;

import com.nttdata.pages.RegisterPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

@AllArgsConstructor
public class RegistrarUsuario implements Task {

    private final String nombre;
    private final String apellido;
    private final String email;
    private final String contrasenia;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(RegisterPage.INP_FIRST_NAME),
                Enter.theValue(apellido).into(RegisterPage.INP_LAST_NAME),
                Enter.theValue(email).into(RegisterPage.INP_EMAIL),
                Enter.theValue(contrasenia).into(RegisterPage.INP_CONTRASENIA),
                Click.on(RegisterPage.BTN_CREAR_USUARIO)
        );
    }

    public static Performable withData(String nombre, String apellido, String email, String contrasenia){
        return new RegistrarUsuario(nombre, apellido, email, contrasenia);
    }
}
