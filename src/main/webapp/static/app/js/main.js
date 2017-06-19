var wafepaApp = angular.module('wafepaApp', ['wafepaApp.routes']);

wafepaApp.controller('CategoryController', function($scope, $http, $location, $routeParams) {

$(function(){
   $('.datepicker').datepicker();
			});


        $scope.getCategories = function(){
                   $http({
                     method: 'GET',
                     url: '/categories',
                     params: {'sortCat': $scope.sortCat,
                              'directionCat': $scope.directionCat}

                   }).then(
                   function successCallback(response) {
                       $scope.categories = response.data;
                     },
                   function errorCallback(response) {
                        alert('Error with Get Users');
                     });
                };

        $scope.deleteCategory = function(id){
                   $http({
                     method: 'DELETE',
                     url: '/users/'+id
                   }).then(function successCallback() {
                       $scope.getUsers();
                     }, function errorCallback(response) {
                        alert('Error with Get Users');
                     });
                };
        $scope.initCategory = function(){
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

wafepaApp.controller('AdController', function($scope, $http, $location, $routeParams) {

        $scope.expiryDateFilter;
        $scope.nameSearch;

        $scope.getAds = function(){
                   $http({
                     method: 'GET',
                     url: '/ads',
                     params: {
                     'expiryDateFilter' : $scope.expiryDateFilter,
                     'sortAd': $scope.sortAd,
                     'directionAd': $scope.directionAd,
                     'nameSearch' : $scope.nameSearch
                              }

                   }).then(
                   function successCallback(response) {
                       $scope.ads = response.data;
                     },
                   function errorCallback(response) {
                        alert('Error with Get Ads');
                     });
                };

        $scope.deleteCategory = function(id){
                   $http({
                     method: 'DELETE',
                     url: '/users/'+id
                   }).then(function successCallback() {
                       $scope.getUsers();
                     }, function errorCallback(response) {
                        alert('Error with Get Users');
                     });
                };
        $scope.initAd = function(){
          $scope.Ad = {};

          if($routeParams.id){
            $http({
                   method: 'GET',
                   url: '/ads/'+$routeParams.id
                 }).then(function successCallback(response) {
                      $scope.Ad = response.data;
                   }, function errorCallback(response) {
                      alert('Error with Get Ad');
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
