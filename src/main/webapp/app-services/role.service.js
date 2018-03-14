(function(){
'use strict';

angular.module('app').factory('RoleService',RoleService);

RoleService.$inject = ['$http'];
function RoleService($http) {
	var service = {};

    service.GetAll = GetAll;
    service.GetById = GetById;
    service.GetByRolename = GetByRolename;
    service.Create = Create;
    service.Update = Update;
    service.Delete = Delete;

    return service;
    
    function GetAll() {
        return $http.get('/LoginAngularRestJan04/rest/Role').then(handleSuccess, handleError('Error getting all users'));
     
    }

    function GetById(id) {
        return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
    }

    function GetByRolename(rolename) {            
    	return $http.get('/LoginAngularRestJan04/rest/Role/'+ rolename).then(handleSuccess, handleError('Error creating user'));
    }

    function Create(role) {
        return $http.post('/LoginAngularRestJan04/rest/Role/', role).then(handleSuccess, handleError('Error creating user'));
    }

    function Update(role) {
        return $http.put('/LoginAngularRestJan04/rest/Role/' + role.roleId, role).then(handleSuccess, handleError('Error updating user'));
    }

    function Delete(id) {
        return $http.delete('/LoginAngularRestJan04/rest/Role/' + id).then(handleSuccess, handleError('Error deleting user'));
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