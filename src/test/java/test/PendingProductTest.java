package test;
import io.qameta.allure.*;
        import pages.*;
        import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Labirint.ru тесты")
public class PendingProductTest extends TestBase{

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    PendingProductPage pendingProductPage = new PendingProductPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №7: Проверка добавления товара в отложенные товары")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkPendingProductTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
        productPage.openProductCard()
                .clickToPendingProduct();
        mainPage.clickPendingButton();
        pendingProductPage.checkPendingProduct();
    }
}
