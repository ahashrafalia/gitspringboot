<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en" ng-app="certHomeClient" ng-controller="certHomeClientCtrl as ctrl">
  <head>
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
  
    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    
    <link href="${pageContext.request.contextPath}/angularlibs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
     <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/angularlibs/bootstrap/dist/js/bootstrap.min.js"></script> 
   <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
   
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script> -->
    <script src="${pageContext.request.contextPath}/js/ang15/angular.js"></script> 
    <script src="${pageContext.request.contextPath}/js/ang15/angular-resource.js"></script> 
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <script src="${pageContext.request.contextPath}/js/certHomeClient.js"></script>
    <script src="${pageContext.request.contextPath}/js/certHomeClientService.js"></script>
    <script src="${pageContext.request.contextPath}/js/certHomeClientController.js"></script>
    <script src="${pageContext.request.contextPath}/js/dirPagnination.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fusioncharts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fusioncharts.theme.ocean.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/angular-fusioncharts.js"></script>
    <script>
	$(document).ready(function(){
		var date_input=$('input[name="date"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'dd-M-yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		})
	})
</script>
  </head>

  <body>
   
    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
      <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <a class="navbar-brand" href="#">Dashboard</a>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <!-- <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Settings</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Help</a>
          </li>
        </ul> -->
        <form class="form-inline mt-2 mt-md-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
       <!--  <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
          <ul class="nav nav-pills flex-column">
            <li class="nav-item">
              <a class="nav-link active" href="#">Overview <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Reports</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Analytics</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Export</a>
            </li>
          </ul>

          <ul class="nav nav-pills flex-column">
            <li class="nav-item">
              <a class="nav-link" href="#">Nav item</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Nav item again</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">One more nav</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Another nav item</a>
            </li>
          </ul>

          <ul class="nav nav-pills flex-column">
            <li class="nav-item">
              <a class="nav-link" href="#">Nav item again</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">One more nav</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Another nav item</a>
            </li>
          </ul>
        </nav>-->

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
          <h1>Dashboard</h1>
 
          <section class="row text-center placeholders">
         
            <div class="col-6 col-sm-3 placeholder thumbnail text-center">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="100" height="100" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Good</h4>
              <div class="text-muted caption"><span style="font-size:100%;color:White;">	{{good}}</span></div>
            </div>
             <div class="col-6 col-sm-3 placeholder thumbnail text-center">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="100" height="100" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Safe</h4>
              <div class="text-muted caption"><span style="font-size:100%;color:White;">	{{safe}}</span></div>
            </div>
             <div class="col-6 col-sm-3 placeholder thumbnail text-center">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="100" height="100" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Warn</h4>
              <div class="text-muted caption"><span style="font-size:100%;color:White;">	{{warn}}</span></div>
            </div>
             <div class="col-6 col-sm-3 placeholder thumbnail text-center">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="100" height="100" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Risk</h4>
              <div class="text-muted caption"><span style="font-size:100%;color:White;">	{{risk}}</span></div>
            </div>
            
            <div class="col-6 col-sm-3 placeholder thumbnail text-center">
              <fusioncharts 
			    width="400" 
			    height="400"
			    type="pie3d"
			    datasource="{{myDataSource}}"></fusioncharts>
            </div>
          </section>
          
         
          <h2>Certificate Form </h2>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.cert.certId" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Cert Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.cert.certName" id="uname" class="username form-control input-sm" placeholder="Enter Cert name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">Expiary Date</label>
                              <div class="col-md-7">
                              <div class='input-group date' id='datetimepicker1'>
				                    <input type='datetime' ng-model="ctrl.cert.expDate" class="form-control input-sm" id="date" name="date" placeholder="DD-MMM-YYYY" />
				                </div>
				                
				                </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">CertStatus</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.cert.certStatus" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.cert.certId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                     <!--  <pre>{{myForm|json}}</pre>  -->
                  </form>
              </div>
          </div>
          

          <h2>Certificate Details</h2>
          <div class="alert alert-info">
					<p>Sort key: {{sortKey}}</p>
					<p>Reverse: {{reverse}}</p>
					<p>Search String : {{search}}</p>
		</div>
          <div class="table-responsive">
          <form class="form-inline">
					<div class="form-group">
						<label >Search</label>
						<input type="text" ng-model="search" class="form-control" placeholder="Search">
					</div>
			</form>
			 <dir-pagination-controls
					max-size="25"
					direction-links="true"
					boundary-links="true" >
			</dir-pagination-controls>
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>#</th>
                  <th ng-click="sort('cert.certId')">Cert Id</th>
                  <th ng-click="sort('cert.clientId')">Client Id</th>
                  <th ng-click="sort('cert.certName')">CertName <span class="glyphicon sort-icon" ng-show="sortKey=='cert.certName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th>Created Date</th>
                   <th>Renewed Date</th>
                   <th ng-click="sort('cert.expDate')">Exp Date</th> 
                   <th>Cert Status</th> 
                   <th width="100">Edit</th>
                   <th width="100">Remove</th>
                </tr>
              </thead>
              <tbody>
                <tr dir-paginate="cert in ctrl.certs|filter:search|orderBy:sortKey:reverse|itemsPerPage:100">
                <td>{{$index+1}}}</td>
                  <td><span ng-bind="cert.certId"></span></td>
                  <td><span ng-bind="cert.clientId"></span></td>
                  <td><span ng-bind="cert.certName"></span></td>
                  <td><span ng-bind="cert.createdDate |date:'dd-MMM-yyyy'"></span></td>
                  <td><span ng-bind="cert.renewedDate"></span></td>
                  <td><span ng-bind="cert.expDate |date:'dd-MMM-yyyy'"></span></td>
                  <td><span ng-bind="cert.certStatus"></span></td>
                  <td>
                    <button type="button" ng-click="ctrl.edit(cert.certId)" class="btn btn-success custom-width">Edit</button>
                  </td>
                  <td>    
                    <button type="button" ng-click="ctrl.remove(cert.certId)" class="btn btn-danger custom-width">Remove</button>
                  </td>
                </tr>
                
              </tbody>
            </table>
            <dir-pagination-controls
					max-size="25"
					direction-links="true"
					boundary-links="true" >
			</dir-pagination-controls>
          </div>
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--Pagination https://ciphertrick.com/2015/08/31/server-side-pagination-in-angularjs/ -->
    
  </body>
</html>
