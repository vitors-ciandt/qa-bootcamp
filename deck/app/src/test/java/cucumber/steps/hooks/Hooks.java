package cucumber.steps.hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public static void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
    }
}
