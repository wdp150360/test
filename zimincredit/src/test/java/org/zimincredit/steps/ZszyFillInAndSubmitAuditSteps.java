package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;
import org.zimincredit.pages.ZszyFillInAndSubmitAuditPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZszyFillInAndSubmitAuditSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	ZszyFillInAndSubmitAuditPage zfasap = new ZszyFillInAndSubmitAuditPage();
	
	@Given("^zszy fill in and submit audit Username zszy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^zszy click fill in button product name as \"([^\"]*)\"$")
	public void userClickFillInButton(String productName){
		zfasap.clickFillInButton(productName);
	}
	
	@Then("^zszy fill in product field$")
	public void userFillInProductField(DataTable table){
		zfasap.fillInProductField(table);
	}
	
	@Then("^zszy click fill in submit button$")
	public void userClickFillInSubmitButton(){
		zfasap.clickFillInSubmitButton();
	}
	
	@Then("^zszy fill in check product status changed$")
	public void userFillInCheckProductStatusChanged(){
		zfasap.fillInCheckProductStatusChanged();
	}
	
	@When("^zszy click submit audit button$")
	public void userClickSubmitAuditButton(){
		zfasap.clickSubmitAuditButton();
	}
	
	@Then("^zszy staff allocation to zsfh01$")
	public void userStaffAllocationTo(){
		zfasap.staffAllocationTo();
	}
	
	@Then("^zszy staff allocation check product status changed$")
	public void userStaffAllocationCheckProductStatusChanged(){
		zfasap.staffAllocationCheckProductStatusChanged();
	}
	
	@Then("^logout zszy01 fill in and submit audit$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser zszy01 fill in and submit audit$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
