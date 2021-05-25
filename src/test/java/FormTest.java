import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormTest {

  static Logger logs = LoggerFactory.getLogger(FormTest.class);

  @BeforeAll
  static void browserInitConf() {
    logs.info("@BeforeAll method");
    Configuration.startMaximized = true;
    Configuration.browser = "chrome";
  }

  @Test
  void positiveFormTest() {
    open("https://demoqa.com/automation-practice-form");
    String firstName = "Serp",
        lastName = "Derp",
        userEmail = "serp@derp.com",
        gender = "Male",
        userNumber = "1234567890",
        birthYear = "1966",
        birthMonth = "September",
        birthDay = "22",
        firstSubject = "Chemistry",
        secondSubject = "English",
        hobby = "Sports",
        currentAddress = "London, 221B Baker Street",
        state = "NCR",
        city = "Delhi";

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $(byText(gender)).doubleClick();
    $("#userNumber").setValue(userNumber);
    $("#dateOfBirthInput").click();
    $(".react-datepicker__year-select").selectOption(birthYear);
    $(".react-datepicker__month-select").selectOption(birthMonth);
    $(byText(birthDay)).click();
    $("#subjectsInput").setValue(firstSubject).pressEnter().setValue(secondSubject).pressEnter();
    $(byText(hobby)).click();
    $("input#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
    $("#currentAddress").setValue(currentAddress);
    $("#state").click();
    $(byText(state)).click();
    $("#city").click();
    $(byText(city)).click();
    $("#submit").click();

    $("tbody").shouldHave(text(firstName + " " + lastName),
                          text(userEmail),
                          text(gender),
                          text(userNumber),
                          text(birthDay + " " + birthMonth + "," + birthYear),
                          text(firstSubject),
                          text(secondSubject),
                          text(hobby),
                          text("test.jpg"),
                          text(currentAddress),
                          text(state),
                          text(city)
                         );

  }

}
