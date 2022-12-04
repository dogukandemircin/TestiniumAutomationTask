package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;

    By product = By.cssSelector("#product-133233 > div > div.product__header > a.product__imageWrapper > div");

    By addToCart = By.cssSelector("#mainContent > div > div.container > div.row > div.col-12.col-lg-4 > div > div.product__buttons > button.product__button.-addToCart.btn.-black");
    By beden = By.cssSelector("#mainContent > div > div.container > div.row > div.col-12.col-lg-4 > div > div.product__sizes > div.product__content.-sizes > div:nth-child(4) > label");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductAndAddToCart() throws InterruptedException {
        driver.findElement(product).click();
        driver.findElement(beden).click();
        driver.findElement(addToCart).click();
        Thread.sleep(5000);
    }
}
