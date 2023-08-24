package tests.e2e;

import api.utils.ValidDataUtils;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.StartPage;
import tests.BaseTest;

import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static org.junit.Assert.assertEquals;

public class RegistrationWithSameDataTwiceTest extends BaseTest {
    StartPage startPage;
    AuthorizationPage authorizationPage;
    RegistrationPage registrationPage;
    HomePage homePage;
    ValidDataUtils validDataUtils;

    @Test
    public void signUpWithDataOfRegisteredTeacherTest() {
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
        homePage.selectTeacherSignOut();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickSignUpButtonInSignInForm();

        registrationPage.waitForLoading();
        registrationPage.selectStudentInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Something went wrong, please try again.", registrationPage.errorMessageSignUpWithExistedUser());

        deleteUserRequest(teacherEmailForRegistration);
    }

    @Test
    public void signUpWithDataOfRegisteredStudentTest() {
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
        homePage.selectStudentSignOut();

        authorizationPage = new AuthorizationPage(app.driver);
        authorizationPage.waitForLoading();
        authorizationPage.clickSignUpButtonInSignInForm();

        registrationPage.waitForLoading();
        registrationPage.selectStudentInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationStudent);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationStudent);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationStudent);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("Something went wrong, please try again.", registrationPage.errorMessageSignUpWithExistedUser());

        deleteUserRequest(studentEmailForRegistration);
    }
}
