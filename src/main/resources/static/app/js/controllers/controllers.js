angular.module('directory.controllers', [])
	.controller('mainCtrl', function ($scope, $http, $log, URLService) {
		
	})
	.controller('resultCtrl', function ($scope, $http, $log, $routeParams, URLService) {
        $http({
			method: 'GET',
			url: URLService.getTopic($routeParams.topicId),
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.topic = data;
			$scope.loading = false;
		}).error(function(data){
			$scope.loading = false;
			$scope.topicId='error';
		});

	})
	.controller('topicCtrl', function ($scope, $http, $log, $routeParams, $location, $ionicScrollDelegate, URLService) {
		
		$scope.startUserTopic = function() {
			$scope.loading = true;
			$http({
		        method: 'POST',
		        url: URLService.startUserTopic($routeParams.topicId),
		        data: angular.toJson($scope.user),
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(data) {
		        $scope.loading = false;
		        if (data != "") {
		        	$scope.isStarted = true;
		        	$scope.uuid = data;
		        }
		    }).error(function(data){
		        $scope.loading = false;
		    });
		};
		
		$scope.endUserTopic = function() {
			$scope.isBusy = true;
			$http({
		        method: 'POST',
		        url: URLService.endUserTopic($scope.uuid),
		        data: angular.toJson($scope.topic),
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(data) {
		        $scope.loading = false;
		        $location.path('/result/' + $scope.topic.id);
		        $ionicScrollDelegate.scrollTop();
		    }).error(function(data){
		        $scope.loading = false;
		    });
			$scope.isBusy = true;
			
		};
		    
        $http({
			method: 'GET',
			url: URLService.getTopic($routeParams.topicId),
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.topic = data;
			$scope.isStarted = false;
            $scope.loading = false;
		}).error(function(data){
			$scope.loading = false;
			$scope.topicId='error';
		});
		
	})
	.controller('topicsCtrl', function ($scope, $http, $log, URLService) {

        $http({
			method: 'GET',
			url: URLService.getTopics,
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.topicList = data;
            $scope.loading = false;
		}).error(function(data){
			$scope.loading = false;
		});
		
    })
    .controller('resultsCtrl', function ($scope, $http, $log, URLService) {
    	
        $http({
			method: 'GET',
			url: URLService.getResults,
			headers: {'Content-Type': 'application/json'}
		}).success(function(data){
			$scope.resultList = data;
            $scope.loading = false;
		}).error(function(data){
			$scope.loading = false;
		});
		
    });;