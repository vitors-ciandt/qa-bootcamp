package com.ciandt.deck.playingcard;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PlayingCard implements Comparable {
    private final Integer value;
    private final CardSuit suit;

    public PlayingCard(Integer value, CardSuit cardSuit) {
        this.value = value;
        this.suit = cardSuit;
    }

    @JsonIgnore
    public String getFormattedValue() {
        switch (value) {
        case 1:
            return "A";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        default:
            return Integer.toString(value);
        }
    }

    @JsonIgnore
    public String getFormattedSuit() {
        switch (suit) {
        case SPADES:
            return "♠";
        case HEARTS:
            return "♥";
        case DIAMONDS:
            return "♦";
        default:
            return "♣";
        }
    }

    @Override
    public String toString() {
        return String.format("%s%s", getFormattedValue(), getFormattedSuit());
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().isAssignableFrom(PlayingCard.class)) {
            return -1;
        }

        int cardComparator = Integer.compare(value, ((PlayingCard) o).value);
        if (cardComparator != 0) {
            if (value == 1) {
                return 1;
            }
            return cardComparator;
        }

        return -Integer.compare(suit.rank, ((PlayingCard) o).suit.rank);
    }
}
