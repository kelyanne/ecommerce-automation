package org.uk.co.automationtesting;

import base.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(resources.Listeners.class)
public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException {
    }

    @Test
    public void orderAsCustomer() throws IOException {
        Homepage homepage = new Homepage();
        homepage.getTestStoreLink().click();

        ShopHomepage shopHomepage = new ShopHomepage();
        shopHomepage.getProdOne().click();

        ShopProductPage shopProductPage = new ShopProductPage();
        Select option = new Select(shopProductPage.getSizeOption());
        option.selectByVisibleText("L");
        shopProductPage.getAddToCartBtn().click();

        ShopContentPanelPage shopContentPanelPage = new ShopContentPanelPage();
        shopContentPanelPage.getCheckoutBtn().click();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.getProceedCheckoutBtn().click();

        OrderFormPersInfoPage orderFormPersInfoPage = new OrderFormPersInfoPage();
        orderFormPersInfoPage.getSignInLink().click();
        orderFormPersInfoPage.getEmailLoginField().sendKeys("kelymiller@test.com");
        orderFormPersInfoPage.getPasswordLoginField().sendKeys("12345");
        orderFormPersInfoPage.getContinueLoginBtn().click();

        OrderFormDeliveryPage orderFormDeliveryPage = new OrderFormDeliveryPage();
        orderFormDeliveryPage.getContinueBtn().click();

        OrderFormShippingMethodPage orderFormShippingMethodPage = new OrderFormShippingMethodPage();
        orderFormShippingMethodPage.getDeliveryMsgTextbox().sendKeys("Random comment");
        orderFormShippingMethodPage.getContinueBtn().click();

        OrderFormPaymentPage orderFormPaymentPage = new OrderFormPaymentPage();
        orderFormPaymentPage.getPayByWireRadioBtn().click();
        orderFormPaymentPage.getTermsConditionsCheckbox().click();
        orderFormPaymentPage.getOrderBtn().click();

        OrderConfirmPage orderConfirmPage = new OrderConfirmPage();
        Assert.assertEquals(orderConfirmPage.getOrderConfirmedMsg().getText(), "\uE876YOUR ORDER IS CONFIRMED");
        Assert.assertEquals(orderConfirmPage.getOrderTotal().getText(), "$26.12");
    }


    @Test
    public void orderAsGuest() throws IOException {
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
        shopContentPanelPage.getCheckoutBtn().click();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.getHavePromo().click();
        shoppingCartPage.getPromoTextbox().sendKeys("20OFF");
        shoppingCartPage.getPromoAddBtn().click();
        shoppingCartPage.getProceedCheckoutBtn().click();

        OrderFormPersInfoPage orderFormPersInfoPage = new OrderFormPersInfoPage();
        orderFormPersInfoPage.getGenderMr().click();
        orderFormPersInfoPage.getFirstNameField().sendKeys("John");
        orderFormPersInfoPage.getLastnameField().sendKeys("Miller");
        orderFormPersInfoPage.getEmailGuessField().sendKeys("johnmiller@test.com");
        orderFormPersInfoPage.getTermsConditionsCheckbox().click();
        orderFormPersInfoPage.getContinueGuessBtn().click();

        OrderFormDeliveryPage orderFormDeliveryPage = new OrderFormDeliveryPage();
        orderFormDeliveryPage.getAddressField().sendKeys("123 Main Street");
        orderFormDeliveryPage.getCityField().sendKeys("Houston");
        Select state = new Select(orderFormDeliveryPage.getStateDropdown());
        state.selectByVisibleText("Texas");
        orderFormDeliveryPage.getPostcodeField().sendKeys("77021");
        orderFormDeliveryPage.getContinueBtn().click();

        OrderFormShippingMethodPage orderFormShippingMethodPage = new OrderFormShippingMethodPage();
        orderFormShippingMethodPage.getDeliveryMsgTextbox().sendKeys("Random comment");
        orderFormShippingMethodPage.getContinueBtn().click();

        OrderFormPaymentPage orderFormPaymentPage = new OrderFormPaymentPage();
        orderFormPaymentPage.getPayByCheckRadioBtn().click();
        orderFormPaymentPage.getTermsConditionsCheckbox().click();
        orderFormPaymentPage.getOrderBtn().click();

        OrderConfirmPage orderConfirmPage = new OrderConfirmPage();

        Assert.assertEquals(orderConfirmPage.getOrderConfirmedMsg().getText(), "\uE876YOUR ORDER IS CONFIRMED");
        Assert.assertEquals(orderConfirmPage.getOrderTotal().getText(), "$37.59");
    }
}
