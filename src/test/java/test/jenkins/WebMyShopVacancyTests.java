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

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @Test
    @DisplayName("Тест-кейс №1: Проверка поиска книги")
    void searchResultsShouldContainDeterminedBookTest () {
        mainPage.MainPage()
                .AuthorSearch();
        searchPage.SearchPage();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №2: Проверка перехода в раздел 'Офисная канцелярия' с помощью меню 'Канцелярия'")
    @Test
    void checkMenuCatalogSectionTest() {
        mainPage.MainPage();
        catalogSectionPage.openCatalogMenu();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №3: Проверка просмотра карточки товара")
    @Test
    void checkProductCardTest() {
        mainPage.MainPage()
                .AuthorSearch();
        searchPage.SearchPage();
        bookPage.openProductCard()
                .checkProductCardPage();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №4: Проверка добавления товара в корзину")
    @Test
    void checkPenBasketTest() {
        mainPage.MainPage()
                .AuthorSearch();
        searchPage.SearchPage();
        bookPage.openProductCard()
                .clickToAddProduct();
        basketPage.checkPenBasketTest();

    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №5: Проверка смены города")
    @Test
    void changeLocationPersonTest() {
        mainPage.MainPage()
                .changeSity()
                .checkChangeSityClick();
    }

}
