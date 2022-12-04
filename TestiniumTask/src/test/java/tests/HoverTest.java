package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HoverPage;
import pages.SearchPage;

public class HoverTest {
    WebDriver driver;
    HoverPage hoverPage;

    @Before
    public void chromeConfig(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.network.com.tr");
        driver.manage().window().maximize();
    }

    @Test
    public void hoverToElement() {
        hoverPage = new HoverPage(driver);
        hoverPage.hoverToElement();
    }
}
