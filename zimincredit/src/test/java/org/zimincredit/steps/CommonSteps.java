package org.zimincredit.steps;

import org.zimincredit.pages.CommonPage;

import cucumber.api.java.en.Given;

/**
 * Created by luhaiming on 2017/6/1 0001.
 */
public class CommonSteps {
    CommonPage commonPage = new CommonPage();

    @Given("^maximize the page$")
    public void maximizeThePage() throws Throwable {
        commonPage.maximize();
    }
}
