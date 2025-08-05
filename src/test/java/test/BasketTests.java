package test;

import io.qameta.allure.*;
import pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Labirint.ru тесты")
public class BasketTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №4: Проверка добавления товара в корзину")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkProductBasketTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        productPage.openProductCard()
                .clickToAddProduct();
        basketPage
                .checkProductBasketTest();

    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №6: Проверка очистки корзины")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkEmptyBasketTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        productPage.openProductCard()
                .clickToAddProduct();
        basketPage
                .checkProductBasketTest()
                .delProductBasketTest();
    }
}
