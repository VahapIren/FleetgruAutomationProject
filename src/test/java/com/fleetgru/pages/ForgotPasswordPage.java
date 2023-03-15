package com.fleetgru.pages;

import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "h2.title")
    public WebElement forgotPasswordHeader;
}
