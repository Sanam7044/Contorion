# Contorion
This is a Gradle project for automating login test case of Contorion website

It automates the following test case:

Given a user has a registered email and password
When the user login with valid credentials
The user should be able to login
And the user should see a welcome message 

Automation framework used: Selenium with Java, JUnit
As a driver, Chrome driver is used. It is configurable. You just need to change the driver name in the config.properties file and put your desired driver exe file in test/resources folder.
All the configuration related values are defined in config.properties file
All the element locators are in ElementLocator.java file
Login test scenario is under Login.java class.

Requirements:

Gradle 7.5.1
java "18.0.1.1"

How to run:
1. Clone repository: https://github.com/Sanam7044/Contorion.git
2. Go to project root directory (Contorion)
3. Checkout branch: feature/login
4. From the command line run 'gradle clean build'
5. The report will generate in the root_directory/build/reports/tests/test/index.html