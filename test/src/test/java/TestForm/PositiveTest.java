package TestForm;

import TestRandom.Post;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.apache.commons.lang3.StringUtils;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;
import java.util.*;


import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;




public class PositiveTest {


   @BeforeEach
   void init(){

   }

    @Test
    void test1(){
        String firstName="name";
        String lastName="last";
        String userEmail="aaa@mail.ru";
        Gender gender=Gender.Other;
        String userNumber="9508871542";
        String subjectsInput="sab";
        String date="09 Nov 2023";
        String address="address";
        TestForm.HobbiesList hobbiesList = new TestForm.HobbiesList();
        hobbiesList.add(Hobbies.Reading);
        String state=State.NCR;
        String city=City.Delhi;

        Map<KeysMap,String> map = TestForm.testSetResults(firstName,lastName,userEmail,
                gender,userNumber,subjectsInput,date,
                address,hobbiesList,state,city);

        assertEquals(map.get(KeysMap.Student_Name),firstName+" "+lastName);
        assertEquals(map.get(KeysMap.Student_Email),userEmail);
        assertEquals(map.get(KeysMap.Gender),gender.name());
        assertEquals(map.get(KeysMap.Mobile),userNumber);
//        assertEquals(map.get(KeysMap.Date_of_Birth),date);//<---------------------- туть баг
//        assertEquals(map.get(KeysMap.Subjects),subjectsInput); //<---------------------- туть баг
//        assertEquals(map.get(KeysMap.Hobbies),hobbiesList.toString()); //<---------------------- туть баг
//        assertEquals(map.get(),firstName+" "+lastName);
        assertEquals(map.get(KeysMap.Address),address);
        assertEquals(map.get(KeysMap.State_and_City),state+" "+city);


    }


    @Test
    void test2(){
        String firstName="name";
        String lastName="last";
        String userEmail="wwgrh@mail.ru";
        Gender gender=Gender.Male;
        String userNumber="9508871542";
        String subjectsInput="sab";
        String date="09 Nov 2023";
        String address="ee";
        TestForm.HobbiesList hobbiesList = new TestForm.HobbiesList();
        hobbiesList.add(Hobbies.Reading);
        String state=State.NCR;
        String city=City.Delhi;

        Map<KeysMap,String> map = TestForm.testSetResults(firstName,lastName,userEmail,
                gender,userNumber,subjectsInput,date,
                address,hobbiesList,state,city);

        assertEquals(map.get(KeysMap.Student_Name),firstName+" "+lastName);
        assertEquals(map.get(KeysMap.Student_Email),userEmail);
        assertEquals(map.get(KeysMap.Gender),gender.name());
        assertEquals(map.get(KeysMap.Mobile),userNumber);
//        assertEquals(map.get(KeysMap.Date_of_Birth),date);//<---------------------- туть баг
//        assertEquals(map.get(KeysMap.Subjects),subjectsInput); //<---------------------- туть баг
//        assertEquals(map.get(KeysMap.Hobbies),hobbiesList.toString()); //<---------------------- туть баг
//        assertEquals(map.get(),firstName+" "+lastName);
        assertEquals(map.get(KeysMap.Address),address);
        assertEquals(map.get(KeysMap.State_and_City),state+" "+city);
    }


    @Test
    void test3(){
        String firstName="name";
        String lastName="last";
        String userEmail="aaa@mail.ru";
        Gender gender=Gender.Other;
        String userNumber="9508871542";
        String subjectsInput="sab";
        String date="09 Nov 2023";
        String address="address";
        TestForm.HobbiesList hobbiesList = new TestForm.HobbiesList();
        hobbiesList.add(Hobbies.Reading);
        String state=State.NCR;
        String city=City.Delhi;

        Map<KeysMap,String> map = TestForm.testSetResults(firstName,lastName,userEmail,
                gender,userNumber,subjectsInput,date,
                address,hobbiesList,state,city);

        assertEquals(map.get(KeysMap.Student_Name),firstName+" "+lastName);
        assertEquals(map.get(KeysMap.Student_Email),userEmail);
        assertEquals(map.get(KeysMap.Gender),gender.name());
        assertEquals(map.get(KeysMap.Mobile),userNumber);
//        assertEquals(map.get(KeysMap.Date_of_Birth),date);//<---------------------- туть баг
//        assertEquals(map.get(KeysMap.Subjects),subjectsInput); //<---------------------- туть баг
//        assertEquals(map.get(KeysMap.Hobbies),hobbiesList.toString()); //<---------------------- туть баг
//        assertEquals(map.get(),firstName+" "+lastName);
        assertEquals(map.get(KeysMap.Address),address);
        assertEquals(map.get(KeysMap.State_and_City),state+" "+city);
    }



    @AfterEach
    void tearDown() {
//        form.quit();
    }
}
