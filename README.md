# Automation Front End - OpenBank Test Cases

#### 🧑‍💻 Technologies Used

- Java 21 
- Maven
- JUnit
- Cucumber | Gherkin BDD

## 🧪 Running Tests

1. First, compile the project to download all dependencies: `mvn clean install -DskipTests`

2. Create a JUnit run configuration in IntelliJ

3. Then, select the test class you want to run:   

* **JUnit**: `OpenBankHomeTest`
* **Cucumber**: `CucumberRunner` (runs `openbank.feature`)

4. Finally, select the environment variables you want to use: 

| Field           | Value  |
|-----------------|--------|
| Accessibility   | true   |
| Application     | ods    | (I have updated the framework locally to launch a custom page)
| Browser         | chrome |
| Platform        | web    |
| Provider        | local  |

## 📂 Project Structure

```
front-end-sergiosanz-task/
├───src
│    ├───main
│    │   ├───java
│    │   │   └───org
│    │   │       └───nttdata
│    │   │           ├───helpers
│    │   │           │       └───Runners
│    │   │           └───pages
│    │   │               └───odshome
│    │   │                   └───OdsHomePage
│    │   └───resources
│    └───test
│        ├───java
│        │   ├───core
│        │   │    └───CucumberTestBase
│        │   │    └───TestBase
│        │   ├───runner
│        │   │    └───CucumberRunner
│        │   ├───scripts
│        │   │    └───OpenBankHomeTest
│        │   ├───stepdef
│        │   │    └───OpenBankSteps
│        │   └───utils
│        │        └───TestHandler
│        └───resources
│             └───features
│                  └───openbank.feature
├───example-report.html
├───pom.xml
└───README.md
```

## 🗒️ Reports Generated

After the test run, the following report is generated:

* **Extent Report**: `report.html`
* **Cucumber Report**: `cucumber-report.html`