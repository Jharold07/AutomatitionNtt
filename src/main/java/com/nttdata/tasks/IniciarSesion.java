package com.nttdata.tasks;

import com.nttdata.pages.HomePage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesion implements Task {

    private final String user;
    private final String pass;

    public IniciarSesion(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public static IniciarSesion with(String user, String pass){
        return Tasks.instrumented(IniciarSesion.class, user, pass);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(HomePage.LNK_LOG_IN),
                Click.on(HomePage.LNK_LOG_IN),
                WaitUntil.the(HomePage.MODAL_LOG_IN, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue(user).into(HomePage.INP_LOGIN_USER),
                Enter.theValue(pass).into(HomePage.INP_LOGIN_PASS),
                Click.on(HomePage.BTN_LOGIN),

                WaitUntil.the(HomePage.LBL_WELCOME_USER, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}