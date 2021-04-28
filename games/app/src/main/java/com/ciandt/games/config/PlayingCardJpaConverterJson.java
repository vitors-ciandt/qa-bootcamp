package com.ciandt.games.config;

import java.io.IOException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ciandt.games.playingcard.PlayingCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class PlayingCardJpaConverterJson implements AttributeConverter<PlayingCard, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(PlayingCard meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (JsonProcessingException ex) {
      return "ERR";
      // or throw an error
    }
  }

  @Override
  public PlayingCard convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, PlayingCard.class);
    } catch (IOException ex) {
      // logger.error("Unexpected IOEx decoding json from database: " + dbData);
      return null;
    }
  }

}
