package appline.utils;

import appline.managers.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyAllureListener extends AllureJunit4 {


//  Здесь должен быть переопределённые методы или метод который позволит прикреплять скриншоты к шагу аллюра
//  Если не получается переопредилить то скопировать библиотеку AllureJunit4 себе в пакет listener
//  И прописать в конкретном месте в скопированной библиотеке строчку Allure.addAttachment();
//  Или там же прописать Allure.getLifecycle().addAttachment();
    @Override
        public void testFailure(Failure failure) {
        addScreenshot();
        super.testFailure(failure);
    }



    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}