'use strict';
certHome.controller('certHomeClientCtrl',['$scope','CertHomeFactory','CertHomeFactory2','popupService','$window','$filter',
		function($scope,CertHomeFactory,CertHomeFactory2,popupService,$window,$filter){
	var self=this;
	$scope.good="";
	$scope.safe="";
	$scope.warn="";
	$scope.risk="";
	$scope.parJson=[];	
	self.certs=[];
	self.cert= new CertHomeFactory();
	

	
	self.fetchAllCerts=function(){
		self.certs=CertHomeFactory.query();
		console.log(self.certs)
	};
	self.fetchAllCerts();
	
	 self.updateCert = function(){
         self.cert.$update(function(){
             self.fetchAllCerts();
         });
     };
     self.createCert = function(){
         self.cert.$save(function(){
             self.fetchAllCerts();
         });
     };
	
	
	
	
	
	self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.certs.length; i++){
            if(self.certs[i].certId === id) {
               self.cert = angular.copy(self.certs[i]);
               self.cert.expDate = $filter('date')(self.cert.expDate , 'dd-MMM-yyyy'); 
               break;
            }
        }
    };
    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.cert.certId === id) {//If it is the one shown on screen, reset screen
           self.reset();
        }
        self.deleteCert(id);
        //self.cert.delete_user(id);
    };
    self.deleteCert = function(identity){
        var cert = CertHomeFactory.get({certId:identity}, function() {
        	console.log("delete cert="+cert);
             cert.$delete_cert(function(){
                 console.log('Deleting cert with id ', identity);
                 self.fetchAllCerts();
             });
        });
     };

    self.submit = function() {
        if(self.cert.certId==null){
            console.log('Saving New cert', self.cert);    
            self.createCert();
        }else{
            console.log('Updating cert with id ', self.cert.certId);
            self.updateCert();
           // console.log('cert updated with id ', self.cert.certId);
        }
        self.reset();
    };
        
    
    self.reset = function(){
        self.cert= new CertHomeFactory();
        $scope.myForm.$setPristine(); //reset Form
    };
      
     
    /* self.remove = function(id){
         console.log('id to be removed', id);
         popupService.showPopup('Really delete this?');
     };*/
         
    
    //var self=this;
	self.certstatuslist=[];
	self.certstatuslists= new CertHomeFactory2();
	

	
	self.fetchCertstatuslist=function(){
		self.certstatuslist=CertHomeFactory2.query(function(data){
			
			//console.log("certstatuslist ctrl="+JSON.stringify(data));
			var st=JSON.stringify(data);
			var jsonData = JSON.parse(st);
			$scope.good = jsonData[0].good;
			$scope.safe = jsonData[0].safe;
			$scope.warn = jsonData[0].warn;
			$scope.risk = jsonData[0].risk;
			console.log(jsonData[0]);
			console.log(jsonData[1]);
			/*angular.forEach(jsonData, function(item){
              console.log(item.good);
				$scope.good=item.good;
				
            })*/
		});
		console.log($scope.good);
		 $scope.myOrder=self.certstatuslist;
		
		
		//console.log("certstatuslist="+$scope.myOrder.mapCertStatuslist.good);
	};
	self.fetchCertstatuslist();
}]);



