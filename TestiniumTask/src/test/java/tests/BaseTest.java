package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import org.apache.log4j.Logger;
/*
1-Page ve Test paketleriyle testler POM halinde yazılmıştır.

2- chromedriver version 106 ya uygun olarak yüklendi, testin koşması için chromedriver güncellemeniz gerekebilir.

3-Tests paketi içerisinde testler hem ayrı ayrı yazılmıştır ve tekli olarak çalıştırılması sağlanmıştır.

4-Tests paketi içerisinde "BaseTest" class'ı içinde tüm testler çağırılıp allTestCase oluşturulup tüm testlerin çalışması sağlanmıştır.

5-Testler içerisine assertion'lar ve log'lar eklenip daha kolay okunabilir olması sağlanmıştır.

6-Proje içerisinde CSV kullanılıp ayrı bir pakette CSVConfig oluşturulmuştur ve CSV'den okunup login işlemleri bu csv üzerinden yapılmıştır.
 */

public class BaseTest {
    WebDriver driver;
    SearchPage searchPage;
    HoverPage hoverPage;
    ProductPage productPage;
    LoginPage loginPage;
    BasketPage basketPage;

    private static final Logger log = Logger.getLogger(BaseTest.class);


    @Before
    public void chromeConfig() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.network.com.tr");
        driver.manage().window().maximize();
    }

    @Test
    public void allTestCases() throws InterruptedException {
        searchText();
        hoverToElement();
        clickProductAndAddToCart();
        basket();
        login();
        removeItemFromBasket();
    }

    public void searchText() {
        searchPage = new SearchPage(driver);
        log.info("Ceket kelimesi ile arama yapılıyor!");
        searchPage.search("ceket");
    }

    public void hoverToElement() {
        hoverPage = new HoverPage(driver);
        log.info("Daha fazla göster butonuna hover yapılıyor!");
        hoverPage.hoverToElement();
        String url = driver.getCurrentUrl();
        log.info("Url kontrolü yapılıyor !");
        Assert.assertEquals(2, Integer.parseInt(url.replace("https://www.network.com.tr/search?searchKey=ceket&page=", "")));
    }

    public void clickProductAndAddToCart() throws InterruptedException {
        productPage = new ProductPage(driver);
        log.info("Ürüne tıklanıp sepete ekleniyor !");
        productPage.clickProductAndAddToCart();
    }

    public void login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login();
    }

    public void basket() throws InterruptedException {
        basketPage = new BasketPage(driver);
        basketPage.basket();
    }

    public void removeItemFromBasket() {
        basketPage = new BasketPage(driver);
        basketPage.removeItemFromBasket();
    }

}
