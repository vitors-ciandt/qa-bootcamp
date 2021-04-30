import { defineParameterType } from 'cypress-cucumber-preprocessor/steps';

defineParameterType({
  name: 'visibleOrInvisible',
  regexp: new RegExp('visible|invisible'),
  transformer(visible: string) {
    return visible === 'visible';
  }
});
