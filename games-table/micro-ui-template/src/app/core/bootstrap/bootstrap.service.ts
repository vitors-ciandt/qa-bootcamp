import { Injectable } from '@angular/core';
import { createCustomElement } from '@angular/elements';
import { BootstrapConfig } from './bootstrap-config.model';

@Injectable({
  providedIn: 'root'
})
export class BootstrapService {
  bootstrapConfigs: BootstrapConfig[] = [];

  constructor() {}

  public add(bootstrapConfig: BootstrapConfig): void {
    this.bootstrapConfigs.push(bootstrapConfig);
  }

  public start(): void {
    this.bootstrapConfigs.forEach((item: BootstrapConfig) => this.doBootstrap(item));
  }

  private doBootstrap(bootstrapConfig: BootstrapConfig): void {
    const element = createCustomElement(bootstrapConfig.component, { injector: bootstrapConfig.injector });
    customElements.define(bootstrapConfig.tag, element);
  }
}
