# AequilibriumTechnicalTest

# Installation

1. Download Eclipse, or any other Java IDE. 
2. In Eclipse, select File -> Import. 
3. Select Git -> Projects from Git (with smart import). 
4. Select Clone URI
5. in the "URI" field, paste the following: https://github.com/zsoldaat/AequilibriumTechnicalTest.git
6. Click "Next"
7. Select a local storage location for the project on your computer. 
8. Click "Finish". The project should now appear on the left side of project explorer in Eclipse.
9. Navigate to the "src/test/java" folder -> "tests". 
10. Right-click on "LoginChrome.java." Click "Run as TestNG test"
11. Right-click on "LoginFirefox.java." Click "Run as TestNG test"
12. Right-click on the project, select "Refresh". 
13. You should see two files: extentReports-Chrome.html and extentReports-Firefox.html. Open those both in your browser to see the results of the automated tests for each of the test cases. 

# Comments

You'll see there are also two files in the "tests" folder: "BaseTestClass.java" and "Login.java". Those were my original tests that were using TestNG parameters to control the browser selection. It would have been nice to get this working so that you don't have to run the tests once for each browser, but the versions of these frameworks I was using were not playing nice with ExtentReports for whatever reason. I left the textng.xml file to show that I do understand how TestNG parameters work. 
