package com.fleetgru.step_definations;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.ForgotPasswordPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.pages.QuickLaunchpadPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinations {


    LoginPage loginPage=new LoginPage();
    QuickLaunchpadPage quickLaunchpadPage=new QuickLaunchpadPage();

    DashboardPage dashboardPage=new DashboardPage();


    ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();



    @Given("User is on the Fleetgru login page")
    public void user_is_on_the_fleetgru_login_page() {
        Driver.getDriver().get("https://qa.fleetgru.com/user/login");
    }
    @When("User log in as a truck driver")
    public void user_log_in_as_a_truck_driver() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("Driver"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }
    @Then("User should be on the {string} page")
    public void user_should_be_on_the_quick_launchpad_page(String expectedHeader) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(quickLaunchpadPage.header));
        Assert.assertTrue(expectedHeader.equals(quickLaunchpadPage.header.getText()));
    }

    @When("User log in as a sales manager")
    public void userLogInAsASalesManager() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("Sales_Manager"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }

    @Then("User should be on {string} page")
    public void userShouldBeOnTheDashboardPage(String expectedHeader) {
        BrowserUtils.sleep(3);
        Assert.assertTrue(expectedHeader.equals(dashboardPage.header.getText()));
    }

    @When("User log in as a store manager")
    public void userLogInAsAStoreManager() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("Store_Manager"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }

    @When("user logins with valid {string} and {string}")
    public void user_logins_with_valid_and(String username, String password) {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty(username));
        loginPage.password.sendKeys(ConfigurationReader.getProperty(password));
        loginPage.loginBtn.click();
    }
    @When("user logins with {string} and valid {string}")
    public void user_logins_with_and_valid(String username, String password) {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty(username));
        loginPage.password.sendKeys(ConfigurationReader.getProperty(password));
        loginPage.loginBtn.click();
    }
    @Then("user should see {string}")
    public void user_should_see(String expectedMessage) {
        loginPage.innvalidMessage.click();
        Assert.assertEquals(expectedMessage,loginPage.innvalidMessage.getText());
    }

    @When("user logins without any username")
    public void user_logins_without_any_username() {
        loginPage.userName.sendKeys("");
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }
    @Then("user should see Please fill out this field on username field")
    public void user_should_see_please_fill_out_this_field() {
        String expected="true";
        Assert.assertEquals(expected,loginPage.userName.getAttribute("required"));
    }


    @When("user logins without any password")
    public void userLoginsWithoutAnyPassword() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("Driver"));
        loginPage.password.sendKeys("");
        loginPage.loginBtn.click();

    }

    @Then("user should see Please fill out this field on password field")
    public void userShouldSeePleaseFillOutThisFieldOnPasswordField() {
        String expected="true";
        Assert.assertEquals(expected,loginPage.password.getAttribute("required"));
    }

    @When("user logins without any username and password")
    public void userLoginsWithoutAnyUsernameAndPassword() {
        loginPage.userName.sendKeys("");
        loginPage.password.sendKeys("");
        loginPage.loginBtn.click();
        //Assert.assertTrue(loginPage.userName.equals(Driver.getDriver().switchTo().activeElement()));
    }

    @When("User click on the {string} link")
    public void user_click_on_the_link(String string) {
        loginPage.forgotPassword.click();
    }
    @Then("User should land on the {string} page")
    public void user_should_land_on_the_page(String string) {
        Assert.assertEquals(string,forgotPasswordPage.forgotPasswordHeader.getText());
    }

    @When("User can see {string} link")
    public void user_can_see_link(String string) {
        Assert.assertTrue(loginPage.rememberMe.getText().contains(string));

    }
    @Then("The link is clickable")
    public void the_link_is_clickable() {
        Assert.assertTrue(loginPage.rememberMe.isEnabled());
    }

    @When("User write anything on password input")
    public void user_write_anything_on_password_input() {
        loginPage.password.sendKeys("anything");
    }
    @Then("User should see characters in bullet sign")
    public void user_should_see_characters_in_bullet_sign() {
        String expected= "password";
        Assert.assertTrue(loginPage.password.getAttribute("type").equals(expected));
    }

    @Then("{string} is on the profile menu")
    public void is_on_the_profile_menu(String string) {
        if (string.equals("user1")){
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(quickLaunchpadPage.userName));
            Assert.assertTrue(quickLaunchpadPage.userName.getText().contains(string));
        }else{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName));
            Assert.assertEquals(string,dashboardPage.userName.getText());
        }
    }


    @When("user enter username but without password and press Enter")
    public void userEnterUsernameButWithoutPasswordAndPressEnter() {
        loginPage.userName.sendKeys("anything"+ Keys.ENTER);
    }

    @Then("user should see required message on password field")
    public void userShouldSeeRequiredMessageOnPasswordField() {
        Assert.assertTrue(loginPage.password.equals(Driver.getDriver().switchTo().activeElement()));
    }

    @When("user enter password but without any username and press Enter")
    public void userEnterPasswordButWithoutAnyUsernameAndPressEnter() {
        loginPage.password.sendKeys("anything"+Keys.ENTER);

    }

    @Then("user should see required message on username field")
    public void userShouldSeeRequiredMessageOnUsernameField() {
        Assert.assertTrue(loginPage.userName.equals(Driver.getDriver().switchTo().activeElement()));
    }

    @When("user does not enter username and password and press Enter")
    public void userDoesNotEnterUsernameAndPasswordAndPressEnter() {
        loginPage.userName.sendKeys("");
        loginPage.password.sendKeys(""+Keys.ENTER);

    }

    @When("user enter valid username and password and press Enter")
    public void userEnterValidUsernameAndPasswordAndPressEnter() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("Driver"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);

    }

    @Then("user should land to Dashboard page")
    public void userShouldLandToDashboardPage() {
        String expectedTitle="Dashboard";
        BrowserUtils.sleep(3);
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    @When("user enter invalid username or password and press Enter")
    public void userEnterInvalidUsernameOrPasswordAndPressEnter() {
        loginPage.userName.sendKeys("anything");
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);

    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message,loginPage.innvalidMessage.getText());
    }

    @When("User login as a {string}")
    public void user_login_as_a(String string) {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty(string));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
        BrowserUtils.sleep(3);
    }
    @Then("User is on the {string} page")
    public void user_is_on_the_page(String expectedHeader) {
        if(expectedHeader.equals("Quick Launchpad")) {
            Assert.assertTrue(expectedHeader.equals(quickLaunchpadPage.header.getText()));
        }else
            Assert.assertTrue(expectedHeader.equals(dashboardPage.header.getText()));
    }
    boolean msg=false;
    @When("user send {string} and {string}")
    public void userSendAnd(String username, String password) {
        loginPage.login(username, password);
        if (username.isBlank()||password.isBlank()) {
            msg=true;
        }
    }

    @Then("user see {string}")
    public void userSee(String message) {
        if (msg) {
            message = "Lütfen bu alanı doldurun.";
            Assert.assertTrue(Driver.getDriver().switchTo().activeElement().getAttribute("validationMessage").equals(message));
        }else {
            if (Driver.getDriver().getTitle().equals("Login")) {
                message = "Invalid user name or password.";
                Assert.assertTrue(message.equals(loginPage.innvalidMessage.getText()));
            }else {
                message = "Dashboard";
                Assert.assertTrue(message.equals(Driver.getDriver().getTitle()));
            }
        }
    }

    @When("user logins {string} and {string} press Enter")
    public void userLoginsAnd(String username, String password) {
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password+Keys.ENTER);
        if (username.isBlank()||password.isBlank()) {
           msg=true;
        }

    }
}
