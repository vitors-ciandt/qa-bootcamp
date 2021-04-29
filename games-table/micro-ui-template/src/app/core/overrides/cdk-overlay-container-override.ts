import { OverlayContainer } from '@angular/cdk/overlay';
import { Platform } from '@angular/cdk/platform';
import { DOCUMENT } from '@angular/common';
import { Inject, Injectable, OnDestroy } from '@angular/core';

@Injectable({ providedIn: 'root' })
/**
 * Extends OverlayContainer and override "cdk-overlay-container" creation in order to fix issues between main app and micro UI using the
 * same "cdk-overlay-container".
 *
 * Currently we clear all overlay containers when we create a new one as a way to avoid duplicate content coming in from the server. Our
 * current approach is a little too aggressive, because it can pick up containers from different apps. These changes add an extra attribute
 * to the container so that we can determine which platform it's coming from.
 *
 * See more:
 * https://github.com/angular/components/pull/17006
 * https://github.com/angular/components/issues/18616
 *
 * This issue is fixed on Angular 9, this class should be removed once angular and material be updated to version 9.
 */
export class CdkOverlayContainerOverride extends OverlayContainer implements OnDestroy {
  constructor(@Inject(DOCUMENT) _document: any, protected _platform?: Platform) {
    super(_document);
  }

  ngOnDestroy(): void {
    const container = this._containerElement;

    if (container && container.parentNode) {
      container.parentNode.removeChild(container);
    }
  }

  protected _createContainer(): void {
    const isBrowser = this._platform ? this._platform.isBrowser : typeof window !== 'undefined';
    const containerClass = 'cdk-overlay-container';

    if (isBrowser) {
      const oppositePlatformContainers = this._document.querySelectorAll(
        `.${containerClass}[platform="server"], ` + `.${containerClass}[platform="test"]`
      );

      // Remove any old containers from the opposite platform.
      // This can happen when transitioning from the server to the client.
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < oppositePlatformContainers.length; i++) {
        // tslint:disable-next-line:no-non-null-assertion
        oppositePlatformContainers[i].parentNode!.removeChild(oppositePlatformContainers[i]);
      }
    }

    const container = this._document.createElement('div');
    container.classList.add(containerClass);

    this._document.body.appendChild(container);
    this._containerElement = container;
  }
}
