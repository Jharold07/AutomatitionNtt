package com.nttdata.tasks;

import com.nttdata.pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavegarA {
    public static Performable demoblaze() {
        return Task.where("{0} abre Demoblaze", Open.browserOn().the(HomePage.class));
    }
}