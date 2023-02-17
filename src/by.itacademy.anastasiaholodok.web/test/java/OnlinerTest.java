import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinerTest {
    WebDriver driver = new ChromeDriver();
    @Before
    public void start() {
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        String copyrightXPath = OnlinerPage.COPYRIGHT;
        By copyrightBy = By.xpath(copyrightXPath);
        WebElement copyrightElement = driver.findElement(copyrightBy);

        Assert.assertEquals("© 2001—2023 Onlíner", copyrightElement.getText());
    }

    @Test
    public void testOpenOnlinerLoginForm() throws InterruptedException {
        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String logoEnterXPath = OnlinerPage.LOGO_ENTER;
        By logoEnterBy = By.xpath(logoEnterXPath);
        WebElement logoEnterElement = driver.findElement(logoEnterBy);

        Assert.assertEquals("Вход", logoEnterElement.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String btnModalLoginXPath = OnlinerPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

        WebElement webEl = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(OnlinerPage.LABEL_WITHOUT_PASSWORD)));

        Assert.assertEquals("Укажите пароль", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_PASSWORD)).getText());
        Assert.assertEquals("Укажите ник или e-mail", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_EMAIL)).getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword(){
        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        driver.findElement(By.xpath(OnlinerPage.INPUT_EMAIL)).sendKeys("a@yandex.ru");

        String btnModalLoginXPath = OnlinerPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

       new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(OnlinerPage.LABEL_WITHOUT_PASSWORD)));

        Assert.assertEquals("Укажите пароль", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_PASSWORD)).getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyEmail(){
        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        driver.findElement(By.xpath(OnlinerPage.INPUT_PASSWORD)).sendKeys("12345");

        String btnModalLoginXPath = OnlinerPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(OnlinerPage.LABEL_WITHOUT_EMAIL)));

        Assert.assertEquals("Укажите ник или e-mail", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_EMAIL)).getText());
    }
    @After
    public void finish(){
        driver.quit();
    }
}