import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {
    //Thread
    @Step("<wait> saniye bekle")
    public void waitForSecond(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        MyLogger.log.info(wait + " SANIYE BEKLENDI");

    }


    //Assert
    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlId(String id, String text) {
        Assert.assertTrue("Element text değerini içerir", appiumDriver.findElement(By.id(id)).getText().contains(text));
        MyLogger.log.info(text + " ALANI KONTROL EDILDI");



    }

    @Step("xpath<xpath> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlXpath(String xpath, String text) {
        Assert.assertTrue("Element text değerini içerir", appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
        MyLogger.log.info(text + " ALANI KONTROL EDILDI");


    }

    // Click
    @Step("<id> id'li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        MyLogger.log.info(id + " ID'LI LOCATER'A TIKLANDI");


    }

    @Step("<xpath> xpath'li elemente tıkla")
    public void clickByXPath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        MyLogger.log.info(xpath + " XPATH'LI LOCATER'A TIKLANDI");



    }


    //Send Keys
    @Step("<id> id'sine <text> textini yaz")
    public void sendKeysById(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        MyLogger.log.info(id + " ID'LI KISMA " + text + " YAZDIRILDI");



    }

    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
        MyLogger.log.info(" RANDOM URUN SECILDI");

    }

    //Scroll

    @Step("Scroll Down")
    public void scrollDown() {
        Dimension dimension = appiumDriver.manage().window().getSize();

        int startX = dimension.width / 2, startY = 1500, endX = dimension.width / 2, endY = 5;
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
        MyLogger.log.info("SCROLL EDILDI");
    }

}
