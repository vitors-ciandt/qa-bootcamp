let LOCAL_STORAGE_MEMORY = {};
const OktaAuth = require('@okta/okta-auth-js');
import { addMatchImageSnapshotCommand } from 'cypress-image-snapshot/command';

addMatchImageSnapshotCommand({
  failureThreshold: 0.01, // threshold for entire image
  failureThresholdType: 'percent', // percent of image or number of pixels
  customDiffConfig: { threshold: 0.01 }, // threshold for each pixel
  capture: 'viewport' // capture viewport in screenshot
});

Cypress.Commands.add('saveLocalStorage', () => {
  Object.keys(localStorage).forEach(key => {
    LOCAL_STORAGE_MEMORY[key] = localStorage[key];
  });
});

Cypress.Commands.add('restoreLocalStorage', () => {
  Object.keys(LOCAL_STORAGE_MEMORY).forEach(key => {
    localStorage.setItem(key, LOCAL_STORAGE_MEMORY[key]);
  });
});

// there is a override option on the feature toggle for local testing, see FeatureToggleService
Cypress.Commands.add('modifyToggleValue', (featureToggleName, value) => {
  localStorage.setItem('toggles', `[["${featureToggleName}",${value}]]`);
});

Cypress.Commands.add('clearModifiedToggleValues', () => {
  localStorage.removeItem('toggles');
});

Cypress.Commands.add('oktaAuthLogin', (username, password) => {
  if (Cypress.env(username)) {
    localStorage['okta-token-storage'] = Cypress.env(username);
  } else {
    const clientId = Cypress.env('clientId');
    console.log(clientId);
    const baseUrl = Cypress.env('baseUrl');
    const authorizationServer = Cypress.env('authorizationServer');
    const redirectUri = Cypress.env('redirectUri');
    const config = {
      clientId,
      url: `https://${baseUrl}`,
      issuer: `https://${baseUrl}/oauth2/${authorizationServer}`,
      redirectUri
    };
    const authClient = new OktaAuth(config);
    cy.wrap('Authenticating in Okta!')
      .then(() => {
        return authClient.signIn({ username, password });
      })
      .then(async ({ sessionToken }) => {
        const response = await authClient.token.getWithoutPrompt({
          responseType: ['id_token', 'token'],
          scopes: ['openid', 'email', 'profile', 'SF_Ext_Att'],
          sessionToken
        });
        return response;
      })
      .then(([idToken, accessToken]) => {
        Cypress.env(username, JSON.stringify({ idToken, accessToken }));
        localStorage['okta-token-storage'] = JSON.stringify({
          idToken,
          accessToken
        });
      });
  }
});
