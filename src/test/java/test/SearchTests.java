package test;

import io.qameta.allure.*;
import pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Labirint.ru тесты")
public class SearchTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №1: Проверка поиска книги")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void searchResultsShouldContainDeterminedBookTest() {
        mainPage.openMainPage()
                .authorSearch();
        searchPage.searchPage();
    }
}
