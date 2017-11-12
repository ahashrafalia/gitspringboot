<!DOCTYPE html >
<html lang="en" ng-app="minmax">
<head >
	<title >Data Binding index</title >
	<link href="${pageContext.request.contextPath}/angularlibs/bootstrap/dist/css/bootstrap.min.css"    rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/angularlibs/ladda/dist/ladda-themeless.min.css"    rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/css/main.css"   rel="stylesheet" >
</head >

<body >

<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container" >
		<div class="navbar-header" >
			<a class="navbar-brand"
			   href="/" >Form Validation - Part 1
			</a >
		</div >
	</div >
</nav >
<div class="container main-content" ng-controller="MinMaxCtrl" ng-init="title='codecraft';awesome='true'">
	This is angular jsp2<br>
	{{title}} is awesome:{{awesome}}
	<input type="text" class="form-control" ng-model="title"/>
	<input type="checkbox" class="form-control" ng-model="awesome"/>

	<form name="theForm" ng-submit="submitBtn(theForm.$valid)" novalidate="novalidate" >
		<div class="form-group" >
			<label for="name" >Name</label >
			<input type="text"
			       class="form-control"
			       ng-model="formModel.name"
			       ng-minlength=4
			       id="name"   required="required" >
		</div >

		<div class="form-group" >
			<label for="email" >Email</label >
			<input type="email"
			       class="form-control"
			       ng-model="formModel.email"
			       id="email"
			       name="email"
			       required="required" >
			     
			       <pre>{{theForm.email.$valid}}</pre>
		</div >

		<div class="form-group" >
			<label for="username" >Username</label >
			<input type="text"
			       class="form-control"
			       ng-model="formModel.username"
			       id="username"
			         required="required"
			         ng-pattern="/^[A-Za-z0-9_]{1,32}$/"
			         min-length="7" 
			         ng-patter-err-type="badUsername" >
		</div >

		<div class="form-group" >
			<label for="age" >Age</label >
			<input type="number"
			       class="form-control"
			       ng-model="formModel.age"
			       id="age" 
			         required="required" 
			         min="18"
			         max="60"
			         ng-min-err-type="tooYoung"
			         ng-max-err-type="tooOld">
		</div >

		<div class="form-group" >
			<label for="sex" >Sex</label >
			<select name="sex"
			        id="sex"
			        class="form-control"
			        ng-model="formModel.sex"
			          required="required"  >
				<option value="" >Please Choose</option >
				<option value="male" >Male</option >
				<option value="female" >Female</option >
			</select >
		</div >

		<div class="form-group" >
			<label for="password" >Password</label >
			<input type="password"
			       class="form-control"
			       ng-model="formModel.password"
			       id="password" >
		</div >

		<div class="form-group" >
			<button class="btn btn-primary"
					ladda="true"
					data-style="expand-right"
			        type="submit" >Register
			</button >
		</div >
		
		<table class="table table-boarded">
			<tr>
				<th></th>
				<th>Name</th>
				<th>Email</th>
				<th>Birthday</th>
			</tr>
			<tr ng-repeat="person in persons" ng-style="{'background-color':$index==selectedIndex?'lightgrey':''}" ng-click="selectedRow($index,person)">
				<td>{{$index+1}}</td>
				<td>{{person.name}}</td>
				<td>{{person.email}}</td>
				<td>{{person.birthdate|date:"dd/MMM/yyyy"}}</td>
			</tr>
		</table>

			<table border="1">
				<tr>
				<th>Phone</th>
				<th>Adress</th>
				<th>City</th>
				</tr>
				<tr>
				<td>{{selectedPerson.phonenumber}}</td>
				<td>{{selectedPerson.address}}</td>
				<td>{{selectedPerson.city}}</td>
				</tr>
			</table>
	</form >
<pre>hi----------{{ theForm.sumbitted }}</pre>
<pre>{{ selectedPerson }}</pre>
	
</div >
<script src="${pageContext.request.contextPath}/angularlibs/angular/angular.min.js" ></script >
 <script src="${pageContext.request.contextPath}/angularlibs/angular-auto-validate/dist/jcs-auto-validate.min.js" ></script >
 <script src="${pageContext.request.contextPath}/angularlibs/ladda/dist/ladda.min.js" ></script >
 <script src="${pageContext.request.contextPath}/angularlibs/angular-ladda/dist/angular-ladda.min.js" ></script >
<script src="${pageContext.request.contextPath}/js/main.js" ></script >
</body >
</html >
