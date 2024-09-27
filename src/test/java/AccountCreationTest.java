import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountCreationTest {

    /**
     * This test case creates an account in the test store.
     * Challenge # 1
     */
    @Test
    void createAccount() {
        String formattedNow = getTimeStampString();

        final String name = "Juan";
        final String lastName = "Velez";
        final String email = "juan" + formattedNow + "@email.com";
        final String password = "H3ll0@22W0rld";
        final String customerForm = "//form[@id='customer-form']";

        WebDriver driver = new ChromeDriver();

        driver.get("https://teststore.automationtesting.co.uk/index.php");

        WebElement signInButton = driver.findElement(By.xpath("//a[contains(@title, 'Log in')]"));
        signInButton.click();

        WebElement createAccountLink = driver.findElement(By.xpath("//a[contains(text(),'Create one here')]"));
        createAccountLink.click();

        WebElement gender = driver.findElement(By.xpath("//label[contains(text(), 'Social')]//following-sibling::div//input[@name='id_gender']"));
        gender.click();

        WebElement firstNameField = driver.findElement(By.xpath(customerForm + "//input[@id='field-firstname']"));
        firstNameField.sendKeys(name);

        WebElement lastNameField = driver.findElement(By.xpath(customerForm + "//input[@id='field-lastname']"));
        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(By.xpath(customerForm + "//input[@id='field-email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath(customerForm + "//input[@id='field-password']"));
        passwordField.sendKeys(password);

        WebElement offers = driver.findElement(By.xpath(customerForm + "//div[contains(@class, 'form-group')]//input[@name='optin']"));
        offers.click();

        WebElement terms = driver.findElement(By.xpath(customerForm + "//div[contains(@class, 'form-group')]//input[@name='psgdpr']"));
        terms.click();

        WebElement newsLetter = driver.findElement(By.xpath(customerForm + "//div[contains(@class, 'form-group')]//input[@name='newsletter']"));
        newsLetter.click();

        WebElement saveButton = driver.findElement(By.xpath(customerForm + "/footer/button[@type='submit']"));
        saveButton.click();

        WebElement profileName = driver.findElement(By.xpath("//div[@id=\"_desktop_user_info\"]/div/a[2]/span"));

        assertEquals(name + " " + lastName, profileName.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    private static String getTimeStampString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateString = now.format(formatter);
        return dateString
                .replaceAll("\\s","")
                .replaceAll("-","")
                .replaceAll(":","");
    }
}


