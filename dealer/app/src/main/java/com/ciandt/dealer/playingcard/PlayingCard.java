package com.ciandt.dealer.playingcard;

import lombok.Data;

@Data
public class PlayingCard {
    private final Integer value;
    private final CardSuit suit;

    public PlayingCard(Integer value, CardSuit cardSuit) {
        this.value = value;
        this.suit = cardSuit;
    }
}
