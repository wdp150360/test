package org.zimincredit.steps;

import org.zimincredit.pages.CszyFillInAndSubmitAuditPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CszyFillInAndSubmitAuditSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	CszyFillInAndSubmitAuditPage cfasap = new CszyFillInAndSubmitAuditPage();
	
	@Given("^cszy fill in and submit audit Username cszy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^click fill in button product name as \"([^\"]*)\"$")
	public void userClickFillInButton(String productName){
		cfasap.clickFillInButton(productName);
	}
	
	@Then("^cszy fill in product field$")
	public void userFillInProductField(DataTable table){
		cfasap.fillInProductField(table);
	}
	
	@Then("^click fill in submit button$")
	public void userClickFillInSubmitButton(){
		cfasap.clickFillInSubmitButton();
	}
	
	@Then("^cszy fill in check product status changed$")
	public void userFillInCheckProductStatusChanged(){
		cfasap.fillInCheckProductStatusChanged();
	}
	
	@When("^cszy click submit audit button$")
	public void userClickSubmitAuditButton(){
		cfasap.clickSubmitAuditButton();
	}
	
	@Then("^cszy staff allocation to csfh01$")
	public void userStaffAllocationTo(){
		cfasap.staffAllocationTo();
	}
	
	@Then("^cszy staff allocation check product status changed$")
	public void userStaffAllocationCheckProductStatusChanged(){
		cfasap.staffAllocationCheckProductStatusChanged();
	}
	
	@Then("^logout cszy01 fill in and submit audit$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser cszy01 fill in and submit audit$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
