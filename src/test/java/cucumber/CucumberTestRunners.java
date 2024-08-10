package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="FrameworksDemo.stepDefinition",monochrome=true,tags= "@ErrorHandling or @Smoke",plugin={"html:target/cucumber.html"})
public class CucumberTestRunners extends AbstractTestNGCucumberTests {

}
