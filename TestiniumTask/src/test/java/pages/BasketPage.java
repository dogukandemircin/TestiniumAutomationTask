package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {

    WebDriver driver;

    By basket = By.cssSelector("#header__desktopBasket > div > div.header__basketSummary > a");
    By devamEt = By.cssSelector("#cop-app > div > div.layout.-default > div.layout__content > div.layout__sidebar > div > div.summary > button");

    By basketItem = By.cssSelector("body > div.stickyHeader > header > div > div > div.col-3.header__rightContent > div.header__basket.js-basket.header__basketLink > button > svg");
    By removeItem = By.cssSelector("#header__desktopBasket > div > div.header__basketProductList.-scrollOne > div > div.header__basketProductBtn.header__basketModal.-remove > svg");
    By cikart = By.cssSelector("body > div.o-modal.o-removeCartModal.-active > div.o-modal__wrapper > div > div.o-removeCartModal__buttonContainer > button.btn.-black.o-removeCartModal__button");
    By sepetBos = By.cssSelector("#header__desktopBasket > div > div.header__emptyBasket > span");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void basket() throws InterruptedException {
        driver.findElement(basketItem).click();
        driver.findElement(basket).click();
        Thread.sleep(2000);
        driver.findElement(devamEt).click();
    }

    public void removeItemFromBasket() {
        driver.findElement(basketItem).click();
        driver.findElement(removeItem).click();
        driver.findElement(cikart).click();
        driver.findElement(basketItem).click();
        String sepetBosControl = driver.findElement(sepetBos).getText();
        Assert.assertEquals(sepetBosControl, "Sepetiniz Henüz Boş");
    }
}
