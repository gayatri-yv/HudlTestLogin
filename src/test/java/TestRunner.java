import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features/",
        glue = "src/test/java/StepDefinitions/",
        tags = "@test"
)

public class TestRunner {
}
