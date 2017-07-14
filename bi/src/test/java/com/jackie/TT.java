package com.jackie;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by luhaiming on 2017/6/5 0005.
 */
public class TT {

    @Test
    public void StartFireFoxByDefault() {
        System.out.println("start firefox browser...");
        System.setProperty("webdriver.firefox.bin", //指定firefox的安装路径
                "\"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe\"");
        WebDriver driver = new FirefoxDriver();
        WebDriver.Navigation navigation = driver.navigate();
        navigation.to("http://www.baidu.com/");
        System.out.println("start firefox browser succeed...");
    }

    @Test
    public void StartChrome() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        /*ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
     //   capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
        options.addArguments("--test-type","no-default-browser-check","--ignore-certificate-errors");*/

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");

    }

}
