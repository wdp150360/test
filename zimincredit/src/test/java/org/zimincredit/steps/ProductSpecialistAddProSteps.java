package org.zimincredit.steps;

import org.zimincredit.pages.LoginPage;
import org.zimincredit.pages.ProductSpecialistAddProPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//产品专员新增产品
public class ProductSpecialistAddProSteps {

	private String url = "https://120.55.94.106:808/dist/index.html";
	LoginPage lp = new LoginPage();
	ProductSpecialistAddProPage psapp = new ProductSpecialistAddProPage();

	@Given("^customer Username cpzy as \"([^\"]*)\" and Password as \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void cpzyLoginSuccess(String userName,String password,String name){
		lp.openBrowse(url);
		lp.maximize();
		lp.inputUserName(userName);
		lp.inputPassword(password);
		lp.clickLoginButton();
		lp.checkUserName(name);
	}

	@Given("^click add product$")
	public void userClickAddProduct(){
		psapp.clickAddProduct();
	}

	@And("^fill in content of pruduct$")
	public void userFillInProductContent(){
		psapp.fillInProductContent();
	}

	@When("^click commit button$")
	public void userClickCommitButton(){
		psapp.clickCommitButton();
	}

	@Then("^add product success and check to see if the product list is new$")
	public void userCommitAndCheckAddProduct(){
		psapp.commitAndCheckAddProduct();
	}
}
