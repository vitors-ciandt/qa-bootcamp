import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from './game';

@Injectable({
  providedIn: 'root',
})
export class GamesService {
  private gamesApi = 'http://k8s-default-games-d9015bd95d-297394171.us-east-1.elb.amazonaws.com';

  constructor(private httpClient: HttpClient) { }

  public findAllAfterTimestamp(date: Date): Observable<Game[]> {
    const formattedDate = formatDate(date, 'yyyy-MM-dd', 'en-US');
    return this.httpClient.get<Game[]>(`${this.gamesApi}/games?date=${formattedDate}`);
  }
}