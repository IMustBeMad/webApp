var app = angular.module('main');

app.controller('loginController', function ($scope, $http, $location) {
    $scope.login = {
        name: '',
        pass: ''
    };

    $scope.postForm = function (login, form) {
        if (form.$valid) {

            $http.post('/login_check', login, {}).success($location.path("/#/welcome.html"))
        } else {
            alert("not valid: " + login.name + " " + login.pass)
        }
    }
});