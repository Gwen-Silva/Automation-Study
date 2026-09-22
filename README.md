# Automation Study

A small Java test-automation project I used to practice Selenium, TestNG and Page Object design. It exercises the [Rahul Shetty Automation Practice](https://rahulshettyacademy.com/AutomationPractice/) page.

## What's in the repository

- `src/test/java/pages/`: page objects and locators.
- `src/test/java/tests/selenium/`: browser tests, configuration, TestNG listener and failure screenshots.
- `src/test/resources/config.properties`: practice-site URL and local browser-driver configuration.
- `pom.xml` and `testng.xml`: Maven dependencies and test configuration.

The existing browser scenarios cover radio buttons, autocomplete input, dropdowns, checkboxes, windows and tabs, alerts, and element visibility. Rest Assured is declared in Maven, but this repository does **not** yet contain a working API test suite. Postman is not part of the runnable project.

## Running locally

Requirements: JDK 11 or newer, Maven, Google Chrome and a compatible ChromeDriver.

1. Clone the repository.
2. Replace the machine-specific `chromeDriverPath` in `src/test/resources/config.properties` with your own ChromeDriver path. The current value is an old local Windows path and will not work on another machine unchanged.
3. Run `mvn test` from the repository root.

The tests target a third-party practice site, so changes to that site can break locators or expected behavior. I have not recorded a recent clean run for the current repository state.

## Known gaps and planned improvements

- Add assertions to scenarios that currently execute actions without verifying the result.
- Isolate tests so execution order does not change their outcome.
- Fix window/tab cleanup and make browser setup portable.
- Remove unused selectors and credentials placeholders from configuration.
- Add an actual API test suite only after selecting a stable public API and defining its assertions.

This repository preserves the original study project. Changes will be made incrementally, with test results recorded when they are actually executed.
