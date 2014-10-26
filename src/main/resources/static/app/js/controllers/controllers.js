angular.module('directory.controllers', [])
	.controller('mainCtrl', function ($scope, $http, $log, URLService) {
		
	})
	.controller('topicCtrl', function ($scope, $http, $log, $routeParams, URLService) {
        $http({
			method: 'GET',
			url: URLService.getTopic($routeParams.topicId),
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.vendorList = data;
            $scope.loading = false;
		}).error(function(data){
			$scope.loading = false;
			$scope.topicId=$routeParams.topicId;
		});
		
	})
	.controller('topicsCtrl', function ($scope, $http, $log, URLService) {
    	
        $http({
			method: 'GET',
			url: URLService.getTopics,
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.vendorList = data;
            $scope.loading = false;
		}).error(function(data){
			$scope.topicList = [{
				"name" : 'topic 1',
				"id" : "1111111111"
			},{
				"name" : 'vendor 2',
				"id" : "2222222222"
			},{
				"name" : 'vendor 3',
				"id" : "3333333333"
			}],
            $scope.loading = false;
		});
		
    })
    .controller('resultsCtrl', function ($scope, $http, $log, URLService) {
    	
        $http({
			method: 'GET',
			url: URLService.getResults,
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.vendorList = data;
            $scope.loading = false;
		}).error(function(data){
			$scope.resultList = [{
				"name" : 'result 1',
				"id" : "1111111111"
			},{
				"name" : 'vendor 2',
				"id" : "2222222222"
			},{
				"name" : 'vendor 3',
				"id" : "3333333333"
			}],
            $scope.loading = false;
		});
		
    });;