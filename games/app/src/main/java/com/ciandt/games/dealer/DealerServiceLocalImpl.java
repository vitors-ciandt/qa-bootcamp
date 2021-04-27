package com.ciandt.games.dealer;

import java.util.List;

import com.ciandt.games.playingcard.PlayingCard;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
@Profile({ "local", "test" })
public class DealerServiceLocalImpl implements DealerService {
    @Autowired
    private ObjectMapper mapper;

    @Override
    @SneakyThrows
    public List<PlayingCard> getShuffled() {
        return mapper.readValue(getClass().getResource("/mock/shuffled-deck.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, PlayingCard.class));
    }
}
