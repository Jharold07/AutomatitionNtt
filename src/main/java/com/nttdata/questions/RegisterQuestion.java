package com.nttdata.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;


@AllArgsConstructor
public class RegisterQuestion implements Question<String> {

    private final Target item;

    public static RegisterQuestion visibleEn(Target item){
        return new RegisterQuestion((item));
    }

    @Override
    public String answeredBy(Actor actor){
        return Text.of(item).answeredBy(actor);
    }
}
