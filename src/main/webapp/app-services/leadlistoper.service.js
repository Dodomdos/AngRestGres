(function () {
    'use strict';

    angular
        .module('app')
        .factory('LeadListOperService', LeadListOperService);

    LeadListOperService.$inject = ['LeadListService','$http'];
    function LeadListOperService(LeadListService,$http) {
    
    	var service = {};        
        service.LoadLeadListDetails = LoadLeadListDetails;
        return service;
        
        function LoadLeadListDetails(callback) {
            var response;                                                       
            LeadListService.GetAll().then(function (leadlist) {                
            	if (leadlist !== "") {
            		console.log("call inside leadlist of LoadLeadDetails " 
            				+ leadlist);
                    response = { success: true };
                } else {
                    response = { success: false, message: 'Lead List does not exist' };
                }
                callback(response,leadlist);
            });               
        }               
    }
    
})();