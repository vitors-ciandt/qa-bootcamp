import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-playground',
  templateUrl: './playground.component.html',
  styleUrls: ['./playground.component.scss']
})
export class PlaygroundComponent implements OnInit {
  constructor() {}
  microUiUrl = 'http://localhost:8001/main.js';
  isMicroUiLoaded: boolean;

  ngOnInit(): void {}

  onMicroUiLoaded(event: string): void {
    console.log(`Micro ui has been loaded`, event);
    this.isMicroUiLoaded = true;
  }
}
