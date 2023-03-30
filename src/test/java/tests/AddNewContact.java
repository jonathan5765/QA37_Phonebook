package tests;

import models.Contact;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase{

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
        app.getHelperContact().fillAddNewContactForm();
        app.getHelperContact().saveNewContact();
    }

}
