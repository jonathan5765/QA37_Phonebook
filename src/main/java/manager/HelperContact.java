package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{

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
    type(By.cssSelector("[placeholder='Phone']"), contact.getPhone()+"");
    type(By.cssSelector("[placeholder='email']"), contact.getEmail());
    type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
    type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveNewContact() {
        click(By.xpath("//b[text()='Save']"));
    }
}
