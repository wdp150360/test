package org.zimincredit.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class ProductProcessSetPage extends CommonPage{

	@FindBy(xpath = "//div[@class='mt10 ng-scope']/div/a[2]")
	private WebElement processManagementButton;

	@FindBy(xpath = "//div[@class='page']/span")
	private List<WebElement> totalSpan;

	@FindBy(xpath = "//table[@class='table']/tbody/tr")
	private List<WebElement> pageProductNumber;

	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[3]")
	private List<WebElement> pageProductNameList;

	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[6]")
	private List<WebElement> pageProductStatus;

	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[7]/a[2]")
	private List<WebElement> pageProductBindButton;

	@FindBy(xpath = "//div[@class='ng-scope']/div[1]/ul/li[2]/a")
	private WebElement processSetButton;

	@FindBy(xpath = "//div[@class='filter ng-scope']/div[1]/select")
	private WebElement applicationTplIdSelect;

	@FindBy(xpath = "//div[@class='filter ng-scope']/div[2]/select")
	private WebElement evaluationTplIdSelect;

	@FindBy(xpath = "//div[@class='filter ng-scope']/div[3]/select")
	private WebElement precheckTplIdSelect;

	@FindBy(xpath = "//div[@class='filter ng-scope']/div[4]/select")
	private WebElement investigateTplIdSelect;

	@FindBy(xpath = "//div[@class='filter ng-scope']/div[5]/select")
	private WebElement finalcheckTplIdSelect;

	@FindBy(xpath = "//div[@class='filter ng-scope']/div[6]/a[2]")
	private WebElement commitButton;

	private WebElement bindTemplateButton = null;

	private WebElement productBindStatus = null;
	private boolean queryproductresult = false;


	public void clickButtonProcessManagement(){
		sleep();
		//driver.switchTo().defaultContent();
//		driver.findElement(By.xpath("//div[@class='mt10 ng-scope']/div/a[2]")).click();
		System.out.println(processManagementButton);
		click(processManagementButton);
	}

	public void queryBindProductName(String productName){
		sleep();
		int tPages = totalSpan.size() - 2;
		if (tPages == 0) {
			System.out.println("没有查询到产品！");
		} else if (tPages == 1) {
			for (int i = 0; i < pageProductNumber.size(); i++) {
				if (productName.equals(pageProductNameList.get(i).getText())
						&& "未绑定".equals(pageProductStatus.get(i).getText())) {
					// click(pageProductBindButton.get(i));
					bindTemplateButton = pageProductBindButton.get(i);
					productBindStatus = pageProductStatus.get(i);
					queryproductresult = true;
					break;
				} else {
					if(i >= pageProductNumber.size()-1){
						System.out.println(productName + "没有该产品或已绑定流程！");
					}
				}
			}
		} else if (tPages >= 2) {
			ln: for (int i = 1; i <= tPages;) {
				for (int pp = 0; pp < pageProductNumber.size(); pp++) {
					if (productName.equals(pageProductNameList.get(pp).getText())
							&& "未绑定".equals(pageProductStatus.get(pp).getText())) {
						// click(pageProductBindButton.get(pp));
						bindTemplateButton = pageProductBindButton.get(pp);
						productBindStatus = pageProductStatus.get(pp);
						queryproductresult = true;
						break ln;
					}
				}
				i++;
				if (i <= tPages) {
					click(totalSpan.get(i));
				} else {
					System.out.println(productName + "没有该产品或已绑定流程！");
				}
			}
		}

	}

	public void clickButtonBindingTemplate(){
		if(queryproductresult == true){
			click(bindTemplateButton);
			sleep();
			driver.switchTo().defaultContent();
		}
		
	}

	public void clickButtonProcessSet(){
		if(queryproductresult == true){
			click(processSetButton);
			sleep();
			driver.switchTo().defaultContent();
		}
		
	}

	public void setProcessTemplate(DataTable table){
		if(queryproductresult == true){
			//初始化数据表
			List<List<String>> data = table.raw();
			//获取数据
			String applicationTplId = data.get(1).get(1);
			String evaluationTplId = data.get(2).get(1);
			String precheckTplId = data.get(3).get(1);
			String investigateTplId = data.get(4).get(1);
			String finalcheckTplId = data.get(5).get(1);
			Select applicationTplIdS = new Select(applicationTplIdSelect);
			applicationTplIdS.selectByVisibleText(applicationTplId);
			Select evaluationTplIdS = new Select(evaluationTplIdSelect);
			evaluationTplIdS.selectByVisibleText(evaluationTplId);
			Select precheckTplIdS = new Select(precheckTplIdSelect);
			precheckTplIdS.selectByVisibleText(precheckTplId);
			Select investigateTplIdS = new Select(investigateTplIdSelect);
			investigateTplIdS.selectByVisibleText(investigateTplId);
			Select finalcheckTplIdS = new Select(finalcheckTplIdSelect);
			finalcheckTplIdS.selectByVisibleText(finalcheckTplId);
		}
		
	}

	public void commitAndCheckBindSuccess(){
		if(queryproductresult == true){
			click(commitButton);
			sleep();
			driver.switchTo().alert().accept();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			sleep();
			driver.switchTo().defaultContent();
			if("已绑定".equals(productBindStatus.getText())){
				System.out.println("绑定成功！");
			}
			System.out.println("绑定失败--产品绑定状态未变更");
		}
		
	}
}
