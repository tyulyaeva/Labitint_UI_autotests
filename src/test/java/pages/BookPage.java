package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {
    private static final String BOOKNAME = "Воспламеняющая";
    private final SelenideElement checkProduct = $("._h1_5o36c_18"),
                                  productCard = $("[href='/books/867711/']"),
                                  buttonAddProduct = $("._actions_zuu52_155").$("._button_ssd04_1");

    @Step("Проверить, что заголовок карточки товара содержит наименование книги")
    public BookPage checkProductCardPage() {
        checkProduct.shouldHave(text(BOOKNAME));
        return this;
    }

    @Step("Открыть карточку товара")
    public BookPage openProductCard() {
        productCard.click();
        return this;
    }

    @Step("Добавить товар в корзину")
    public BookPage clickToAddProduct() {
        buttonAddProduct.click();
        return this;
    }
}
