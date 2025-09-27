package com.nttdata.stepDefinitions;

import com.nttdata.pages.HomePage;
import com.nttdata.questions.RegisterQuestion;
import com.nttdata.tasks.NavegarA;
import com.nttdata.tasks.RegistrarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;


public class RegistrarUsuarioStepDef {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} esta en la pagina de inicio de Shopify")
    public void elActorEstaEnLaPaginaDeInicioDeShopify(Actor actor) {
        actor.attemptsTo(NavegarA.theHomePage());
    }

    @And("selecciona el item de registrar usuario")
    public void seleccionaElItemDeRegistrarUsuario() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.ITM_SIGN_UP));
    }

    @When("se registra ingresando nombre {string} apellido {string} email {string} y contrasenia {string}")
    public void seRegistraIngresandoNombreApellidoEmailYContrasenia(String nombre, String apellido, String email, String contrasenia) {
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.withData(nombre, apellido, email, contrasenia));
    }

    @Then("se realiza el registro del usuario de manera exitosa")
    public void seRealizaElRegistroDelUsuarioDeManeraExitosa() {
        //theActorInTheSpotlight().should(seeThat("Se muestra el item My Account", RegisterQuestion.visibleEn(HomePage.ITM_MY_ACCOUNT)));
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(HomePage.ITM_MY_ACCOUNT, isVisible()).forNoMoreThan(30).seconds());
        theActorInTheSpotlight().should(seeThat(RegisterQuestion.visibleEn(HomePage.ITM_MY_ACCOUNT), equalTo("My Account")));
    }


}
