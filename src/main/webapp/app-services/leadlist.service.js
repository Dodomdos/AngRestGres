(function () {
    'use strict';

    angular
        .module('app')
        .factory('LeadListService', LeadListService);

    LeadListService.$inject = ['$http'];
    function LeadListService($http) {
        var service = {};

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByLeadListname = GetByLeadListname;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            //return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
        	return $http.get('/LoginAngularRestJan04/rest/Lead_List').then(handleSuccess, handleError('Error getting all leads'));
         
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByLeadListname(leadname,userId) {            
        	return $http.get('/LoginAngularRestJan04/rest/Lead_List/'+ leadname + '/' + userId).then(handleSuccess, handleError('Error creating lead'));
        }

        function Create(lead) {
            return $http.post('/LoginAngularRestJan04/rest/Lead_List/', lead).then(handleSuccess, handleError('Error creating lead'));
        }

        function Update(lead) {
            return $http.put('/LoginAngularRestJan04/rest/Lead_List/' + lead.lead_id, lead).then(handleSuccess, handleError('Error updating lead'));
        }

        function Delete(id) {
            return $http.delete('/LoginAngularRestJan04/rest/Lead_List/' + id).then(handleSuccess, handleError('Error deleting lead'));
        }

        // private functions
        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
