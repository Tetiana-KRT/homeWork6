package HomeWork6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static homeWork5.HomeWork5.*;

public class HomeWork6Test {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\Tetiana_Kryvytska\\\\Downloads\\\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DisplayName("Add To Cart Test")
    @Tag("testTag")
    @Test
    public void addToCartTest() {
        driver.get("https://ecse00100fdb.epam.com:9002/yacceleratorstorefront/?site=electronics");
        WebElement searchField = driver.findElement(By.xpath("//input[@id='js-site-search-input']"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-link js_search_button']"));
        String amount = "￥610.00";
        searchField.sendKeys("1934793");
        searchButton.click();
        WebElement productInSearchResult = driver.findElement(By.xpath("//a[@class='product__list--name'][contains(@href, '1934793')]"));
        productInSearchResult.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='addToCartButton']"));
        addToCartButton.click();
        WebElement checkOutButton = driver.findElement(By.xpath("//a[contains(text(),'Check Out')]"));
        checkOutButton.click();
        WebElement subtotal = driver.findElement(By.xpath("//div[@class='col-xs-6 cart-totals-right text-right']"));
        Assert.assertEquals(amount, subtotal.getText());
        WebElement total = driver.findElement(By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']"));
        Assert.assertEquals(amount, total.getText());
        WebElement checkOutButtonInCart = driver.findElement(By.xpath("//div[@class='cart__actions']//button[contains(text(),'Check Out')]"));
        checkOutButtonInCart.click();
        WebElement guestEmailInput = driver.findElement(By.xpath("//input[@id='guest.email']"));
        guestEmailInput.sendKeys("test@user.com");
        WebElement confirmGuestEmailInput = driver.findElement(By.xpath("//input[@id='guest.confirm.email']"));
        confirmGuestEmailInput.sendKeys("test@user.com");
        WebElement checkOutAsGuestButton = driver.findElement(By.xpath("//button[.='Check Out as a Guest']"));
        checkOutAsGuestButton.click();
        WebElement subtotalValue = driver.findElement(By.xpath("//div[@class='subtotal']//span"));
        WebElement totalValue = driver.findElement(By.xpath("//div[@class='totals']//span"));
        WebElement taxValue = driver.findElement(By.xpath("//div[@class='realTotals']//p"));
        Assert.assertEquals(amount, subtotalValue.getText());
        Assert.assertEquals(amount, totalValue.getText());
        Assert.assertTrue(taxValue.getText().contains("￥55.45"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
