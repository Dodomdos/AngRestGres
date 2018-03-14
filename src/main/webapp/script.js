var appname = angular.module('appname', []);
appname.controller('appCtrl', [ '$scope', function($scope) {
	$scope.names = [ {
		name : 'Jani',
		country : 'Norway'
	}, {
		name : 'Hege',
		country : 'Sweden'
	}, {
		name : 'Kai',
		country : 'Denmark'
	} ];
} ]);