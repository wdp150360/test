package org.zimincredit.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.zimincredit.pages.CommonPage;

public class QueryProductGetOperationButtons extends CommonPage{
	
	@FindBy(xpath = "//div[@class='page']/span")
	private List<WebElement> totalSpan;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[4]")
	private List<WebElement> pageProductNameList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[6]")
	private List<WebElement> pageProductStatusList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr")
	private List<WebElement> pageProductNumber;
	
	@FindBy(xpath = "//div[@class='popwindow ng-scope']/div/div[2]/div/form/div/select")
	private WebElement assignUserList;
	
	@FindBy(xpath = "//form[@class='form-horizontal ng-valid ng-dirty ng-valid-parse']/div[2]/div/button")
	private WebElement allocSubmitButton;
	
	public WebElement productStatus = null;
	public boolean qureyproductresult = false;

	public List<WebElement> getOperationButtons(String productName,String initialState){
		int TPages = totalSpan.size() - 2;
		List<WebElement> operateButtons = null;
		if(TPages <= 0){
			System.out.println(productName + "没有查询到产品！");
		}else if (TPages == 1){
			for(int i = 0;i < pageProductNumber.size();i++){
				if(productName.equals(pageProductNameList.get(i).getText()) && initialState.equals(pageProductStatusList.get(i).getText())){
					int k = i + 1;
					String xpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
					operateButtons = driver.findElements(By.xpath(xpath));
					productStatus = pageProductStatusList.get(i);
					qureyproductresult = true;
					break;
				}else{
					if(i >= pageProductNumber.size()){
						System.out.println(productName + "没有查询到产品！");
					}
				}
			}
		}else if (TPages >= 2){
			ln:
			for(int i = 1;i <= TPages;){
				for(int j = 0;j < pageProductNameList.size();j++){
					if(productName.equals(pageProductNameList.get(j).getText()) && initialState.equals(pageProductStatusList.get(j).getText())){
						int k = j + 1;
						String xpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
						operateButtons = driver.findElements(By.xpath(xpath));
						int buttonNumber = operateButtons.size() - 2;
						click(operateButtons.get(buttonNumber));
						sleep();
						driver.switchTo().defaultContent();
						Select assignUser = new Select(assignUserList);
						assignUser.selectByValue("number:158");
//						assignUserList.selectByVisibleText("初审专员01");
//						assignUserList.selectByValue("number:158");
						click(allocSubmitButton);
						sleep();
						driver.switchTo().alert().accept();
						sleep();
						Actions action = new Actions(driver);
						action.sendKeys(Keys.ENTER).build().perform();
						sleep();
						productStatus = pageProductStatusList.get(j);
						qureyproductresult = true;
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
		return operateButtons;
	}
}
