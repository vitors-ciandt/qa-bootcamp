export {};

const yaml = require('yaml');
const fs = require('fs');

const environment = process.env.ENV || 'ci';
const generalProposalUiConfig = fs.readFileSync('./environments/ihm-micro-ui-template.yaml', 'utf8');
const generalProposalUiConfigJson = yaml.parse(generalProposalUiConfig);

const proposalUiConfig = { ...generalProposalUiConfigJson.all, ...generalProposalUiConfigJson[environment] };

fs.writeFileSync('ihm-micro-ui-template.json', JSON.stringify(proposalUiConfig, null, '  '), 'utf-8');
fs.writeFileSync('../micro-ui-demo/ihm-micro-ui-template.json', JSON.stringify(proposalUiConfig, null, '  '), 'utf-8');
