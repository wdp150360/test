package com.jackie.seleniumext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by luhaiming on 2017/1/4 0004.
 */
public class WindowObjects {
    public static WebDriver driver;
    private static final int TRY_TIMES = 6;
    private static final int WAIT_SECONDS = 3 * 1000;
    private static final int ONE_SECOND = 1000;
    private static WebDriverWait wait;

    public WindowObjects() {
        if (null == driver) {
            driver = DriverFactory.getChromeDriver();
        }

        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loadPage(String url) {
        driver.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(final WebElement element, final ExpectedCondition... conditions) {

        SafeAction action = () -> {
            for (int i = 0; i < TRY_TIMES; i++) {
                try {
                    until(element);
                    element.click();
                    for (ExpectedCondition condition : conditions) {
                        wait.until(condition);
                    }
                    break;
                } catch (Throwable e) {
                    try {
                        Thread.sleep(WAIT_SECONDS);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
        action.apply();
    }

    public void input(final WebElement element, final String text, final ExpectedCondition... conditions) {
        SafeAction action = () -> {
            for (int i = 0; i < TRY_TIMES; i++) {
                try {
                    until(element);
                    element.sendKeys(text);
                    for (ExpectedCondition condition : conditions) {
                        wait.until(condition);
                    }
                    break;
                } catch (Throwable e) {
                    try {
                        Thread.sleep(WAIT_SECONDS);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
        action.apply();
    }

    public void select(final Select select, final String value) {
        SafeAction action = () -> {
            for (int i = 0; i < TRY_TIMES; i++) {
                try {
                    Thread.sleep(ONE_SECOND);
                    select.selectByValue(value);
                    break;
                } catch (Throwable e) {
                    try {
                        Thread.sleep(WAIT_SECONDS);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
        action.apply();
    }


    public static void main(String[] args) {

        String url = "www.baidu.com";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<WebElement>) d -> d.findElement(By.id("b"))).click();
    }


    protected void until(String xpath) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))
        );
    }

    protected void until(final WebElement element) {
        wait.until((ExpectedCondition<WebElement>) driver -> element);

    }


    protected void sleep() {
        try {
            Thread.sleep(WAIT_SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
