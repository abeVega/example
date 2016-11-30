var myApp = angular.module('myApp', []); 
myApp.controller
('AppCtrl', ['$scope', '$http', function($scope, $http){ 
    console.log("Hello World from controller");

    var refresh = function(){
	console.log("controller->refresh(): I got the data I requested")	
	$http.get('/education_list').success
	(
	    function(response){
		$scope.education_list = response
	    }
	)

	$http.get('/project_list').success
	(
	    function(response){
		$scope.project_list = response
	    }
	)

	$http.get('/skill_list').success
	(
	    function(response){
		$scope.skill_list = response
	    }
	)
    }
        
    refresh();