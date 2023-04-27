package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase {
    @BeforeClass
    public void preCondition() {
        //if Logout present ---> login
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("tirex@gmail.com").setPassword("Rr12345$"));
            logger.info("Before method is present login");
        }
    }

    @Test(dataProvider = "contactSuccess", dataProviderClass = DataProviderContact.class)
    public void addNewContactSuccessAll(Contact contact) {
        logger.info("Start test with name 'addNewContactSuccess'");
        logger.info("Test data --> ");

        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        //add pause
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.HelperContact().isContactAddedByPhone(contact.getPhone()));
        logger.info("Assert check is the new Contact present");
    }

    @Test
    public void addNewContactSuccess() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("RonReq" + i)
                .lastName("Zak")
                .phone("87456982" + i)
                .email("ron" + i + "@gmail.com")
                .address("TA")
                .description("description")
                .build();
        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.HelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Zak")
                .phone("8745698234")
                .email("ron@gmail.com")
                .address("TA")
                .description("empty name")
                .build();
        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("8745698234")
                .email("ron@gmail.com")
                .address("")
                .description("empty address")
                .build();
        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("")
                .phone("8745698234")
                .email("ron@gmail.com")
                .address("NY")
                .description("empty last name")
                .build();
        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());

    }

    @Test(dataProvider = "contactWrongPhone", dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhone(Contact contact) {
//        Contact contact = Contact.builder()
//                .name("Ron")
//                .lastName("Zak")
//                .phone("123")
//                .email("ron@gmail.com")
//                .address("NY")
//                .description("wrong phone")
//                .build();
        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail() {
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("8745698234")
                .email("starkgmail.com")
                .address("NY")
                .description("wrong email")
                .build();
        logger.info("Tests run with data --->" + contact.toString());
        app.HelperContact().openAddNewContactForm();
        app.HelperContact().fillAddNewContactForm(contact);
        app.HelperContact().saveNewContact();
        Assert.assertTrue(app.HelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));

    }

}
