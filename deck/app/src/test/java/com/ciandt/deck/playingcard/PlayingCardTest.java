package com.ciandt.deck.playingcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayingCardTest {
    @ParameterizedTest
    @MethodSource("provideCards")
    void compareToTest(PlayingCard c1, PlayingCard c2, boolean isGreater) {
        assertEquals(c1.compareTo(c2) > 0, isGreater,
                String.format("%s is not bigger than %s", c1.toString(), c2.toString()));
    }

    static Stream<Arguments> provideCards() {
        return Stream.of(of(new PlayingCard(2, CardSuit.SPADES), new PlayingCard(2, CardSuit.HEARTS), true),
                of(new PlayingCard(2, CardSuit.SPADES), new PlayingCard(3, CardSuit.HEARTS), false),
                of(new PlayingCard(1, CardSuit.SPADES), new PlayingCard(10, CardSuit.HEARTS), true),
                of(new PlayingCard(1, CardSuit.SPADES), new PlayingCard(1, CardSuit.HEARTS), true),
                of(new PlayingCard(13, CardSuit.DIAMONDS), new PlayingCard(12, CardSuit.SPADES), true));
    }
}
