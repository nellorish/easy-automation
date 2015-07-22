package com.capitalone.ease.ui.run;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/capitalonelogin.feature", 
tags="@demo",
glue = { "com.capitalone.ease.ui.stepdefs","com.capitalone.ease.ui.pages" })
public class RunCukesTest {

}
