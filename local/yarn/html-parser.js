'use strict';

const axios = require('axios');
const { JSDOM } = require('jsdom');

axios.get('https://www.google.co.jp/')
  .then(function (response) {
    // handle success
    console.log(response.data);
    const { document } = (new JSDOM(response.data)).window;
    const titleEl = document.querySelector("title");
    console.log(titleEl.firstChild.textContent);
  });