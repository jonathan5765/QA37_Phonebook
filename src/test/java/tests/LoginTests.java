package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        //if SignOut present ---> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }

    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Start test with name 'loginSuccess'");
       // logger.info("Test data --> email:'tirex@gmail.com' & 'Rr12345$'");
        logger.info("Test data --> email:"+email+" & password: "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        //time--->signOut

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");


    }


    @Test(dataProvider = "loginModels",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data --> " +user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }
    @Test(dataProvider = "loginFile",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Test data --> " +user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test(groups = {"smoke"})
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
