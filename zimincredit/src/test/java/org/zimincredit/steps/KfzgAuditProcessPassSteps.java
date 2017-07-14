package org.zimincredit.steps;

import org.zimincredit.pages.KfzgAuditProcessPassPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KfzgAuditProcessPassSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	KfzgAuditProcessPassPage kappp = new KfzgAuditProcessPassPage();
	
	@Given("^kfzg audit process pass Username kfzg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^click commit button product name as \"([^\"]*)\"$")
	public void userClickCommitButton(String productName){
		kappp.clickCommitButton(productName);
	}
	
	@Then("^kfzg01 check status changed$")
	public void userCheckStatusChanged(){
		kappp.checkStatusChanged();
	}
	
	@Then("^logout kfzg01 audit process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser kfzg01 commit process$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
