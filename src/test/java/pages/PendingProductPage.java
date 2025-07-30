package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static pages.BookPage.BOOKNAME;

public class PendingProductPage {
    private final SelenideElement pendingProduct =  $(".products-row");

    @Step("Проверить на странице с отложенными товарами наличие отложенного товара")
    public PendingProductPage checkPendingProduct() {
        pendingProduct
                .shouldHave(text(BOOKNAME));
        return this;
    }
}
