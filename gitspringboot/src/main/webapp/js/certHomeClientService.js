'use strict';
certHome.factory('CertHomeFactory',['$resource',function($resource){
	var url='http://localhost:8081/gitspringboot/rest/secured/cert/:id';
	return $resource(url,
		{
			id:'@id'
		},
		{
			update:{
				method:"PUT"
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