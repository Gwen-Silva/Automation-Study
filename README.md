# Automation Study

A Java test-automation project I used to practice Selenium, TestNG and Page Object design. It exercises the [Rahul Shetty Automation Practice](https://rahulshettyacademy.com/AutomationPractice/) page.

## Project structure

- `src/test/java/pages/`: page objects and locators.
- `src/test/java/tests/selenium/`: browser tests, configuration, TestNG listener and failure screenshots.
- `src/test/resources/config.properties`: URL of the practice site.
- `pom.xml` and `testng.xml`: Maven dependencies and test configuration.

The browser scenarios cover radio buttons, autocomplete input, dropdowns, checkboxes, windows and tabs, alerts, and element visibility. Rest Assured is declared as a dependency, but an API suite has **not** been implemented in this project. Postman is not part of its runnable code.

## Running locally

Requirements: JDK 11 or newer, Maven and Google Chrome. Selenium Manager (included with the Selenium version declared in `pom.xml`) resolves the ChromeDriver binary where supported; an internet connection may be required for its first setup.

1. Clone the repository.
2. Run `mvn test` from the repository root.

This uses an external practice site, and I have **not** recorded a clean test run against its current version.

## Changes in the portfolio review branch

- Removed the old Windows-only ChromeDriver path and unused credential placeholders from configuration.
- Updated the configuration reader to fail clearly if configuration is missing.
- Added actual visibility assertions to the Show and Hide scenarios.

## Remaining work

- Add assertions to tests that currently perform actions without checking the outcome.
- Isolate the browser tests so test order does not affect them.
- Correct window/tab handling and clean up opened windows between tests.
- Review locators against the current external site and execute the suite in a clean environment.
- Add API tests only after choosing an API and defining verifiable scenarios.

The original study history is preserved. Test results will be documented only after execution.
