package com.jackie.steps;

import com.jackie.pages.CustomerPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Created by luhaiming on 2017/6/5 0005.
 */
public class CustomerSteps {

    CustomerPage customerPage = new CustomerPage();

    @Given("^customer coordinator click button record issue")
    public void customer_coordinator_click_buuton_entertask() {
        customerPage.enterRecordIssue();
    }

    @Given("^customer coordinator select loan type \"([^\"]*)\" ,\"([^\"]*)\" and product \"([^\"]*)\"$")
    public void customerCoordinatorSelectLoanTypeAndProduct(String loanType1, String loanType2, String product) throws Throwable {
        customerPage.selectLoanProduct(loanType1 ,loanType2 ,product);
    }

    @Given("^customer coordinator click new customer issue$")
    public void customerCoordinatorClickNewCustomerIssue() throws Throwable {
        customerPage.clickCreateNewLoan();

    }

    @When("^customer coordinator click submit$")
    public void customerCoordinatorClickSubmit() throws Throwable {

    }

    @When("^customer coordinator click alert yes$")
    public void customerCoordinatorClickAlertYes() throws Throwable {

    }

    @When("^customer coordinator click alert sure$")
    public void customerCoordinatorClickAlertSure() throws Throwable {

    }

    @Then("^customer coordinator a new loan issue was added to the loan issue list$")
    public void customerCoordinatorANewLoanIssueWasAddedToTheLoanIssueList() throws Throwable {

    }

    @Then("^customer coordinator new loan issue's loan product is \"([^\"]*)\"$")
    public void customerCoordinatorNewLoanIssueSLoanProductIs(String arg0) throws Throwable {

    }

    @Then("^customer coordinator new loan issue's status is \"([^\"]*)\"$")
    public void customerCoordinatorNewLoanIssueSStatusIs(String arg0) throws Throwable {

    }

    @Then("^customer coordinator new loan issue's process is \"([^\"]*)\"$")
    public void customerCoordinatorNewLoanIssueSProcessIs(String arg0) throws Throwable {

    }

    @Then("^customer coordinator new loan issue's operation is$")
    public void customerCoordinatorNewLoanIssueSOperationIsOperations(List<String> array) throws Throwable {
        System.out.println("aaa");
    }

}
