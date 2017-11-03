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
2. `mvn clean test -Dsurefire.suiteXmlFiles=AllTestsSuite.xml` to run all tests
Additional parameters: 
* run tests in a specific browser(chrome is default): `-Dbrowser=chrome firefox`
* run a specific test suite: `-Dsurefire.suiteXmlFiles=LoginSuite.xml`

Example: `mvn clean test -Dsurefire.suiteXmlFiles=LoginSuite.xml -Dbrowser=firefox` 
 --> run Login tests suite in FireFox

3. `allure serve allure-results` to generate report 
