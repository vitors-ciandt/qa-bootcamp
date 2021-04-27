package com.ciandt.games.dealer;

import java.util.List;

import com.ciandt.games.playingcard.PlayingCard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dealerProxy", url = "${dealerProxy.url}")
public interface DealerProxy {
    @GetMapping("/shuffled")
    List<PlayingCard> getShuffled();
}
