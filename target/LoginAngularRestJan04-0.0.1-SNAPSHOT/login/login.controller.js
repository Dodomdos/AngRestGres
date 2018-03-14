(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['UserService','$location', 'AuthenticationService', 'FlashService'];
    function LoginController(UserService,$location, AuthenticationService, FlashService) {
        var vm = this;
        var response;
        
        vm.login = login;        
        
        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
        	console.log("am in login controller");
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response,user) {
                if (response.success) {
                	console.log('response data is success ' + user.username) ;
                	console.log('response data is success ' + user.password) ;
                	console.log('response data is success ' + user.roleId) ;
                	console.log('moduleNames ' + user.moduleNames);
                	
                	if(user.moduleNames == "")
                	{
                		user.roleId = 2;
                		user.moduleNames = 'Lead List&Purchase Order&Invoice';
                	}
                	
                	console.log('moduleNames after' + user.roleId);
                	console.log(user.moduleNames);
                	
                	AuthenticationService.SetCredentials(user);
                    
                    $location.path('/home');
                    
                } else {                	
                	FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();
