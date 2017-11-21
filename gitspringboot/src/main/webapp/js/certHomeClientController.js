'use strict';
certHome.controller('certHomeClientCtrl',['$scope','CertHomeFactory','popupService','$window',function($scope,CertHomeFactory,popupService,$window){
	var self=this;
	self.certs=[];
	self.cert= new CertHomeFactory();
	
	self.fetchAllCerts=function(){
		self.certs=CertHomeFactory.query();
		console.log(self.certs)
	};
	self.fetchAllCerts();
	
	 self.updateUser = function(){
         self.cert.$update(function(){
             self.fetchAllUsers();
         });
     };
	
	
	
	
	
	self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.certs.length; i++){
            if(self.certs[i].certId === id) {
               self.cert = angular.copy(self.certs[i]);
               break;
            }
        }
    };
    
    self.submit = function() {
        if(self.cert.certId==null){
            console.log('Saving New cert', self.cert);    
            self.createUser();
        }else{
            console.log('Updating cert with id ', self.cert.certId);
            self.updateUser();
            console.log('cert updated with id ', self.cert.certId);
        }
        self.reset();
    };
        
    
    self.reset = function(){
        self.cert= new CertHomeFactory();
        $scope.myForm.$setPristine(); //reset Form
    };
      
     
     self.remove = function(id){
         console.log('id to be removed', id);
         popupService.showPopup('Really delete this?');
     };
         
}]);