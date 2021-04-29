import { Injector } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { MatProgressBarModule } from '@angular/material';
import { BrowserDynamicTestingModule } from '@angular/platform-browser-dynamic/testing';
import { MicroUiTemplateComponent } from 'src/app/custom-elements/micro-ui-template/micro-ui-template.component';
import { BootstrapService } from './bootstrap.service';

describe('BootstrapService', () => {
  let service: BootstrapService;
  let injector: Injector;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MicroUiTemplateComponent],
      providers: [BootstrapService],
      imports: [MatProgressBarModule]
    }).overrideModule(BrowserDynamicTestingModule, {
      set: {
        entryComponents: [MicroUiTemplateComponent]
      }
    });
    service = TestBed.get(BootstrapService);
    injector = TestBed.get(Injector);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should add a configuration to bootstrap', () => {
    service.add({
      tag: 'micro-ui-template',
      component: MicroUiTemplateComponent,
      injector
    });

    expect(service.bootstrapConfigs.length).toEqual(1);
  });

  it('should create custom element and register it', () => {
    const bootstrapConfig = {
      tag: 'micro-ui-template',
      component: MicroUiTemplateComponent,
      injector
    };

    service.add(bootstrapConfig);

    const defineSpy = spyOn<any>(customElements, 'define').and.callThrough();

    service.start();

    expect(defineSpy).toHaveBeenCalled();
  });
});
