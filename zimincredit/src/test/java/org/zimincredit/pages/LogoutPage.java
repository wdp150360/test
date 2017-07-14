package org.zimincredit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends CommonPage{
	
	@FindBy(xpath = "//div[@class='head ng-scope']/span/a")
	private WebElement we;
	
	public void logout(){
		click(we);
	}
}
