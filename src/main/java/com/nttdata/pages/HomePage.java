package com.nttdata.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://sauce-demo.myshopify.com/")
public class HomePage extends PageObject {

    // SIGN UP

    public static final Target ITM_SIGN_UP = Target.the("Item para ir a iniciar sesion")
            .located(By.id("customer_register_link"));

    // MY ACCOUNT

    public static final Target ITM_MY_ACCOUNT = Target.the("Item para ir a Mi Cuenta")
            .located(By.xpath("//a[text()='My Account']"));
}
