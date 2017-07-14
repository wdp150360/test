package com.jackie.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by luhaiming on 2017/6/1 0001.
 */
public class LoginPage extends CommonPage {

    @FindBy(xpath = "/html/body/div[1]/div/div/div/input[1]")
    private WebElement username_input;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/input[2]")
    private WebElement password_input;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/button")
    private WebElement login_button;

    @FindBy(xpath = "/html/body/div[1]/div[1]/span")
    private WebElement user_name_show;


    public void inputUserName(String username) {
        input(username_input, username);
    }

    public void inputPassword(String password) {
        input(password_input, password);
    }

    public void clickLoginButton() {
        click(login_button);
    }

    public void checkUserName(String username) {
        sleep();
        String user_name_show_txt = user_name_show.getText();
        Assert.assertTrue("login user error", user_name_show_txt.contains(username));
    }
}
