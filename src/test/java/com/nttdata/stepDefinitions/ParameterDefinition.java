package com.nttdata.stepDefinitions;

import com.nttdata.tasks.NavegarA;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ParameterDefinition {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("que el actor abre Demoblaze")
    public void que_el_actor_abre_demoblaze() {
        OnStage.theActorCalled("QA").attemptsTo(NavegarA.demoblaze());
    }
}