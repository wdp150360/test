package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;
import org.zimincredit.pages.ProductProcessSetPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductProcessSetSteps {

	private String url = "https://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	ProductProcessSetPage ppsp = new ProductProcessSetPage();

	@Given("^customer Username jkzy as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void jkzyLoginSuccess(String userName,String password,String name){
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}

	@Given("^click button go into process_management page$")
	public void userClickButtonProcessManagement(){
		ppsp.clickButtonProcessManagement();
	}

	@Then("^query needs to bind product name as \"([^\"]*)\"$")
	public void userQueryBindProductName(String productName){
		ppsp.queryBindProductName(productName);
	}

	@Then("^click button BindingTemplate$")
	public void userClickButtonBindingTemplate(){
		ppsp.clickButtonBindingTemplate();
	}

	@And("^click button Process_Set$")
	public void userClickButtonProcessSet(){
		ppsp.clickButtonProcessSet();
	}

	@When("^Set process template$")
	public void userSetProcessTemplate(DataTable table){
		ppsp.setProcessTemplate(table);
	}

	@Then("^commit and check bind success$")
	public void userCommitAndCheckBindSuccess(){
		ppsp.commitAndCheckBindSuccess();
	}

	@Then("^user logout$")
	public void userLogout(){
		ltp.logout();
	}

	@And("^closed browser$")
	public void userClosedBrowser(){
		lp.closedBrowser();
	}
}
