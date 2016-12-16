package org.qa_automation.ui.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/TestResults/html/Inprogress_Runner/cucumber-html-report","json:target/TestResults/json/Inprogress_Runner-reports.json" }, 
features = { "src/test/resources/features" }, 
tags = "@single", glue = {"com.qa_automation.ease.ui.stepdef","com.qa_automation.ease.ui.pages" })
public class DroidRunnerTest {


}
