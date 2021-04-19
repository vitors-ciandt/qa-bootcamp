package com.ciandt.deck;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.val;

public class CardDeckTest {
    @Test
    void shouldHaveAllCards() {
        val cards = CardDeck.getDeck();

        assertAll(() -> assertEquals(52, cards.size(), "There are 52 cards"),
                () -> assertEquals(4, cards.stream().map(c -> c.getSuit()).distinct().count(), "There are 4 suits"),
                () -> assertEquals(13, cards.stream().map(c -> c.getValue()).distinct().count(),
                        "There are 13 values"));
    }
}
