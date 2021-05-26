package com.ciandt.dealer.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ciandt.dealer.playingcard.PlayingCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckService {
    @Autowired
    private DeckProxy deckProxy;

    public List<PlayingCard> getDeck() {
        return deckProxy.getDeck();
    }

    public List<PlayingCard> shuffleDeck(List<PlayingCard> deck) {
        var cloneList = new ArrayList<>(deck);
        Collections.shuffle(cloneList);

        return cloneList;
    }
}
