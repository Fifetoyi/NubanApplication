var app = angular.module('myApp', []);

app.controller('myController', function($scope, $http) {
    $scope.generatedNubans = [];
    $scope.bankCode = '';
    $scope.serial = '';
    $scope.nuban = '';
    $scope.error = '';

    $scope.submitForm = function() {
        if ($scope.nubanForm.$valid) {
            var url = '/nuban?bankCode=' + encodeURIComponent($scope.bankCode) + '&serial=' + encodeURIComponent($scope.serial);

            $http.post(url)
                .then(function(response) {
                    $scope.nuban = response.data.nuban;
                    $scope.error = '';
                    $scope.generatedNubans.push(response.data.nuban);
                })
                .catch(function(error) {
                    if (error.status === 409) {
                        $scope.nuban = '';
                        $scope.error = 'An error occurred. Please try again.';
                    } else {
                        $scope.nuban = '';
                        $scope.error = 'Duplicate serial number detected. Please enter a different serial number.';
                        console.log(error);
                    }
                });
        } else {
            $scope.nuban = '';
            $scope.error = 'Please enter a valid bank code and serial number.';
        }
    };
});
