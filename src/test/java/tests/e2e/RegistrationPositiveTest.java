package tests.e2e;

import api.utils.ValidDataUtils;
import org.junit.Test;
import pages.*;
import tests.BaseTest;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationPositiveTest extends BaseTest {

    StartPage startPage;
    RegistrationPage registrationPage;
    AuthorizationPage authorizationPage;
    HomePage homePage;
    PrivacyPolicyPage privacyPolicyPage;
    TermsPage termsPage;
    ValidDataUtils validDataUtils;

    @Test
    public void successRegistrationAsTeacherTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();

        assertTrue(homePage.getTextForTeacher().contains("As a teacher"));

        validDataUtils = new ValidDataUtils();
        validDataUtils.deleteUser(200, dataForRegistrationTeacher.getEmail());
    }

    @Test
    public void successRegistrationAsStudentTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectStudentInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationStudent);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationStudent);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationStudent);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();

        assertTrue(homePage.getTextForStudent().contains("As a student"));

        validDataUtils = new ValidDataUtils();
        validDataUtils.deleteUser(200, dataForRegistrationStudent.getEmail());
    }

    @Test
    public void checkTermsLinkTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.clickTerms();
        registrationPage.switchToWindow();

        termsPage = new TermsPage(app.driver);

        assertEquals("Terms and Conditions for the Use of the Softr Platform", termsPage.checkTerms());
    }

    @Test
    public void checkPrivacyPolicyLinkTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.clickPrivacyPolicy();
        registrationPage.switchToWindow();

        privacyPolicyPage = new PrivacyPolicyPage(app.driver);

        assertEquals("Privacy Policy", privacyPolicyPage.checkPrivacyPolicyElement());
    }

    @Test
    public void passwordInvisibilitySignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);

        assertTrue(registrationPage.passwordCheckMaskedSignUpForm());
    }

    @Test
    public void passwordVisibilitySignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.clickCrossedEye();

        assertTrue(registrationPage.passwordCheckNotMaskedSignUpForm());
    }

    @Test
    public void disabledCopyForHiddenPasswordSignInFormTest() throws IOException, UnsupportedFlavorException {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();

        assertTrue(registrationPage.isCopyingDisabledSignUpForm(validStudentPassword));
    }

    @Test
    public void disabledCutForHiddenPasswordSignInFormTest() throws IOException, UnsupportedFlavorException {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();

        assertTrue(registrationPage.isCuttingDisabledSignUpForm(validStudentPassword));
    }

    @Test
    public void checkSignInButtonInSignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.clickSignInButtonSignUpForm();

        authorizationPage = new AuthorizationPage(app.driver);
        assertTrue(authorizationPage.emailInSignInFormIsVisible());
    }
}
