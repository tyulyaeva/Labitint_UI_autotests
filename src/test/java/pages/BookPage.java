package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {
    private static final String BOOKNAME = "Воспламеняющая";

    @Step("Проверить, что заголовок карточки товара содержит наименование книги")
    public BookPage checkProductCardPage() {
        $("._h1_5o36c_18").shouldHave(text(BOOKNAME));
        return this;
    }

    @Step("Открыть карточку товара")
    public BookPage openProductCard() {
        $("[href='/books/867711/']").click();
        return this;
    }

    @Step("Добавить товар в корзину")
    public BookPage clickToAddProduct() {
        $("._actions_zuu52_155").$("._button_ssd04_1").click();
        return this;
    }
}
