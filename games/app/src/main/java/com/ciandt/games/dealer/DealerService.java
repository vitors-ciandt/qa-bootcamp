package com.ciandt.games.dealer;

import java.util.List;

import com.ciandt.games.playingcard.PlayingCard;

public interface DealerService {
    List<PlayingCard> getShuffled();
}
