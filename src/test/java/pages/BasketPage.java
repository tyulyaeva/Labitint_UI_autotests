package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private static final String BOOKNAME = "Воспламеняющая";

    @Step("Проверить добавленный товар в корзине")
    public BasketPage checkPenBasketTest() {
        $("._cartCount_1a3wc_104").click();
        $(".b-bask-panel.b-bask-panel-order").shouldHave(text(BOOKNAME));
        return this;
    }
}
