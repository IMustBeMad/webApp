angular.module('main', [
    'ngRoute'
]).config(function ($routeProvider) {

    $routeProvider
        .when('/welcome', {
            templateUrl: 'welcome.html'
        });
    $routeProvider.when('/login', {
            templateUrl: 'login.html',
            controller: 'loginController'
        });
    $routeProvider.otherwise('/');
});
