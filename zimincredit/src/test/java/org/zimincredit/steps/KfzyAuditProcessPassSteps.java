package org.zimincredit.steps;

import org.zimincredit.pages.KfzyAuditProcessPassPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KfzyAuditProcessPassSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	KfzyAuditProcessPassPage kappp = new KfzyAuditProcessPassPage();
	
	@Given("^kfzy audit process pass Username kfzy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^click Submit audit button product name as \"([^\"]*)\"$")
	public void UserClickSubmitauditbutton(String productName){
		kappp.clickSubmitauditbutton(productName);
	}
	
	@Then("^check status changed$")
	public void UserCheckStatusChanged(){
		kappp.checkStatusChanged();
	}
	
	@Then("^logout kfzy01 audit process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser audit process$")
	public void closedBrowser(){
		lp.closedBrowser();
	}
}
