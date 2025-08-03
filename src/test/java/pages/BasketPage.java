package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private static final String BOOKNAME = "Воспламеняющая";
    private final SelenideElement basket = $("._cartCount_1a3wc_104"),
            basketPanel = $(".b-bask-panel.b-bask-panel-order"),
            emptyBasketDel = $("div[class='text-regular empty-basket-link trash-link'] span[class='b-link-popup basket-header-links']"),
            emptyBasketCheck = $("div[class='b-bask-panel'] span[class='g-alttext-small g-alttext-grey g-alttext-head']");

    @Step("Проверить добавленный товар в корзине")
    public BasketPage checkProductBasketTest() {
        basket.click();
        basketPanel.shouldHave(text(BOOKNAME));
        return this;
    }

    @Step("Удалить добавленный товар в корзине")
    public BasketPage delProductBasketTest() {
        emptyBasketDel.click();
        emptyBasketCheck.shouldHave(text("Ваша корзина пуста. Почему?"));
        return this;
    }
}
