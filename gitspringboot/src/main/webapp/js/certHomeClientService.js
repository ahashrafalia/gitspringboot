'use strict';
certHome.factory('CertHomeFactory',['$resource',function($resource){
	var url='http://localhost:8081/gitspringboot/rest/secured/cert/:certId';
	return $resource(url,
		{
			certId:'@certId'
		},
		{
			update:{
				method:"PUT",
				 headers: {
			            'Content-Type': 'application/json'
			        }
			},
			delete_user: {
	            method: 'DELETE'
	        }
		});
	
}]);

certHome.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
