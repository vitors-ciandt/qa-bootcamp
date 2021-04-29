import { After, Before } from 'cypress-cucumber-preprocessor/steps';
import { ViewportHeight, ViewportWidth } from '../../enums/viewport.enum';

Before(() => {
  cy.restoreLocalStorage();

  // This is only needed since so far we don't have a specific user for CI tests
  // Since we are not testing user preferences on Acceptance, we assume that they are default
  // This absolutely must be deleted once we have a user only for automation test purposes
  cy.server();

  // This is needed because of the new responsive tests.
  cy.viewport(ViewportWidth.Extra, ViewportHeight.Extra);
  Cypress.config('viewportWidth', ViewportWidth.Extra);
  Cypress.config('viewportHeight', ViewportHeight.Extra);
});

After(() => {
  // clear the toggle to avoid issues with following tests
  cy.clearModifiedToggleValues();
  cy.saveLocalStorage();
});
