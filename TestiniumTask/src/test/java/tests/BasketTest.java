package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasketPage;
import pages.ProductPage;

public class BasketTest {
    WebDriver driver;
    BasketPage basketPage;

    @Before
    public void chromeConfig(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.network.com.tr");
        driver.manage().window().maximize();
    }

    @Test
    public void basket() throws InterruptedException {
        basketPage = new BasketPage(driver);
        basketPage.basket();
    }

    @Test
    public void removeItemFromBasket(){
        basketPage = new BasketPage(driver);
        basketPage.removeItemFromBasket();
    }
}
