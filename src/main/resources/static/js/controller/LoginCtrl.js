var app = angular.module('main');

app.controller('loginController', function ($scope, $http, $window) {
    $scope.login = {
        name: '',
        pass: ''
    };

    $scope.postForm = function (login, form) {
        if (form.$valid) {

            $http({
                method: 'POST',
                url: "login_check",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                transformRequest: function (obj) {
                    var str = [];
                    for (var p in obj) {
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
                data: {name: login.name, pass: login.pass}
            }).success(function () {
                $window.location.href = "/"
            });

        } else {
            alert("not valid: " + login.name + " " + login.pass)
        }
    };
});
