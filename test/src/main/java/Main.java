import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement el = driver.findElement(By.id("react-select-3-input"));

        el.sendKeys(Keys.SPACE);
        Thread.sleep(3000);
        WebElement css = driver.findElement(By.cssSelector(" css-26l3qy-menu"));

        System.out.println(css.getText());

        driver.quit();

    }
}
