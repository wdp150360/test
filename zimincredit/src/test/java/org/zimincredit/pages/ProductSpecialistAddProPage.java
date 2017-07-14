package org.zimincredit.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.zimincredit.utils.TimeStamp;

//产品专员新增产品
public class ProductSpecialistAddProPage extends CommonPage{

	private String productName = null;
	//点击添加产品
	public void clickAddProduct(){
		driver.findElement(By.xpath("//div[@id='productlist']/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	//填写产品内容详细信息
	public void fillInProductContent(){
		driver.switchTo().defaultContent();
		Select productType = new Select(driver.findElement(By.xpath("//div[@class='filter']/div[1]/div[1]/select[1]")));
		productType.selectByValue("number:1");
		Select subProductType = new Select(driver.findElement(By.xpath("//div[@class='filter']/div[1]/div[1]/select[2]")));
		subProductType.selectByValue("number:11");
		TimeStamp timeStamp = new TimeStamp();
		String ts = timeStamp.getTimeStamp();
		productName = "信用产品" + ts;
		driver.findElement(By.xpath("//div[@class='filter']/div[1]/div[2]/div/input")).sendKeys(productName);
		driver.findElement(By.xpath("//div[@class='filter']/div[1]/div[3]/input")).sendKeys("1.0");
		Select productRegionProvince = new Select(driver.findElement(By.xpath("//div[@class='filter']/div[2]/div/select[1]")));
		productRegionProvince.selectByVisibleText("北京市");;
		Select productRegionCity = new Select(driver.findElement(By.xpath("//div[@class='filter']/div[2]/div/select[2]")));
		productRegionCity.selectByVisibleText("市辖区");
		productRegionCity.selectByVisibleText("市辖区");;
		driver.findElement(By.xpath("//div[@class='filter']/div[2]/div/button")).click();
		driver.findElement(By.xpath("//div[@class='filter']/div[3]/div/textarea")).sendKeys(productName);
		driver.findElement(By.xpath("//div[@class='filter']/div[4]/div/div/div[1]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//div[@class='filter']/div[4]/div/div/div[1]/input[2]")).sendKeys("2");
		Select repaymentCalculation = new Select(driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[1]/select")));
		repaymentCalculation.selectByValue("1");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[2]/div[1]/input")).sendKeys("1");
		Select eachLength = new Select(driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[2]/div[1]/select")));
		eachLength.selectByValue("月");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[2]/div[1]/button")).click();
		driver.findElement(By.xpath("//div[@class='popwindow ng-scope']/div/div[2]/div/div[1]/div[1]/label")).click();
		driver.findElement(By.xpath("//div[@class='popwindow ng-scope']/div/div[2]/div/div[1]/div[2]/label")).click();
		driver.findElement(By.xpath("//div[@class='popwindow ng-scope']/div/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[1]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[1]/input[2]")).sendKeys("2");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[2]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[2]/input[2]")).sendKeys("2");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[4]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[4]/input[2]")).sendKeys("2");
		Select retrunType = new Select(driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[3]/div[5]/select")));
		retrunType.selectByValue("1");
		Select interestDeductType1 = new Select(driver.findElement(
				By.xpath("//ng-form[@name='nestedForm']/div/div[4]/div[1]/select[1]")));
		interestDeductType1.selectByValue("1");
		Select interestDeductType2 = new Select(driver.findElement(
				By.xpath("//ng-form[@name='nestedForm']/div/div[4]/div[1]/select[2]")));
		interestDeductType2.selectByValue("1");
		Select chargeDeductType1 = new Select(driver.findElement(
				By.xpath("//ng-form[@name='nestedForm']/div/div[4]/div[2]/select[1]")));
		chargeDeductType1.selectByValue("1");
		Select chargeDeductType2 = new Select(driver.findElement(
				By.xpath("//ng-form[@name='nestedForm']/div/div[4]/div[2]/select[2]")));
		chargeDeductType2.selectByValue("1");
		Select guaranteeDeductType1 = new Select(driver.findElement(
				By.xpath("//ng-form[@name='nestedForm']/div/div[4]/div[3]/select[1]")));
		guaranteeDeductType1.selectByValue("1");
		Select guaranteeDeductType2 = new Select(driver.findElement(
				By.xpath("//ng-form[@name='nestedForm']/div/div[4]/div[3]/select[2]")));
		guaranteeDeductType2.selectByValue("1");
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[5]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ng-form[@name='nestedForm']/div/div[5]/button")).click();
	}

	//点击提交按钮
	public void clickCommitButton(){
		driver.findElement(By.xpath("//div[@class='filter']/div[4]/div[5]/button[2]")).click();
		sleep();
		driver.switchTo().alert().accept();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep();
		}

	//提交成功后检查产品列表中新增产品记录
	public void commitAndCheckAddProduct(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
//		driver.switchTo().alert().accept();
		String actualProductName = driver.findElement(By.xpath("//div[@id='productlist']/div[3]/table/tbody/tr/td[3]")).getText();
		//Assert.assertSame("productName error ",productName, actualProductName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		//Assert.assertSame("productName error ",productName, actualProductName);
		System.out.println(actualProductName + productName);
		Assert.assertTrue("productName error", actualProductName.equals(productName));
	}
}
