# Swag Labs Selenium Test Automation

Automated UI tests for [Swag Labs](https://www.saucedemo.com/v1) using Java, Selenium WebDriver, and TestNG.

## Features

- Login tests (valid, invalid, random credentials)
- Product selection and cart verification
- Order placement and confirmation
- Page Object Model structure
- Gradle build and dependency management

## Prerequisites

- Java 17 or higher
- Gradle 7 or higher
- Chrome, Firefox, or Edge browser installed

## Setup

1. Clone the repository:
git clone https://github.com/howlett-james/SauceDemo_Practise.git

2. Install dependencies:
## Running Tests

### All Tests

Run all tests using the TestNG suite:
### Single Test

Run a specific test class or method from your IDE, or use:
### Rerun Failed Tests

After a suite run, rerun failed tests using the generated `testng-failed.xml`:

> **Note:**  
> `testng-failed.xml` is generated only when running via a suite XML (e.g., `testng.xml`).  
> Make sure your `BaseTest` uses `@Optional` parameters for browser and headless mode to avoid parameter errors.

## Project Structure

- `src/main/java/` — Page objects, utilities, and core classes
- `src/test/java/` — Test classes and assertions
- `src/test/resources/` — TestNG suite XML

## Configuration

- Default browser: Chrome
- Default URL: https://www.saucedemo.com/v1
- Change browser or headless mode via TestNG parameters in `testng.xml`

## Authors

- [Yokesh](https://github.com/howlett-james)

## License

This project is licensed under the MIT License.
