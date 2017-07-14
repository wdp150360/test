package com.jackie.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by luhaiming on 2017/6/5 0005.
 */
public class CustomerPage extends CommonPage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/a[1]")
    private WebElement record_issue_btton;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/form[1]/div[1]/select[1]")
    private Select loan_type1_selector;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/form[1]/div[1]/select[2]")
    private Select loan_type2_selector;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/form[1]/div[2]/select")
    private Select loan_product_selector;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div[3]")
    private WebElement create_new_loan_button;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[1]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement submit_button;

    private WebElement first_line_loan_product;
    private WebElement first_line_loan_status;
    private WebElement first_line_loan_processor;
    private WebElement first_line_loan_operations;

    @FindBy(xpath = "")
    private WebElement save_as_draft_button;

    public void enterRecordIssue() {
        click(record_issue_btton);
    }

    public void selectLoanProduct(String loanType1, String loanType2, String product) {
        select(loan_type1_selector, loanType1);
        select(loan_type2_selector, loanType2);
        select(loan_product_selector, product);
    }

    public void clickCreateNewLoan() {
        click(create_new_loan_button);
    }

    public void checkNewLoanProduct(String product) {

    }

    public void checkNewLoanStatus(String status) {

    }

    public void checkNewLoanProcessor(String processor) {

    }

    public void checkNewLoanOpeatation(List<String> operations) {

    }
}
