(function () {
    'use strict';

    angular
        .module('app')
        .controller('ForgotPasswordController', ForgotPasswordController);

    ForgotPasswordController.$inject = ['$location', '$rootScope', 'FlashService'];
    function ForgotPasswordController($location, $rootScope, FlashService) {
        var vm = this;

        vm.fp = fp;

        function fp() {
            return;
        }
    }

})();
