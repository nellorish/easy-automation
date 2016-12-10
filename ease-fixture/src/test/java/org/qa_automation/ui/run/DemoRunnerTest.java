/**
 * 
 */
package org.qa_automation.ui.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//import cucumber.api.junit.Cucumber;

/**
 * @author gtg716
 *
 */


@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/TestResults/html/Inprogress_Runner/cucumber-html-report","json:target/TestResults/json/Inprogress_Runner-reports.json" }, 
features = { "src/test/resources/features"}, 
tags = "@firefox", glue = {"com.capitalone.ease.ui.stepdef","com.capitalone.ease.ui.pages" })

public class DemoRunnerTest {

}
