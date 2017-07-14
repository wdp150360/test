package org.zimincredit.steps;

import org.zimincredit.pages.JkzyAgreeProcessPage;
import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JkzyAgreeProcessSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	JkzyAgreeProcessPage japp = new JkzyAgreeProcessPage();
	
	@Given("^jk audit process pass Username jkzy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@When("^jk click agree button product name as \"([^\"]*)\"$")
	public void userClickAgreeButton(String productName){
		japp.clickAgreeButton(productName);
	}
	
	@Then("^jk check product status changed$")
	public void userCheckProductStatusChanged(){
		japp.checkProductStatusChanged();
	}
	
	@Then("^logout jk agree process$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser jk agree process$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
