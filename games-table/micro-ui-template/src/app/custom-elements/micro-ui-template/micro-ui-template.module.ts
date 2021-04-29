import { CommonModule } from '@angular/common';
import { Injector, NgModule } from '@angular/core';
import { MatButtonModule, MatProgressBarModule } from '@angular/material';
import { BootstrapService } from 'src/app/core/bootstrap/bootstrap.service';
import { MicroUiTemplateComponent } from './micro-ui-template.component';

@NgModule({
  declarations: [MicroUiTemplateComponent],
  imports: [CommonModule, MatButtonModule, MatProgressBarModule],
  entryComponents: [MicroUiTemplateComponent]
})
export class MicroUiTemplateModule {
  constructor(bootstrapService: BootstrapService, private injector: Injector) {
    bootstrapService.add({
      tag: 'micro-ui-template',
      component: MicroUiTemplateComponent,
      injector: this.injector
    });
  }
}
