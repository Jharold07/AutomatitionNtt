package com.nttdata.tasks;

import com.nttdata.pages.HomePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarUsuario implements Task {

    private final String user;
    private final String pass;

    public RegistrarUsuario(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public static RegistrarUsuario with(String user, String pass){
        return Tasks.instrumented(RegistrarUsuario.class, user, pass);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(HomePage.LNK_SIGN_UP),
                Click.on(HomePage.LNK_SIGN_UP),
                WaitUntil.the(HomePage.MODAL_SIGN_UP, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue(user).into(HomePage.INP_SIGNUP_USER),
                Enter.theValue(pass).into(HomePage.INP_SIGNUP_PASS),
                Click.on(HomePage.BTN_SIGNUP)
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        Serenity.setSessionVariable("alertText").to(alert.getText());
        alert.accept();
    }
}
