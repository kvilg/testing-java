package TestSovcombank;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTest {

    private WebDriver driver;

    @Test
    void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://people.sovcombank.ru/");
        driver.manage().window().maximize();

        WebElement buttonVacancies = driver.findElement(By.xpath("//a[contains(@href,'/vacancies')]"));
        buttonVacancies.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[contains(@placeholder,'Все города')]")).sendKeys("Москва");

        driver.findElement(By.cssSelector(".v-list.v-select-list.v-sheet.theme--light.theme--light")).click();
        
        driver.findElement(By.xpath("//div[contains(@aria-owns,'list-1279')]")).click();
        driver.findElements(By.cssSelector("div.v-input--selection-controls__ripple")).get(2).click();

        Thread.sleep(1500);


        WebElement a = driver.findElement(By.cssSelector(".section-vacancies.full-width"));

        List<WebElement> w = a.findElements(By.tagName("a"));

        assertEquals(w.size(),10);


        List<Vacancies> vacanciesList = w.parallelStream().map(Vacancies::new).toList();



        vacanciesList.parallelStream().forEach(m->{

            assertTrue(m.getInfo().contains("Москва") || m.getInfo().contains("Вся Россия"));
            assertTrue(m.getInfo().contains("Совкомбанк Технологии"));
        });


    }

    static class Vacancies{

        private final By byInfo = By.cssSelector(".t2vac");

        private String strInfo = "";

        public Vacancies(WebElement vacancies){
            this.strInfo = vacancies.findElement(byInfo).getText();
        }

        public String getInfo(){
            return strInfo;
        }

    }
}