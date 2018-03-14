(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            //return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
        	return $http.get('/LoginAngularRestJan04/rest/User').then(handleSuccess, handleError('Error getting all users'));
         
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username,password) {            
        	return $http.get('/LoginAngularRestJan04/rest/User/'+ username + '/'+ password).then(handleSuccess, handleError('Error creating user'));
        }

        function Create(user) {
            return $http.post('/LoginAngularRestJan04/rest/User/', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/LoginAngularRestJan04/rest/User/' + user.userId, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/LoginAngularRestJan04/rest/User/' + id).then(handleSuccess, handleError('Error deleting user'));
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
