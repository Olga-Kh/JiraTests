# JiraTests

Welcome to anyone, who comes in peace and is going to use these tests :)

Using it you can perform verification of certain set of features - **Login to Jira** (here you can find `@DataProvider`, which allows to check different data sets, valid and not valid - just add the key and value for the ones you're interested in), **View existing issue**, **Create new issue** and **Add issue comment**. For the convenience and effective maintainability this project is designed using PageObject pattern - so there are tests, and there are objects to represent the pages.

### Project Installation and Tests Execution
Getting it up and running is quite simple - copy the web URL and open it as a "new project from Version Control" using your IDE and hit Run - you'll see the run results in the Terminal.

![Run results in Idea](https://github.com/Olga-Kh/JiraTests/blob/media/1.png?raw=true)

If you're not going to use IDE, perform `git clone` of the project, go to the local project path and run command `mvn clean test` - you'll see the build and run processes in console logs, as well as the results. 

![Run results in CommandLine](https://github.com/Olga-Kh/JiraTests/blob/media/run_results_cmd.png?raw=true)

Quantitiy of passed tests is according current settings, but changing content of `<classes></classes>` section in testng.xml file, you are able to control, which specific test should or should not be run.

### Before you start
To be able to perform these actions, it is nessesary for you to have the following software installed on your PC (if you already do, small reminder wouldn't hurt, right?):
- Java JDK 8
- Git
- Maven

### Additional features
Also note, that this project provides an opportunity to capture and store screenshots, when test failure occurred. In addition - you can set up this option for some other events - file TestNGListener.java is designed and added for that purpose, just edit it to your taste and needs.

And even more - if you are interested in running your tests in CircleCI - I've got it covered for you too, just add the project to your GitHub and set it up to be built in CircleCI. File config.yml in ".circleci" folder is added specially for that - commits to the chosen branch will trigger new build. 

So good luck and I hope you'll have a pleasant experience :) 

Please, don't hesitate to address your questions or improvement propositions to me - any contribution is appreciated!
