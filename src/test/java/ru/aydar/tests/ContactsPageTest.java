package ru.aydar.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.aydar.pages.ContactsPage;

@DisplayName("Сценарии проверок страницы контактов")
@Tag("ibs")
public class ContactsPageTest extends TestBase {
    ContactsPage contactsPage = new ContactsPage();
    String pressEmail = "pressa@ibs.ru";

    @Test
    @DisplayName("Проверка отображения адреса после выбора региона")
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework17")
    void languageSwitchTest()
    {
        contactsPage.openPage()
                .checkAddressInRegion("Санкт-Петербург","Английская набережная, д. 70")
                .checkAddressInRegion("Вологда","ул. Зосимовская, д.18")
                .checkAddressInRegion("Уфа","ул. Менделеева, д. 130, блок А, 2 этаж, офис 201");
    }

    @Test
    @DisplayName("Проверка отображения адреса электронной почты пресс-службы")
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework17")
    void pressEmailTest()
    {
        contactsPage.openPage()
                .checkPressEmail(pressEmail);
    }
}
