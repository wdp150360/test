package org.zimincredit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class CszyFillInAndSubmitAuditPage extends CommonPage{

	@FindBy(xpath = "//div[@class='page']/span")
	private List<WebElement> totalSpan;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[4]")
	private List<WebElement> pageProductNameList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[6]")
	private List<WebElement> pageProductStatusList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr")
	private List<WebElement> pageProductNumber;
	
	@FindBy(xpath = "//div[@ng-switch-when='select']/span/span/select")
	private WebElement approvalResultX;
	
	@FindBy(xpath = "//div[@ng-switch-when='text']/input")
	private WebElement approvalReasonX;
	
	@FindBy(xpath = "//div[@class='z-tcenter mt20 ng-scope']/a[2]")
	private WebElement fillInSubmitButton;
	
	@FindBy(xpath = "//div[@class='popwindow ng-scope']/div/div[2]/div/form/div/select")
	private WebElement assignUserList;
	
	@FindBy(xpath = "//form[@class='form-horizontal ng-valid ng-dirty ng-valid-parse']/div[2]/div/button")
	private WebElement allocSubmitButton;
	
	private boolean queryproductresult = false;
	private String operationButtonXpath;
	private int pageProductStatusIndex;
	
	public void clickFillInButton(String productName){
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
	
	public void fillInProductField(DataTable table){
		if(queryproductresult == true){
			List<List<String>> data = table.raw();
			String approvalResult = data.get(1).get(1);
			String approvalReason = data.get(2).get(1);
			Select approvalResultSelect = new Select(approvalResultX);
			approvalResultSelect.selectByVisibleText(approvalResult);
			approvalReasonX.sendKeys(approvalReason);
		}
	}
	
	public void clickFillInSubmitButton(){
		if(queryproductresult == true){
			click(fillInSubmitButton);
			sleep();
			driver.switchTo().alert().accept();
			sleep();
			driver.switchTo().alert().accept();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
		}
	}
	
	public void fillInCheckProductStatusChanged(){
		if(queryproductresult == true && pageProductStatusList.get(pageProductStatusIndex).getText().equals("待提交")){
			//默认产品在第一页显示，后期修改该部分内容
			System.out.println("--------> 初审专员填写提交成功！");
		}
		
	}
	
	public void clickSubmitAuditButton(){
		if(queryproductresult == true){
			List<WebElement> operationButtons = driver.findElements(By.xpath(operationButtonXpath));
			click(operationButtons.get(0));
			sleep();
		}
	}
	
	public void staffAllocationTo(){
		if(queryproductresult == true){
			driver.switchTo().defaultContent();
			Select assignUser = new Select(assignUserList);
			assignUser.selectByVisibleText("初审复核01");
			click(allocSubmitButton);
			sleep();
			driver.switchTo().alert().accept();
			sleep();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
		}
	}
	
	public void staffAllocationCheckProductStatusChanged(){
		if(queryproductresult == true && pageProductStatusList.get(pageProductStatusIndex).getText().equals("已完成")){
			//默认产品在第一页显示，后期修改该部分内容
			System.out.println("--------> 初审专员提交审核成功！");
		}
		
	}
}
