(function () {
    'use strict';

    angular
        .module('app')
        .factory('DisplayService', DisplayService);

    DisplayService.$inject = ['UserService','RoleService','ModuleService','$http', '$cookies', '$rootScope'];
    function DisplayService(UserService,RoleService,ModuleService,$http, $cookies, $rootScope) {
    
    	var service = {};        
        service.LoadUserDetails = LoadUserDetails;
        service.LoadRoles = LoadRoles;
        service.LoadModules = LoadModules;
        return service;
        
        function LoadUserDetails(callback) {
            var response;                                                       
            UserService.GetAll().then(function (userlist) {                
            	if (userlist !== "") {
            		console.log("call inside userlist of LoadUserDetails " + userlist);
                    response = { success: true };
                } else {
                    response = { success: false, message: 'Username or password is incorrect' };
                }
                callback(response,userlist);
            });   
            
        }
        
        function LoadRoles(callback) {
            var response;         
                                              
            RoleService.GetAll()
            .then(function (roleNames) {                
            	if (roleNames !== "") {
            		console.log("call inside rolelist of LoadRoleDetails " + roleNames);
                    response = { success: true };
                } else {
                    response = { success: false, message: 'Username or password is incorrect' };
                }
                callback(response,roleNames);
            }); 
        }
        
        function LoadModules(callback){
        	var response;         
            
            ModuleService.GetAll()
            .then(function (moduleNames) {                
            	if (moduleNames !== "") {
            		console.log("call inside modulelist of LoadModules " + moduleNames);
                    response = { success: true };
                } else {
                    response = { success: false, message: 'ModuleNames is not populated' };
                }
                callback(response,moduleNames);
            }); 
        }       
        
    }
    
})();