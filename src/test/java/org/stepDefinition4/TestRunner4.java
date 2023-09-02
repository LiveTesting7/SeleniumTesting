package org.stepDefinition4;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
glue = "org.stepDefinition4"
,monochrome = true
,dryRun = false
,snippets = SnippetType.CAMELCASE
,tags = "@regression"
,plugin = {"html:report","junit:Report\\junitreport.xml","json:Report\\jsonreport.json"})
public class TestRunner4 {	

}
