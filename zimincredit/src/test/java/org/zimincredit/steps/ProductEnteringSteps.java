package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.LogoutPage;
import org.zimincredit.pages.ProductEnteringPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductEnteringSteps {

	private String url = "http://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	LogoutPage ltp = new LogoutPage();
	ProductEnteringPage pep = new ProductEnteringPage();
	
	@Given("^customer Username kfzy01 as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void LoginSuccess(String userName, String password, String name) {
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}
	
	@Then("^click button product entering$")
	public void userClickButtonProductEntering(){
		pep.clickButtonProductEntering();
	}
	
	@Then("^select  productType as \"([^\"]*)\" and subProductType as \"([^\"]*)\" and productName as \"([^\"]*)\"$")
	public void userSelectLoadTypeAndProductName(String productType,String subProductType,String productName){
		pep.selectLoadTypeAndProductName( productType, subProductType, productName);
	}
	
	@When("^click new customer entering button$")
	public void userClickButtonNewCustomerEntering(){
		pep.clickButtonNewCustomerEntering();
	}
	
	@Then("^fill in product entering$")
	public void userFillinProductEntering(DataTable table){
		pep.fillinProductEntering(table);
	}
	
	@When("^click product entering commit button$")
	public void userClickProductEnteringCommitButton(){
		pep.clickProductEnteringCommitButton();
	}
	
	@Then("^check product entering commit success productName as \"([^\"]*)\"$")
	public void userCheckProductEnteringCommitSuccess(String productName){
		pep.checkProductEnteringCommitSuccess(productName);
	}

	@Then("^logout kfzy01 product entering$")
	public void userLogout(){
		ltp.logout();
	}
	
	@Then("^closed browser product entering$")
	public void closedBrowser(){
		lp.closedBrowser();
	}
	
}
