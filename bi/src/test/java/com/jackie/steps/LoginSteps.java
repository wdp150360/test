package com.jackie.steps;

import com.jackie.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by luhaiming on 2017/6/1 0001.
 */
public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("^user open brower \"([^\"]*)\"$")
    public void userOpenBrower(String url) throws Throwable {
        loginPage.openBrowse(url);
    }

    @Given("^user input username \"([^\"]*)\"$")
    public void userInputUsername(String username) throws Throwable {
        loginPage.inputUserName(username);
    }

    @Given("^user input password \"([^\"]*)\"$")
    public void userInputPassword(String password) throws Throwable {
        loginPage.inputPassword(password);
    }

    @Then("^user login in the zmcredit system as \"([^\"]*)\"$")
    public void userLoginInTheZmcreditSystemAs(String username) throws Throwable {
        loginPage.checkUserName(username);
    }

    @When("^user click the button login$")
    public void userClickTheButtonLogin() throws Throwable {
        loginPage.clickLoginButton();
    }


}
