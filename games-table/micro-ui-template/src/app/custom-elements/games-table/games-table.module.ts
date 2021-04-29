import { CommonModule } from "@angular/common";
import { Injector, NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatTableModule } from "@angular/material";
import { BootstrapService } from "src/app/core/bootstrap/bootstrap.service";
import { PlayingCardModule } from "../playing-card/playing-card.module";
import { GamesTableComponent } from "./games-table.component";

@NgModule({
  declarations: [GamesTableComponent],
  imports: [CommonModule, PlayingCardModule, FormsModule, ReactiveFormsModule, MatTableModule],
  entryComponents: [GamesTableComponent]
})
export class GamesTableModule {
  constructor(bootstrapService: BootstrapService, private injector: Injector) {
    bootstrapService.add({
      tag: 'games-table',
      component: GamesTableComponent,
      injector: this.injector
    });
  }

}
