package org.uk.co.automationtesting;
import base.Hooks;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;
import java.io.IOException;

@Listeners(resources.Listeners.class)
public class AddRemoveItemCartTest extends Hooks {

    public AddRemoveItemCartTest() throws IOException {
    }

    @Test
    public void removeItemCart() throws IOException {
        Homepage home = new Homepage();
        home.getTestStoreLink().click();

        ShopHomepage shopHomepage = new ShopHomepage();
        shopHomepage.getProdOne().click();

        ShopProductPage shopProductPage = new ShopProductPage();
        Select option = new Select(shopProductPage.getSizeOption());
        option.selectByVisibleText("M");
        shopProductPage.getQuantIncrease().click();
        shopProductPage.getAddToCartBtn().click();

        ShopContentPanelPage shopContentPanelPage = new ShopContentPanelPage();
        shopContentPanelPage.getContinueShopBtn().click();

        shopProductPage.getHomepageLink().click();

        shopHomepage.getProdTwo().click();

        shopProductPage.getAddToCartBtn().click();

        shopContentPanelPage.getCheckoutBtn().click();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.getDeleteItemTwo().click();

        waitElementBeInvisible(shoppingCartPage.getDeleteItemTwo(), 120);

        Assert.assertEquals(shoppingCartPage.getTotalAmount().getText(), "$45.24");
    }
}
