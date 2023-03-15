package com.fleetgru.pages;

import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//h1)[2]")
    public WebElement header;

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement userName;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logout;

}
