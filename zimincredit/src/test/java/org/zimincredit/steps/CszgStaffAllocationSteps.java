package org.zimincredit.steps;

import org.zimincredit.pages.CszgStaffAllocationPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CszgStaffAllocationSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	CszgStaffAllocationPage csap = new CszgStaffAllocationPage();
	
	@Given("^cszg staff allocation Username cszg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^staff allocation to cszy01 product name as \"([^\"]*)\"$")
	public void userStaffAllocation(String productName){
		csap.staffAllocation(productName);
	}
	
	@Then("^cszg01 check status changed$")
	public void userCheckStatusChanged(){
		csap.checkStatusChanged();
	}
	
	@Then("^logout cszg01 staff allocation$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser cszg01 staff allocation$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
