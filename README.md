Running All Tests

1. Using Maven:
mvn clean test -Denv=qa -Dbrowser=firefox -DtestSuite=regression
2. Using TestNG:
   Create a run configuration as shown in the screenshot below:
![img.png](img.png)


Running Selected Tests (by Group)
Add the tests you want to execute into the run group.
![img_1.png](img_1.png)

1. Using Maven:
mvn clean test -Denv=qa -Dbrowser=firefox -DtestSuite=regression -Dgroups=run
2. Using TestNG:
   Create a run configuration as shown in the screenshot below:
![img_2.png](img_2.png)

Generating Allure Report
allure serve {project path}\report_portal_test\allure-results

