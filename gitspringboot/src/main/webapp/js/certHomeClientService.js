'use strict';
certHome.factory('CertHomeFactory',['$resource',function($resource){
	var url='http://localhost:8081/gitspringboot/rest/secured/cert:id';
	return $resource(url,
		{
			id:'@id'
		},
		{
			update:{
				method:'PUT'
			}
		});
	
}]);

certHome.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});