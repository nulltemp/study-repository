'use strict';

const AWS = require('aws-sdk');
AWS.config.update({region: `${process.env.AWS_REGION}`});
const dynamoDb = new AWS.DynamoDB({apiVersion: '2012-08-10'});

module.exports.exec = async () => {
  await dynamoDb.putItem({
    TableName: 'testDynamoDB',
    Item: {
      'id': {
        S: Date.now().toString()
      },
      'name': {
        S: 'hoge'
      }
    }
  }).promise();

  const all = await dynamoDb.scan({
    TableName: 'testDynamoDB'
  }).promise();

  console.log(all);
};
