// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
var app = angular.module('starter', ['ionic', 'ngRoute', 'directory.services', 'directory.controllers'])


.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
});

app.config(['$routeProvider', '$sceProvider', function($routeProvider, $sceProvider) {
	$sceProvider.enabled(false);
	$routeProvider.
		when('/topics', {
			templateUrl: 'partials/topics.html',
			controller: 'topicsCtrl'
		}).
		when('/results', {
			templateUrl: 'partials/results.html',
			controller: 'resultsCtrl'
		}).		
		when('/result/:topicId', {
			templateUrl: 'partials/result.html',
			controller: 'resultCtrl'
		}).
		when('/topic', {
			templateUrl: 'partials/topic.html',
			controller: 'topicCtrl'
		}).
		when('/user_topic/:topicId', {
			templateUrl: 'partials/user_topic.html',
			controller: 'mainCtrl'
		}).
        otherwise({
			redirectTo: '/topics'
		});
}]);
