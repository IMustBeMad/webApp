var app = angular.module('main');

app.controller('loginController', function ($scope, $http, $location) {
    $scope.login = {
        name: '',
        pass: ''
    };

    $scope.postForm = function (login, form) {
        if (form.$valid) {

            $http.post('j_spring_security_check', login, {})
                 .success(
                $scope.loggedIn = true,
                $location.path("/#/welcome.html")
            )
        } else {
            alert("not valid: " + login.name + " " + login.pass)
        }
    }
});