<!DOCTYPE html >
<html lang="en" ng-app="minmax">
<head >
	<title >Data Binding</title >
	<link href="${pageContext.request.contextPath}/angularlibs/bootstrap/dist/css/bootstrap.min.css"    rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/css/main.css"   rel="stylesheet" >
</head >

<body >

<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container" >
		<div class="navbar-header" >
			<a class="navbar-brand"
			   href="/" >Controllers
			</a >
		</div >
		,
	</div >
</nav >
<div class="container main-content" ng-controller="MinMaxCtrl" ng-init="title='codecraft';awesome='true'">
	This is angular jsp<br>
	{{title}} is awesome:{{awesome}}
	<input type="text" class="form-control" ng-model="title"/>
	<input type="checkbox" class="form-control" ng-model="awesome"/>

<form >
		<div class="form-group" >
			<label for="name" >Name</label >
			<input type="text"
			       class="form-control"
			       ng-model="formModel.name";
			       id="name" >
		</div >

		<div class="form-group" >
			<label for="email" >Email</label >
			<input type="email"
			       class="form-control"
			       ng-model="formModel.email"
			       id="email" >
		</div >

		<div class="form-group" >
			<label for="password" >Password</label >
			<input type="password"
			       class="form-control"
			       ng-model="formModel.password"
			       id="password" >
		</div >

		<div class="form-group" >
			<button type="button" class="btn btn-primary" ng-click="submitBtn()">Register
			</button >
		</div >
<pre>{{formModel|json}}</pre>
	</form >
</div >
<script src="${pageContext.request.contextPath}/angularlibs/angular/angular.min.js" ></script >
<script src="${pageContext.request.contextPath}/js/main.js" ></script >
</body >
</html >
