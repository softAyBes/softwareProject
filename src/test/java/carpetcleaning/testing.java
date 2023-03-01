package carpetcleaning;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "cases",  monochrome = true,
glue="carpetcleaning"
//, snippets = SnippetType.CAMELCASE
)
  
public class testing {
	
}
