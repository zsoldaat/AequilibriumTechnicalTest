# AequilibriumTechnicalTest

# Assumptions

I am assuming that anything beyond the login page is not part of the login feature. Specifically, I did not create any test cases to address the issue experienced by "problem_user", as the problem with their account lies in the content they see once they have already bypassed the login page.

# Exercise 1:

The test cases for the login feature are listed in a document called "Update Aequilibrium Technical Test - All Test Cases.txt". 

# Exercise 2 Installation:

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
