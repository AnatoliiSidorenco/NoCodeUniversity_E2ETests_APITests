package tests.e2e;

import org.junit.Test;
import pages.AuthorizationPage;
import pages.StartPage;
import tests.BaseTest;

import static org.junit.Assert.assertEquals;

public class AuthorizationWithInvalidDataTest extends BaseTest {
    StartPage startPage;
    AuthorizationPage authorizationPage;

    @Test
    public void signInWithNonExistedUserTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputEmailSignInForm(nonRegisteredUser);
        authorizationPage.fillInputPasswordSignInForm(nonRegisteredUser);
        authorizationPage.clickSignInButtonInSignInForm();

        assertEquals("Invalid email or password", authorizationPage.errorMessageSignInForm());
    }

    @Test
    public void signInWithInvalidEmailTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputEmailSignInForm(nonRegisteredUser);
        authorizationPage.fillInputPasswordSignInForm(validTeacher);
        authorizationPage.clickSignInButtonInSignInForm();

        assertEquals("Invalid email or password", authorizationPage.errorMessageSignInForm());
    }

    @Test
    public void signInWithInvalidPasswordTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputEmailSignInForm(validTeacher);
        authorizationPage.fillInputPasswordSignInForm(nonRegisteredUser);
        authorizationPage.clickSignInButtonInSignInForm();

        assertEquals("Invalid email or password", authorizationPage.errorMessageSignInForm());
    }
}
