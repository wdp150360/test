package org.zimincredit.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class ProductEnteringPage extends CommonPage{

	@FindBy(xpath = "//div[@class='mt10 ng-scope']/div/a[1]")
	private WebElement productEnteringButton;
	
	@FindBy(xpath = "//div[@class='filter']/form[1]/div[1]/select[1]")
	private WebElement productTypeE;
	
//	@FindBy(xpath = "//div[@class='filter']/form[1]/div[1]/select[1]/option[2]")
//	private WebElement productTypeOption;
	
	@FindBy(xpath = "//div[@class='filter']/form[1]/div[1]/select[2]")
	private WebElement subProductTypeX;
	
	@FindBy(xpath = "//div[@class='filter']/form[1]/div[2]/select")
	private WebElement productNameX;
	
	@FindBy(xpath = "//div[@class='filter']/div[3]/p")
	private WebElement newCustomerEnteringButton;
	
	@FindBy(xpath = "//div[@class='filedfore']/div/div[2]/div[1]/div/input")
	private WebElement useredNameX;
	
	@FindBy(xpath = "//div[@class='filedfore']/div/div[4]/div[1]/div/span/span/select")
	private WebElement approvalResultX;
	
	@FindBy(xpath = "//div[@class='filedfore']/div/div[5]/div[1]/div/span/span/select")
	private WebElement validationResultX;
	
	@FindBy(xpath = "//div[@class='filedfore']/div/div[6]/div[1]/div/span/span/select")
	private WebElement finalValidationResultX;
	
	@FindBy(xpath = "//div[@class='tab-content']/div/div[4]/a[2]")
	private WebElement commitButton;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[4]")
	private WebElement actualProductNameX;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[6]")
	private WebElement productStatusX;
	
	public void clickButtonProductEntering(){
		sleep();
		click(productEnteringButton);
	}
	
	public void selectLoadTypeAndProductName(String productType,String subProductType,String productName){
		sleep();
		productTypeE.click();
		Select productTypeS = new Select(productTypeE);
		productTypeS.selectByVisibleText(productType);
		sleep();
		Select subProductTypeS = new Select(subProductTypeX);
		subProductTypeS.selectByVisibleText(subProductType);
		sleep();
		Select productNameS = new Select(productNameX);
		productNameS.selectByVisibleText(productName);
	}
	
	public void clickButtonNewCustomerEntering(){
		click(newCustomerEnteringButton);
	}
	
	public void fillinProductEntering(DataTable table){
		List<List<String>> data = table.raw();
		String useredName = data.get(1).get(1);
		String approvalResult = data.get(2).get(1);
		String validationResult = data.get(3).get(1);
		String finalValidationResult = data.get(4).get(1);
		useredNameX.sendKeys(useredName);
		Select approvalResultS = new Select(approvalResultX);
		approvalResultS.selectByVisibleText(approvalResult);
		Select validationResultS = new Select(validationResultX);
		validationResultS.selectByVisibleText(validationResult);
		Select finalValidationResultS = new Select(finalValidationResultX);
		finalValidationResultS.selectByVisibleText(finalValidationResult);
	}
	
	public void clickProductEnteringCommitButton(){
		click(commitButton);
		driver.switchTo().alert().accept();
		sleep();
		driver.switchTo().alert().accept();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep();
	}
	
	public void checkProductEnteringCommitSuccess(String productName){
		sleep();
		if(actualProductNameX.getText().equals(productName) && "待提交".equals(productStatusX.getText())){
			System.out.println(productName + "录入成功！");
		}
		System.out.println(productName + "录入失败！");
	}
}
