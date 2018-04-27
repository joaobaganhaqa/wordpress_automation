# Wordpress Automation Backend
A Page Object Model Framework to test automation wordpress backend with Java, Maven, TestNG and Selenium 
The objective of this demo project is automate some parts of wordpress backend like Media Library and Posts for now.

I decide to choose Wordpress CMS, because is very complete and its wonderfull to cover lots of UI Elements, selenium webdriver, database tests etc...

<b>For now this demo covers:</b>

Data driven aproach;
Framework design pattern;
Data provider;
Handling Javascript alerts;
Handlind iFrames;
Handling input, checkboxes, and other HTML tags.   

<b>Note:</b>

This is developed on mac OS and to run this project you need to modify this files:

ConfigurationBase.java
TestUtilities.java
AddNewMediaTest.java

And change the directory paths to your system.

To run this project simply find testng.xml on /src/main/resourses and run on TestNG


<b>Observations:</b> 

One of my strugles is dealing with the dialog box of mac OS, and you can notice that on AddNewMediaTest.java. For handling this kind of dialog box on mac OS I need to use the Apple Script commands. 
