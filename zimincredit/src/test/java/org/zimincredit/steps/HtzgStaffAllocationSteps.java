package org.zimincredit.steps;

import org.zimincredit.pages.HtzgStaffAllocationPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HtzgStaffAllocationSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	HtzgStaffAllocationPage hsap = new HtzgStaffAllocationPage();
	
	@Given("^htzg staff allocation Username htzg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^staff allocation to htzg01 product name as \"([^\"]*)\"$")
	public void userStaffAllocationTo(String productName){
		hsap.staffAllocationTo(productName);
	}
	
	@Then("^htzg01 check status changed$")
	public void userCheckStatusChanged(){
		hsap.checkStatusChanged();
	}
	
	@Then("^logout htzg01 staff allocation$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser htzg01 staff allocation$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
