package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderConfirmPage extends BasePage{

    public WebDriver driver;

    By orderConfirmedMsg = By.cssSelector(".h1");
    By orderTotal = By.cssSelector(".font-weight-bold td:nth-of-type(2)");

    public OrderConfirmPage() throws IOException {
        super();
    }

    public WebElement getOrderConfirmedMsg(){
        driver = getDriver();
        return driver.findElement(orderConfirmedMsg);
    }

    public WebElement getOrderTotal(){
        driver = getDriver();
        return driver.findElement(orderTotal);
    }
}
