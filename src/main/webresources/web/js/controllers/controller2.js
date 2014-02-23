(function(ns) {

	ns.Controller2 = function($scope, $http, cservice) {
        $http({method: 'GET', url: '/service/offers'}).
            success(function(data, status, headers, config) {
                // this callback will be called asynchronously
                // when the response is available
                $scope.customers = data;

            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
			// $scope.customers = cservice.customers;
	}

})(org.demo);