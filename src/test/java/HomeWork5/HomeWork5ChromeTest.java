package HomeWork5;

import homeWork5.HomeWork5;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

public class HomeWork5ChromeTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\Tetiana_Kryvytska\\\\Downloads\\\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DisplayName("My First Test")
    @Tag("testTag")
    @Test
    public void camileoTest() {
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
//        WebElement addCamileoToCartButton = driver.findElement(By.xpath("//a[contains(@href, 'Camileo-S10-EU')]/..//button[contains(@class, 'glyphicon-shopping-cart')]"));
        WebElement camileoInSearchResult = driver.findElement(By.xpath("//a[@class='product__list--name'][contains(@href, 'Camileo-S10-EU')]"));
        camileoInSearchResult.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='addToCartButton']"));
        addToCartButton.click();
    }

    @DisplayName("Task 2")
    @Tag("testTag")
    @Test
    public void differentUrlsTest() {
        driver.get("https://city-soap.com.ua/");
        driver.getTitle();
        printCurrentPageInfo("City-soap");
        driver.get("https://furnitura-ua.com/ua/");
        printCurrentPageInfo("Furnitura");
        driver.navigate().back();
        driver.navigate().refresh();
        printCurrentPageInfo("Go back to city-soap and refresh");

    }

    @DisplayName("Task 3")
    @Tag("testTag")
    @Test
    public void glossUa() {
        driver.get("https://gloss.ua/");
        List<WebElement> listOfArticles = driver.findElements(By.xpath("//div[@class='vc_container']//a"));
        System.out.println("Full list of Articles and urls:");
        printFullNamesAndUrlsList(listOfArticles);
    }

    private void printCurrentPageInfo(String text){
        System.out.println(text);
        System.out.println("Page title is " + driver.getTitle());
        System.out.println("Page url is " + driver.getCurrentUrl());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
