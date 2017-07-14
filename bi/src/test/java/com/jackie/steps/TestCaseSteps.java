package com.jackie.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import java.util.List;

/**
 * Created by luhaiming on 2017/5/31 0031.
 */
public class TestCaseSteps {

    @Given("he has a receipt$")
    public void heHasAReceipt() throws Throwable {
        System.out.println("aaaa");
    }

    @Given("^what fuck$")
    public void whatFuck() throws Throwable {
        System.out.println("bbbb");
    }

}
