package com.ciandt.games.config;

import java.io.IOException;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ciandt.games.playingcard.PlayingCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class PlayingCardListJpaConverterJson implements AttributeConverter<List<PlayingCard>, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(List<PlayingCard> meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (JsonProcessingException ex) {
      return "ERR";
      // or throw an error
    }
  }

  @Override
  public List<PlayingCard> convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData,
          objectMapper.getTypeFactory().constructCollectionType(List.class, PlayingCard.class));
    } catch (IOException ex) {
      // logger.error("Unexpected IOEx decoding json from database: " + dbData);
      return null;
    }
  }

}
