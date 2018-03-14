(function () {
    'use strict';

    angular
        .module('app')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['UserService','$http', '$cookies', '$rootScope'];
    function AuthenticationService(UserService,$http, $cookies, $rootScope) {
        var service = {};

        service.Login = Login;
        service.LoadUserDetails = LoadUserDetails;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;
        service.GetCredentials = GetCredentials;
        
        return service;

        function Login(username, password, callback) {
            var response;         
                                              
            UserService.GetByUsername(username,password)
            .then(function (user) {
                //if (user.username !== null && user.password === password) {
            	if (user.username !== "") {
            		console.log("call inside user " + user.username);
                    response = { success: true };
                } else {
                    response = { success: false, message: 'Username or password is incorrect' };
                }
                callback(response,user);
            });        
            
        }
        
        function LoadUserDetails(callback) {
            var response;         
                                              
            UserService.GetByAll()
            .then(function (userlist) {                
            	if (userlist !== "") {
            		console.log("call inside userlist of LoadUserDetails " + userlist);
                    response = { success: true };
                } else {
                    response = { success: false, message: 'Username or password is incorrect' };
                }
                callback(response,userlist);
            });     
            
        }
        
        function GetCredentials(callback) {
              
        	  $rootScope.globals = {
                          userId : 0,
                          username: "",
                          firstName: "",
                          lastName : "",
                          userroleid : 0,
                          userModules: "",
                          authdata: ""
                 };
        	  	
                var attribute = null;
        	  
                $rootScope.globals = $cookies.getObject('globals'); 
            	console.log('username getcredential '+ $rootScope.globals.username);            	
            	
            	/*angular.forEach(globals, function (value,key) {
            		//$rootScope.currUser.push(value);
            		console.log("value is "+ value + " key " + key);
                });
            	for( attribute in globals)
            	{
            		console.log(`${attribute}`.toUpperCase() + `: ${globals[attribute]}`);
            	}*/
            	
            	console.log("value is "+ $rootScope.globals.userId );
                callback($rootScope.globals);
        }
        
        function SetCredentials(user) {
            var authdata = Base64.encode(username + ':' + password);

            /*$rootScope.globals = {
                currentUser: {
                	userId : user.userId,
                    username: user.username,
                    firstName: user.firstName,
                    lastName : user.lastName,
                    userroleid : user.roleId,
                    userModules: user.moduleNames,
                    authdata: authdata
                }
            };*/
            
            $rootScope.globals = {                    
                    	userId : user.userId,
                        username: user.username,
                        firstName: user.firstName,
                        lastName : user.lastName,
                        userroleid : user.roleId,
                        userModules: user.moduleNames,
                        authdata: authdata                    
                };

            console.log('Inside SetCredentials '+ $rootScope.globals.username);
            // set default auth header for http requests
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;

            // store user details in globals cookie that keeps user logged in for 1 week (or until they logout)
            var cookieExp = new Date();
            cookieExp.setDate(cookieExp.getDate() + 7);
            $cookies.putObject('globals', $rootScope.globals, { expires: cookieExp });
            
            // $rootScope.globals = $cookies.getObject('globals');        	
        	//console.log('Inside SetCredentials $rootScope.globals '+ $rootScope.globals.username);
        }

        function ClearCredentials() {
            $rootScope.globals = {};
            $cookies.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic';
        }
    }

    // Base64 encoding service used by AuthenticationService
    var Base64 = {

        keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                    this.keyStr.charAt(enc1) +
                    this.keyStr.charAt(enc2) +
                    this.keyStr.charAt(enc3) +
                    this.keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                window.alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = this.keyStr.indexOf(input.charAt(i++));
                enc2 = this.keyStr.indexOf(input.charAt(i++));
                enc3 = this.keyStr.indexOf(input.charAt(i++));
                enc4 = this.keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };

})();