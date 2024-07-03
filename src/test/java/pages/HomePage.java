package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    // Locators
    private By radio1Locator = By.cssSelector("input[value='radio1']");
    private By radio2Locator = By.cssSelector("input[value='radio2']");
    private By radio3Locator = By.cssSelector("input[value='radio3']");
    private By autoCompleteLocator = By.id("autocomplete");
    private By dropdownLocator = By.id("dropdown-class-example");
    private By checkBox1Locator = By.id("checkBoxOption1");
    private By checkBox2Locator = By.id("checkBoxOption2");
    private By checkBox3Locator = By.id("checkBoxOption3");
    private By openWindowLocator = By.id("openwindow");
    private By openTabLocator = By.id("opentab");
    private By nameInputLocator = By.id("name");
    private By productTableLocator = By.id("product");
    private By displayedTextLocator = By.id("displayed-text");
    private By showButtonLocator = By.id("show-textbox");
    private By hideButtonLocator = By.id("hide-textbox");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRadioButton1() {
        driver.findElement(radio1Locator).click();
    }

    public void clickRadioButton2() {
        driver.findElement(radio2Locator).click();
    }

    public void clickRadioButton3() {
        driver.findElement(radio3Locator).click();
    }

    public boolean isRadioButtonSelected(int radioButtonIndex) {
        switch (radioButtonIndex) {
            case 1:
                return driver.findElement(radio1Locator).isSelected();
            case 2:
                return driver.findElement(radio2Locator).isSelected();
            case 3:
                return driver.findElement(radio3Locator).isSelected();
            default:
                throw new IllegalArgumentException("Invalid radio button index: " + radioButtonIndex);
        }
    }

    public void enterAutoComplete(String text) {
        WebElement autoComplete = driver.findElement(autoCompleteLocator);
        autoComplete.sendKeys(text);
    }

    public void selectDropdownOption(String optionText) {
        WebElement dropdown = driver.findElement(dropdownLocator);
        dropdown.sendKeys(optionText);
    }

    public void clickCheckbox1() {
        driver.findElement(checkBox1Locator).click();
    }

    public void clickCheckbox2() {
        driver.findElement(checkBox2Locator).click();
    }

    public void clickCheckbox3() {
        driver.findElement(checkBox3Locator).click();
    }

    public void clickOpenWindowButton() {
        driver.findElement(openWindowLocator).click();

    }

    public void checkNewWindow() {
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

    public void closeNewWindow() {
        driver.close();
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[0]);
    }

    public void checkNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void closeNewTab() {
        driver.close();
    }

    public void clickOpenTabLink() {
        driver.findElement(openTabLocator).click();
    }

    public void enterName(String name) {
        WebElement nameInput = driver.findElement(nameInputLocator);
        nameInput.sendKeys(name);
    }

    public void clickAlertButton() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public WebElement getProductTable() {
        return driver.findElement(productTableLocator);
    }

    public WebElement getDisplayedTextElement() {
        return driver.findElement(displayedTextLocator);
    }

    public void clickShowButton() {
        driver.findElement(showButtonLocator).click();
    }

    public void clickHideButton() {
        driver.findElement(hideButtonLocator).click();
    }

}
