import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {

    {
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://app.qa.guru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {
        String firstName = "Yury";
        open("/automation-practice-form");
        $(".MuiTypography-h4").shouldHave(text("Practice form"));


        $("#\\:r0\\:").setValue(firstName);
        $("#\\:r2\\:").setValue("vitovtov.y@test.com");
        $("#\\:r1\\:").setValue("Vitovtov");
        $("#\\:r3\\:").setValue("2345678901");
        $("#\\:r7\\:").setValue("2755 Broadway");
        $(byText("Language")).parent().click();
        $(byText("Russian")).click();


        $("[value=Male]").click();
        $("[value=Sports]").click();
        $("[value=Reading]").click();
        $("#\\:r4\\:").setValue("06/11/1991");
        $(byText("Subjects")).parent().click();
        $(byText("Science")).click();
        $(byText("Maths")).click();
        $("#menu-").click();
        $(byText("State")).parent().click();
        $(byText("Florida")).click();
        $(byText("City")).parent().click();
        $(byText("Tampa")).click();

        $("button[type=submit]").scrollIntoView(true);
        $("button[type=submit]").parent().click();


        $(".css-105y4gd").shouldHave(text("Yury"), text("vitovtov.y@test.com"), text("Vitovtov"),
                text("+1 234 567 8901"), text("2755 Broadway"), text("Male"),
                text("Sports"), text("Reading"), text("Science"), text("Maths"), text("Florida"),
                text("Russian"), text("Tampa"));
        $(byText("Language")).click();
    }
}