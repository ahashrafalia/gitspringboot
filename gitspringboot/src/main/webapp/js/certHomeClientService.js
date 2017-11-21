'use strict';
certHome.factory('CertHomeFactory',['$resource',function($resource){
	var url='http://localhost:8081/gitspringboot/rest/secured/certSearch:id';
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