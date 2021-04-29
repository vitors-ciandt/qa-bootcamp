import { Component, EventEmitter, Input, OnChanges, Output } from '@angular/core';

@Component({
  selector: 'app-micro-ui-template',
  templateUrl: './micro-ui-template.component.html'
})
export class MicroUiTemplateComponent implements OnChanges {
  // Inputs
  @Input() readonly paramTitle: string;
  @Input() readonly paramDescription: string;

  // Outputs
  @Output() readonly onMicroUiLoaded: EventEmitter<string> = new EventEmitter();

  // Public variables
  initialized: boolean;

  constructor() {}

  ngOnChanges(): void {
    if (this.areAllParametersInitialized && !this.initialized) {
      this.init();
    }
  }

  private init(): void {
    this.initialized = true;
    this.onMicroUiLoaded.emit('Micro UI Loaded!');
  }

  private get areAllParametersInitialized(): boolean {
    return !!this.paramTitle && !!this.paramDescription;
  }
}
