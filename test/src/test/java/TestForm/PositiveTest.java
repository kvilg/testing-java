package TestForm;

import TestRandom.Post;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class PositiveTest {

//    WebDriver driver = new ChromeDriver();
//
//    WebElement firstName ;
//    WebElement lastName ;
//    WebElement userEmail ;
//
//    WebElement genderRadio1;
//    WebElement genderRadio2;
//    WebElement genderRadio3 ;
//
//    WebElement userNumber;
//
//    WebElement dateOfBirthInput;
//
//    WebElement subjectsInput ;
//
//    WebElement hobbiesCheckbox1;
//    WebElement hobbiesCheckbox2;
//    WebElement hobbiesCheckbox3;
//
//    WebElement uploadPicture;
//
//    WebElement currentAddress;
//
//    WebElement submit;
//
//
//    @BeforeEach
//    void init() {
//        driver.get("https://demoqa.com/automation-practice-form");
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//
//        firstName = driver.findElement(By.id("firstName"));
//        lastName = driver.findElement(By.id("lastName"));
//        userEmail = driver.findElement(By.id("lastName"));
//
//        genderRadio1 = driver.findElement(By.id("gender-radio-1"));
//        genderRadio2 = driver.findElement(By.id("gender-radio-2"));
//        genderRadio3 = driver.findElement(By.id("gender-radio-3"));
//
//        userNumber = driver.findElement(By.id("userNumber"));
//
//        dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
//
//        subjectsInput = driver.findElement(By.id("subjectsInput"));
//
//        hobbiesCheckbox1 = driver.findElement(By.id("hobbies-checkbox-1"));
//        hobbiesCheckbox2 = driver.findElement(By.id("hobbies-checkbox-2"));
//        hobbiesCheckbox3 = driver.findElement(By.id("hobbies-checkbox-3"));
//
//        currentAddress = driver.findElement(By.id("currentAddress"));
//
//        //выбрать файл
//        uploadPicture = driver.findElement(By.id("uploadPicture"));
//
//        submit = driver.findElement(By.id("submit"));
//
//    }
//
//    @Test
//    public void testSetResults() {
//        firstName.sendKeys("f-name");
//        lastName.sendKeys("l-name");
//        userEmail.sendKeys("mailii@mail.ru");
//
//        genderRadio1.click();
//
//        userNumber.sendKeys("89507795555");
//
//        subjectsInput.sendKeys("subjects");
//
//        hobbiesCheckbox1.click();
//        hobbiesCheckbox2.click();
//        hobbiesCheckbox3.click();
//
//        currentAddress.sendKeys("currentAddress");
//
//
//        submit.click();
//
//        WebElement result = driver.findElement(By.id("example-modal-sizes-title-lg"));
//        assertEquals(result.getText(),"Thanks for submitting the form");
//    }

    @Test
    public void testT(){
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }
}
