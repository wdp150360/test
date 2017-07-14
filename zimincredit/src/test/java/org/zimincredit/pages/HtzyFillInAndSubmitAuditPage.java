package org.zimincredit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;

public class HtzyFillInAndSubmitAuditPage extends CommonPage{

	@FindBy(xpath = "//div[@class='page']/span")
	private List<WebElement> totalSpan;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[4]")
	private List<WebElement> pageProductNameList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[6]")
	private List<WebElement> pageProductStatusList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr")
	private List<WebElement> pageProductNumber;
	
	@FindBy(xpath = "//div[@active='tabsActive']/ul/li[2]/a")
	private WebElement tabContractButton;
	
	@FindBy(xpath = "//div[@active='subtabsActive']/ul/li[2]/a")
	private WebElement subtabContract2button;
	
	@FindBy(xpath = "//div[@class='tab-content']/div/div/div[3]/a")
	private WebElement subtabContractSaveButton;
	
	@FindBy(xpath = "//div[@active='tabsActive']/ul/li[3]/a")
	private WebElement tabLoanMessageButton;
	
	@FindBy(xpath = "//div[@class='tblist']/ul/li/div/input")
	private List<WebElement> loanMessageFieldsList;
	
	@FindBy(xpath = "//div[@class='tab-content']/div[3]/div/div/div[2]/a")
	private WebElement loanMessageSaveButton;
	
	@FindBy(xpath = "//div[@class='rightbox-shadow']/div[2]/a[2]")
	private WebElement processSubmitButton;
	
	private boolean queryproductresult = false;
	private String operationButtonXpath;
	private int pageProductStatusIndex;
	
	public void clickDisposeButton(String productName){
		int TPages = totalSpan.size() - 2;
		if(TPages <= 0){
			System.out.println(productName + "没有查询到产品！");
		}else if (TPages == 1){
			for(int i = 0;i < pageProductNumber.size();i++){
				if(productName.equals(pageProductNameList.get(i).getText()) && "待处理".equals(pageProductStatusList.get(i).getText())){
					pageProductStatusIndex = i;
					int k = i + 1;
					operationButtonXpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
					List<WebElement> operateButtons = driver.findElements(By.xpath(operationButtonXpath));
					int buttonNumber = operateButtons.size() - 1;
					click(operateButtons.get(buttonNumber));
					sleep();
					queryproductresult = true;
					break;
				}else{
					if(i >= pageProductNumber.size()-1){
						System.out.println(productName + "没有查询到产品！");
					}
				}
			}
		}else if (TPages >= 2){
			ln:
			for(int i = 1;i <= TPages;){
				for(int j = 0;j < pageProductNameList.size();j++){
					if(productName.equals(pageProductNameList.get(j).getText()) && "待处理".equals(pageProductStatusList.get(j).getText())){
						pageProductStatusIndex = j;
						int k = j + 1;
						operationButtonXpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
						List<WebElement> operateButtons = driver.findElements(By.xpath(operationButtonXpath));
						int buttonNumber = operateButtons.size() - 1;
						click(operateButtons.get(buttonNumber));
						sleep();
						queryproductresult = true;
						break ln;
					}
				}
				i++;
				if(i > TPages){
					System.out.println(productName + "没有查询到产品！");
				}else{
					click(totalSpan.get(i));
					sleep();
				}
			}
		}
	}
	
	public void clickTabContract(){
		if(queryproductresult ==true){
			click(tabContractButton);
			sleep();
		}
	}
	
	public void clickSaveButtonInTabContract(){
		if(queryproductresult ==true){
//			click(subtabContractSaveButton);
//			sleep();
//			driver.switchTo().alert().accept();
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.ENTER).build().perform();
//			sleep();
			click(subtabContract2button);
			sleep();
			click(subtabContractSaveButton);
			sleep();
			driver.switchTo().alert().accept();
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.ENTER).build().perform();
			
//			sleep();
//			action.sendKeys(Keys.ENTER).build().perform();
//			sleep();
		}	
	}
	
	public void clickTabLoanMessage(){
		if(queryproductresult == true){
			click(tabLoanMessageButton);
			sleep();
		}
	}
	
	public void fillInLoanMessage(DataTable table){
		if(queryproductresult == true){
			List<List<String>> data = table.raw();
			String contractNO = data.get(1).get(1);
			String customerName = data.get(2).get(1);
			String customerDesignatedPayee = data.get(3).get(1);
			String lendingAccount = data.get(4).get(1);
			String loanAccount = data.get(5).get(1);
			String department = data.get(6).get(1);
			String loanAmount = data.get(7).get(1);
			String phoneNumber = data.get(8).get(1);
			String customerBankAccount = data.get(9).get(1);
			String customerAccountBank = data.get(10).get(1);
			loanMessageFieldsList.get(0).sendKeys(contractNO);
			loanMessageFieldsList.get(1).sendKeys(customerName);
			loanMessageFieldsList.get(2).sendKeys(customerDesignatedPayee);
			loanMessageFieldsList.get(3).sendKeys(lendingAccount);
			loanMessageFieldsList.get(4).sendKeys(loanAccount);
			loanMessageFieldsList.get(5).sendKeys(department);
			loanMessageFieldsList.get(6).sendKeys(loanAmount);
			loanMessageFieldsList.get(7).sendKeys(phoneNumber);
			loanMessageFieldsList.get(8).sendKeys(customerBankAccount);
			loanMessageFieldsList.get(9).sendKeys(customerAccountBank);
		}
	}
	
	public void clickSaveButtonInTabLoanMessage(){
		if(queryproductresult == true){
			click(loanMessageSaveButton);
			sleep();
			driver.switchTo().alert().accept();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
		}
	}
	
	public void clickProcessSubmitButton(){
		if(queryproductresult == true){
			click(processSubmitButton);
			sleep();
			driver.switchTo().alert().accept();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
		}
	}
	
	public void checkProductStatusChanged(){
		if(queryproductresult == true && pageProductStatusList.get(pageProductStatusIndex).getText().equals("待提交")){
			//默认产品在第一页显示，后期修改该部分内容
			System.out.println("--------> 合同专员填写提交成功！");
		}
	}
	
	public void clickSubmitAuditButton(){
		if(queryproductresult == true){
			List<WebElement> operationButtons = driver.findElements(By.xpath(operationButtonXpath));
			click(operationButtons.get(0));
			sleep();
			driver.switchTo().alert().accept();
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
		}
	}
	
	public void checkProductStatusChangedAfterSubmit(){
		if(queryproductresult == true && pageProductStatusList.get(pageProductStatusIndex).getText().equals("已完成")){
			//默认产品在第一页显示，后期修改该部分内容
			System.out.println("--------> 合同专员提交审核成功！");
		}
	}
}
