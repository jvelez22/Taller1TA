import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeTest {

    /**
     * This test case interacts with an iframe.
     * Challenge Extra
     */
    @Test
    void iframeTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationtesting.co.uk/iframes.html");

        // Wait for the iframe to be available and switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div/div[1]/div/iframe")));

        driver.switchTo().frame(iframe);

        // Wait until the menu is clickable and click it
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sidebar']//a[text()='Toggle']")));
        menu.click();

        // Wait until the menu is clickable and click Accordion option
        WebElement iframeNav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@id='menu']/ul/li[2]/a[text()='Accordion']")));
        iframeNav.click();

        driver.switchTo().defaultContent();

        WebElement mainMenu = driver.findElement(By.xpath("//*[@id='sidebar']/a[contains(text(), 'Toggle')]"));
        mainMenu.click();

        driver.quit();
    }
}
