import { OverlayContainer } from '@angular/cdk/overlay';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatSnackBarModule } from '@angular/material';
import { CdkOverlayContainerOverride } from './overrides/cdk-overlay-container-override';

const appName: string = 'ihm-micro-ui-template';

@NgModule({
  declarations: [],
  imports: [CommonModule, HttpClientModule, MatSnackBarModule],
  providers: [
    { provide: OverlayContainer, useClass: CdkOverlayContainerOverride }
  ]
})
export class CoreModule { }
