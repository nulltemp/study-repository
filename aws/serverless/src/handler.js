'use strict';

const { v4: uuidv4 } = require('uuid');

module.exports.hello = async (event) => {
  return {
    statusCode: 200,
    body: JSON.stringify(
      {
        message: 'Go Serverless v3.0! Your function executed successfully!',
        input: event,
        uuid: uuidv4()
      },
      null,
      2
    ),
  };
};
