package org.zimincredit.steps;

import org.zimincredit.pages.CsfhAuditProcessPassPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CsfhAuditProcessPassSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	CsfhAuditProcessPassPage cappp = new CsfhAuditProcessPassPage();
	
	@Given("^csfh audit process pass Username cszy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^csfh click submit audit button product name as \"([^\"]*)\"$")
	public void userClickSubmitAuditButton(String productName){
		cappp.clickSubmitAuditButton(productName);
	}
	
	@Then("^csfh check product status changed$")
	public void userCheckProductStatusChanged(){
		cappp.checkProductStatusChanged();
	}
	
	@Then("^logout csfh audit process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^close browser csfh audit process$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
