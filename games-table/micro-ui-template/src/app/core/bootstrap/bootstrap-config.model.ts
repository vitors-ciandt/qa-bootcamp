import { Injector } from '@angular/core';

export interface BootstrapConfig<ComponentType = any> {
  tag: string;
  component: ComponentType;
  injector: Injector;
}
