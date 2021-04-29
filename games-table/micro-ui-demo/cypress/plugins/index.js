// // ***********************************************************
// // This example plugins/index.js can be used to load plugins
// //
// // You can change the location of this file or turn off loading
// // the plugins file with the 'pluginsFile' configuration option.
// //
// // You can read more here:
// // https://on.cypress.io/plugins-guide
// // ***********************************************************

// // This function is called when a project is opened or re-opened (e.g. due to
// // the project's config changing)

const { addMatchImageSnapshotPlugin, matchImageSnapshotPlugin } = require('cypress-image-snapshot/plugin');

const wp = require('@cypress/webpack-preprocessor');
const fs = require('fs');
const path = require('path');

module.exports = (on, config) => {
  const options = { webpackOptions: require('../webpack.config.js') };
  on('file:preprocessor', wp(options));

  on('before:browser:launch', (browser = {}, args) => {
    if (browser.name === 'chrome') {
      args.push('--disable-dev-shm-usage');
      if (browser.isHeadless) {
        // This configuration is necessary to override the default window size, just adding cause a bug when it's a Jenkins build
        for (var i = 0; i < args.args.length; i++) {
          if (args.args[i].startsWith('--window-size')) {
            args.args[i] = '--window-size=1920,1080';
          }
        }
      }
      return args;
    }

    return args;
  });

  addMatchImageSnapshotPlugin(on, config);

  on('after:screenshot', details => {
    let filename = details.path.split('/');
    filename = filename[filename.length - 1];

    const newPath = path.resolve(__dirname, '../screenshots/' + filename);
    fs.renameSync(details.path, newPath);
    return matchImageSnapshotPlugin({ path: newPath });
  });

  return retrieveLoginAccessConfiguration(config);
};

function retrieveLoginAccessConfiguration(config) {
  try {
    //check if the user and password are being sent as env variables, if so, use then instead of the s3 - used for github actions
    if (process.env.aeUsernameLocal) {
      return new Promise(resolve => {
        //no difference on the user that is logged in since we are not using the okta token, we are passing the role as a micro ui parameter
        config.env.aeUsernameLocal = process.env.aeUsernameLocal;
        config.env.aePasswordLocal = process.env.aePasswordLocal;
        config.env.smUsernameLocal = process.env.aeUsernameLocal;
        config.env.smPasswordLocal = process.env.aePasswordLocal;
        config.env.tmUsernameLocal = process.env.aeUsernameLocal;
        config.env.tmPasswordLocal = process.env.aePasswordLocal;
        config.env.dseUsername = process.env.dseUsername;
        config.env.dsePassword = process.env.dsePassword;

        resolve(config);
      });
    }

    const workspace = process.env.WORKSPACE;
    const credentials = require(workspace + '/credentials-ui.json');
    return retrieveLoginAccessConfigurationFromLocalFile(config, credentials);
  } catch (e) {
    console.log('credentials-ui.json not found, trying to get access configuration from aws s3');
    return retrieveLoginAccessConfigurationFromS3(config);
  }
}

function retrieveLoginAccessConfigurationFromLocalFile(config, credentials) {
  return new Promise(resolve => {
    config.env.aeUsernameNational = credentials.loginAccess.aeUsernameNational;
    config.env.aePasswordNational = credentials.loginAccess.aePasswordNational;
    config.env.aeUsernameLocal = credentials.loginAccess.aeUserNameLocal;
    config.env.aePasswordLocal = credentials.loginAccess.aePasswordLocal;
    config.env.smUsernameLocal = credentials.loginAccess.smUserNameLocal;
    config.env.smPasswordLocal = credentials.loginAccess.smPasswordLocal;
    config.env.tmUsernameLocal = credentials.loginAccess.tmUserNameLocal;
    config.env.tmPasswordLocal = credentials.loginAccess.tmPasswordLocal;
    config.env.dseUsername = credentials.loginAccess.dseUsername;
    config.env.dsePassword = credentials.loginAccess.dsePassword;

    resolve(config);
  });
}

function retrieveLoginAccessConfigurationFromS3(config) {
  return new Promise(resolve => {
    const AWS = require('aws-sdk');
    const credentials = new AWS.SharedIniFileCredentials({ profile: 'ihm' });

    AWS.config.update({ region: 'us-east-1', credentials });

    const s3 = new AWS.S3();

    s3.getObject({
      Bucket: 'ihm-proposal-secrets-nonprod/tst',
      Key: 'credentials-ui.json'
    })
      .promise()
      .then(data => {
        const s3Body = JSON.parse(data.Body.toString());
        const loginAccess = s3Body.loginAccess;

        config.env.aeUsernameNational = loginAccess.aeUsernameNational;
        config.env.aePasswordNational = loginAccess.aePasswordNational;
        config.env.aeUsernameLocal = loginAccess.aeUserNameLocal;
        config.env.aePasswordLocal = loginAccess.aePasswordLocal;
        config.env.smUsernameLocal = loginAccess.smUserNameLocal;
        config.env.smPasswordLocal = loginAccess.smPasswordLocal;
        config.env.tmUsernameLocal = loginAccess.tmUserNameLocal;
        config.env.tmPasswordLocal = loginAccess.tmPasswordLocal;
        config.env.dseUsername = loginAccess.dseUsername;
        config.env.dsePassword = loginAccess.dsePassword;
      })
      .catch(err => {
        console.error('\n\n');
        console.error('===============================');
        console.error(err);
        console.error('===============================');
        console.error('\n\n');
      })
      .finally(() => resolve(config));
  });
}
