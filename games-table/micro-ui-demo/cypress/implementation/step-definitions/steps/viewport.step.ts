import { When } from 'cypress-cucumber-preprocessor/steps';
import { ViewportHeight, ViewportWidth } from '../../enums/viewport.enum';

When('the resolution is {string}', resolution => {
  const viewportResolutions: any = {
    Medium: { width: ViewportWidth.Medium, height: ViewportHeight.Medium },
    Large: { width: ViewportWidth.Large, height: ViewportHeight.Large },
    Extra: { width: ViewportWidth.Extra, height: ViewportHeight.Extra }
  };

  const size = viewportResolutions[resolution];

  cy.viewport(size.width, size.height);
  Cypress.config('viewportWidth', size.width);
  Cypress.config('viewportHeight', size.height);
});
