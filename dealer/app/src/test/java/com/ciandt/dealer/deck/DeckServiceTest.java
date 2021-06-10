package com.ciandt.dealer.deck;

import com.ciandt.dealer.playingcard.CardSuit;
import com.ciandt.dealer.playingcard.PlayingCard;
import gherkin.lexer.Pl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(MockitoExtension.class)
public class DeckServiceTest {

    @Mock
    DeckProxy deckProxyMock;

    @InjectMocks
    DeckService deckService;

    @Test
    void getDeckShouldReturnAPlayingCardList(){
        ArrayList<PlayingCard> returning = new ArrayList<>();
        returning.add(0, new PlayingCard(1, CardSuit.HEARTS));

        when(deckProxyMock.getDeck()).thenReturn(returning);

        List<PlayingCard> result = deckService.getDeck();

        assertSame(result, returning);
    }
}
