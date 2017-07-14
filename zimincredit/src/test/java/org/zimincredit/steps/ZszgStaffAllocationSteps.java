package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;
import org.zimincredit.pages.ZszgStaffAllocationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZszgStaffAllocationSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	ZszgStaffAllocationPage zsap = new ZszgStaffAllocationPage();
	
	@Given("^zszg staff allocation Username zszg01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^staff allocation to zszy01 product name as \"([^\"]*)\"$")
	public void userStaffAllocationTo(String productName){
		zsap.staffAllocationTo(productName);
	}
	
	@Then("^zszg01 check status changed$")
	public void userCheckStatusChanged(){
		zsap.checkStatusChanged();
	}
	
	@Then("^logout zszg01 staff allocation$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser zszg01 staff allocation$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
