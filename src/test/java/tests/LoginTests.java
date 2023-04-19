package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        //if SignOut present ---> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }

    }

    @Test
    public void loginSuccess() {
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data --> email:'tirex@gmail.com' & 'Rr12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("tirex@gmail.com", "Rr12345$");
        app.getHelperUser().submitLogin();
        //time--->signOut

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data --> email:'tirex@gmail.com' & 'Rr12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("tirex@gmail.com", "Rr12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data --> email:'tirexgmail.com' & 'Rr12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("tirexgmail.com", "Rr12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");


    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data --> email:'tirex@gmail.com' & 'Rr12345'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("tirex@gmail.com", "Rr12");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data --> email:'tir@gmail.com' & 'Pp12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("tir@gmail.com", "Pp12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }
}
