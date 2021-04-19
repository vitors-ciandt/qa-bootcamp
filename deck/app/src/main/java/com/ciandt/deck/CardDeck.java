package com.ciandt.deck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.ciandt.deck.playingcard.CardSuit;
import com.ciandt.deck.playingcard.PlayingCard;

public class CardDeck {
    private static final List<CardSuit> orderedSuits = Arrays.asList(CardSuit.values());
    static {
        Collections.sort(orderedSuits);
    }

    private static Stream<PlayingCard> getSuits(int value) {
        return orderedSuits.stream().map(s -> new PlayingCard(value, s));
    }

    public static List<PlayingCard> getDeck() {
        return IntStream.rangeClosed(1, 13).boxed().flatMap(i -> getSuits(i)).collect(Collectors.toList());
    }
}
