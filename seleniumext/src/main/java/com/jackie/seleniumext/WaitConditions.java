package com.jackie.seleniumext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by luhaiming on 2017/1/4 0004.
 */
public class WaitConditions {

    public ExpectedCondition<Boolean> presenceOfElement(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return element.isEnabled();
            }
        };
    }

}
