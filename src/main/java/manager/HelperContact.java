package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddNewContactForm() {
        pause(2000);
        click(By.cssSelector("[href='/add']"));
    }

    public void fillAddNewContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone() + "");
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveNewContact() {
        getScreenElement("src/test/screenshots/screen-btn.png", By.xpath("//b[text()='Save']"));
        click(By.xpath("//b[text()='Save']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }

        }
        return false;

    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }

        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of contacts list before remove is ---> " + before);
        removeContact();
        int after = countOfContacts();
        logger.info("Number of contacts list after remove is ---> " + after);
        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeContact();
        }
    }

    public void provideContacts() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                addOneContact();
            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Roni" + i)
                .lastName("Zax")
                .phone("87456982" + i)
                .email("roni" + i + "@gmail.com")
                .address("TA")
                .description("description")
                .build();
        openAddNewContactForm();
        fillAddNewContactForm(contact);
        saveNewContact();
        //pause(500);

    }
}
