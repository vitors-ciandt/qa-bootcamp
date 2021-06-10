package com.ciandt.deck;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ciandt.deck.playingcard.CardSuit;
import com.ciandt.deck.playingcard.PlayingCard;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class CardDeckTest {
    @Test
    void shouldHaveAFiftyTwoCardsDeck() {
        var cards = CardDeck.getDeck();

        assertEquals(52, cards.size());
    }

    @Test
    void shouldHaveCardMinimumValueEqualToOne() {
        var cards = CardDeck.getDeck();
        Integer minimumCardsValue;

        minimumCardsValue = cards.stream().map(value -> value.getValue()).min(Comparator.naturalOrder()).get().intValue();

        assertEquals(1, minimumCardsValue);
    }

    @Test
    void shouldHaveCardMaximumValueEqualToThirteen() {
        var cards = CardDeck.getDeck();
        Integer maximumCardsValue;

        maximumCardsValue = cards.stream().map(value -> value.getValue()).max(Comparator.naturalOrder()).get().intValue();

        assertEquals(13, maximumCardsValue);
    }

    @Test
    void shouldHaveThirteenDistinctValues() {
        var cards = CardDeck.getDeck();

        assertEquals(13, cards.stream()
                .map(value -> value.getValue())
                .distinct()
                .count()
        );
    }

    @Test
    void shouldHaveATotalOfFourSuits() {
        var cards = CardDeck.getDeck();

        assertEquals(4, cards.stream()
                .map(suit -> suit.getSuit())
                .distinct()
                .count()
        );
    }

    @Test
    void eachCardShouldASuit() {
        var cards = CardDeck.getDeck();

        assertEquals(52, cards.stream()
                        .map(suit -> suit.getSuit())
                        .filter(suit -> suit.equals(CardSuit.SPADES)
                                || suit.equals(CardSuit.HEARTS)
                                || suit.equals(CardSuit.DIAMONDS)
                                || suit.equals(CardSuit.CLUBS)
                        )
                        .count()
        );
    }

    @Test
    void eachSuitShouldHaveThirteenCards() {
        var cards = CardDeck.getDeck();
        int spadesCards = 0;
        int heartsCards = 0;
        int diamondsCards = 0;
        int clubsCards = 0;

        for (PlayingCard c : cards) {
            if (c.getSuit() == CardSuit.SPADES) {
                spadesCards++;
            } else if (c.getSuit() == CardSuit.HEARTS) {
                heartsCards++;
            } else if (c.getSuit() == CardSuit.DIAMONDS) {
                diamondsCards++;
            } else {
                clubsCards++;
            }
        }

        int finalSpadesCards = spadesCards;
        int finalHeartsCards = heartsCards;
        int finalDiamondsCards = diamondsCards;
        int finalClubsCards = clubsCards;

        assertAll(() -> assertEquals(13, finalSpadesCards),
                () -> assertEquals(13, finalHeartsCards),
                () -> assertEquals(13, finalDiamondsCards),
                () -> assertEquals(13, finalClubsCards)
        );
    }
}
