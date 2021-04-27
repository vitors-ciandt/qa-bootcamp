package com.ciandt.games.dealer;

import java.util.List;

import com.ciandt.games.playingcard.PlayingCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnMissingBean(DealerServiceLocalImpl.class)
public class DealerServiceImpl implements DealerService {
    @Autowired
    private DealerProxy proxy;

    public List<PlayingCard> getShuffled() {
        return proxy.getShuffled();
    }

}
