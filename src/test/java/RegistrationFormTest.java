import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://app.qa.guru";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulRegistrationTest() {
        String firstName = "Yury";
        open("/automation-practice-form");
        $("#root").shouldHave(text("Practice form"));


        $("#\\:r0\\:").setValue(firstName);
        $("#\\:r2\\:").setValue("vitovtov.y@test.com");
        $("#\\:r1\\:").setValue("Vitovtov");
        $("#\\:r3\\:").setValue("2345678901");
        $("#\\:r7\\:").setValue("2755 Broadway");
        $(byText("Language")).parent().click();
        $(by("data-value", "Russian")).click();

        $("[value=Male]").click();
        $("[value=Sports]").click();
        $("[value=Reading]").click();

        $("[aria-label='Choose date']").click();

        $(byText("Subjects")).parent().click();
        $(byText("Science")).click();
        $(byText("Maths")).click();
        $("#menu-").click();
        $(byText("State")).parent().click();
        $(by("data-value", "Florida")).click();
        $(byText("City")).parent().click();
        $(by("data-value", "Tampa")).click();
        $("button[type=submit]").scrollIntoView(true);

        $("[aria-label='Choose date']").click();
        $("#\\:r9\\:-grid-label").click();
        $(byText("1991")).click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[aria-label='Next month']").click();
        $("[data-timestamp='689364000000']").click();
        $("button[type=submit]").parent().click();


        $(".css-105y4gd").shouldHave(text(firstName));
        $(".css-105y4gd").shouldHave(text("vitovtov.y@test.com"));
        $(".css-105y4gd").shouldHave(text("Vitovtov"));
        $(".css-105y4gd").shouldHave(text("+1 234 567 8901"));
        $(".css-105y4gd").shouldHave(text("2755 Broadway"));
        $(".css-105y4gd").shouldHave(text("Male"));
        $(".css-105y4gd").shouldHave(text("Sports"));
        $(".css-105y4gd").shouldHave(text("Reading"));
        $(".css-105y4gd").shouldHave(text("Science"));
        $(".css-105y4gd").shouldHave(text("Maths"));
        $(".css-105y4gd").shouldHave(text("Florida"));
        $(".css-105y4gd").shouldHave(text("Russian"));
        $(".css-105y4gd").shouldHave(text("Tampa"));
        $(".css-105y4gd").shouldHave(text("06/11/1991"));

    }
}