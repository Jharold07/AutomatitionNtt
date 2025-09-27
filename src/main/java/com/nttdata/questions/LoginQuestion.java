package com.nttdata.questions;

import com.nttdata.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginQuestion implements Question<String> {
    public static LoginQuestion value(){ return new LoginQuestion(); }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePage.LBL_WELCOME_USER).answeredBy(actor);
    }
}