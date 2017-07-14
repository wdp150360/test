package org.zimincredit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JkzyAgreeProcessPage extends CommonPage{

	@FindBy(xpath = "//div[@class='page']/span")
	private List<WebElement> totalSpan;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[4]")
	private List<WebElement> pageProductNameList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr/td[6]")
	private List<WebElement> pageProductStatusList;
	
	@FindBy(xpath = "//tbody[@id='app_list']/tr")
	private List<WebElement> pageProductNumber;
	
	private WebElement productStatus = null;
	private boolean qureyproductresult = false;
	
	public void clickAgreeButton(String productName){
		int TPages = totalSpan.size() - 2;
		if(TPages <= 0){
			System.out.println(productName + "没有查询到产品！");
		}else if (TPages == 1){
			for(int i = 0;i < pageProductNumber.size();i++){
				if(productName.equals(pageProductNameList.get(i).getText()) && "待处理".equals(pageProductStatusList.get(i).getText())){
					int k = i + 1;
					String xpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
					List<WebElement> operateButtons = driver.findElements(By.xpath(xpath));
					click(operateButtons.get(1));
					sleep();
					driver.switchTo().alert().accept();
					sleep();
					Actions action = new Actions(driver);
					action.sendKeys(Keys.ENTER).build().perform();
					sleep();
					productStatus = pageProductStatusList.get(i);
					qureyproductresult = true;
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
						int k = j + 1;
						String xpath = "//tbody[@id='app_list']/tr[" + k + "]/td[9]/a";
						List<WebElement> operateButtons = driver.findElements(By.xpath(xpath));
						click(operateButtons.get(1));
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
	}
	
	public void checkProductStatusChanged(){
		if(qureyproductresult == true && productStatus.getText().equals("已完成")){
			System.out.println("--------> 监控部门同意审核提交成功！");
		}
	}
}
