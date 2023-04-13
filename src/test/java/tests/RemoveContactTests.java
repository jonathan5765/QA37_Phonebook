package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if Logout present ---> login
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("tirex@gmail.com").setPassword("Rr12345$"));
        }
        app.HelperContact().provideContacts();//if list < 3 ==> add 3 contacts
    }
    @Test
    public void removeFirstContact(){

        Assert.assertEquals(app.HelperContact().removeOneContact(),1);

    }
    @Test
    public void removeAllContacts(){

        app.HelperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");
        //Assert



    }
}
