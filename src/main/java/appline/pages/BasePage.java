package appline.pages;

import appline.managers.ManagerPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appline.managers.DriverManager.getDriver;

public class BasePage {
    protected ManagerPages app = ManagerPages.getManagerPages();


    protected Actions action = new Actions(getDriver());


    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);




    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    protected WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void fillInputField(WebElement field, String value) {
        elementToBeClickable(field);
        clickElementAction(field);
        field.sendKeys(value);
    }

    protected void keyEnter(WebElement element) {
        elementToBeClickable(element).sendKeys(Keys.ENTER);
    }

    protected void elementTextToBePresent(WebElement element, String value) {
        wait.withMessage("Текс элемента ожидался " + value + "\n\n\n\n");
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
    }

    protected void clickElementJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    protected void moveToElement(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    protected void waitPresenceLocated(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    protected void clickElementAction(WebElement element) {
        action.click(element).build().perform();
    }





}
