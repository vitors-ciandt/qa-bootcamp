import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private gamesApi = 'http://k8s-default-games-d9015bd95d-297394171.us-east-1.elb.amazonaws.com';

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
