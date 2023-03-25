package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        //if SignOut present ---> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        User user = new User().setEmail("tor" + i + "@gmail.com")
                .setPassword("Tor12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");

    }
    @Test
    public void registrationWrongIsPresent() {

        User user = new User().setEmail("tor1@gmail.com")
                .setPassword("Rr12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }
    @Test
    public void registrationWrongEmail() {

        User user = new User().setEmail("tor1gmail.com")
                .setPassword("Rr12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();


        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }



}
