'use strict';

module.exports.exec = async (event) => {
  event.Records.forEach(record => {
    const { body } = record;
    console.log(body);
  });
};
