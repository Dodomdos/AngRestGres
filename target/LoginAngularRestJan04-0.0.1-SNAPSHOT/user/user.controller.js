(function() {
	'use strict';

	angular.module('app').controller('UserGUIController', UserGUIController);

	UserGUIController.$inject = [ 'UserService', '$location',
			'AuthenticationService', 'FlashService' ];
	function UserGUIController(UserService, $location, AuthenticationService,
			FlashService) {
		var vm = this;
			
		/*userId = 0;
		username = "";
		usernamenew = "";
		firstName = "";
		lastName = "";
		password = "";
		roleId = 0;
		roleName = "";
		userDetailsId = 0;
		moduleNames = "";
		*/

		vm.useraddedit = useraddedit();

		function useraddedit() {
			console.log('Am in user screen.Addd CRUD operations on user')
			vm.dataLoading = true;

			//user does not exists post --create
			if (vm.user.userId == 0) {
				UserService.Create(vm.user).then(function(response,user) {
					if (response.success) {
						FlashService.Success('Creation Post successful', true);
						console.log('the userId is '+ user.userId);
						//$location.path('/user');
					} else {
						FlashService.Error(response.message);
						vm.dataLoading = false;
					}
				});
			} else { //put and an update
				console.log(" am in update user ")
				/*UserService.Update(vm.user).then(function(response) {
					if (response.success) {
						FlashService.Success('Registration successful', true);
						$location.path('/user');
					} else {
						FlashService.Error(response.message);
						vm.dataLoading = false;
					}
				});*/
			}
		};
	}
})();
