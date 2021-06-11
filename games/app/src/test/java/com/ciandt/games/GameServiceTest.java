package com.ciandt.games;

import com.ciandt.games.dealer.DealerService;
import com.ciandt.games.playingcard.CardSuit;
import com.ciandt.games.playingcard.PlayingCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    DealerService dealerServiceMock;

    @Mock
    GameRepository gameRepositoryMock;

    @InjectMocks
    GameService gameService;
    private Object RuntimeException;

    @Test
    void shouldSaveGame() {
        // Arrange
        ArrayList<PlayingCard> deck = new ArrayList<>();
        PlayingCard card1 = new PlayingCard(1, CardSuit.CLUBS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.CLUBS);
        deck.add(card1);
        deck.add(card2);

        Game playedGame = new Game();

        when(dealerServiceMock.getShuffled()).thenReturn(deck);
        when(gameRepositoryMock.save(argThat(game ->
                game.getCard1().equals(card1)
                        && game.getCard2().equals(card2)
                        && game.getPlayedDeck().equals(deck))))
                .thenReturn(playedGame);

        // Act
        Game result = gameService.play();

        // Assert
        assertEquals(playedGame, result);
    }

    @Test
    void runTimeExceptionTest() {
        RuntimeException runTimeException = assertThrows(java.lang.RuntimeException.class,
                () -> gameService.play()
        );

        assertEquals("You cannot play a game with less than 2 cards", runTimeException.getMessage());

    }
}
