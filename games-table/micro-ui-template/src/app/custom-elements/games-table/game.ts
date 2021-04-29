export interface Card {
  value: string;
  suit: string;
}

export interface Game {
  id: number;
  timestamp: Date;
  card1: Card;
  card2: Card;
}