package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private static final String BOOKNAME = "Воспламеняющая";

    @Step("Найти книгу 'Воспламеняющая' автора 'Стивен Кинг'")
    public SearchPage SearchPage() {
        $(".search-result")
                .shouldHave(text(BOOKNAME));
        return this;
    }
}
