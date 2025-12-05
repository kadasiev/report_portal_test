Running All Tests                                                        
mvn clean test -Denv=qa -Dbrowser=firefox -DtestSuite=regression


Running Selected Tests (by Group)                                                        
Add selected test method or test class to the group run (groups = {"run"})                    
mvn clean test -Denv=qa -Dbrowser=firefox -DtestSuite=groupedTests


Generating Allure Report                                             
allure serve {project path}\report_portal_test\allure-results

