package TestForm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForm {



    public static class HobbiesList extends LinkedList<Hobbies> {
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            Iterator<Hobbies> iterator = this.iterator();
            sb.append(iterator.next().name());
            sb.append(" ");
            while (iterator.hasNext()) {
                sb.append(iterator.next().name());
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    static private WebForm form;

    static public Map<KeysMap, String> testSetResults(String firstName, String lastName,
                                                               String userEmail, Gender gender,
                                                               String userNumber, String subjectsInput,
                                                               String date, String address,
                                                               HobbiesList hobbiesList,
                                                               String state, String city) {
        form = new WebForm();


        form.setFirstName(firstName);
        form.setLastName(lastName);
        form.setUserEmail(userEmail);

        form.setGender(gender);


        form.setUserNumber(userNumber);

        form.setSubjectsInput(subjectsInput);

        hobbiesList.stream().peek(p ->form.setHobbiesCheckbox(p));

//        form.setDateOfBirthInput(date);//<---------------------- туть баг

        form.setCurrentAddress(address);

        form.setState(state);

        form.setCity(city);

        form.setSubmit();

        Map<KeysMap,String> map = form.getResult();
        assertEquals(map.size(),10);


        form.quit();
        return map;
    }

    static void quit(){
        form.quit();
    }

}
