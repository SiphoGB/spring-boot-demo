angular.module('directory.services', ['hostServices'])
    .factory('DemoService', function($q) {
        // We use promises to make this api asynchronous. This is clearly not necessary when using in-memory data
        // but it makes this service more flexible and plug-and-play. For example, you can now easily replace this
        // service with a JSON service that gets its data from a remote server without having to changes anything
        // in the modules invoking the data service since the api is already async.
		return {
			findAll: function() {
				return deferred.promise;
			}
		}

    })
    .factory('URLService', function($q, $log, HostnameFactory) {
    	var pre = 'rest';
    	$log.debug(HostnameFactory.url);
    	return {
    		//startUserTopic : HostnameFactory.url + pre + '/project/stats',
    		getTopics : HostnameFactory.url + pre + '/topics',
    		getResults : HostnameFactory.url + pre + '/results',
    		getTopic : function(topicId) {
    			return HostnameFactory.url + pre + '/topic/' + topicId;
    		},
    		startUserTopic : function(topicId) {
    			return HostnameFactory.url + pre + '/user/start/' + topicId;
    		},
    		submitUserTopic : function(topicId, uuid) {
    			return HostnameFactory.url + pre + '/user/submit/' + uuid;
    		}
    	}
    });