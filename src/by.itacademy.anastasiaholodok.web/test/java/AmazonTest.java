import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    @Test
    public void testOpenAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.get(AmazonPage.URL);

        String copyrightXPath = AmazonPage.COPYRIGHT;
        By copyrightBy = By.xpath(copyrightXPath);
        WebElement copyrightElement = driver.findElement(copyrightBy);

        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates", copyrightElement.getText());
        driver.quit();
    }
    @Test
    public void testOpenAmazonCart(){
        WebDriver driver = new ChromeDriver();
        driver.get(AmazonPage.URL);

        String btnEnterXPath = AmazonPage.BUTTON_CART;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String logoEnterXPath = AmazonPage.LABEL_WITHOUT_FILLING_CART;
        By logoEnterBy = By.xpath(logoEnterXPath);
        WebElement logoEnterElement = driver.findElement(logoEnterBy);

        Assert.assertEquals("Your Amazon Cart is empty", logoEnterElement.getText());
        driver.quit();
    }
    @Test
    public void testOpenAmazonLoginForm(){
        WebDriver driver = new ChromeDriver();
        driver.get(AmazonPage.URL);

        String btnEnterXPath = AmazonPage.BUTTON_CART;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String btnModalLoginXPath = AmazonPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

        Assert.assertEquals("Sign in", driver.findElement(By.xpath(AmazonPage.LOGO_LOGIN_FORM)).getText());
        driver.quit();
    }
    @Test
    public void testAmazonLoginFormWithEmptyCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.get(AmazonPage.URL);

        String btnEnterXPath = AmazonPage.BUTTON_CART;
        By btnEnterBy = By.xpath(btnEnterXPath);
        WebElement btnEnterElement = driver.findElement(btnEnterBy);
        btnEnterElement.click();

        String btnModalLoginXPath = AmazonPage.BUTTON_MODAL_LOGIN;
        By btnModalLoginBy = By.xpath(btnModalLoginXPath);
        WebElement btnModalLoginElement = driver.findElement(btnModalLoginBy);
        btnModalLoginElement.click();

        driver.findElement(By.xpath(AmazonPage.BUTTON_CONTINUE)).click();

        Assert.assertEquals("Enter your email or mobile phone number", driver.findElement(By.xpath(AmazonPage.LABEL_WITHOUT_AUTHORIZATION)).getText());
        driver.quit();
    }
}