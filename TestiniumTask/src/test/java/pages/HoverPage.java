package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {

    WebDriver driver;

    By hoverToDahaFazlaGoster = By.cssSelector("#pagedListContainer > div:nth-child(2) > div.productList__moreContent.-prev > button");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }


    public void hoverToElement() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(hoverToDahaFazlaGoster);
        action.moveToElement(element);
        element.click();
    }

}
