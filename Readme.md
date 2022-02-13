## Documentation

Before you start, please take a look at the [Getting Started Guide](https://www.edureka.co/blog/create-selenium-maven-project/) of the project 


## About The Project

This is a [FlipKart](https://www.flipkart.com/) Automation Maven Project build by using [Selenium](https://www.guru99.com/introduction-to-selenium.html) and [TestNg](https://www.seleniumeasy.com/testng-tutorials/testng-introduction).

## TestNG file description
- Testng.xml : XML file which contains all the Test configuration and used to run and organize our test.

## Packages description 
 - com.selenium.flipkart_automation.pages : This package has all the pages file which contain corresponding web page elements.       
 - com.selenium.flipkart_automation.tests : This package has all the test file which contain all the methods corresponding to the web pages
 - com.selenium.flipkart_automation.utils : This package contains utilities needed for the tests.

## Tests.java files description 
-**BaseTest** : The Base class which defines: 
- *@Test*- to run the test cases
- *@BeforeMethod* - to run before method
- *@AfterMethod*  - to run after method
- *@BeforeTest*  - to run before test
- *@AfterTest*   - to run before test


## How to run on github
- gitHub link :- **https://github.com/Bhagyasr123/FlipKart_Automation**

## Important Note

-**To change the browser ** - You can change the browser to go into config.properties file:
- *FOR FIREFOX BROWSER* - browser= firefox
- *FOR GOOGLE CHROME* - browser= chrome
- *FOR MICROSOFT EDGE* - browser= edge
- *FOR HEADLESS MODE* - browser= chromehl

-If in any case test case shows that page is unable to load or unexpected error then run the test case again or reload page manually

## Important Directory

- Drivers : ./Drivers/
- Report File : ./Reports/ExtentReport.html
- Log File : ./output/logs/log4j-allLogForFlipKArt.log
- Configuration File: ./Resources/config.properties
- Screenshots Folder: ./FailedScreenshots/
- Test Data File : ./Resources/testData/TestDataForFlipKart.xlsx


### Screenshots

- Screenshots will generated only when test case fail.

### Reports

- Extent Report will generated after running the test cases.

## How to run in testNg

- Run testNg.xml file [alt+shift+x,G]

## How to run in Maven command line

- In command prompt at projects location use 

```
mvn clean test
```

## Main Parameters in config.properties file

- browser : chromehl -> to run the test cases in headless mode.

## Implemented features

-	Create atleast 20 automated scenarios across different flows and screens - **done** 
-	Implement POM - **done**
-	Use Logger to implement logging in your test cases - **done**
-	Test data should be read from excel sheet. User has the ability to selective run the 	 	cases by 	marking yes in the Execution Required field in excel - **done**  
-	Global Parameters should be read from Config file like browser name, test site 	URL,  	etc. 	should be read from a properties file - **done**  
-	Put proper assertions and error screenshot in the extent report - **done**
-	Test Suite should be executable from command line using Maven - **done**
-	Use proper waits i.e., implicit wait and explicit wait wherever necessary  - **done** 
-	The test should run on following browsers Chrome, FF, EE - **done** 
-	There should be an option to run the test cases in headless mode - **done**
-	Use Grouping, Priority, and enable/disable when creating the TestNG Test Cases 	- **done**  
-	Assertions should be used properly throughout the suite - **done** 
-	Create reusable libraries and import these as jars in the current project - **done** 	(com.selenium.flipkart_automation.utils)
-	Create a ReadMe document which has the steps to install and run the code - **done**
-	Integrate your test suite with Jenkins and GitHub for CI/CD part -  **done**



