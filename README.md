# Mobile Automation Project (mobileb1)

This project contains simple test automation for an Android application using Appium, Selenium, TestNG, and Java.

## Project Structure

The core automation script is located at:
- `src/test/java/com/example/AppTest.java`

Dependencies and build configuration are managed within:
- `pom.xml`

## Dependencies

This Maven project encompasses the following key dependencies:
- **Appium Java Client** (v10.1.0): Interacts with Android mobile elements using WebDriver commands.
- **TestNG** (v7.12.0): Robust testing framework allowing annotation-based test declarations, suites, and assertions.

## Application Under Test
The test currently targets the **General Store** test application (`com.androidsample.generalstore`).

## Prerequisites

To successfully execute this test suite, ensure the following software is running:
1. **Java Development Kit (JDK)**: Installed and environment variables set correctly.
2. **Maven**: Configured in system variables for dependency management and test execution.
3. **Appium Server**: Actively running locally at `http://127.0.0.1:4723`.
4. **Android Emulator / Target Device**: 
   - An emulated or physical Android device should be booted up.
   - Default configuration specifically looks for `emulator-5554`. Update `appium:udid` in `AppTest.java` (capabilities) to match your device if different.

## Automated Scenario
`AppTest` runs a continuous shopping cart scenario containing these steps:
1. Selects a localized region ("Albania").
2. Enters user input properties (Name: "Test User").
3. Chooses a gender option ("Female").
4. Clicks the "Let's Shop" entrance button.
5. Injects the first available product listing into the cart container.
6. Opens the cart page.
7. Toggles the generic terms check interface component.

## Execution

To execute the test automation via command-line, navigate to the project directory and invoke Maven:

```bash
mvn clean test
```
