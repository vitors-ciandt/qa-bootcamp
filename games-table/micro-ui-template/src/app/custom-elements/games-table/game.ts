export interface Card {
  value: number;
  suit: string;
}

export interface Game {
  id: number;
  timestamp: Date;
  card1: Card;
  card2: Card;
}
