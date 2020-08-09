package appline.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.fail;

public class ContributionsPage extends BasePage {
    @FindBy(xpath = "//span[@class='calculator__currency-field-text']")
    List<WebElement> currencyButtons;

    @FindBy(xpath = "//label[text()='Сумма вклада']/parent::div/div/label/input")
    WebElement sumContributionInput;

    @FindBy(xpath = "//label[text()='Ежемесячное пополнение']/parent::div/div/label/input")
    WebElement monthlyPayment;

    @FindBy(xpath = "//select")
    WebElement timeOfDepositForm;


    @FindBy(xpath = "//input[@name='capitalization']/..")
    WebElement checkbox;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement interestAccrued;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenishmentInFewMonths;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement removeInFewMonths;

    @Step("Выбираем валюту для вклада: {currencyName}")
    public ContributionsPage clickCurrencyButton(String currencyName) {
        for (WebElement item : currencyButtons) {
            if (item.getText().contains(currencyName)) {
                elementToBeClickable(item).click();
                return this;
            }
        }
        fail("Валюта с наименованием = " + currencyName + "не найдена");
        return this;
    }


    @Step("Вводим сумму вклада")
    public ContributionsPage fillSumContributionInput(String value) {
        fillInputField(sumContributionInput, value);
        return this;
    }

    @Step("Вводим ежемесячное пополнение")
    public ContributionsPage fillMonthlyPaymentInput(String value) {
        fillInputField(monthlyPayment, value);
        return this;
    }


    @Step("Выбираем срок вложения")
    public ContributionsPage selectTimeOfDeposit(String timeOfDeposit) {
        Select select = new Select(timeOfDepositForm);
        select.selectByVisibleText(timeOfDeposit);
        return this;

    }

    @Step("Ставим галочку 'Ежемесячная капитализация'")
    public ContributionsPage clickCheckBoxMonthlyCapitalization() {
        elementToBeClickable(checkbox);
        clickElementAction(checkbox);
        return this;
    }

    @Step("Проверяем значения полей")
    public ContributionsPage assertField(String nameField, String expectedValue) {
        switch (nameField) {
            case "Начислено %":
                elementTextToBePresent(interestAccrued, expectedValue);
                break;
            case "Пополнение":
                elementTextToBePresent(replenishmentInFewMonths, expectedValue);
                break;
            case "К снятию":
                elementTextToBePresent(removeInFewMonths, expectedValue);
                break;
            default:
                fail("Элемент" + nameField + "Не найден");
        }

        return this;

    }
}
