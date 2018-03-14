(function() {
	'use strict';

	angular.module('app').controller('RoleGUIController', RoleGUIController);

	RoleGUIController.$inject = ['RoleService','DisplayService', '$location',
			'AuthenticationService', 'FlashService' ];
	function RoleGUIController(RoleService,DisplayService, $location, AuthenticationService,
			FlashService) {
		var vm = this;
		
		//initializing the input controls
		vm.role = {
				roleId:-1,
				roleName:"",
				roleDescription:"",
				moduleNames:""
		};		
		
		var loadForm = loadRoles(function(rolelist){			
			vm.rolelist = rolelist;
		});	
		
		loadForm;
		
		vm.editRole = function(role){			
			  console.log('inside editRole');
			  vm.role.roleId = role.roleId; 	
			  vm.role.roleName = role.roleName;
			  vm.role.roleDescription = role.roleDescription ;
			  vm.role.moduleNames = role.moduleNames ;			  
		}
			
		vm.clearRole = function(){
				  console.log('inside clearRole');
				  vm.role.roleId = -1; 	
				  vm.role.roleName = "";
				  vm.role.roleDescription = "" ;
				  vm.role.moduleNames = "" ;				  
		};			
		
		vm.deleteRole = function(role){
			console.log('Am in delete function ' + role.roleId);
			RoleService.Delete(role.roleId).then(
					function(response) {
						console.log("inside roleuser DeleteUser " + 
								response );			
						loadRoles(function(rolelist){			
							vm.rolelist = rolelist;
						});				
						(vm.clearRole)();
				
			});
		};
		
		vm.roleaddedit = function() {
		
			RoleService.GetByRolename(vm.role.roleName).then(function(role) {
				console.log("call inside roleaddedit " + role.roleId);
				
				if(role.roleId != -1){
					//roleId present so an update 
					RoleService.Update(vm.role)
					.then(
							function(roleDetails) {
								console.log("inside roleController UpdateRole " + roleDetails.roleId);								
								if(roleDetails.roleId != -1){
									FlashService.Success('Updation of Role successful', true);
									loadRoles(function(rolelist){			
										vm.rolelist = rolelist;
									});											
									(vm.clearRole)();									
							
								}else
								{
									FlashService.Error('Updation of Role not successful', true);
								}
					});
				
				}else{
					console.log("am in insert role");
					RoleService.Create(vm.role)
					.then(
							function(roleDetails) {
								console.log("inside roleController InsertRole " + roleDetails.roleId);								
								if(roleDetails.roleId != -1){
									FlashService.Success('Insertion of Role successful', true);
									loadRoles(function(rolelist){			
										vm.rolelist = rolelist;
									});											
									(vm.clearRole)();									
							
								}else
								{
									FlashService.Error('Insertion of Role not successful', true);
								}
					});		
					
				}
			});
		}		
		
		function loadRoles(fn){
			//get all the roles for display in hint
			console.log("Inside loadRoles in role controller ");
			DisplayService.LoadRoles(function(response,rolelist) {
				if (response.success) {
					FlashService.Success('Load Roles successful', true);
					console.log('the rolelist is '+ rolelist);					
				} else {
					FlashService.Error(response.message);
					vm.dataLoading = false;
				}
				fn(rolelist);
			});	
		}
	}
})();
