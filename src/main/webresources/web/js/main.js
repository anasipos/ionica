(function(ns) {



    angular.module('app', [])
        .directive("custWithScope", ns.CustomDirectiveWScope)
        .service('cservice', ns.CustomerService)
        .config([
            '$routeProvider',
            function($routeProvider) {
                //Front pages
                $routeProvider.
                when('/', {
                    templateUrl: 'views/page1.htm',
                    controller: ns.Controller1
                }).when('/page2', {
                    templateUrl: 'views/page2.htm',
                    controller: ns.Controller2
                }).otherwise({
                    redirectTo: '/'
                });
            }
        ])

})(org.demo);