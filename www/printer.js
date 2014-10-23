/*global cordova*/
module.exports = {

    openPrinter: function (macAddress, success, failure) {
        cordova.exec(success, failure, "Printer", "openPrinter", [macAddress]);
    },

    close: function (success, failure) {
        cordova.exec(success, failure, "Printer", "close", []);
    },

    isNoConnection: function (success, failure) {
        cordova.exec(success, failure, "Printer", "isNoConnection", []);
    },

    print: function (data, success, failure) {
        cordova.exec(success, failure, "Printer", "print", [data]);
    },

};
