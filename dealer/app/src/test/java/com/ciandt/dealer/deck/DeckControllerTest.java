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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeckControllerTest {

    @Mock
    DeckService deckServiceMock;

    @InjectMocks
    DeckController deckController;

    @Test
    void getDeckShouldReturnAPlayingCardListFromTheService() {
        // Arrange
        ArrayList<PlayingCard> returning = new ArrayList<>();
        returning.add(0, new PlayingCard(1, CardSuit.HEARTS));

        when(deckServiceMock.getDeck()).thenReturn(returning);

        // Act
        List<PlayingCard> result = deckController.getDeck();

        // Assert
        assertSame(returning, result);
    }

    @Test
    void getDeckShouldReturnAShuffledDeck() {
        // Arrange
        ArrayList<PlayingCard> deckMock = new ArrayList<>();
        deckMock.add(0, new PlayingCard(1, CardSuit.HEARTS));
        deckMock.add(1, new PlayingCard(2, CardSuit.DIAMONDS));

        ArrayList<PlayingCard> shuffledDeckReturn = new ArrayList<>();
        shuffledDeckReturn.add(0, new PlayingCard(2, CardSuit.DIAMONDS));
        shuffledDeckReturn.add(1, new PlayingCard(1, CardSuit.HEARTS));

        when(deckServiceMock.getDeck()).thenReturn(deckMock);
        when(deckServiceMock.shuffleDeck(deckServiceMock.getDeck())).thenReturn(shuffledDeckReturn);

        // Act
        List<PlayingCard> originalDeck = deckController.getDeck();

        List<PlayingCard> shuffledDeck = deckController.getShuffledDeck();

        // Assert
        assertNotEquals(originalDeck, shuffledDeck);
    }
}
