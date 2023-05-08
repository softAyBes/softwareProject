package carpetcleaning;

import java.util.ArrayList;

import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(features = "cases",  monochrome = true,
glue="carpetcleaning", 
snippets = SnippetType.CAMELCASE
)
   
public class testing {
	

}
