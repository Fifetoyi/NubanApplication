var app = angular.module('myApp', []);

app.controller('myController', function($scope, $http) {
    $scope.serial = '';
    $scope.bankCode = '';
    $scope.submitForm = function() {
        if ($scope.nubanForm.$valid) {
            var url = '/nuban?bankCode=' + encodeURIComponent($scope.bankCode) + '&serial=' + encodeURIComponent($scope.serial);

            $http.post(url)
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
