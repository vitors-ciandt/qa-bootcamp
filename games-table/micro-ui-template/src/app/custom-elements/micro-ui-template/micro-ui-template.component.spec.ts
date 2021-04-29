import { createTestComponentFactory, Spectator } from '@netbasal/spectator';
import { MicroUiTemplateComponent } from './micro-ui-template.component';

describe('MicroUiTemplateComponent', () => {
  let spectator: Spectator<MicroUiTemplateComponent>;

  const createComponent = createTestComponentFactory<MicroUiTemplateComponent>({
    component: MicroUiTemplateComponent,
    mocks: [],
    shallow: true,
    detectChanges: false
  });

  beforeEach(() => {
    spectator = createComponent();
  });

  it('should create ', () => {
    expect(spectator.component).toBeTruthy();
  });
});
