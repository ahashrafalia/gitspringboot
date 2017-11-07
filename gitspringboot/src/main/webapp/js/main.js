var app=angular.module('minmax',[]);
app.controller('MinMaxCtrl',function($scope){
	$scope.formModel={};
	$scope.submitBtn=function(){
		console.log("Hey i am submitted");
		console.log($scope.formModel);
		
	}
});