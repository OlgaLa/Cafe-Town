# Cafe-Town

# Before running tests:
1. Make sure that browser drivers are set in the system properties 
* Download *chrome* or *firefox* driver
* Unzip it in any folder 
* For Windows: 
  * Type *advanced system settings* in the search box (beside the Windows start button), clicks View advanced system settings.
  * Select *Advance tab*, clicks *Environment Variables*
  * In System variables, find PATH, clicks edit and append path to the folder with drivers to the end.
  * Click OK
2. (Optional) Install *allure comanline* to generate reports. You can find info how to do this here: https://docs.qameta.io/allure/latest/#_installing_a_commandline


# How to run the tests in the terminal: 
1. Go to the project folder
2. `mvn clean test` to run tests
Additional parameters: 
* run tests in a specific browser(chrome is default): `-Dbrowser=chrome firefox`
* run a specific test suite: `-Dsuite=LoginSuite.xml` (All possible suites are in the folder /src/test/resources/)
* run tests which allow to specific group: `-Dgroup=login`

Example: `mvn clean test -Dbrowser=firefox -Dsuite=LoginSuite.xml` 
 --> run Login tests suite in FireFox

3. `allure serve /target/allure-reports/` to generate report 
