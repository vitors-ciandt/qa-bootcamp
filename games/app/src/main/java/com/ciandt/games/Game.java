package com.ciandt.games;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ciandt.games.config.PlayingCardJpaConverterJson;
import com.ciandt.games.config.PlayingCardListJpaConverterJson;
import com.ciandt.games.playingcard.PlayingCard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Instant timestamp;
    @Convert(converter = PlayingCardJpaConverterJson.class)
    private PlayingCard card1;
    @Convert(converter = PlayingCardJpaConverterJson.class)
    private PlayingCard card2;
    @Convert(converter = PlayingCardJpaConverterJson.class)
    @Column(columnDefinition = "text")
    @Convert(converter = PlayingCardListJpaConverterJson.class)
    private List<PlayingCard> playedDeck;
}