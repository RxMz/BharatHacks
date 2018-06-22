const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);

exports.addMessage = functions.https.onRequest((req, res) => {
    var percentage;
    var stt;
    percentage = Math.floor((Math.random() * 40) + 1);
    stt = percentage.toString();
    stt += "%";
    res.send(stt);
});
