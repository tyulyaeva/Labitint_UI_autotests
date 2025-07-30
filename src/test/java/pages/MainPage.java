package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String  MainPage = "https://www.labirint.ru/",
                                 AUTHOR = "Стивен Кинг",
                                 City = "Санкт-Петербург";
    private final SelenideElement searchField =  $("[id=search-field"),
                                  regionLocation = $(".region-location-icon-txt"),
                                  location = $(".g-alttext-deepblue:nth-child(3)"),
                                  pendingButton = $("._icon_1a3wc_41");

    @Step("Открыть страницу: https://www.labirint.ru/")
    public MainPage openMainPage() {
        open(MainPage);
        return this;
    }

    @Step("Найти книги автора 'Стивен Кинг'")
    public MainPage authorSearch() {
        searchField.
                setValue(AUTHOR).pressEnter();
        return this;
    }

    @Step("Сменить текущую локацию на г.Санкт-Петербург")
    public MainPage changeCity() {
        regionLocation.shouldBe(visible).click();
        location.click();
        return this;
    }

    @Step("Проверить, что установлен в качестве текущей локации г.Санкт-Петербург")
    public MainPage checkChangeCityClick() {
        regionLocation
                .shouldHave(text(City));
        return this;
    }

    @Step("Перейти на страницу с отложенными товарами")
    public MainPage clickPendingButton() {
        pendingButton
                .click();
        return this;
    }
}
