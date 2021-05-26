package cucumber.steps.definitions;

import com.ciandt.deck.playingcard.PlayingCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.config.SpringIntegrationTest;
import cucumber.config.utils.RestUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
public class DeckStep extends SpringIntegrationTest {
    private RestUtils restUtils;

    @When("^the game is up$")
    public void theGameIsUp() { testContext.setResponse(restUtils.get("/")); }

    @Then("^a deck of 52 cards with suits is generated$")
    public void aDeckOfFiftyTwoCardsWithSuitsIsGenerated() throws JsonProcessingException {
        ResponseEntity<String> response = testContext.getResponse();
        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<PlayingCard> responseDeck = objectMapper.readValue(response.getBody(),
                new TypeReference<List<PlayingCard>>() {});

        assertEquals(52, responseDeck.size());

        List<PlayingCard> sortedList = responseDeck;
        Collections.sort(sortedList);

        assertEquals(sortedList, responseDeck);
    }
}
