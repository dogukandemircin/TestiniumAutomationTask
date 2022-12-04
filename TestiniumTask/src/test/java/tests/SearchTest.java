package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SearchPage;

public class SearchTest {

    WebDriver driver;
    SearchPage searchPage;

    @Before
    public void chromeConfig(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.network.com.tr");
        driver.manage().window().maximize();
    }

    @Test
    public void hoverElement() {
        searchPage = new SearchPage(driver);
        searchPage.search("ceket");
    }
}
