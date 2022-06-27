package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка Drag&Drop")
    void dragAndDropTest() {
        open ("/drag_and_drop");
        String firstColumnText = $("#column-a").text();
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(Condition.text(firstColumnText));
    }
}
