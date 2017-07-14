package com.jackie;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by luhaiming on 2017/5/31 0031.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"} , features = "bi/src/test/resources/stories")
public class StoryTest {
}
