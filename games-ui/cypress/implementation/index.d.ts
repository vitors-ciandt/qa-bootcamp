// in cypress/support/index.d.ts
// load type definitions that come with Cypress module
/// <reference types="cypress" />

declare namespace Cypress {
  interface Chainable {
    saveLocalStorage(): void;

    matchImageSnapshot(): void;

    restoreLocalStorage(): void;

    modifyToggleValue(featureToggleName: string, isToggleOn: boolean): void;

    clearModifiedToggleValues(): void;

    oktaAuthLogin(username: string, password: string): Chainable<PrevSubject>;
  }
}
