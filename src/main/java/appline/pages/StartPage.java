package appline.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.fail;

public class StartPage extends BasePage {
    private @FindBy(xpath = "//div[@class='service__title']")
    List<WebElement> menu;

    @Step("Переходим в меню \"Вклады\"")
    public ContributionsPage gotToMenu(String nameMenu) {
        for(WebElement item : menu) {
            item = item.findElement(By.xpath("./div"));
            if(item.getText().contains(nameMenu)){
                moveToElement(item);
                clickElementAction(item);
                return app.getContributionsPage();
            }
        }
        fail("Элемент меню с названием = " + nameMenu + "не найден");
        return app.getContributionsPage();
    }


}
