(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$rootScope','AuthenticationService'];
    function HomeController($rootScope,
    		AuthenticationService) {
        var vm = this;        
        
        setMenuBarController();

        function setMenuBarController() {        	           
        	AuthenticationService.GetCredentials($rootScope,function(user){        				
        			    console.log("am in home controller user " );
        	//angular.forEach(vm.user.currentUser, function (value, key) {
        		//console.log("am in home controller user " + value );
            //});
        					        	
        });      
        	
      }
   }

})();