import { Component, Input, OnChanges, OnInit } from "@angular/core";
import { Card } from "../games-table/game";

@Component({
  selector: 'app-playing-card',
  templateUrl: './playing-card.component.html'
})
export class PlayingCardComponent {
  // Inputs
  @Input() readonly paramCard: Card;

  // Public variables
  initialized: boolean;

  constructor() { }

  public getSuitColor(): string {
    if (['DIAMONDS', 'HEARTS'].includes(this.paramCard.suit)) {
      return "red";
    }
    return "black";
  }

  public getValue(value: Number): string {
    switch (value) {
      case 1: return 'A';
      case 11: return 'J';
      case 12: return 'Q';
      case 13: return 'K';
      default:
        return value.toString();
    }
  }

  public getSuit(suit: string): string {
    switch (suit) {
      case 'SPADES': return '♠';
      case 'HEARTS': return '♥';
      case 'DIAMONDS': return '♦';
      case 'CLUBS': return '♣';
      default:
        return suit;
    }
  }
}