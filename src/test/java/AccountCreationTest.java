import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountCreationTest {

    @Test
    void createAccount() {

        final String name = "Juan";
        final String lastName = "Velez";
        final String email = "juan01@email.com";
        final String password = "H3ll0@22W0rld";

        WebDriver driver = new ChromeDriver();

        driver.get("https://teststore.automationtesting.co.uk/index.php");

        WebElement signInButton = driver.findElement(By.xpath("//a[contains(@title, 'Log in')]"));
        signInButton.click();

        WebElement createAccountLink = driver.findElement(By.xpath("//a[contains(text(),'Create one here')]"));
        createAccountLink.click();

        WebElement gender = driver.findElement(By.xpath("//label[contains(text(), 'Social')]//following-sibling::div//input[@name='id_gender']"));
        gender.click();

        WebElement firstNameField = driver.findElement(By.xpath("//form[@id='customer-form']//input[@id='field-firstname']"));
        firstNameField.sendKeys(name);

        WebElement lastNameField = driver.findElement(By.xpath("//form[@id='customer-form']//input[@id='field-lastname']"));
        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(By.xpath("//form[@id='customer-form']//input[@id='field-email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//form[@id='customer-form']//input[@id='field-password']"));
        passwordField.sendKeys(password);

        WebElement offers = driver.findElement(By.xpath("//form[@id='customer-form']//div[contains(@class, 'form-group')]//input[@name='optin']"));
        offers.click();

        WebElement terms = driver.findElement(By.xpath("//form[@id='customer-form']//div[contains(@class, 'form-group')]//input[@name='psgdpr']"));
        terms.click();

        WebElement newsLetter = driver.findElement(By.xpath("//form[@id='customer-form']//div[contains(@class, 'form-group')]//input[@name='newsletter']"));
        newsLetter.click();

        WebElement saveButton = driver.findElement(By.xpath("//form[@id='customer-form']/footer/button[@type='submit']"));
        saveButton.click();

        WebElement profileName = driver.findElement(By.xpath("//div[@id=\"_desktop_user_info\"]/div/a[2]/span"));

        assertEquals(name + " " + lastName, profileName.getText());

        driver.quit();
    }
}


