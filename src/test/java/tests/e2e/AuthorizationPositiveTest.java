package tests.e2e;

import org.junit.Test;
import pages.*;
import tests.BaseTest;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class AuthorizationPositiveTest extends BaseTest {
    StartPage startPage;
    AuthorizationPage authorizationPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;

    RegistrationPage registrationPage;

    @Test
    public void successAuthorizationAsTeacherTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputEmailSignInForm(validTeacher);
        authorizationPage.fillInputPasswordSignInForm(validTeacher);
        authorizationPage.clickSignInButtonInSignInForm();

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();

        assertTrue(homePage.getTextForTeacher().contains("As a teacher"));
    }

    @Test
    public void successAuthorizationAsStudentTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputEmailSignInForm(validStudent);
        authorizationPage.fillInputPasswordSignInForm(validStudent);
        authorizationPage.clickSignInButtonInSignInForm();

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();

        assertTrue(homePage.getTextForStudent().contains("As a student"));
    }

    @Test
    public void checkForgotPasswordTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickForgotPasswordLink();

        forgotPasswordPage = new ForgotPasswordPage(app.driver);
        assertTrue(forgotPasswordPage.recoverPasswordButton());
    }

    @Test
    public void passwordInvisibilitySignInFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputPasswordSignInForm(validStudent);

        assertTrue(authorizationPage.passwordCheckMaskedSignInForm());
    }

    @Test
    public void passwordVisibilitySignInFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.fillInputPasswordSignInForm(validStudent);
        authorizationPage.clickOnEyeInPasswordFieldSignInForm();

        assertTrue(authorizationPage.passwordCheckNotMaskedSignInForm());
    }

    @Test
    public void disabledCopyForHiddenPasswordSignInFormTest() throws IOException, UnsupportedFlavorException {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();

        assertTrue(authorizationPage.isCopyingDisabledSignInForm(validStudentPassword));
    }

    @Test
    public void disabledCutForHiddenPasswordSignInFormTest() throws IOException, UnsupportedFlavorException {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();

        assertTrue(authorizationPage.isCuttingDisabledSignInForm(validStudentPassword));
    }

    @Test
    public void checkSignUpButtonInSignInFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignInButton();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickSignUpButtonInSignInForm();

        registrationPage = new RegistrationPage(app.driver);
        assertTrue(registrationPage.signUpFormIsVisible());
    }
}
