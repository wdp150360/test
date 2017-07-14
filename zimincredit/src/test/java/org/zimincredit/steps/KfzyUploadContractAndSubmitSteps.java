package org.zimincredit.steps;

import org.zimincredit.pages.KfzyUploadContractAndSubmitPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KfzyUploadContractAndSubmitSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	KfzyUploadContractAndSubmitPage kucasp = new KfzyUploadContractAndSubmitPage();
	
	@Given("^kfzy upload contract and submit as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^kfzy click upload contract button product name as \"([^\"]*)\"$")
	public void userClickUploadContractButton(String productName){
		kucasp.clickUploadContractButton(productName);
	}
	
	@Then("^kfzy click upload contract button and upload pic$")
	public void userUploadPic(){
		kucasp.uploadPic();
	}
	
	@When("^kfzy click closed contract page button$")
	public void userClickClosedContractPageButton(){
		kucasp.clickClosedContractPageButton();
	}
	
	@Then("^kfzy upload contract check product status changed$")
	public void userUploadContractCheckProductStatusChanged(){
		kucasp.uploadContractCheckProductStatusChanged();
	}
	
	@When("^kfzy click submit button to htzg$")
	public void userClickSubmitButtonTo(){
		kucasp.clickSubmitButtonTo();
	}
	
	@Then("^kfzy submit to htzg check product status changed$")
	public void userSubmitToCheckProductStatusChanged(){
		kucasp.submitToCheckProductStatusChanged();
	}
	
	@Then("^logout kfzy upload contract and submit$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser kfzy upload contract and submit$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
