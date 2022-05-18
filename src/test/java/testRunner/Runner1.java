package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"FeatureFiles"},tags= {"@UserMultipleData"},glue= {"stepDefination"},format= {"pretty", "html:target/cucumber-reports"},monochrome=true)
public class Runner1 {

}
