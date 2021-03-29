# swaglabs

This demo framework is build on Spring boot using cucumber, selenium and TestNG. The test navigates to policy expert home insurance page and complete the following sections
  - About You (Implemented)
  - Statements about you (Skeleton only)
  - About your property (Skeleton only)
  - Statements about your property (Skeleton only)
  - About safety and security (Implemented)
  - About the joint policyholders (Implemented)
  - About your insurance history (Implemented)
  - About the cover you want (Building only scenario implemented)
  


  - main
    - java
      - com.policyexpert.qademofa
        - browser
          - BrowserDriver      => manage creation of web driver (Chrome/Firefox and web driver wait)
        - config
          - Faker              => manage the demo data
        - page
          - *page              => all page objects are defined
        - utility
          - ScenarioSession   => manage the data to be used within the steps
          - ScreenShotService  => manage the screenshot 
          - WebDriverHelper    => wrapper for selenium web driver
          - Workflow           => methods to support workflow of test
    - resources
      - application.properties => framework properties are defined
  - test
    - java
      - com.policyexpert.qademo
        - bdd
          - CucumberHooks      => cucumber hooks
          - *Steps             => step definitions
        - CucumberRunner       => runner class
    - resources
      - features 
        - *.features           => all features are defined
        

**Run the test with command line**
  - Prerequisite: JDK 1.8, Maven
  - Clone the repository
  - Goto the project directory with pom.xml 
  - Run with Chrome _mvn clean install -Dbrowser=chrome_
  - Run with Firefox _mvn clean install -Dbrowser=firefox_
  
**Run in IntelliJ**
  - Prerequisite: JDK 1.8, Maven, IntelliJ, IntelliJ Plugin (Cucumber for Java)
  - Open the pom.xml as project
  - Click Run -> Edit Configuration
  - Add new Cucumber java configuration
  - Main Class: _io.cucumber.core.cli.Main_
  - Feature or folder path: _WORKSPACE/qa-demo/src/test/resources/features/_
  - Click Save
  - Run
  
