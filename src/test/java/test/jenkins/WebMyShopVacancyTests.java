package test.jenkins;
import pages.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.TestBase;

@DisplayName("Labirint.ru тесты")
public class WebMyShopVacancyTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    BookPage bookPage = new BookPage();
    BasketPage basketPage = new BasketPage();
    CatalogSectionPage catalogSectionPage = new CatalogSectionPage();
    PendingProductPage pendingProductPage = new PendingProductPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @Test
    @DisplayName("Тест-кейс №1: Проверка поиска книги")
    void searchResultsShouldContainDeterminedBookTest () {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №2: Проверка перехода в раздел 'Офисная канцелярия' с помощью меню 'Канцелярия'")
    @Test
    void checkMenuCatalogSectionTest() {
        mainPage.openMainPage();
        catalogSectionPage.openCatalogMenu();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №3: Проверка просмотра карточки товара")
    @Test
    void checkProductCardTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        bookPage.openProductCard()
                .checkProductCardPage();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №4: Проверка добавления товара в корзину")
    @Test
    void checkProductBasketTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        bookPage.openProductCard()
                .clickToAddProduct();
        basketPage.
                checkProductBasketTest();

    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №5: Проверка смены города")
    @Test
    void changeLocationPersonTest() {
        mainPage.openMainPage()
                .changeCity()
                .checkChangeCityClick();
    }
    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №6: Проверка удаления товара из корзину")
    @Test
    void checkEmptyBasketTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        bookPage.openProductCard()
                .clickToAddProduct();
        basketPage
                .checkProductBasketTest()
                .delProductBasketTest();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №7: Проверка добавления товара в отложенные товары")
    @Test
    void checkPendingProductTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        bookPage.openProductCard()
                .clickToPendingProduct();
        mainPage.clickPendingButton();
        pendingProductPage.checkPendingProduct();
    }
}
