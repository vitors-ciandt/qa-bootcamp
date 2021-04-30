import { defineParameterType } from 'cypress-cucumber-preprocessor/steps';

defineParameterType({
  name: 'stringToList',
  regexp: /.*/,
  transformer(value: string) {
    return value.replace(/\"/gi, '').split(',');
  }
});
