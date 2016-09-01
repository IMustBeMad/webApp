angular.module('main', [
    'ngRoute'
]).config(function ($routeProvider, $httpProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'index.html'
        })
        .when('/welcome', {
            templateUrl: 'welcome.html'
        })
        .when('/login', {
            templateUrl: 'login.html'
        })
        .otherwise('/');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});
