(function() {
	'use strict';

	angular.module('app').controller('UserGUIController', UserGUIController);

	UserGUIController.$inject = ['UserService','DisplayService','$location',
			'AuthenticationService', 'FlashService','UseroperService'];
	function UserGUIController(UserService,DisplayService,$location, 
			AuthenticationService,FlashService,UseroperService) {
		
		var vm = this;		
		
		//initializing the input controls
		
		vm.user = {
				userId:-1,
				firstName:"",
				lastName:"",
				username:"",
				password:"",
				roleName:""
		};
		
		
		//Now load the data from server
		var loadForm = loadUserData(function(userlist){
			console.log('inside loadUserData userlist'+ userlist);
			//use user list for data population in ngtables
			vm.userlist = userlist;
			(vm.clearUser)();
		});
		
		loadForm;
		
		/*//Now load the data from server
		loadUserData(function(userlist){
			console.log('inside loadUserData userlist'+ userlist);
			//use user list for data population in ngtables
			vm.userlist = userlist;
			
			for (var i=0;i<vm.userlist.length;i++)
			{
			        vm.selection.push(vm.userlist[i].username);
			        console.log(vm.selection);			    
			} 
			 
		});*/
		
		
		loadRoles(function(roleNames){
			//use rolenames for hint; consider it as a separate function
			vm.roleNames = roleNames;
		});	
		
		//vm.tableParams = new NgTableParams({}, { dataset: userlist});
		
		//vm.tableParams = new ngTableParams({}, { dataset: userlist});
		
		
		vm.editUser = function(user){			
		  console.log('inside editUser');
		  vm.user.userId = user.userId; 	
		  vm.user.firstName = user.firstName;
		  vm.user.lastName = user.lastName ;
		  vm.user.username = user.username ;
		  vm.user.password = user.password ;
		  vm.user.roleName = user.roleName ;
		};
		
		vm.clearUser = function(){
			  console.log('inside clearUser');
			  vm.user.userId = -1; 	
			  vm.user.firstName = "";
			  vm.user.lastName = "" ;
			  vm.user.username = "" ;
			  vm.user.password = "" ;
			  vm.user.roleName = "" ;
		};
		
		function loadUserData(fn){
			//get all the user data for display in vm.user
			vm.dataLoading = true;
			DisplayService.LoadUserDetails(function(response,userlist) {
				if (response.success) {
					FlashService.Success('LoadUser Data successful', true);
					console.log('the userlist is '+ userlist);					
				} else {
					FlashService.Error(response.message);
					vm.dataLoading = false;
				}
				
				fn(userlist);
			});
		}
		
		function loadRoles(fn){
			//get all the roles for display in hint
			DisplayService.LoadRoles(function(response,rolelist) {
				if (response.success) {
					FlashService.Success('LoadUser Roles successful', true);
					console.log('the rolelist is '+ rolelist);					
				} else {
					FlashService.Error(response.message);
					vm.dataLoading = false;
				}
				fn(rolelist);
			});	
		}
		
		vm.deleteUser = function(user){
			console.log('Am in delete function ' + user.username);
			UserService.Delete(user.username).then(
					function(response) {
						//console.log("inside operuser DeleteUser " + response );
						loadUserData(function(userlist){
							vm.userlist = userlist;				
						});
						(vm.clearUser)();
					});
			
			/*loadUserData(function(userlist){
				console.log('inside loadUserData userlist'+ userlist);
				//use user list for data population in ngtables
				vm.userlist = userlist;				
			});
			(vm.clearUser)();
			 */		
			}
		
		vm.useraddedit = function() {
			console.log('Am in user screen ' + vm.user.username);
			vm.dataLoading = true;
			
			//check for the user name to determine update or create
			UseroperService.LoadUserName(vm.user.username,
					function (userDetails){
					console.log('the userDetails userId is '+ userDetails.userId);
					// do set credentials here
					if(userDetails.userId != -1)
					{
						//this is update functionality
						console.log('the userDetails is '+ userDetails.userId);
						console.log(' am in update user ');	
						
						UserService.Update(vm.user)
						.then(
								function(userInsDetails) {
									console.log("inside operuser UpdateUser " + userInsDetails.userId);								
									//callback(userInsDetails);
									loadUserData(function(userlist){
										console.log('inside loadUserData userlist'+ userlist);
										//use user list for data population in ngtables
										vm.userlist = userlist;									
									});
									(vm.clearUser)();									
								});
						
						/*UseroperService.UpdateUser(vm.user,
								function (userDetails){
							if (userDetails.userId != -1) {
								FlashService.Success('Updation successful', true);
								//loadUserData(uD);
								//clearUser();
							} else {
								FlashService.Error(response.message);
								vm.dataLoading = false;
							}
						});*/
					}
					else
					{
						console.log("am in insert user");
						
						UseroperService.InsertUser(vm.user,
								function (userDetails){
							if (userDetails.userId != -1) {								
								FlashService.Success('Insertion successful', true);
								loadUserData(function(userlist){
									console.log('inside loadUserData userlist'+ userlist);
									//use user list for data population in ngtables
									vm.userlist = userlist;									
								});
								(vm.clearUser)();
							} else { 
								FlashService.Error('Insertion not successful', true);
								vm.dataLoading = false;
							}
						});
					}				
			});			
		};		
	}	
})();
