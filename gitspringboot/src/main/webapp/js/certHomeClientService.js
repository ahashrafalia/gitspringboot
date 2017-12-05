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
			delete_cert: {
	            method: 'DELETE'
	        }
		});
	
}]);


certHome.factory('CertHomeFactory2',['$resource',function($resource){
	var url='http://localhost:8081/gitspringboot/rest/secured/certCountClient';
	 var res =  $resource(url, {}, {
	      query: {
	        method: 'GET',
	        params: {
	        },
	        isArray: true,
	        transformResponse: function(data, header){
	          //Getting string data in response
	          var jsonData = angular.fromJson(data)
	          var notes = [];

	          angular.forEach(jsonData, function(item){
	           // var note = new Note();
	           // note.noteTitle = item.title;  
	            notes.push(item);
	        	 // console.log(item);
	          });

	          return notes;
	        }
	        
	      }
	    });
	    return res;
	
}]);

certHome.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
