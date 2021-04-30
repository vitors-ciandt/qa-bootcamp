import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private gamesApi = 'https://37946zhd90.execute-api.us-east-1.amazonaws.com';

  constructor(private httpClient: HttpClient) {}

  public play(): Observable<Game> {
    return this.httpClient.get<Game>(`${this.gamesApi}/play`);
  }

  public playFromTheBottom(): Observable<Game> {
    return this.httpClient.get<Game>(`${this.gamesApi}/play`);
  }
}

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
