var app = angular.module('myApp', []);

app.controller('myController', function($scope, $http) {
    $scope.submitForm = function() {
        if ($scope.nubanForm.$valid) {
            var data = {
                bankCode: $scope.bankCode,
                serial: $scope.serial
            };

            $http.post('/nuban', data)
                .then(function(response) {
                    $scope.nuban = response.data.nuban;
                })
                .catch(function(error) {
                    console.log(error);
                });
        } else {
            $scope.nuban = null;
        }
    };
});
