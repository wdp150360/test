package org.zimincredit.steps;

import org.zimincredit.pages.HtzgSubmitTokfzyPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HtzgSubmitTokfzySteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	HtzgSubmitTokfzyPage hstp = new HtzgSubmitTokfzyPage();
	
	@Given("^htzg submit to kfzy Username htzg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^htzg click submit button product name as \"([^\"]*)\"$")
	public void userClickSubmitButton(String productName){
		hstp.clickSubmitButton(productName);
	}
	
	@Then("^htzg submit to kfzy check product status changed$")
	public void userCheckProductStatusChanged(){
		hstp.checkProductStatusChanged();
	}
	
	@Then("^logout htzg submit to kfzy$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser htzg submit to kfzy$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
