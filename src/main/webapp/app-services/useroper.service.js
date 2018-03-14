(function() {
	'use strict';

	angular.module('app').factory('UseroperService', UseroperService);

	UseroperService.$inject = [ 'UserService', 'RoleService', '$http',
			'$cookies', '$rootScope' ];
	function UseroperService(UserService, RoleService, $http, $cookies,
			$rootScope) {

		var service = {};
		service.LoadUserName = LoadUserName;
		service.InsertUser = InsertUser;
		return service;

		function LoadUserName(username, callback) {
			UserService.GetByUsername(username).then(function(user) {
				console.log("call inside user " + user.userId);
				callback(user);
			});
		}

		function InsertUser(user, callback) {			
			UserService
					.Create(user)
					.then(
							function(userInsDetails) {
								console.log("inside operuser InsertUser " + userInsDetails.userId);								
								callback(userInsDetails);
							});
		}
		
		function UpdateUser(user, callback) {			
			UserService
					.Update(user)
					.then(
							function(userInsDetails) {
								console.log("inside operuser UpdateUser " + userInsDetails.userId);								
								callback(userInsDetails);
							});
		}
		
		function DeleteUser(user) {			
			UserService.Delete(user.username).then(
							function(response) {
								console.log("inside operuser DeleteUser " + response );	
							});
		}

	}

})();