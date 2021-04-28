package com.ciandt.games.playingcard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayingCard {
    private Integer value;
    private CardSuit suit;
}
