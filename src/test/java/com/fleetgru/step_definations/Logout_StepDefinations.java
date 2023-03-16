package com.fleetgru.step_definations;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Logout_StepDefinations {

    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("User already login to the Dashboard page")
    public void userAlreadyLoginToTheDashboardPage() {
        Driver.getDriver().get("http://qa.fleetgru.com/");
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("Sales_Manager"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName));
    }


    @When("user clicks to the profile menu and see logout button")
    public void userClicksToTheProfileMenuAndSeeLogoutButton() {
        BrowserUtils.sleep(2);
        dashboardPage.userName.click();
        Assert.assertTrue(dashboardPage.logout.isDisplayed());
    }

    @And("user clicks to the logout button")
    public void userClicksToTheLogoutButton() {
        dashboardPage.logout.click();
    }

    @Then("user should land on the {string} page")
    public void userShouldLandOnThePage(String title) {

        Assert.assertEquals(title, Driver.getDriver().getTitle());
    }

    @And("user clicks to the Back button")
    public void userClicksToTheBackButton() {
        Driver.getDriver().navigate().back();
    }

    @When("user closes to the tab-tabs")
    public void userClosesToTheTabTabs() {
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.open('https://qa.fleetgru.com/','_blank');");
        js.executeScript("window.open('https://qa.fleetgru.com/','_blank');");
        js.executeScript("window.open('https://qa.fleetgru.com/','_blank');");
        BrowserUtils.sleep(5);
        js.executeScript("window.open('https://google.com','_blank');");
        ArrayList<String> tabs =new ArrayList<String>(Driver.getDriver().getWindowHandles());
        BrowserUtils.sleep(5);

        int tabGoogleNum =0;
        for (int i = 0; i < tabs.size(); i++) {
            Driver.getDriver().switchTo().window(tabs.get(i));

            if (Driver.getDriver().getTitle().equals("Dashboard")) {
                //tabs.remove(tabs.get(i));
                Driver.getDriver().close();
            }else if(Driver.getDriver().getTitle().equals("Google"))
                tabGoogleNum =i;


        }
        Driver.getDriver().switchTo().window(tabs.get(tabGoogleNum));

        js.executeScript("window.open('https://qa.fleetgru.com/user/login','_blank');");

    }

    @And("user navigate to the login page")
    public void userNavigateToTheLoginPage() {
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }
        BrowserUtils.sleep(5);
        System.out.println(Driver.getDriver().getTitle());
    }

    @When("user wait {int} minutes")
    public void userWaitMinutes(int seconds) {
        BrowserUtils.sleep(seconds *61);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(3);
    }
}
