package org.zimincredit.steps;

import org.zimincredit.pages.KfzyToContractDepPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KfzyToContractDepSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	KfzyToContractDepPage ktcdp = new KfzyToContractDepPage();
	
	@Given("^kfzy to contract department Username kfzy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^kfzy click submit button product name as \"([^\"]*)\"$")
	public void userClickSubmitButton(String productName){
		ktcdp.clickSubmitButton(productName);
	}
	
	@Then("^kfzy check product status changed$")
	public void userCheckProductStatusChanged(){
		ktcdp.checkProductStatusChanged();
	}
	
	@Then("^logout kfzy to contract dep$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser kfzy to contract dep$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
