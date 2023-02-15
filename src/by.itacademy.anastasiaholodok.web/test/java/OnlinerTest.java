import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
    @Test
    public void testOpenOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.get(OnlinerPage.URL);
        String copyrightXPath = OnlinerPage.COPYRIGHT;
        By copyrightBy = By.xpath(copyrightXPath);
        WebElement copyrightElement = driver.findElement(copyrightBy);

        Assert.assertEquals("© 2001—2023 Onlíner", copyrightElement.getText());
        driver.quit();
    }
    @Test
    public void testOpenOnlinerLoginForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(OnlinerPage.URL);

        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String logoEnterXPath = OnlinerPage.LOGO_ENTER;
        By logoEnterBy = By.xpath(logoEnterXPath);
        WebElement logoEnterElement = driver.findElement(logoEnterBy);

        Assert.assertEquals("Вход", logoEnterElement.getText());
        driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(OnlinerPage.URL);

        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String btnModalLoginXPath = OnlinerPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

        Thread.sleep(5000);

        Assert.assertEquals("Укажите пароль", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_PASSWORD)).getText());
        Assert.assertEquals("Укажите ник или e-mail", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_EMAIL)).getText());
        driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(OnlinerPage.URL);

        String btnEnterXPath = OnlinerPage.BUTTON_LOGIN;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        driver.findElement(By.xpath(OnlinerPage.INPUT_EMAIL)).sendKeys("a@yandex.ru");

        String btnModalLoginXPath = OnlinerPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

        Thread.sleep(5000);

        Assert.assertEquals("Укажите пароль", driver.findElement(By.xpath(OnlinerPage.LABEL_WITHOUT_PASSWORD)).getText());
        driver.quit();
    }
}