package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;
import org.zimincredit.pages.ZsfhAuditProcessPassPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZsfhAuditProcessPassSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	ZsfhAuditProcessPassPage zappp = new ZsfhAuditProcessPassPage();
	
	@Given("^zsfh audit process pass Username zsfh01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^zsfh click submit audit button product name as \"([^\"]*)\"$")
	public void userClickSubmitAuditButton(String productName){
		zappp.clickSubmitAuditButton(productName);
	}
	
	@Then("^zsfh check product status changed$")
	public void userCheckProductStatusChanged(){
		zappp.checkProductStatusChanged();
	}
	
	@Then("^logout zsfh audit process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^close browser zsfh audit process$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
