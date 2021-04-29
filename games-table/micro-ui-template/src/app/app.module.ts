import { DoBootstrap, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BootstrapService } from './core/bootstrap/bootstrap.service';
import { CoreModule } from './core/core.module';
import { GamesTableModule } from './custom-elements/games-table/games-table.module';

@NgModule({
  imports: [BrowserModule, BrowserAnimationsModule, CoreModule, GamesTableModule]
})
export class AppModule implements DoBootstrap {
  ngDoBootstrap(): void {
    this.bootstrapService.start();
  }

  constructor(private bootstrapService: BootstrapService) { }
}
