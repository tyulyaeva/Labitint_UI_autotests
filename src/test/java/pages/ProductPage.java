package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    public static final String BOOKNAME = "Воспламеняющая";
    private final SelenideElement nameProduct = $("._h1_5o36c_18"),
            productCard = $("[href='/books/867711/']"),
            buttonAddProduct = $("._actions_zuu52_155").$("._button_ssd04_1"),
            buttonPendingProduct = $("._button_ssd04_1._is-m_ssd04_85._is-gray_ssd04_128._is-rounded_ssd04_94");

    @Step("Проверить, что заголовок карточки товара содержит наименование книги")
    public ProductPage checkProductCardPage() {
        nameProduct.shouldHave(text(BOOKNAME));
        return this;
    }

    @Step("Открыть карточку товара")
    public ProductPage openProductCard() {
        productCard.click();
        return this;
    }

    @Step("Добавить товар в корзину")
    public ProductPage clickToAddProduct() {
        buttonAddProduct.click();
        return this;
    }

    @Step("Добавить товар в отложенные")
    public ProductPage clickToPendingProduct() {
        buttonPendingProduct.click();
        return this;
    }
}
