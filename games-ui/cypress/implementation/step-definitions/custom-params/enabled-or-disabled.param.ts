import { defineParameterType } from 'cypress-cucumber-preprocessor/steps';

defineParameterType({
  name: 'enabledOrDisabled',
  regexp: new RegExp('enabled|disabled'),
  transformer(enabled: string) {
    return enabled === 'enabled';
  }
});
