package test;

import io.qameta.allure.*;
import pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Labirint.ru тесты")
public class ProductCardTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №3: Проверка просмотра карточки товара")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkProductCardTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        productPage.openProductCard()
                .checkProductCardPage();
    }
}
