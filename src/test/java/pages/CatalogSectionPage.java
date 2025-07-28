package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CatalogSectionPage {

    private static final String SectionPage = "Офисная канцелярия";
    private final SelenideElement menuItemStationery = $(".b-header-b-menu-e-list-item.b-toggle.b-header-b-menu-e-list-item-m-temp.analytics-click-js:nth-child(6) .b-header-b-menu-e-text"),
                                  menuItemOfficeSupplies = $("[href='/genres/1444/']"),
                                  menuNameOfficeSupplies = $(".genre-name");

    @Step("Перейти в подраздел 'Офисная канцелярия'")
    public CatalogSectionPage openCatalogMenu() {
        menuItemStationery
                .shouldBe(visible).click();
        menuItemOfficeSupplies.click();
        menuNameOfficeSupplies
                .shouldHave(text(SectionPage));
        return this;
    }
}
