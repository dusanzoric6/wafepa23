var wafepaApp = angular.module('wafepaApp.routes', ['ngRoute']);

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
        .when('/categories', {
                   templateUrl : '/static/app/html/partial/categories.html',
                   controller: 'CategoryController'
       })
        .when('/ads', {
                   templateUrl : '/static/app/html/partial/ads.html',
                   controller: 'AdController'
               })

}]);