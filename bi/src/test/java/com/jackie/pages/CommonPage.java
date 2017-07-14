package com.jackie.pages;

import com.jackie.seleniumext.WindowObjects;
import org.openqa.selenium.WebElement;

/**
 * Created by luhaiming on 2017/6/1 0001.
 */
public class CommonPage extends WindowObjects {

    public void openBrowse(String url) {
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }
}
