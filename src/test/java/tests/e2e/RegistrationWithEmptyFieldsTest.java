package tests.e2e;

import org.junit.Test;
import pages.RegistrationPage;
import pages.StartPage;
import tests.BaseTest;

import static org.junit.Assert.assertEquals;

public class RegistrationWithEmptyFieldsTest extends BaseTest {
    StartPage startPage;
    RegistrationPage registrationPage;

    @Test
    public void signUpWithEmptyFieldsTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageEmptyFieldsSignUpForm());
    }

    @Test
    public void signUpWithEmptyFieldRoleTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageEmptyFieldsSignUpForm());
    }

    @Test
    public void signUpWithEmptyFieldFullNameTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageEmptyFieldsSignUpForm());
    }

    @Test
    public void signUpWithEmptyFieldEmailTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageEmptyFieldsSignUpForm());
    }

    @Test
    public void signUpWithEmptyFieldPasswordTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageEmptyFieldsSignUpForm());
    }

    @Test
    public void signUpWithNotSelectedCheckBoxTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageEmptyFieldsSignUpForm());
    }
}
