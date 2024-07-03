package tests.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestSelenium {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.openChromeBrowser());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void testRadioButtonExample() {
        homePage.clickRadioButton1();
        Assert.assertTrue(homePage.isRadioButtonSelected(1), "Radio button 1 should be selected.");

        homePage.clickRadioButton2();
        Assert.assertTrue(homePage.isRadioButtonSelected(2), "Radio button 2 should be selected.");

        homePage.clickRadioButton3();
        Assert.assertTrue(homePage.isRadioButtonSelected(3), "Radio button 3 should be selected.");
    }

    @Test(priority = 2)
    public void testAutocompleteExample() {
        homePage.enterAutoComplete("United States");

    }

    @Test(priority = 3)
    public void testDropdownExample() {
        homePage.selectDropdownOption("Option1");

    }

    @Test(priority = 4)
    public void testCheckboxExample() {
        homePage.clickCheckbox1();

    }

    @Test(priority = 5)
    public void testSwitchWindowExample() {
        homePage.clickOpenWindowButton();
        homePage.checkNewWindow();

    }

    @Test(priority = 6)
    public void testSwitchTabExample() {
        homePage.clickOpenTabLink();
        homePage.closeNewTab();

    }

    @Test(priority = 7)
    public void testSwitchToAlertExample() {
        homePage.enterName("John Doe");
        homePage.clickAlertButton();

    }

/*     @Test(priority = 8)
    public void testWebTableExample() {

    } */

    @Test(priority = 9)
    public void testElementDisplayedExample() {
        homePage.clickShowButton();
        homePage.getDisplayedTextElement();
    }

    @Test(priority = 10)
    public void testElementNotDisplayedExample() {
        homePage.clickHideButton();
        homePage.getDisplayedTextElement();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotError.captureScreenshot(driver, result);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
