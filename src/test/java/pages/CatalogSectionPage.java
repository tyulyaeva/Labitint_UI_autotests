package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CatalogSectionPage {

    private static final String SectionPage = "Офисная канцелярия";

    @Step("Перейти в подраздел 'Офисная канцелярия'")
    public CatalogSectionPage openCatalogMenu() {
        $(".b-header-b-menu-e-list-item.b-toggle.b-header-b-menu-e-list-item-m-temp.analytics-click-js:nth-child(6) .b-header-b-menu-e-text")
                .shouldBe(visible).click();
        $("[href='/genres/1444/']").click();
        $(".genre-name")
                .shouldHave(text(SectionPage));
        return this;
    }
}
