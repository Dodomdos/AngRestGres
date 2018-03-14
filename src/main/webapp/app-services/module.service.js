(function(){
'use strict';

angular.module('app').factory('ModuleService',ModuleService);

ModuleService.$inject = ['$http'];
function ModuleService($http) {
	var service = {};

    service.GetAll = GetAll;
    service.GetById = GetById;
    service.GetByModulename = GetByModulename;
    service.Create = Create;
    service.Update = Update;
    service.Delete = Delete;

    return service;
    
    function GetAll() {
        return $http.get('/LoginAngularRestJan04/rest/Module').then(handleSuccess, handleError('Error getting all users'));
     
    }

    function GetById(id) {
        return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
    }

    function GetByModulename(modulename) {            
    	return $http.get('/LoginAngularRestJan04/rest/Module/'+ modulename).then(handleSuccess, handleError('Error creating user'));
    }

    function Create(module) {
        return $http.post('/LoginAngularRestJan04/rest/Module/', module).then(handleSuccess, handleError('Error creating user'));
    }

    function Update(module) {
        return $http.put('/LoginAngularRestJan04/rest/Module/' + module.moduleId, module).then(handleSuccess, handleError('Error updating user'));
    }

    function Delete(id) {
        return $http.delete('/LoginAngularRestJan04/rest/Module/' + id).then(handleSuccess, handleError('Error deleting user'));
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