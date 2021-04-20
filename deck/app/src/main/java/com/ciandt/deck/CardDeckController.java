package com.ciandt.deck;

import java.util.List;

import com.ciandt.deck.playingcard.PlayingCard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardDeckController {
    @GetMapping("/")
    public List<PlayingCard> getGreeting() {
        return CardDeck.getDeck();
    }
}
