package HomeWork5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class HomeWork5FireFoxTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\\\Tetiana_Kryvytska\\\\Downloads\\\\geckodriver-v0.28.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DisplayName("FireFox Test")
    @Tag("testTag")
    @Test
    public void fireFoxTest() {
        driver.get("https://ecse00100fdb.epam.com:9002/yacceleratorstorefront/?site=electronics");
        WebElement searchField = driver.findElement(By.xpath("//input[@id='js-site-search-input']"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-link js_search_button']"));
        WebElement logoImg = driver.findElement(By.xpath("//div[@class='nav__left js-site-logo']//img[contains(@src, 'logo')]"));
        WebElement signInRegisterButton = driver.findElement(By.xpath("//div[@class='nav__right']//a[contains(text(),'Sign in / Register')]"));
        WebElement navigationMenu = driver.findElement(By.xpath("//div[@class='navigation__overflow']"));
        WebElement banner = driver.findElement(By.xpath("//div[@class='banner__component simple-banner']"));
        WebElement cartIcon = driver.findElement(By.xpath("//div[@class='yCmsContentSlot componentContainer']//div[@class='mini-cart-icon']"));


        searchField.sendKeys("camileo");
        searchButton.click();
        WebElement camileoInSearchResult = driver.findElement(By.xpath("//a[@class='product__list--name'][contains(@href, 'Camileo-S10-EU')]"));
        camileoInSearchResult.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='addToCartButton']"));
        addToCartButton.click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
