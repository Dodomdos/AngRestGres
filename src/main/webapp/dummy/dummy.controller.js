(function () {
    'use strict';

    angular
        .module('app')
        .controller('DummyController', DummyController);

    DummyController.$inject = ['$rootScope','AuthenticationService', 'FlashService'];
    function DummyController($rootScope, AuthenticationService,FlashService) {
        var vm = this;

        vm.register = register;

        initRegister();
        
        function initRegister(){
        	console.log("am in home controller");   
	           
        	AuthenticationService.GetCredentials($rootScope,function(user){
        		console.log("am in home controller username "+user.username);
        	});        	
       
        }
        
        function register() {
            vm.dataLoading = true;
            return;
        }
    }

})();
