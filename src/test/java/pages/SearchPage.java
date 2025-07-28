package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private static final String BOOKNAME = "Воспламеняющая";
    private final SelenideElement searchResult = $(".search-result");

    @Step("Найти книгу 'Воспламеняющая' автора 'Стивен Кинг'")
    public SearchPage SearchPage() {
        searchResult.shouldHave(text(BOOKNAME));
        return this;
    }
}
