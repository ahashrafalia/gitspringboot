'use strict';
certHome.controller('certHomeClientCtrl',['$scope','CertHomeFactory',function($scope,CertHomeFactory){
	var self=this;
	self.certs=[];
	
	self.fetchAllCerts=function(){
		self.certs=CertHomeFactory.query();
	};
	self.fetchAllCerts();
}]);