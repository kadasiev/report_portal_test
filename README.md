Для того чтобы запустить все тесты 

1. Для Maven необходимо выполнить команду:
mvn clean test -Denv=qa -Dbrowser=firefox -DtestSuite=regression
2. Для TestNG необходимо создать настройку как на скрине

![img.png](img.png)


Для того чтобы запустить одтдельно один тест его нужно добавить в группу run

![img_1.png](img_1.png)

1. Для запуска через Maven необходимо выполнить команду:
mvn clean test -Denv=qa -Dbrowser=firefox -DtestSuite=regression -Dgroups=run
2. Для запуска через TestNG необходимо создать настройку

![img_2.png](img_2.png)

Для того чтобы запустить Allure необходимо выполнить команду:
allure serve {project path}\report_portal_test\allure-results

