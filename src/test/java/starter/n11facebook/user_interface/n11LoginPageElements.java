package starter.n11facebook.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class n11LoginPageElements {
    public static Target EMAIL_FIELD = Target.the("email textbox").located(By.id("email"));
    public static Target PASSWORD_FIELD = Target.the("pass textbox").located(By.id("pass"));
    public static Target LOGIN_BTN = Target.the("login btn").located(By.id("loginButton"));
    public static Target FB_BTN = Target.the("facebook btn").locatedBy(".facebook_large.medium.facebookBtn.btnLogin");
    public static Target ACCESS_TEXT = Target.the("Access request").locatedBy(".f10w8fjw");
    public static Target ALLOW_ACCESS = Target.the("Allow request").locatedBy(".rj1gh0hx.buofh1pr");

}
