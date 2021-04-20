package com.ciandt.dealer.deck;

import java.util.List;

import com.ciandt.dealer.playingcard.PlayingCard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "deckProxy", url = "${deckProxy.url}")
public interface DeckProxy {
    @RequestMapping("/")
    public List<PlayingCard> getDeck();
}
