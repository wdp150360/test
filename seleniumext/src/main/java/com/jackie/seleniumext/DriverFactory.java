package com.jackie.seleniumext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;


/**
 * Created by luhaiming on 2017/1/4 0004.
 */
public class DriverFactory {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        /*ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
     //   capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
        options.addArguments("--test-type","no-default-browser-check","--ignore-certificate-errors");*/

        return new ChromeDriver();
    }

    public static WebDriver getFireFoxDriver() {
        return null;
    }
}
