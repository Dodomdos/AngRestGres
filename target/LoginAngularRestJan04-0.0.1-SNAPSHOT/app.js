(function(){
	'use strict';
	 
	angular
	.module('app',['ngRoute','ngCookies'])
	.config(config)
	.run(run);
	
	config.$inject = ['$routeProvider','$locationProvider'];
	function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
            	controller: 'LoginController',
                templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
            })
            .when('/dummy',{
            	controller: 'DummyController',
            	templateUrl: 'dummy/dummy.view.html',
            	controllerAs: 'vm'            	
            })
            .when('/home',{
            	controller: 'HomeController',
            	templateUrl: 'home/home.view.html',
            	controllerAs: 'vm'
            })
            .when('/forgotPassword',{
            	controller: 'ForgotPasswordController',
            	templateUrl:'fp/fp.view.html',
            	controllerAs: 'vm'
            })
            .when('/register',{
            	controller:'RegisterController',
            	templateUrl:'register/register.view.html',
            	controllerAs: 'vm'
            })
            .when('/user',{
            	controller:'UserGUIController',
            	templateUrl:'user/user.view.html',
            	controllerAs: 'vm'
            })
            .otherwise({ redirectTo: '/' });
    }
	 
	run.$inject = ['$rootScope','$cookies', '$http'];
    function run($rootScope,$cookies,$http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + 
            $rootScope.globals.currentUser.authdata;
        }
     }	
})();


