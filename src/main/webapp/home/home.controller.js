(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$rootScope','$cookies','AuthenticationService'];
    function HomeController($rootScope,$cookies,
    		AuthenticationService) {
        
    	var vm = this; 
        vm.fields = ["Role"];
        
        setMenuBarController(function(user,somefields){
        	console.log('somefields '+somefields);
        	vm.fields = somefields;
        	vm.user = user
        });
        
        console.log('vm.fields '+vm.fields);
        console.log('vm.user '+vm.user.username);
        
        function setMenuBarController(fn){
        	
        	$rootScope.globals = {
                    userId : 0,
                    username: "",
                    firstName: "",
                    lastName : "",
                    userroleid : 0,
                    userModules: "",
                    authdata: ""
           };
        	
        	$rootScope.globals = $cookies.getObject('globals');        	
        	console.log('$rootScope.globals setMenuBarController '+ $rootScope.globals.username);
        	
        	var moduleNames = $rootScope.globals.userModules;
        	var modulefields = moduleNames.split(',');
        	
        	fn($rootScope.globals, modulefields);
        }
        
        /*function setMenuBarController(fn) {        	           
        	AuthenticationService.GetCredentials(function(user){        				
        	console.log("am in home controller user " + user.username );
        	//angular.forEach(vm.user.currentUser, function (value, key) {
        		//console.log("am in home controller user " + value );
            //});
        	//hard coding for now
        	var user = {
        				userId: 8,
                        username: "dodomdos@gmail.com",
                        firstName: "dodo",
                        lastName : "dos",
                        userroleid : 0,
                        userModules: "User,Role,Module,Bank,Lead List,Purchase Order,Invoice",
                        authdata: "W29iamVjdCBIVE1MSW5wdXRFbGVtZW50XTpbb2JqZWN0IEhUTUxJbnB1dEVsZW1lbnRd"		    
        	};
        	
        	console.log( user.userId);
        	console.log( user.userModules);
        	var moduleNames = user.userModules;
        	var modulefields = moduleNames.split(',');
        	
        	//looping through an array
        	for (var i = 0; i < modulefields.length; i++) 
        	{ console.log(modulefields[i]); }       	
        	
        	fn(user, modulefields);
        });      
        	
      }*/
   }

})();