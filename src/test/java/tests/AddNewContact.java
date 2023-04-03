package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
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
        int i = new Random().nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("65894721"+i)
                .email("ron" + i + "@gmail.com")
                .address("TA")
                .description("friend")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.HelperContact().isContactAddedByPhone(contact.getPhone()));
    }
    @Test
    public void addNewContactSuccess(){
        int i = new Random().nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Ron"+i)
                .lastName("Zak")
                .phone("87456982" + i)
                .email("ron" + i + "@gmail.com")
                .address("TA")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.HelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("Zak")
                .phone("8745698234")
                .email("ron@gmail.com")
                .address("TA")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void  addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("8745698234")
                .email("ron@gmail.com")
                .address("")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("")
                .phone("8745698234")
                .email("ron@gmail.com")
                .address("NY")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("")
                .email("ron@gmail.com")
                .address("NY")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }
    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("8745698234")
                .email("starkgmail.com")
                .address("NY")
                .build();
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));

    }

}
