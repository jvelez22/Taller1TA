import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AccountCreationTest {

    @Test
    void createAccount() {
        // Setup ChromeDriver using WebDriverManager
        WebDriver driver = new ChromeDriver();

        // Step 1: Navigate to the website
        driver.get("https://teststore.automationtesting.co.uk/index.php");

        // Step 2: Click on "Sign In"
        WebElement signInButton = driver.findElement(By.xpath("//a[contains(@title, 'Log in')]"));
        signInButton.click();

        // Step 3: Click on "No account? Create one here"
        WebElement createAccountLink = driver.findElement(By.xpath("//a[contains(text(),'Create one here')]"));
        createAccountLink.click();

        WebElement gender = driver.findElement(By.xpath("//label[contains(text(), 'Social')]//following-sibling::div//input[@name='id_gender']"));
        gender.click();

        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastNameField.sendKeys("Doe");

        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys("johndoe@example.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("SecurePassword123");

        // Step 5: Click the "Save" button using RelativeLocator (Selenium 4.25 feature)
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();

        // Close the browser after the test
        driver.quit();
    }
}


