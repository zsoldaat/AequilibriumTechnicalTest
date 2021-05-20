# AequilibriumTechnicalTest

# Assumptions

I am assuming that anything beyond the login page is not part of the login feature. Specifically, I did not create any test cases to address the issue experienced by "problem_user", as the problem with their account lies in the content they see once they have already bypassed the login page.

# Exercise 1:

The test cases for the login feature are listed in a document called "Update Aequilibrium Technical Test - All Test Cases.txt".

The titles of the fields I'm using for each test case are in the first line of the document, seperated by a "|". The values for all the test cases are in the following lines. 

# Exercise 2 Installation:

1. Download Eclipse, or any other Java IDE.
2. Create an empty Java project in the project explorer.
3. In Eclipse, select File -> Import. 
4. Select Git -> Projects from Git (with smart import). 
5. Select Clone URI
6. in the "URI" field, paste the following: https://github.com/zsoldaat/AequilibriumTechnicalTest.git
7. Click "Next"
8. Select the empty Java project you created in step 2.
9. Click "Finish". The project should now appear on the left side of project explorer in Eclipse in the empty Java project you had created.
10. Navigate to the "src/test/java" folder -> "tests". 
11. Run "LoginChrome.java".
12. Run "LoginFirefox.java".
13. Right-click on the project, select "Refresh". 
14. You should see two files: extentReports-Chrome.html and extentReports-Firefox.html. Open those both in your browser to see the results of the automated tests for each of the test cases. 

# Comments

You'll see there are also two files in the "tests" folder: "BaseTestClass.java" and "Login.java". Those were my original tests that were using TestNG parameters to control the browser selection. It would have been nice to get this working so that you don't have to run the tests once for each browser, but the versions of these frameworks I was using were not playing nice with ExtentReports for whatever reason. I left the textng.xml file to show that I do understand how TestNG parameters work. 
