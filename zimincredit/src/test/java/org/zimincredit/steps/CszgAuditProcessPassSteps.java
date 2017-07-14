package org.zimincredit.steps;

import org.zimincredit.pages.CszgAuditPorcessPassPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CszgAuditProcessPassSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	CszgAuditPorcessPassPage cappp = new CszgAuditPorcessPassPage();
	
	@Given("^cszg audit process pass Username cszg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^cszg click submit audit button product name as \"([^\"]*)\"$")
	public void userClickSubmitAuditButton(String productName){
		cappp.clickSubmitAuditButton(productName);
	}
	
	@Then("^cszg check product status changed$")
	public void userCheckProductStatusChanged(){
		cappp.checkProductStatusChanged();
	}
	
	@Then("^logout cszg audit process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^close browser cszg audit process$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
