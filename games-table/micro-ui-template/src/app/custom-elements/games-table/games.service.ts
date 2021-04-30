import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from './game';

@Injectable({
  providedIn: 'root'
})
export class GamesService {
  private gamesApi = 'https://37946zhd90.execute-api.us-east-1.amazonaws.com';

  constructor(private httpClient: HttpClient) {}

  public findAllAfterTimestamp(date: Date): Observable<Game[]> {
    const formattedDate = formatDate(date, 'yyyy-MM-dd', 'en-US');
    return this.httpClient.get<Game[]>(`${this.gamesApi}/games?date=${formattedDate}`);
  }
}
