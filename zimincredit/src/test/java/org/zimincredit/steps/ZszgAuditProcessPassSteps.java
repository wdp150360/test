package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;
import org.zimincredit.pages.ZszgAuditProcessPassPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZszgAuditProcessPassSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	ZszgAuditProcessPassPage zappp = new ZszgAuditProcessPassPage();
	
	@Given("^zszg audit process pass Username zszg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^zszg click submit audit button product name as \"([^\"]*)\"$")
	public void userClickSubmitAuditButton(String productName){
		zappp.clickSubmitAuditButton(productName);
	}
	
	@Then("^zszg check product status changed$")
	public void userCheckProductStatusChanged(){
		zappp.checkProductStatusChanged();
	}
	
	@Then("^logout zszg audit process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^close browser zszg audit process$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
