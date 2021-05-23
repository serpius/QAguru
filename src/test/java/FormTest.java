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
    var firstName = "Serp";
    var lastName ="Derp";
    var userEmail="serp@derp.com";
    var gender="Male";
    var userNumber="1234567890";
    var birthYear="1966";
    var birthMonth="September";
    var birthDay="22";
    var firstSubject="Chemistry";
    var secondSubject="English";
    var hobby="Sports";
    var currentAddress="London, 221B Baker Street";
    var state="NCR";
    var city="Delhi";

    $("[id=firstName]").setValue(firstName);
    $("[id=lastName]").setValue(lastName);
    $("[id=userEmail]").setValue(userEmail);
    $(byText(gender)).doubleClick();
    $("[id=userNumber]").setValue(userNumber);
    $("[id=dateOfBirthInput").click();
    $(".react-datepicker__year-select").selectOption(birthYear);
    $(".react-datepicker__month-select").selectOption(birthMonth);
    $(byText(birthDay)).click();
    $("[id=subjectsInput").setValue(firstSubject).pressEnter().setValue(secondSubject).pressEnter();
    $(byText(hobby)).click();
    $("input[id=uploadPicture]").uploadFile(new File("src/test/resources/test.jpg"));
    $("[id=currentAddress]").setValue(currentAddress);
    $("[id=state").click();
    $(byText(state)).click();
    $("[id=city").click();
    $(byText(city)).click();
    $("[id=submit").click();

    $("tbody").shouldHave(text(firstName+" "+lastName),
                          text(userEmail),
                          text(gender),
                          text(userNumber),
                          text(birthDay+" "+birthMonth+","+birthYear),
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