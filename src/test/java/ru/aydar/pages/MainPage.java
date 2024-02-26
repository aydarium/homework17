package ru.aydar.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            searchButton = $(".js-header-search"),
            searchPopUp = $(".search"),
            searchLastHeader = $(".search-last__header"),
            searchInput = $(".js-search-input"),
            burgerButton = $(".header-burger"),
            navigationSections = $(".navigation-sections"),
            topSlideDescription = $(".top-slide__desc"),
            footerCopyright = $(".footer-copy"),
            headerLinks = $(".header-links");

    @Step("Открываем главную страницу")
    public MainPage openPage()
    {
        open("");
        return this;
    }

    @Step("Нажимаем на кнопку поиска по сайту")
    public MainPage clickSearch()
    {
        searchButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку гамбургер-меню (три полоски)")
    public MainPage clickHamburger()
    {
        burgerButton.click();
        return this;
    }

    @Step("Проверяем наличие пункта '{value}' в гамбургер-меню")
    public MainPage checkNavigationSectionString(String value)
    {
        navigationSections.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем наличие заголовка '{value}' в окне поиска по сайту")
    public MainPage checkSearchHeader(String value)
    {
        searchPopUp.shouldHave(text(value)).shouldBe(visible);
        return this;
    }

    @Step("Проверяем наличие плейсхолдера в поле поиска по сайту")
    public MainPage checkSearchPlaceholder()
    {
        searchInput.shouldBe(visible);
        searchInput.shouldHave(attribute("placeholder","Поиск по сайту"));
        return this;
    }

    @Step("Нажимаем на кнопку смены языка сайта '{value}'")
    public MainPage switchLang(String value)
    {
        headerLinks.$(byText(value)).click();
        return this;
    }

    @Step("Проверяем текст описания в верхнем слайде (ожидаем '{value}')")
    public MainPage checkTopSlideDescription(String value)
    {
        topSlideDescription.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем, что в футере сайта написан копирайт '{value}'")
    public MainPage checkCopyrightTextInFooter(String value)
    {
        footerCopyright.scrollIntoView(true).shouldHave(text(value));
        return this;
    }
}
