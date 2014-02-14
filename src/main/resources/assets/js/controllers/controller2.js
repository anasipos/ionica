(function(ns) {

	ns.Controller2 = function($scope, cservice) {
			$scope.customers = cservice.customers;
	}

})(org.demo);