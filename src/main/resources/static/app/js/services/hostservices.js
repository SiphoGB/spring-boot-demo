var hostServices = angular.module('hostServices', []);

hostServices.factory('HostnameFactory', function ($http, $location) {
    return {
        url: $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/"
    };
});