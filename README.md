This framework is created by using Selenium and Cucumber BDD&DDT   
and navigated with java as a main programing language. Maven is used as a build automation tool. All dependencies and plugins are added in pom.xml. Junit is used to create some assertions and annotations for the purpose of verification in the framework.

This framework occurs from 2 main parts. The first part is "features" package that are stored in “resources”. One feature file is created for each main functionality (one feature file for each user story). The possible scenarios (Test Cases) are written in Gherkin Language. In these scenarios, both scenarios outline and parameterization are implemented for Data Driven Testing. Since I don't know any Acceptance Criteria, any requirement or any documentation, I have scripted test scenarios according to the website.

The second part is java package where all coding process and testing process are performed. This part occurs from 4 main packages:                                        
1) In the utilities package, there are 3 java classes.                                    - In “Driver” class, the singleton design pattern is created to allow the framework to pass the same exact instance of Driver in one session                - In “BrowserUtils” class, some useful and repeatable methods are added.  - In “ConfigurationReader” class, some methods are created to retrieve the datas from “Configuration.properties”. 
2) In “pages” package, the classes are created according to POM Design Pattern. One Java class is created for each page of the web application. All of related web elements to current page are stored in its own java class. Some related custom methods are also stored here, so that they are used in the step definitions. For verification, some assertions (from Junit) are used in those methods. “Basepage” class is created as an abstract class where other page classes extend. It includes the main method that initializes the driver instance and object of the class. It can also include common locators for all pages. 
3) In the step definitions package, one step definition class is created for each feature file. All methods in page class are used here. In Hooks class, some cucumber annotations are implemented such as Before, After. 
4) The framework is triggered from “CukesRunner” class in “runners” package.

     
The test results are attached here. There are 5 feature files, 25 scenarios and 108 steps in total.  