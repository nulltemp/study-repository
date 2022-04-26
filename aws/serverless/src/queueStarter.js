'use strict';

const AWS = require('aws-sdk');
AWS.config.update({region: `${process.env.AWS_REGION}`});
const sqs = new AWS.SQS({apiVersion: '2012-11-05'});

module.exports.exec = async (event, context) => {
  const accountId = context.invokedFunctionArn.split(':')[4];
  const queueUrl = `https://sqs.${process.env.AWS_REGION}.amazonaws.com/${accountId}/test-queue`;

  try {
    for (let i = 0; i < 3; i++) {
      const params = {
        MessageBody: `message${i}`,
        QueueUrl: queueUrl
      };
      const result = await sqs.sendMessage(params).promise();
      console.log(result);
    }
  } catch (e) {
    console.log(e);
  }
};
