var app = angular.module('mainApp', [ 'ngRoute','ngSanitize','ngFileUpload',
    'angularFileUpload']);
	
app.config(
	function($routeProvider) {
		$routeProvider
		/*.when('/Home', {
			templateUrl : '/otfportal/home',
		})*/
		.when('/searchmod1', {
			templateUrl : '/dsign/searchmod1',
			controller : 'searchmod1Controller'
		})
		.when('/reportmod1', {
			templateUrl : '/dsign/reportmod1',
			controller : 'reportmod1Controller'
		})
		.when('/manageappmod1', {
			templateUrl : '/dsign/manageappmod1',
			controller : 'manageappmod1Controller'
		})
		.when('/searchmod2', {
			templateUrl : '/dsign/searchmod2',
			controller : 'searchmod2Controller'
		})
		.when('/reportmod2', {
			templateUrl : '/dsign/reportmod2',
			controller : 'reportmod2Controller'
		})
		.when('/manageappmod2', {
			templateUrl : '/dsign/manageappmod2',
			controller : 'manageappmod2Controller'
		})
		.when('/Module4', {
			templateUrl : '/dsign/module4',
			controller : 'module4Controller'
		})
		.otherwise({
			redirectTo : "/Home"
		})
	}
)
	
	 
	app.controller('searchmod1Controller', ['$scope', '$window', '$http',
		function($scope,$window,$http) {
			$scope.btnSearch = function() {
				$scope.showSpinner = true;
				$scope.showMessage = false;
				$scope.showLink = false;
				$scope.downloads = {};
				var URL ='/dsign/search1';
			    var data = {
			    		fileName: $scope.fileName
			    		}; 
			    $http({
					url : URL,
					method : "POST",
					params : data
			    }).then(function successcallback(response) {
			    	$scope.showSpinner = false;
			    	if(response.data.hasError == true) {
			    		$scope.message=response.data.message;
			    		$scope.showMessage = true;
			    	} else {
						$scope.showLink = true;
						$scope.downloads = response.data.data;
			    	}
			    }, function errorcallback(response) {
					console.log(response);
				});
			}
      	}
    ]);

	app.controller('reportmod1Controller', ['$scope', '$window', '$http','$filter',
	function($scope,$window,$http,$filter) {
		
		$scope.btnSearch = function() {
			$scope.showSpinner = true;
			$scope.showMessage = false;
			$scope.showLink = false;
			$scope.downloads = {};
			var URL ='/dsign/report1';
		    var data = {
		    		fromdate: $filter('date')($scope.fromDate, "yyyy-MM-dd"),
		    		todate: $filter('date')($scope.toDate, "yyyy-MM-dd")
		    		}; 
		    $http({
				url : URL,
				method : "POST",
				params : data
		    }).then(function successcallback(response) {
		    	$scope.showSpinner = false;
		    	if(response.data.hasError == true) {
		    		$scope.message=response.data.message;
		    		$scope.showMessage = true;
		    	} else {
					$scope.showLink = true;
					$scope.downloads=response.data.data;
		    	}
			}, function errorcallback(response) {
				console.log(response);
			});
		   
		}
			
  	}
]);
	
	app.controller('manageappmod1Controller', ['$scope', '$window', '$http',
		function($scope,$window,$http) {
		
			$scope.btnExecute = function() {
				
				var URL ='/dsign/manage1';
			     
			    $http({
					url : URL,
					method : "POST"
					
			    }).then(function successcallback(response) {
					console.log(response);
					
				}, function errorcallback(response) {
					console.log(response);
				});
			   
			}
				
	  	}
	]);

	app.controller('searchmod2Controller', ['$scope', '$window', '$http',
    	function($scope,$window,$http) {
			
			$scope.btnSearch = function() {
				$scope.showSpinner = true;
				$scope.showMessage = false;
				$scope.showLink = false;
				$scope.downloads = {};
			    var URL ='/dsign/search2';
			    var data = {
			    		fileName: $scope.fileName
			    		}; 
			    $http({
					url : URL,
					method : "POST",
					params : data
			    }).then(function successcallback(response) {
			    	$scope.showSpinner = false;
			    	if(response.data.hasError == true) {
			    		$scope.showMessage = true;
			    	} else {
						$scope.showLink = true;
						$scope.file1=response.data.data;
						$scope.downloads=response.data.data;
			    	}
				}, function errorcallback(response) {
					console.log(response);
				});
			   
			}
				
      	}
    ]);

	app.controller('reportmod2Controller', ['$scope', '$window', '$http','$filter',
	function($scope,$window,$http,$filter) {
		
		$scope.btnSearch = function() {
			$scope.showSpinner = true;
			$scope.showMessage = false;
			$scope.showLink = false;
			$scope.downloads = {};
			var URL ='/dsign/report2';
		    var data = {
		    		fromdate: $filter('date')($scope.fromDate, "yyyy-MM-dd"),
		    		todate: $filter('date')($scope.toDate, "yyyy-MM-dd")
		    		}; 
		    $http({
				url : URL,
				method : "POST",
				params : data
		    }).then(function successcallback(response) {
		    	$scope.showSpinner = false;
		    	if(response.data.hasError == true) {
		    		$scope.showMessage = true;
		    	} else {
					$scope.showLink = true;
					$scope.downloads=response.data.data;
		    	}
			}, function errorcallback(response) {
				console.log(response);
			});
		   
		}
			
  	}
]);
	
	app.controller('manageappmod2Controller', ['$scope', '$window', '$http',
		function($scope,$window,$http) {
		
			$scope.btnExecute = function() {
				alert("Manage app module")
				var URL ='/dsign/manage2';
			     
			    $http({
					url : URL,
					method : "POST"
					
			    }).then(function successcallback(response) {
					console.log(response);
					
				}, function errorcallback(response) {
					console.log(response);
				});
			   
			}
				
	  	}
	]);

app.controller('module4Controller', ['$scope', '$window', '$http',
	function($scope,$window,$http) {
		
		$scope.upload = function() {
		    var URL ='/otfportal/processdata';
		    var fd = new FormData();
		    fd.append('myfile', myfile.files[0]);
		    
		    $http.post(URL, fd, {
		        transformRequest : angular.identity,
		        headers : {
		            'Content-Type' : undefined
		        }
		    }).then(function successcallback(response) {
				alert("upload success");
				$window.location.href = '#!Report';
			}, function errorcallback(response) {
				console.log(response);
			});
		   
		}
			
  	}
]);

	app.controller('reportController',['$scope','$http',
		function($scope,$http) {
			$http({
				url : "/otfportal/uploadlist",
				method : "GET"
			}).then(function successcallback(response) {
				var data = response.data;
				$scope.reportJson = response.data;
			}, function errorcallback(response) {
				$scope.error = response.statusText;
			});
		
			$scope.download = function(loc) {
			    var URL ='/otfportal/download';
			    $http({
			        url: URL, 
			        method: "GET",
			        params: {filePath: loc}
			    }).then(function successcallback(response) {
					console.log(response.data);
				}, function errorcallback(response) {
					console.log(response);
				});
			   
			}
	
	}
	]);