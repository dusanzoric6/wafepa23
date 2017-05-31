var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('MyController', function($scope, $http, $location, $routeParams) {

        $scope.textt="neki text";
        $scope.smer="ASC";
        $scope.view=false;

        $scope.set2View = function () {
          $scope.view=true;
        };

        $scope.reverse = function(){
          if($scope.smer == "ASC"){$scope.smer="DESC";}

          if($scope.smer == "DESC"){$scope.smer="ASC";}


        }

        $scope.getUsers = function(){
                   $http({
                     method: 'GET',
                     url: '/users',
                     params: {'smer': $scope.smer}

                   }).then(function successCallback(response) {
                       $scope.users = response.data;
                     }, function errorCallback(response) {
                        alert('Error with Get Users');
                     });
                };

        $scope.deleteUser = function(id){
                   $http({
                     method: 'DELETE',
                     url: '/users/'+id
                   }).then(function successCallback() {
                       $scope.getUsers();
                     }, function errorCallback(response) {
                        alert('Error with Get Users');
                     });
                };
        $scope.initUser = function(){
          $scope.newUser = {};

          if($routeParams.id){
            $http({
                   method: 'GET',
                   url: '/users/'+$routeParams.id
                 }).then(function successCallback(response) {
                      $scope.newUser = response.data;
                   }, function errorCallback(response) {
                      alert('Error with Get Users');
                   });
          }

        };

        $scope.saveUser = function(){
         if($routeParams.id){ //edit
                    $http({
                           method: 'PUT',
                           url: '/users/'+$routeParams.id,
                           data : $scope.newUser
                         }).then(function successCallback(response) {
                              $location.path('/users');
                           }, function errorCallback(response) {
                              alert('Error with PUT Users');
                           });
                  }else{
                           $http({
                             method: 'POST',
                             url: '/users',
                             data : $scope.newUser
                           }).then(function successCallback() {
                               $location.path('/users');
                             }, function errorCallback(response) {
                                alert('Error with POST User');
                             });
                        };
                   }


});

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
        .when('/users', {
            templateUrl : '/static/app/html/partial/users.html',
            controller: 'MyController'
        })
        .when('/users/add', {
            templateUrl : '/static/app/html/partial/addEditUser.html',
            controller: 'MyController'
        })
        .when('/users/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditUser.html',
            controller: 'MyController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);