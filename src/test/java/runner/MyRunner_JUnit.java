   package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/features"},
                 glue     = {"stepdefinitions"},
                 plugin    = {"pretty"},  
tags = "@RegisterForTutorialsNinja or @LoginForTutorialsNinja or @SearchProductInTutorialsNinja"
                 )


public class MyRunner_JUnit 
{

}
 