package org.zimincredit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.zimincredit.utils.UploadFile;


public class KfzyUploadContractAndSubmitPage extends CommonPage{

	@FindBy(xpath = "//div[@class='page']/span")
	private List<WebElement> totalSpan;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[4]")
	private List<WebElement> pageProductNameList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[6]")
	private List<WebElement> pageProductStatusList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr")
	private List<WebElement> pageProductNumber;
	
	@FindBy(xpath = "//div[@class='tab-content']/div/div/span/a")
	private WebElement uploadContractButton;
	
	@FindBy(id = "application_management_btn")
	private WebElement entryManagementButton;
	
	private boolean queryproductresult = false;
	private String operationButtonXpath;
	private int pageProductStatusIndex;
	
	public void clickUploadContractButton(String productName){
		int TPages = totalSpan.size() - 2;
		if(TPages <= 0){
			System.out.println(productName + "没有查询到产品！");
		}else if (TPages == 1){
			for(int i = 0;i < pageProductNumber.size();i++){
				if(productName.equals(pageProductNameList.get(i).getText()) && "待签约".equals(pageProductStatusList.get(i).getText())){
					pageProductStatusIndex = i;
					int k = i + 1;
					operationButtonXpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
					List<WebElement> operateButtons = driver.findElements(By.xpath(operationButtonXpath));
					click(operateButtons.get(0));
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
					if(productName.equals(pageProductNameList.get(j).getText()) && "待签约".equals(pageProductStatusList.get(j).getText())){
						pageProductStatusIndex = j;
						int k = j + 1;
						operationButtonXpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
						List<WebElement> operateButtons = driver.findElements(By.xpath(operationButtonXpath));
						click(operateButtons.get(0));
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
	
	public void uploadPic(){
		if(queryproductresult == true){
			click(uploadContractButton);
			sleep();
			UploadFile uf = new UploadFile();
			uf.uploadFile("pic.png");
			sleep();
		}
	}
	
	public void clickClosedContractPageButton(){
		if(queryproductresult == true){
			entryManagementButton.click();
			sleep();
		}
	}
	
	public void uploadContractCheckProductStatusChanged(){
		if(queryproductresult == true && pageProductStatusList.get(pageProductStatusIndex).getText().equals("已签约")){
			System.out.println("--------> 客服专员上传合同成功！");
		}
	}
	
	public void clickSubmitButtonTo(){
		if(queryproductresult == true){
			List<WebElement> operationButtons = driver.findElements(By.xpath(operationButtonXpath));
			click(operationButtons.get(2));
			sleep();
			driver.switchTo().alert().accept();
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
		}
	}
	
	public void submitToCheckProductStatusChanged(){
		if(queryproductresult == true && pageProductStatusList.get(pageProductStatusIndex).getText().equals("已完成")){
			System.out.println("--------> 客服专员上传合同提交成功！");
		}
	}
}
