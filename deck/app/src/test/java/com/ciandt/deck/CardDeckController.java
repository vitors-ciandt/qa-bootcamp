package com.ciandt.deck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDeckController {
    @Test
    void shouldHaveAFiftyTwoCardsDeckWithValueAndSuit() {
        var cards = CardDeck.getDeck();

        assertAll(() -> assertEquals(52, cards.size()),
                () -> assertEquals(13, cards.stream().map(suit -> suit.getSuit()).distinct().count()),
                () -> assertEquals(4, cards.stream().map(value -> value.getValue()).distinct().count())
        );
    }
}