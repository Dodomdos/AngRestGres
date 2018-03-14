(function() {
	'use strict';

	angular.module('app').controller('ModuleGUIController', ModuleGUIController);

	ModuleGUIController.$inject = ['ModuleService','DisplayService', '$location',
			'AuthenticationService', 'FlashService' ];
	function ModuleGUIController(ModuleService,DisplayService, $location, AuthenticationService,
			FlashService) {
		var vm = this;
		
		//initializing the input controls
		vm.module = {
				moduleId:-1,
				moduleName:"",
				moduleDescription:""				
		};		
		
		var loadForm = loadModules(function(modulelist){			
			vm.modulelist = modulelist;
		});	
		
		loadForm;
		
		vm.editModule = function(module){			
			  console.log('inside editModule');
			  vm.module.moduleId = module.moduleId; 	
			  vm.module.moduleName = module.moduleName;
			  vm.module.moduleDescription = module.moduleDescription ;			  			  
		}
			
		vm.clearModule = function(){
				  console.log('inside clearModule');
				  vm.module.moduleId = -1; 	
				  vm.module.moduleName = "";
				  vm.module.moduleDescription = "" ;				  				  
		};			
		
		vm.deleteModule = function(module){
			console.log('Am in delete function ' + module.moduleId);
			ModuleService.Delete(module.moduleId).then(
					function(response) {
						loadModules(function(modulelist){			
							vm.modulelist = modulelist;
						});				
						(vm.clearModule)();

						console.log("inside roleuser DeleteUser " + response );						
			});
			
		};
		
		vm.moduleaddedit = function() {
		
			ModuleService.GetByModulename(vm.module.moduleName).then(function(module) {
				console.log("call inside roleaddedit " + module.moduleId);
				
				if(module.moduleId != -1){
					//roleId present so an update
					
					console.log("inside moduleController UpdateModule ");
					
					ModuleService.Update(vm.module)
					.then(
							function(moduleDetails) {
								console.log("inside moduleController UpdateModule " + moduleDetails.moduleId);								
								if(moduleDetails.moduleId != -1){
									FlashService.Success('Updation of Module successful', true);
									
									loadModules(function(modulelist){			
										vm.modulelist = modulelist;
									});											
									(vm.clearModule)();									
							
								}else
								{
									FlashService.Error('Updation of Module not successful', true);
								}
					});
				
				}else{
					console.log("am in insert module");
					ModuleService.Create(vm.module)
					.then(
							function(moduleDetails) {
								console.log("inside moduleController InsertModule " + moduleDetails.moduleId);								
								if(moduleDetails.moduleId != -1){
									FlashService.Success('Insertion of Module successful', true);
									
									loadModules(function(modulelist){			
										vm.modulelist = modulelist;
									});											
									(vm.clearModule)();									
							
								}else
								{
									FlashService.Error('Insertion of Module not successful', true);
								}
					});		
					
				}
			});
		}		
		
		function loadModules(fn){
			//get all the roles for display in hint
			console.log("Inside loadRoles in role controller ");
			DisplayService.LoadModules(function(response,modulelist) {
				if (response.success) {
					FlashService.Success('Load Roles successful', true);
					console.log('the modulelist is '+ modulelist);					
				} else {
					FlashService.Error(response.message);
					vm.dataLoading = false;
				}
				fn(modulelist);
			});	
		}
	}
})();
