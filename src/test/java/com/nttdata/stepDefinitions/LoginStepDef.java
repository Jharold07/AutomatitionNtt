package com.nttdata.stepDefinitions;

import com.nttdata.questions.LoginQuestion;
import com.nttdata.tasks.IniciarSesion;
import io.cucumber.java.en.And;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDef {

    @Cuando("inicia sesión con el usuario {string} y password {string}")
    public void inicia_sesion_con_el_usuario_y_password(String usuario, String password) {
        if ("AUTO".equalsIgnoreCase(usuario)) {
            usuario = Serenity.sessionVariableCalled("user");
            password = Serenity.sessionVariableCalled("pass");
        }
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.with(usuario, password)
        );
    }

    @Entonces("veo el saludo de bienvenida con el usuario {string}")
    public void veo_el_saludo_de_bienvenida_con_el_usuario(String usuario) {
        if ("AUTO".equalsIgnoreCase(usuario)) {
            usuario = Serenity.sessionVariableCalled("user");
        }
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginQuestion.value(), containsString(usuario))
        );
    }


}


