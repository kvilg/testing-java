package TestForm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class WebForm {


    private WebDriver driver;
    private WebElement firstName ;
    private WebElement lastName ;
    private WebElement userEmail ;

    private WebElement genderRadioMale;
    private WebElement genderRadioFamale;
    private WebElement genderRadioOther ;

    private WebElement userNumber;

    private WebElement dateOfBirthInput;

    private WebElement subjectsInput ;

    private WebElement hobbiesCheckboxSports;
    private WebElement hobbiesCheckboxReading;
    private WebElement hobbiesCheckboxMusic;

    private WebElement uploadPicture;

    private WebElement currentAddress;

    private WebElement state;

    private WebElement submit;

    private WebElement city;



    public WebForm(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        driver.manage().window().maximize();
        firstName = driver.findElement(By.id("firstName"));
        lastName = driver.findElement(By.id("lastName"));
        userEmail = driver.findElement(By.id("userEmail"));

        genderRadioMale = driver.findElement(By.id("gender-radio-1"));
        genderRadioFamale = driver.findElement(By.id("gender-radio-2"));
        genderRadioOther = driver.findElement(By.id("gender-radio-3"));

        userNumber = driver.findElement(By.id("userNumber"));

        dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));

        subjectsInput = driver.findElement(By.id("subjectsInput"));

        hobbiesCheckboxSports = driver.findElement(By.id("hobbies-checkbox-1"));
        hobbiesCheckboxReading = driver.findElement(By.id("hobbies-checkbox-2"));
        hobbiesCheckboxMusic = driver.findElement(By.id("hobbies-checkbox-3"));

        currentAddress = driver.findElement(By.id("currentAddress"));

        //выбрать файл
        uploadPicture = driver.findElement(By.id("uploadPicture"));

        state = driver.findElement(By.id("react-select-3-input"));

        city = driver.findElement(By.id("react-select-4-input"));

        submit = driver.findElement(By.id("submit"));

    }

    public Map<KeysMap,String> getResult(){
        Map<KeysMap,String> map = new HashMap<>();

        WebElement tBody = driver.findElement(By.tagName("tbody"));
        List<WebElement> tList = tBody.findElements(By.tagName("tr"));

//        assertEquals(tList.size(), 0);

        for (int i = 0; i < tList.size(); i++) {
            List<WebElement> itemList = tList.get(i).findElements(By.tagName("td"));

            map.put(KeysMap.values()[i],itemList.get(1).getText());

        }

        return map;
    }


    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.sendKeys(userEmail);
    }

    public void setGender(Gender gender) {
        if(gender == Gender.Male){
            this.genderRadioMale.sendKeys(Keys.SPACE);
        }else if(gender == Gender.Female) {
            this.genderRadioFamale.sendKeys(Keys.SPACE);
        }else {
            this.genderRadioOther.sendKeys(Keys.SPACE);
        }

    }



    public void setUserNumber(String nam) {
        this.userNumber.sendKeys(nam);
    }

    public void setDateOfBirthInput(String dateOfBirthInput) {
        for (int i = 0; i < 11; i++) {
            this.dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        }
        this.dateOfBirthInput.sendKeys(dateOfBirthInput);
    }

    public void setSubjectsInput(String subjectsInput) {
        this.subjectsInput.sendKeys(subjectsInput);
    }

    public void setHobbiesCheckbox(Hobbies hobbies) {
        if(hobbies == Hobbies.Sports){
            this.hobbiesCheckboxSports.sendKeys(Keys.SPACE);
        }else if(hobbies == Hobbies.Reading){
            this.hobbiesCheckboxReading.sendKeys(Keys.SPACE);
        }else {
            this.hobbiesCheckboxMusic.sendKeys(Keys.SPACE);
        }

    }



    public void setUploadPicture(String uploadPicture) {
        this.uploadPicture.sendKeys(uploadPicture);
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress.sendKeys(currentAddress);
    }


    public void setState(String state){
        this.state.sendKeys(state+"\n");
    }

    public void setCity(String city){
        this.city.sendKeys(city+"\n");
    }
    public void setSubmit() {
        this.submit.sendKeys(Keys.ENTER);
    }

    public void quit(){
        driver.quit();
    }
}
enum Gender{
    Male,Female,Other;

    public void add(){

    }
}

enum Hobbies{
    Sports,Reading,Music
}

enum KeysMap{
    Student_Name,
        Student_Email,
        Gender,
        Mobile,
        Date_of_Birth,
        Subjects,
        Hobbies,
        Picture,
        Address,
        State_and_City
}

class State{
    public static String NCR = "NCR";
    public static String Uttar_Pradesh = "Uttar Pradesh";
    public static String Haryana = "Haryana";
    public static String Rajasthan = "Rajasthan";

}

class City{
    public static String Delhi = "Delhi";
    public static String Gurgaon = "Gurgaon";
    public static String Noida = "Noida";


    public static String Agra = "Agra";
    public static String Lucknow = "Lucknow";
    public static String Merrut = "Merrut";

    public static String Karnal = "Karnal";
    public static String Panipat = "Panipat";

    public static String Jaipur = "Jaipur";
    public static String Jaiselmer = "Jaiselmer";


}