package pages;

import csv.CSVConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    By username = By.cssSelector("#n-input-email");
    By password = By.cssSelector("#n-input-password");
    By giris = By.cssSelector("#login > button");
    By networkIcon = By.cssSelector("#cop-app > div > div > header > div > div > div.col-md-2 > a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws InterruptedException {
        CSVConfig csvConfig = new CSVConfig();
        List<List<String>> csv = csvConfig.readCsv();
        String usernames = csv.get(0).get(0);
        String passwords = csv.get(0).get(1);

        Thread.sleep(2000);
        driver.findElement(username).sendKeys(usernames);
        driver.findElement(password).sendKeys(passwords);
        WebElement element = driver.findElement(giris);
        Assert.assertEquals(element.getText(), "GİRİŞ YAP");
        element.click();
        driver.findElement(networkIcon).click();
    }
}
