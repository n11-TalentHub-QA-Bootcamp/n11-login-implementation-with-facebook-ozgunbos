package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

import starter.n11facebook.login.LoginAsClient;
import starter.n11facebook.tasks.NavigateTo;
import starter.n11facebook.user_interface.n11LoginPageElements;
import starter.n11facebook.user_interface.n11UserHomePageElements;

import java.util.Iterator;
import java.util.Set;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.n11facebook.tasks.NavigateTo.theParent;

public class n11FacebookStepDefinitions {

    Actor actor = Actor.named("n11FacebookActor");
    String getHandle;
    @Managed
    WebDriver webDriver;

    //String windHandleBefore = webDriver.getWindowHandle();


    @Given("user launch browser and open the main page")
    public void userLaunchBrowserAndOpenTheMainPage() {


        actor.can(BrowseTheWeb.with(webDriver));

        // ilerde driver referansı lazım olabilir diye tutuyorum
        getHandle = webDriver.getWindowHandle();

        actor.wasAbleTo(NavigateTo.theN11HomePage());


    }

    @When("user logged in with facebook login auth")
    public void userLoggedInWithFacebookLoginAuth() {

        actor.attemptsTo(


                LoginAsClient.loginThePage("facebook hesabın kullanıcı adı","facebook hesabın şifresi"));
   }

    @Then("user logged in successfully")
    public void userLoggedInSuccessfully() {

        actor.attemptsTo(
                //theParent(getHandle),


                Ensure.that(n11UserHomePageElements.USERNAME_LINK).isDisplayed(),
                Ensure.that(n11UserHomePageElements.USERNAME_LINK).text().contains("Özgün")

        );

    }
}
