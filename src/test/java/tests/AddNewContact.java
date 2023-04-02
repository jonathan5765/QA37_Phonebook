package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase{
    @BeforeClass
    public void preCondition() {
        //if Logout present ---> login
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("tirex@gmail.com").setPassword("Rr12345$"));
        }
    }

    @Test
    public void addNewContactSuccessAll(){
        int i = new Random().nextInt(1000)+1000000000;
        int z = new Random().nextInt(1000);
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone(i)
                .email("ron" + z + "@gmail.com")
                .address("TA")
                .description("friend")
                .build();
        app.getHelperContact().openAddNewContactForm();
        app.getHelperContact().fillAddNewContactForm(contact);
        app.getHelperContact().saveNewContact();
    }
    @Test
    public void addNewContactSuccess(){
        int i = new Random().nextInt(1000)+1000000000;
        int z = new Random().nextInt(1000);
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone(i)
                .email("ron" + z + "@gmail.com")
                .address("TA")
                .build();
        app.getHelperContact().openAddNewContactForm();
        app.getHelperContact().fillAddNewContactForm(contact);
        app.getHelperContact().saveNewContact();
    }

}
