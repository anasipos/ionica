(function(ns) {
    ns.CustomDirectiveWScope = function() {
        return {
            templateUrl: 'views/templates/template.html',
            transclude: true,
            scope: {
                'cust': '='
            },
            link: function(scope, iElement, iAttrs) {
                $(iElement).css("background-color", iAttrs['col']);
                scope.newVariable = 'test';
            }

        };
    }
})(org.demo);