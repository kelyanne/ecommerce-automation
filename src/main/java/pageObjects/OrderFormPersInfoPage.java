package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormPersInfoPage extends BasePage {

    public WebDriver driver;

    By signInLink = By.linkText("Sign in");
    By emailLoginField = By.cssSelector("form#login-form > section input[name='email']");
    By passwordLoginField = By.cssSelector("form#login-form > section input[name='password']");
    By genderMr = By.cssSelector("label:nth-of-type(1) > .custom-radio > input[name='id_gender']");
    By genderMrs = By.cssSelector("label:nth-of-type(2) > .custom-radio > input[name='id_gender']");
    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By emailGuessField = By.cssSelector("form#customer-form > section input[name='email']");
    By passwordGuessField = By.cssSelector("form#customer-form > section input[name='password']");
    By birthDateField = By.cssSelector("input[name='birthday']");
    By receiveOffersCheckbox = By.cssSelector("div:nth-of-type(7)  span > label > span");
    By newsletterCheckbox = By.cssSelector("div:nth-of-type(8)  span > label > span");
    By termsConditionsCheckbox = By.cssSelector("input[name='psgdpr']");
    By continueGuessBtn = By.cssSelector("form#customer-form  button[name='continue']");
    By continueLoginBtn = By.cssSelector("form#login-form  button[name='continue']");

    public OrderFormPersInfoPage() throws IOException {
        super();
    }

    public WebElement getSignInLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(signInLink);
    }

    public WebElement getEmailLoginField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailLoginField);
    }

    public WebElement getPasswordLoginField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(passwordLoginField);
    }

    public WebElement getGenderMr() throws IOException {
        this.driver = getDriver();
        return driver.findElement(genderMr);
    }

    public WebElement getGenderMrs() throws IOException {
        this.driver = getDriver();
        return driver.findElement(genderMrs);
    }

    public WebElement getFirstNameField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(firstNameField);
    }

    public WebElement getLastnameField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(lastNameField);
    }

    public WebElement getEmailGuessField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailGuessField);
    }

    public WebElement getPasswordGuessField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(passwordGuessField);
    }

    public WebElement getBirthDateField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(birthDateField);
    }

    public WebElement getRecOfferCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(receiveOffersCheckbox);
    }

    public WebElement getNewsletterCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(newsletterCheckbox);
    }

    public WebElement getTermsConditionsCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(termsConditionsCheckbox);
    }

    public WebElement getContinueGuessBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueGuessBtn);
    }

    public WebElement getContinueLoginBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueLoginBtn);
    }
}
