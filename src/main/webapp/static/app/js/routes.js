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
        .when('/ads/view/:id', {
                    templateUrl : '/static/app/html/partial/viewAd.html',
                    controller: 'AdController'
                })
        .when('/ads/addEditAd', {
                            templateUrl : '/static/app/html/partial/addEditAd.html',
                            controller: 'AdController'
                        })

}]);