package test;
import io.qameta.allure.*;
import pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Labirint.ru тесты")
public class LocationTests extends TestBase{
    MainPage mainPage = new MainPage();

    @Tag("myshop_form")
    @Feature("VacancyJavaQa")
    @Story("Тестирование формы сайта: https://www.labirint.ru/")
    @Owner("inna_tyulyaeva")
    @DisplayName("Тест-кейс №5: Проверка смены города")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    void changeLocationPersonTest() {
        mainPage.openMainPage()
                .changeCity()
                .checkChangeCityClick();
    }
}
