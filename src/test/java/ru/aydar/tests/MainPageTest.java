package ru.aydar.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.aydar.pages.MainPage;

import java.util.Arrays;
import java.util.List;

@DisplayName("Сценарии проверок главной страницы")
@Tag("ibs")
public class MainPageTest extends TestBase {
    MainPage mainPage = new MainPage();
    String
            ruDescription = "Ключевой технологический партнер лидеров российского бизнеса",
            engDescription = "A key technology partner for Russian business leaders",
            copyrightText = "© ООО «ИБС Экспертиза», 2024. Все права защищены";
    List<String> sectionList = Arrays.asList("Решения и услуги", "Отраслевые решения", "Проекты", "Создано в IBS", "Карьера", "Медиацентр", "О компании");

    @Test
    @DisplayName("Проверка смены языка")
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework17")
    void languageSwitchTest()
    {
        mainPage
                .openPage()
                .checkTopSlideDescription(ruDescription)
                .switchToEng()
                .checkTopSlideDescription(engDescription)
                .switchToRu()
                .checkTopSlideDescription(ruDescription);
    }

    @Test
    @DisplayName("Проверка текста в элементах раздела поиска по сайту")
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework17")
    void searchPopularHeaderTest()
    {
        mainPage
                .openPage()
                .clickSearch()
                .checkSearchPlaceholder()
                .checkSearchPopularHeader()
                .checkSearchLastHeader();
    }

    @Test
    @DisplayName("Проверка названий разделов гамбургер-меню")
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework17")
    void searchNavigationSectionTest()
    {
        mainPage
                .openPage()
                .clickHamburger();
        for (String sectionName : sectionList)
        {
            mainPage.checkNavigationSectionString(sectionName);
        }
    }

    @Test
    @DisplayName("Проверка текста копирайта в футере")
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework17")
    void checkFooterCopyrightTest()
    {
        mainPage
                .openPage()
                .checkCopyrightTextInFooter(copyrightText);
    }
}
