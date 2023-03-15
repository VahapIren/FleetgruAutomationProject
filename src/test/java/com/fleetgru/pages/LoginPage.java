package com.fleetgru.pages;

import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[.='Invalid user name or password.']")
    public WebElement innvalidMessage;

    @FindBy(xpath = "//*[.='Forgot your password?']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMe;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement checkBox;

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }




}
