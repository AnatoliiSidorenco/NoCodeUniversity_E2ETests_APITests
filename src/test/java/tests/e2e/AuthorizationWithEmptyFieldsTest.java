package tests.e2e;

import org.junit.Test;
import pages.AuthorizationPage;
import pages.StartPage;
import tests.BaseTest;

import static org.junit.Assert.assertEquals;

public class AuthorizationWithEmptyFieldsTest extends BaseTest {

    StartPage startPage;
    AuthorizationPage authorizationPage;

    @Test
    public void signInWithEmptyFieldsTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickSignInButtonInSignInForm();

        assertEquals("Invalid email or password", authorizationPage.errorMessageSignInForm());
    }

    @Test
    public void signInWithEmptyFieldEmailTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputPasswordSignInForm(validTeacher);
        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickSignInButtonInSignInForm();

        assertEquals("Invalid email or password", authorizationPage.errorMessageSignInForm());
    }

    @Test
    public void signInWithEmptyFieldPasswordTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputEmailSignInForm(validTeacher);
        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickSignInButtonInSignInForm();

        assertEquals("Invalid email or password", authorizationPage.errorMessageSignInForm());
    }
}
