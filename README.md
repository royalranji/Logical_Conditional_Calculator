Logical Condition Calculator Project

@Author: Ranjithkumar Sundararajan

Tech Stack: 
Selenium
Cucumber
Test NG
Java
Maven

Design pattern used - Page Object Model (POM)

Commands to execute the test

# For single instance
mvn clean test -Dcucumber.filter.tags="@test"

# For parallel instances*
mvn clean test -Dcucumber.filter.tags="@test" -Ddataproviderthreadcount=3

Improvements:
Better synchronization can be implemented  
Necessary logging to put in place  
Scope for refining page factory  
To implement reporting mechanism using Allure/Extent reports etc

Cucumber Report:
![img.png](img.png)

![img_1.png](img_1.png)



