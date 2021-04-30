import { LazyElementsModule } from '@angular-extensions/elements';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatTabsModule } from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlaygroundComponent } from './playground/playground.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { PlayingCardModule } from './shared/playing-card/playing-card.module';

@NgModule({
  declarations: [AppComponent, PlaygroundComponent, PageNotFoundComponent],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule,
    LazyElementsModule,
    AppRoutingModule,
    RouterModule,
    MatTabsModule,
    BrowserAnimationsModule,
    PlayingCardModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
