package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[type='button']")
    private WebElement recoverPasswordButtonElement;

    public boolean recoverPasswordButton(){
        Wait wait = new Wait(driver);
        wait.forVisibility(recoverPasswordButtonElement);
        return recoverPasswordButtonElement.isDisplayed();
    }
}
