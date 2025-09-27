package com.nttdata.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegisterQuestion implements Question<String> {
    public static RegisterQuestion alertText(){ return new RegisterQuestion(); }
    @Override
    public String answeredBy(Actor actor) {
        return Serenity.sessionVariableCalled("alertText"); // guardado por la Task
    }
}