package tests.e2e;

import org.junit.Test;
import pages.RegistrationPage;
import pages.StartPage;
import tests.BaseTest;

import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static org.junit.Assert.assertEquals;

public class RegistrationWithInvalidDataTest extends BaseTest {
    StartPage startPage;
    RegistrationPage registrationPage;


/*    @After
    public void setup() {
        deleteRequest(teacherEmailForRegistration);
    }*/
    @Test
    public void cleanUp() {
        deleteUserRequest(teacherEmailForRegistration);
    }
/*    @Rule
    public TestWatcher watchman = new TestWatcher() {


        @Override
        protected void finished(Description description) {

            deleteRequest(teacherEmailForRegistration);
        }
    };*/

    @Test
    public void inputInvalidDataInFullNameInSignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(invalidUser);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("clear and descriptive validation notification", registrationPage.FAILURE_EXISTING_NOTIFICATION_SignUpForm());

    }

    @Test
    public void inputInvalidDataInEmailInSignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(invalidUser);
        registrationPage.fillInputPasswordSignUpForm(dataForRegistrationTeacher);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("clear and descriptive validation notification", registrationPage.FAILURE_EXISTING_NOTIFICATION_SignUpForm());

    }

    @Test
    public void inputInvalidDataInPasswordInSignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordSignUpForm(invalidUser);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("clear and descriptive validation notification", registrationPage.FAILURE_EXISTING_NOTIFICATION_SignUpForm());

    }

    @Test
    public void inputFiveCharactersInPasswordInSignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordWithQuantity(passwordQuantity_5);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("clear and descriptive validation notification", registrationPage.FAILURE_EXISTING_NOTIFICATION_SignUpForm());
    }

    @Test
    public void inputOneCharacterInPasswordInSignUpFormTest() {
        startPage = new StartPage(app.driver);
        startPage.clickHeaderSignUpButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectTeacherInDropdownInSignUpForm();
        registrationPage.fillInputFullNameSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputEmailSignUpForm(dataForRegistrationTeacher);
        registrationPage.fillInputPasswordWithQuantity(passwordQuantity_1);
        registrationPage.selectCheckBoxSignUpForm();
        registrationPage.clickSignUpButtonInSignUpForm();

        assertEquals("clear and descriptive validation notification", registrationPage.FAILURE_EXISTING_NOTIFICATION_SignUpForm());
    }
}

