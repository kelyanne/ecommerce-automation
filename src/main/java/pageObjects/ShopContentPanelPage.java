package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopContentPanelPage extends BasePage {

    public WebDriver driver;

    By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
    By checkoutBtn = By.linkText("\uE876PROCEED TO CHECKOUT");

    public ShopContentPanelPage() throws IOException {
        super();
    }

    public WebElement getContinueShopBtn() {
        this.driver = getDriver();
        return driver.findElement(continueShoppingBtn);
    }

    public WebElement getCheckoutBtn(){
        this.driver = getDriver();
        return driver.findElement(checkoutBtn);
    }
}
