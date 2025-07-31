package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {
    private static final String  namePage = "Контакты";
    private final SelenideElement nameContactPage = $(".content-default.read-area.contact__wrapper");

    @Step("Проверить, что заголовок карточки товара содержит наименование книги")
    public ContactPage checkContactPage() {
        nameContactPage.shouldHave(text(namePage));
        return this;
    }
}
