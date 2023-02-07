package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopHomepage extends BasePage {

    public WebDriver driver;

    By productOne = By.cssSelector("article:nth-of-type(1) h3 > a");
    By productTwo = By.cssSelector("article:nth-of-type(2) h3 > a");
    By productThree = By.cssSelector("article:nth-of-type(3) h3 > a");
    By productFour = By.cssSelector("article:nth-of-type(4) h3 > a");

    public ShopHomepage() throws IOException {
        super();
    }

    public WebElement getProdOne() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productOne);
    }

    public WebElement getProdTwo() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productTwo);
    }

    public WebElement getProdThree() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productThree);
    }

    public WebElement getProdFour() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productFour);
    }

}
