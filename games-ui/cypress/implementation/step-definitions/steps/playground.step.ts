import { Given, Then } from 'cypress-cucumber-preprocessor/steps';
import { PlaygroundPageObject } from '../../page-objects/playground.po';

const playgroundPageObject: PlaygroundPageObject = new PlaygroundPageObject();

Given('the user is in the {string} tab', (productFamily: string) => {
  playgroundPageObject.goToFamilyTab(productFamily);
});

Then('take a screenshot', () => {
  playgroundPageObject.takeAScreenshot();
});
