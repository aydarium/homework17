# Проект по автоматизации тестовых сценариев для сайта группы компаний IBS
## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logos/IntelijIDEA.svg">
<img width="6%" title="Java" src="media/logos/Java.svg">
  <img width="6%" title="Gradle" src="media/logos/Gradle.svg">
<img width="6%" title="Selenide" src="media/logos/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logos/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logos/AllureReport.svg">
<img width="6%" title="JUnit5" src="media/logos/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logos/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logos/Jenkins.svg">
<img width="6%" title="Telegram" src="media/logos/Telegram.svg">
  <img width="5%" title="Allure TestOps" src="media/logos/AllureTestOps.svg">
<img width="5%" title="Jira" src="media/logos/Jira.svg">
</p>

Тесты в проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/) и сборщика <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для удалённого запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Также реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала (с параметрами по умолчанию)
```
gradle clean ibs_test
```

### Запуск тестов из Jenkins (с указанием параметров)
```
clean ibs_test
-DbrowserRemoteUrl=${REMOTE_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VER}
-DbrowserSize=${BROWSER_RES}
```

### Параметры сборки

* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты. По умолчанию – <code>https://user1:1234@selenoid.autotests.cloud/wd/hub</code>
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По умолчанию – <code>chrome</code>.
* <code>BROWSER_VER</code> – версия браузера, в которой будут выполняться тесты. По умолчанию – <code>100.0</code>.
* <code>BROWSER_RES</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию – <code>1920x1080</code>.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logos/Jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Build witn parameters</code> и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Сборка в Jenkins" src="media/screencaps/Jenkins.png">
</p>
После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logos/AllureReport.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Общий вид отчёта Allure" src="media/screencaps/AllureOverview.png">
</p>

### Suites

<p align="center">
<img title="Список тест-кейсов в отчёте Allure" src="media/screencaps/AllureCases.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logos/AllureTestOps.svg"> Интеграция с Allure TestOps

На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них добавлены и проходятся вручную (на скриншоте ручной тест можно увидеть в списке в статусе Draft), сколько автоматизированы. Новые тесты, а также результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Дэшборд Allure TestOps" src="media/screencaps/TestOpsDashboard.png">
</p>

### Результат выполнения автотеста

<p align="center">
<img title="Результаты теста в Allure TestOps" src="media/screencaps/TestOpsResults.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logos/Jira.svg"> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и их прогоны.

<p align="center">
<img title="Тикет в Jira" src="media/screencaps/Jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, получает из Jenkins и отправляет сообщение с отчётом о прогоне тестов.

<p align="center">
<img width="70%" title="Уведомление в Telegram" src="media/screencaps/Bot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logos/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплён не только скриншот, но и видео прохождения теста, записанное Selenoid.
<p align="center">
  <img title="Видео, записанное Selenoid" src="media/video/Video.gif">
</p>
