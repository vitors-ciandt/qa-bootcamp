package com.ciandt.dealer.playingcard;

public enum CardSuit {
    SPADES(0), HEARTS(1), DIAMONDS(2), CLUBS(3);

    public final int rank;
    private CardSuit(int cardRank) {
        rank = cardRank;
    }
}
