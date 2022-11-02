package cucumberRun;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/main/resources",
        glue = "stepdefs",
        tags = "@TC01"
)

public class RunCukeTest {
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass
    public void beforeClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(dataProvider = "getScenarios")
    public void runScenarios(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @DataProvider
    public Object[][] getScenarios(){
        return testNGCucumberRunner.provideScenarios();
    }
    @AfterClass
    public void afterClass(){
        testNGCucumberRunner.finish();
    }
}