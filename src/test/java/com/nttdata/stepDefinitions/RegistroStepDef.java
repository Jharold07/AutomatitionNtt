package com.nttdata.stepDefinitions;

import com.nttdata.questions.RegisterQuestion;
import com.nttdata.tasks.RegistrarUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistroStepDef {

    @Cuando("se registra con el usuario {string} y password {string}")
    public void se_registra_con_el_usuario_y_password(String usuario, String password) {
        if ("AUTO".equalsIgnoreCase(usuario)) {
            usuario = "qa_" + System.currentTimeMillis();
        }
        Serenity.setSessionVariable("user").to(usuario);
        Serenity.setSessionVariable("pass").to(password);

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarUsuario.with(usuario, password)
        );
    }

    @Entonces("veo el mensaje de registro exitoso")
    public void veo_el_mensaje_de_registro_exitoso() {
        String alert = RegisterQuestion.alertText().answeredBy(OnStage.theActorInTheSpotlight());
        assertThat(alert.toLowerCase()).contains("sign up");
    }
}