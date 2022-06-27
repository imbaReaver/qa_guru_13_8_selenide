package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка JUnit5 Example Code в Wiki")
    void selenideTest() {
        open ("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link button").click();
        $$("#wiki-pages-box .flex-1").filterBy(Condition.text("SoftAssertions")).first()
            .shouldBe(Condition.visible).click();
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
    }
}
