package com.nttdata.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    // Navbar selector
    public static final Target LNK_SIGN_UP = Target.the("Sign up link")
            .located(By.id("signin2"));
    public static final Target LNK_LOG_IN = Target.the("Log in link")
            .located(By.id("login2"));

    // Ver Modales visibles
    public static final Target MODAL_SIGN_UP = Target.the("Sign up modal visible")
            .located(By.xpath("//div[@id='signInModal' and contains(@class,'show')]"));
    public static final Target MODAL_LOG_IN = Target.the("Log in modal visible")
            .located(By.xpath("//div[@id='logInModal' and contains(@class,'show')]"));

    // iniciar
    public static final Target INP_SIGNUP_USER = Target.the("Sign up username")
            .located(By.id("sign-username"));
    public static final Target INP_SIGNUP_PASS = Target.the("Sign up password")
            .located(By.id("sign-password"));
    public static final Target BTN_SIGNUP = Target.the("Sign up button")
            .located(By.xpath("//button[text()='Sign up']"));

    // Logear
    public static final Target INP_LOGIN_USER = Target.the("Login username")
            .located(By.id("loginusername"));
    public static final Target INP_LOGIN_PASS = Target.the("Login password")
            .located(By.id("loginpassword"));
    public static final Target BTN_LOGIN = Target.the("Log in button")
            .located(By.xpath("//button[text()='Log in']"));

    // Post login
    public static final Target LBL_WELCOME_USER = Target.the("Welcome user label")
            .located(By.id("nameofuser"));
}