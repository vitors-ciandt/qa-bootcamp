package cucumber.config;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"classpath:cucumber.steps.definitions", "classpath:cucumber.steps.hooks"},
        strict = true)

public class CucumberIntegrationTest {
}
