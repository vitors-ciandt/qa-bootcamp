package com.ciandt.deck.playingcard;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayingCardTest {
    @Test
    void cardShouldReturnValueAWhenItsEqualToOne() {
        // Arrange
        PlayingCard card = new PlayingCard(1, CardSuit.HEARTS);

        // Act
        String cardValue = card.getFormattedValue();
        String expectedValue = "A";

        // Assert
        assertSame(cardValue, expectedValue);
    }

    @Test
    void cardShouldReturnValueJWhenItsEqualToEleven() {
        // Arrange
        PlayingCard card = new PlayingCard(11, CardSuit.HEARTS);

        // Act
        String cardValue = card.getFormattedValue();
        String expectedValue = "J";

        // Assert
        assertSame(cardValue, expectedValue);
    }

    @Test
    void cardShouldReturnValueQWhenItsEqualToTwelve() {
        // Arrange
        PlayingCard card = new PlayingCard(12, CardSuit.HEARTS);

        // Act
        String cardValue = card.getFormattedValue();
        String expectedValue = "Q";

        // Assert
        assertSame(cardValue, expectedValue);
    }

    @Test
    void cardShouldReturnValueKWhenItsEqualToThirteen() {
        // Arrange
        PlayingCard card = new PlayingCard(13, CardSuit.HEARTS);

        // Act
        String cardValue = card.getFormattedValue();
        String expectedValue = "K";

        // Assert
        assertSame(cardValue, expectedValue);
    }

    @Test
    void playingCardShouldReturnValue() {
        // Arrange
        PlayingCard card = new PlayingCard(2, CardSuit.HEARTS);

        // Act
        String cardValue = card.getFormattedValue();
        Integer i = 2;
        String expectedValue = String.valueOf(i);

        // Assert
        assertSame(cardValue, expectedValue);
    }

    @Test
    void cardShouldReturnSuitWhenItsEqualToSpades() {
        // Arrange
        PlayingCard card = new PlayingCard(13, CardSuit.SPADES);

        // Act
        String cardSuit = card.getFormattedSuit();
        String expectedSuit = "♠";

        // Assert
        assertSame(cardSuit, expectedSuit);
    }

    @Test
    void cardShouldReturnSuitWhenItsEqualToHeart() {
        // Arrange
        PlayingCard card = new PlayingCard(13, CardSuit.HEARTS);

        // Act
        String cardSuit = card.getFormattedSuit();
        String expectedSuit = "♥";

        // Assert
        assertSame(cardSuit, expectedSuit);
    }

    @Test
    void cardShouldReturnSuitWhenItsEqualToDiamonds() {
        // Arrange
        PlayingCard card = new PlayingCard(13, CardSuit.DIAMONDS);

        // Act
        String cardSuit = card.getFormattedSuit();
        String expectedSuit = "♦";

        // Assert
        assertSame(cardSuit, expectedSuit);
    }

    @Test
    void cardShouldReturnSuitWhenItsEqualToClubs() {
        // Arrange
        PlayingCard card = new PlayingCard(13, CardSuit.CLUBS);

        // Act
        String cardSuit = card.getFormattedSuit();
        String expectedSuit = "♣";

        // Assert
        assertSame(cardSuit, expectedSuit);
    }

    @Test
    void kingComparedToAceShouldReturnGreater() {
        // Arrange
        PlayingCard card1 = new PlayingCard(1, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(11, CardSuit.HEARTS);

        // Act
        int result = card1.compareTo((card2));

        // Assert
        assertEquals(1, result);
    }

    @Test
    void aceComparedToKingShouldReturnGrater() {
        // Arrange
        PlayingCard card1 = new PlayingCard(1, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(11, CardSuit.HEARTS);

        // Act
        int result = card1.compareTo((card2));

        // Assert
        assertEquals(1, result);
    }

    @Test
    void kingComparedToAceShouldReturnSmaller() {
        // Arrange
        PlayingCard card1 = new PlayingCard(1, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(11, CardSuit.HEARTS);

        // Act
        int result = card2.compareTo((card1));

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void cardShouldReturnGreater() {
        // Arrange
        PlayingCard card1 = new PlayingCard(5, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.HEARTS);

        // Act
        int result = card1.compareTo((card2));

        // Assert
        assertEquals(1, result);
    }

    @Test
    void cardShouldReturnLess() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(11, CardSuit.HEARTS);

        // Act
        int result = card1.compareTo((card2));

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void cardShouldReturnEqual() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.HEARTS);

        // Act
        int result = card1.compareTo((card2));

        // Assert
        assertEquals(0, result);
    }

    @Test
    void aceCardShouldReturnEqual() {
        // Arrange
        PlayingCard card1 = new PlayingCard(1, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(1, CardSuit.HEARTS);

        // Act
        int result = card1.compareTo((card2));

        // Assert
        assertEquals(0, result);
    }

    @Test
    void spadesComparedToSpadesShouldReturnEqual() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.SPADES);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void spadesComparedToHeartsShouldReturnGreater() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.HEARTS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(1, result);
    }

    @Test
    void heartsComparedToSpadesShouldReturnLess() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.HEARTS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardTwoRank, cardOneRank);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void spadesComparedToDiamondsShouldReturnGreater() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.DIAMONDS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(1, result);
    }

    @Test
    void diamondsComparedToSpadesShouldReturnLess() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.DIAMONDS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardTwoRank, cardOneRank);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void spadesComparedToClubsShouldReturnGreater() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.CLUBS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(1, result);
    }

    @Test
    void clubsComparedToSpadesShouldReturnLess() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card2 = new PlayingCard(2, CardSuit.CLUBS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardTwoRank, cardOneRank);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void heartsComparedToHeartsShouldReturnEqual() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.HEARTS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.HEARTS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void diamondsComparedToDiamondsShouldReturnEqual() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.DIAMONDS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.DIAMONDS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void clubsComparedToClubsShouldReturnEqual() {
        // Arrange
        PlayingCard card1 = new PlayingCard(2, CardSuit.CLUBS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.CLUBS);

        // Act
        int cardOneRank = card1.getSuit().rank;
        int cardTwoRank = card2.getSuit().rank;
        int result = -Integer.compare(cardOneRank, cardTwoRank);

        // Assert
        assertEquals(0, result);
    }
}
