import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlaygroundComponent } from './playground/playground.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/playground', pathMatch: 'full' },
  {
    path: 'playground',
    component: PlaygroundComponent,
    canActivate: []
  },
  {
    path: '**',
    component: PageNotFoundComponent,
    canActivate: []
  }
];
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
