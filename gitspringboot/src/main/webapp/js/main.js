var app=angular.module('minmax',[]);
app.controller('MinMaxCtrl',function($scope,$http){
	$scope.formModel={};
	$scope.submitBtn=function(){
		console.log("Hey i am submitted");
		console.log($scope.formModel);
		$http.post('./addAddress',$scope.formModel).
			success(function(data){
				console.log("Hey i am Ok");
			}).error(function(data){
				console.log("Hey i am Not ok");
			});
		
	};
});