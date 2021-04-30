import { Component, OnInit } from '@angular/core';
import { Game, GameService } from './game.service';

@Component({
  selector: 'app-playground',
  templateUrl: './playground.component.html',
  styleUrls: ['./playground.component.scss']
})
export class PlaygroundComponent implements OnInit {
  microUiUrl = 'https://master.dwf201msu5idm.amplifyapp.com/main.js';

  constructor(private gameService: GameService) {}
  currentGame: Game;

  ngOnInit(): void {}

  play(): void {
    this.gameService.play().subscribe(g => (this.currentGame = g));
  }

  playFromTheBottom(): void {
    this.gameService.playFromTheBottom().subscribe(g => (this.currentGame = g));
  }
}
