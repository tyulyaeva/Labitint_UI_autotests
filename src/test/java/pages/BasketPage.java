package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private static final String BOOKNAME = "Воспламеняющая";
    private final SelenideElement basket = $("._cartCount_1a3wc_104"),
                                  basketPanel = $(".b-bask-panel.b-bask-panel-order");

    @Step("Проверить добавленный товар в корзине")
    public BasketPage checkPenBasketTest() {
        basket.click();
        basketPanel.shouldHave(text(BOOKNAME));
        return this;
    }
}
