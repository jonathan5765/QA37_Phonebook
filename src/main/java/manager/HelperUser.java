package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginRegistrationForm(){
//        WebElement loginTab = wd.findElement(By.xpath("//a[text()='LOGIN']"));
//        //css.Selector: "a[href]='/login']
//        loginTab.click();
        click(By.xpath("//a[text()='LOGIN']"));

    }
    public void fillLoginRegistrationForm(String email, String password){
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"),email);
        type(By.xpath("//input[last()]"),password);

    }
    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }
    public void logout(){
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertPresent(String message) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if(alert != null && alert.getText().equals(message)){
            System.out.println(alert.getText());
            //click ok
            //pause

            alert.accept();
            //click cansel --> alert.dismiss();


            return true;
        }
        return false;
    }
}
