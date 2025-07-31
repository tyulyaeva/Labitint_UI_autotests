package test;
import io.qameta.allure.*;
import pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Labirint.ru тесты")
public class SectionTests extends TestBase{

    MainPage mainPage = new MainPage();
    CatalogSectionPage catalogSectionPage = new CatalogSectionPage();
    ContactPage contactPage = new ContactPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №2: Проверка перехода в раздел 'Офисная канцелярия' с помощью меню 'Канцелярия'")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkMenuCatalogSectionTest() {
        mainPage.openMainPage();
        catalogSectionPage.openCatalogMenu();
    }

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №8: Проверка перехода на страницу 'Контакты'")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkOpenContactPage () {
        mainPage.openMainPage()
                .clickMenuContacts();
        contactPage.checkContactPage();
    }
}
