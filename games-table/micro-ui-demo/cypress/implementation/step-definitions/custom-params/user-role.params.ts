import { defineParameterType } from 'cypress-cucumber-preprocessor/steps';
import { UserRoleEnum } from '../../config/user-role.enum';

defineParameterType({
  name: 'userRole',
  regexp: new RegExp('AE|SM|TM'),
  transformer(userRole: string) {
    return userRole as UserRoleEnum;
  }
});
