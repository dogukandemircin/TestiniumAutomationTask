package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebDriver driver;

    By searchText = By.id("search");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String text) {
        WebElement element = driver.findElement(searchText);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
}
