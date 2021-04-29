import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { MatCardModule } from "@angular/material";
import { PlayingCardComponent } from "./playing-card.component";

@NgModule({
  declarations: [PlayingCardComponent],
  imports: [CommonModule, MatCardModule],
  exports: [PlayingCardComponent]
})
export class PlayingCardModule {
  constructor() { }
}