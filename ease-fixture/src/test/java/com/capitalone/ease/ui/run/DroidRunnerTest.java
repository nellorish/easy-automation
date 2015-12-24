package com.capitalone.ease.ui.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/TestResults/html/Inprogress_Runner/cucumber-html-report","json:target/TestResults/json/Inprogress_Runner-reports.json" }, 
features = { "src/test/resources/features" }, 
tags = "@droid", glue = {"com.capitalone.ease.ui.stepdef","com.capitalone.ease.ui.pages" })
public class DroidRunnerTest {

}
