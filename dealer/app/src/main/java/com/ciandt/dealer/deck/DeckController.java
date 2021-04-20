package com.ciandt.dealer.deck;

import java.util.List;

import com.ciandt.dealer.playingcard.PlayingCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {
    @Autowired
    private DeckService deckService;

    @GetMapping("/")
    public List<PlayingCard> getDeck() {
        return deckService.getDeck();
    }

    @GetMapping("/shuffled")
    public List<PlayingCard> getShuffledDeck() {
        return deckService.shuffleDeck(deckService.getDeck());
    }
}
