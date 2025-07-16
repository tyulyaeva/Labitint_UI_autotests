package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String  MainPage = "https://www.labirint.ru/",
                                 AUTHOR = "Стивен Кинг";

    @Step("Открыть страницу: https://www.labirint.ru/")
    public MainPage MainPage() {
        open(MainPage);
        return this;
    }

    @Step("Найти книги автора 'Стивен Кинг'")
    public MainPage AuthorSearch() {
        $("[id=search-field").
                setValue(AUTHOR).pressEnter();
        return this;
    }

    @Step("Сменить текущую локацию на г.Санкт-Петербург")
    public MainPage changeSity() {
        $(".region-location-icon-txt").shouldBe(visible).click();
        $(".g-alttext-deepblue:nth-child(3)").click();
        return this;
    }

    @Step("Проверить, что установлен в качестве текущей локации г.Санкт-Петербург")
    public MainPage checkChangeSityClick() {
        $(".region-location-icon-txt")
                .shouldHave(text("Санкт-Петербург"));
        return this;
    }
}
