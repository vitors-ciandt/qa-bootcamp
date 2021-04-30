import { BuildTargetsElements } from '../elements/build-targets.element';
import { PlaygroundElements } from '../elements/playground.element';

export class PlaygroundPageObject {
  goToFamilyTab(productFamily: string): PlaygroundPageObject {
    // wait the previous tab load, before moving to another tab.
    cy.wait(500);
    cy.get(PlaygroundElements.tabs).contains(productFamily).click();
    // make sure that the tab is loaded
    cy.wait(500);
    cy.get(BuildTargetsElements.flightCard).should('be.visible');
    return this;
  }

  takeAScreenshot(): PlaygroundPageObject {
    cy.wait(2000);
    cy.matchImageSnapshot();
    return this;
  }
}
