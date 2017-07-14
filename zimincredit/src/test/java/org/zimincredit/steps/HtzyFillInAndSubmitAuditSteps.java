package org.zimincredit.steps;

import org.zimincredit.pages.HtzyFillInAndSubmitAuditPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HtzyFillInAndSubmitAuditSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	HtzyFillInAndSubmitAuditPage hfasap = new HtzyFillInAndSubmitAuditPage();
	
	@Given("^htzy fill in and submit contract Username htzy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^htzy click dispose button product name as \"([^\"]*)\"$")
	public void userClickDisposeButton(String productName){
		hfasap.clickDisposeButton(productName);
	}
	
	@When("^htzy click tab contract$")
	public void userClickTabContract(){
		hfasap.clickTabContract();
	}
	
	@Then("^htzy click save button in tab contract$")
	public void userClickSaveButtonInTabContract(){
		hfasap.clickSaveButtonInTabContract();
	}
	
	@When("^htzy click tab loan message$")
	public void userClickTabLoanMessage(){
		hfasap.clickTabLoanMessage();
	}
	
	@Then("^htzy fill in loan message$")
	public void userFillInLoanMessage(DataTable table){
		hfasap.fillInLoanMessage(table);
	}
	
	@Then("^htzy click save button in tab loan message$")
	public void userClickSaveButtonInTabLoanMessage(){
		hfasap.clickSaveButtonInTabLoanMessage();
	}
	
	@When("^htzy click process submit button$")
	public void userClickProcessSubmitButton(){
		hfasap.clickProcessSubmitButton();
	}
	
	@Then("^htzy check product status changed$")
	public void userCheckProductStatusChanged(){
		hfasap.checkProductStatusChanged();
	}
	
	@When("^htzy click submit audit button$")
	public void userClickSubmitAuditButton(){
		hfasap.clickSubmitAuditButton();
	}
	
	@Then("^htzy check product status changed after submit$")
	public void userCheckProductStatusChangedAfterSubmit(){
		hfasap.checkProductStatusChangedAfterSubmit();
	}
	
	@Then("^logout htzy fill in and submit contract$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser htzy fill in and submit contract$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
