package stepdefinitions_;

import org.junit.runner.RunWith;
//iii
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="uses_cases_1",
glue={"stepdefinitions_"},
monochrome=true
)
public class Run_test_product 
{

}
