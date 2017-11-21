'use strict';
certHome.controller('certHomeClientCtrl',['$scope','CertHomeFactory','popupService','$window',function($scope,CertHomeFactory,popupService,$window){
	var self=this;
	self.certs=[];
	
	self.fetchAllCerts=function(){
		self.certs=CertHomeFactory.query();
		console.log(self.certs)
	};
	self.fetchAllCerts();
	
	 self.edit = function(id){
         console.log('id to be edited', id);
         popupService.showPopup('Really delete this?');
     };
         
}]);