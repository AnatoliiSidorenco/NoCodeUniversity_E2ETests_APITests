package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class AuthorizationPage extends BasePage {

    Wait wait;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sw-form-capture-email-input")
    private WebElement emailInputSignInElement;
    @FindBy(id = "sw-form-password-input")
    private WebElement passwordInputSignInElement;
    @FindBy(xpath = "(//i)[1]")
    private WebElement eyeIconPasswordSignInForm;
    @FindBy(css = "a[href='/forgot-password']")
    private WebElement forgotPasswordLinkElement;
    @FindBy(id = "sw-sign-in-submit-btn")
    private WebElement signInButtonSignInFormElement;
    @FindBy(id = "sw-go-to-sign-up-btn")
    private WebElement signUpButtonSignInFormElement;
    @FindBy(css = "[class='error-message login-error d-block']")
    private WebElement errorMessageSignInElement;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(emailInputSignInElement);
    }

    public void fillInputEmailSignInForm(User user) {
        emailInputSignInElement.sendKeys(user.getEmail());
    }

    public void fillInputPasswordSignInForm(User user) {
        passwordInputSignInElement.sendKeys(user.getPassword());
    }

    public void clickSignInButtonInSignInForm() {
        signInButtonSignInFormElement.click();
    }

    public void clickSignUpButtonInSignInForm() {
        signUpButtonSignInFormElement.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLinkElement.click();
    }

    public void clickOnEyeInPasswordFieldSignInForm() {
        eyeIconPasswordSignInForm.click();
    }

    public boolean passwordCheckMaskedSignInForm() {
        String text = "password";
        String textAttribute = passwordInputSignInElement.getAttribute("type");
        return text.equals(textAttribute);
    }

    public boolean passwordCheckNotMaskedSignInForm() {
        String text = "text";
        String textAttribute = passwordInputSignInElement.getAttribute("type");
        return text.equals(textAttribute);
    }

    public boolean isCopyingDisabledSignInForm(String password) throws IOException, UnsupportedFlavorException {

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);

        passwordInputSignInElement.sendKeys(password);
        passwordInputSignInElement.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String copiedText = (String) contents.getTransferData(DataFlavor.stringFlavor);

        return copiedText == null || copiedText.isEmpty();
    }

    public boolean isCuttingDisabledSignInForm(String password) throws IOException, UnsupportedFlavorException {

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);
        passwordInputSignInElement.sendKeys(password);
        passwordInputSignInElement.sendKeys(Keys.CONTROL + "x");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String carvedText = (String) contents.getTransferData(DataFlavor.stringFlavor);

        return carvedText == null || carvedText.isEmpty();
    }

    public boolean emailInSignInFormIsVisible() {

        return emailInputSignInElement.isDisplayed();
    }

    public String errorMessageSignInForm() {
        wait.forVisibility(errorMessageSignInElement);
        return errorMessageSignInElement.getText();
    }


}
