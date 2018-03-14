var appname = angular.module('validationApp', []);
	appname.controller('mainController', [ '$scope', function($scope) {
		$scope.submitForm = function(isValid) {
			if (isValid) {
				alert('Login Form is now valid');
			}
		};
	} ]);