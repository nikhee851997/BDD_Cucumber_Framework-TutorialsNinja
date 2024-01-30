package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		           dryRun  = false,
                   monochrome= true,
		           features= {"src/test/resources/features"},
                   glue    = {"stepdefinitions"},
                   
tags = "@RegisterForTutorialsNinja or @LoginForTutorialsNinja or @SearchProductInTutorialsNinja or @ProductSpecsAndAddingToCart or @OrderPlacement or @Logout",

    plugin = {"pretty", "html:target/cucumber-reports/html-TheFinal-report"}

                ) 


public class MyRunner_TestNG extends AbstractTestNGCucumberTests
{

}
