<h1 style="display: flex; align-items: center; justify-content: space-between;">
  <span>Проект по автоматизации тестирования сайта </span>
  <img src="images/icons/restore.jpeg" width="50"/>
</h1>

re:Store — официальный ритейлер техники Apple в России.
Проект направлен на автоматизацию UI-регрессионного тестирования сайта с использованием современного QA-стека и CI/CD.

Цели проекта:
•	проверка ключевых пользовательских сценариев
•	автоматический запуск тестов
•	генерация Allure-отчетов
•	уведомления о результатах в Telegram
•	интеграция с Jenkins

Содержание
•	Стек технологий￼
•	Сборка в Jenkins￼
•	Allure отчет￼
•	Уведомления в Telegram￼
•	Видео выполнения тестов (Selenoid)￼
•	Запуск тестов￼

Стек технологий
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/icons/intellij.png" width="50" height="50"  alt="intellij"/></a>
<a href="https://www.java.com/"><img src="images/icons/java.png" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/icons/github.png" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/icons/junit5.png" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/icons/gradle.png" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/icons/selenide.png" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/icons/selenoid.png" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/icons/allure.png" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/icons/jenkins.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="images/icons/telegram.png" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/icons/jira.png" width="50" height="50"  alt="Jira"/></a>  
</p>
	•	Java — язык программирования
	•	JUnit 5 — тестовый фреймворк
	•	Selenide — UI-автоматизация
	•	Gradle — система сборки
	•	Allure — отчеты о тестировании
	•	Jenkins — CI/CD
	•	Selenoid — запуск браузеров в Docker
	•	Telegram Bot — уведомления о сборках
    •   Jira: Платформа для управления проектами и отслеживания задач.
    •   Allure TestOps: Платформа для управления тестированием и анализа результатов тестов.

<h2>
  <img src="images/icons/jenkins.png" width="24" style="vertical-align: middle;" />
  Сборка в Jenkins
</h2>

Jenkins используется для автоматизации запуска тестов и генерации отчетов.
<p align="center">
  <img src="images/screenshots/jenkins.png" width="900" />
</p>
•	параметризованный запуск
•	автоматическая генерация Allure Report
•	история запусков
•	артефакты сборки
•	тренды прохождения тестов
Пример сборки в Jenkins:

