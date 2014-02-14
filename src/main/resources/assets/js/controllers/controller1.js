(function(ns) {

    ns.Controller1 = function($scope, cservice) {


        $scope.getRegisteredCustomerNumber = function() {
            return cservice.customers.length;
        }

        $scope.addCustomer = function() {
            var customer = {
                'name': $scope.name,
                'address': $scope.address
            };
            cservice.customers.push(customer);
        }

    }

})(org.demo);