(function() {
	'use strict';

	//var app = angular.module("app", ["ngTable"]);'NgTableParams',
	
	angular.module('app').controller('LeadGUIController', LeadGUIController);

	LeadGUIController.$inject = ['LeadListOperService','LeadListService','AuthenticationService',
			'FlashService' ];
	
	function LeadGUIController(LeadListOperService, LeadListService,AuthenticationService,
			FlashService) {
		var vm = this;
		vm.user = {};
				
		// initializing the input controls
		vm.lead = {
				lead_id:-1,
				lead_name:"",
			    designation:"" ,
			    company_name:"",
			    country:"",
			    company_website:"",
				telephone:"",
			    email:"",
			    areaoi:"",
			    remarks:"",
			    next_date:"",
			    status:"",
			    cur_remarks:"",
			    degree:"",			    
			    frole_id:-1,
			    fuser_id:-1			    
		};	
		
		var loadForm = loadlead(function(leadlist){			
			vm.leadlist = leadlist;
		});	
		
		loadForm;
		
		//vm.tableParams = new NgTableParams({}, { data: vm.lead});
		
		AuthenticationService.GetCredentials(function(user){
			vm.user = user;
			console.log( "the userId is " + vm.user.userId);
		});		
		
		vm.editLeadList = function(lead){				
			  console.log('inside editlead');
			  vm.lead.lead_id = lead.lead_id;
			  vm.lead.lead_name = lead.lead_name;
			  vm.lead.designation = lead.designation;
			  vm.lead.company_name = lead.company_name,
			  vm.lead.country = lead.country;
			  vm.lead.company_website = lead.company_website;
			  vm.lead.telephone = lead.telephone;
			  vm.lead.email = lead.email;
			  vm.lead.areaoi = lead.areaoi;
			  vm.lead.remarks = lead.remarks;
			  vm.lead.next_date = lead.next_date;
			  vm.lead.status = lead.status;
			  vm.lead.degree = lead.degree;	
			  vm.lead.frole_id = vm.user.userroleid;
			  vm.lead.fuser_id = vm.user.userId;
		}
			
		vm.clearlead = function(){
			   console.log('inside clearlead');
			   vm.lead.lead_id = -1;
			   vm.lead.lead_name = "";
			   vm.lead.designation = "";
			   vm.lead.company_name = "";
			   vm.lead.country = "";
			   vm.lead.company_website = "";
			   vm.lead.telephone = "";
			   vm.lead.email = "";
		  	   vm.lead.areaoi = "";
			   vm.lead.remarks = "";
			   vm.lead.next_date = "";
			   vm.lead.status = "";
			   vm.lead.degree = "";		
			   vm.lead.frole_id = -1;
			   vm.lead.fuser_id = -1;
		};			
		
		vm.deleteLeadList = function(lead){
			console.log('Am in delete function ' + lead.lead_id);
			LeadListService.Delete(lead.lead_id).then(
					function(response) {
						console.log("inside roleuser DeleteUser " + response );
						loadlead(function(leadlist){			
							vm.leadlist = leadlist;
						});				
						(vm.clearlead)();
			});
			
		};		
			
		vm.leadlistaddedit = function() {
			//GetByleadname(leadname,username)
			console.log('Am in leadaddedit function leadName ' + vm.lead.lead_name);
			console.log('Am in leadaddedit function userId ' + vm.user.userId);
			
			LeadListService.GetByLeadListname(vm.lead.lead_name, vm.user.userId).then(function(lead) {
				
				console.log("call inside leadaddedit " + lead.lead_name);
				
				if(lead.lead_id != -1){
					console.log("am in update module leadId is "+ vm.lead.lead_id);
					//vm.lead.leadId = lead.lead_id;
					//leadId present so an update 
					LeadListService.Update(vm.lead)
					.then(
							function(upLead) {
								console.log("inside leadController Updatelead " 
										+ upLead.lead_id);								
								if(upLead.lead_id != -1){
									FlashService.Success('Updation of lead successful', true);
									
									loadlead(function(leadlist){			
										vm.leadlist = leadlist;
									});
									
									(vm.clearlead)();									
							
								}else
								{
									FlashService.Error('Updation of Lead not successful', false);
								}
					});
				
				}else{
					console.log("am in insert lead");
					//have set it in editlead
					
					LeadListService.Create(vm.lead)
					.then(
							function(insLead) {
								console.log("inside leadController Insertlead " +
										insLead.lead_id);								
								if(insLead.lead_id != -1){
									FlashService.Success('Insertion of lead successful', true);
									
									loadlead(function(leadlist){			
										vm.leadlist = leadlist;
									});
									
									(vm.clearlead)();									
							
								}else
								{
									FlashService.Error('Insertion of Lead not successful', true);
								}
					});	
					
				}
			});
		};		
		
		function loadlead(fn){
			console.log("Inside loadlead in list controller ");
			LeadListOperService.LoadLeadListDetails(function(response,leadlist) {
				if (response.success) {
					FlashService.Success('Load Lead List successful', true);
					//console.log('the lead is '+ leadlist);					
				} else {
					FlashService.Error(response.message);
					vm.dataLoading = false;
				}
				fn(leadlist);
			});
		}
	}
	
})();
