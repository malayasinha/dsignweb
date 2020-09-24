<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Record Master</title>

<link rel="stylesheet" href="resources/assets/font-awesome/font-awesome.min.css" />
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="resources/assets/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" href="resources/assets/css/bootstrap-datetimepicker.min.css" />

<script type="text/javascript" src="resources/assets/angularjs/angular.js"></script>
<script type="text/javascript" src="resources/assets/angularjs/angular-resource.js"></script>
<script type="text/javascript" src="resources/assets/angularjs/angular-route.js"></script>
<script type="text/javascript" src="resources/assets/angularjs/angular-sanitize.js"></script>

<script type="text/javascript" src="resources/assets/angularjs/angular-file-upload.js"></script>
<script type="text/javascript" src="resources/assets/angularjs/angular-file-upload-shim.js"></script>
<script type="text/javascript" src="resources/assets/angularjs/ng-file-upload.js"></script>
<script type="text/javascript" src="resources/assets/angularjs/ng-file-upload-shim.js"></script>

<script type="text/javascript" src="resources/assets/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/assets/js/popper.min.js"></script>
<script type="text/javascript" src="resources/assets/js/moment.min.js"></script>

<script type="text/javascript" src="resources/assets/js/bootstrap-datetimepicker.min.js"></script>


<script type="text/javascript" src="resources/js/MainApp.js"></script>

<style>
.navbar-nav li:hover > ul.dropdown-menu {
    display: block;
}
.dropdown-submenu {
    position:relative;
}
.dropdown-submenu>.dropdown-menu {
    top: 0;
    left: 100%;
    margin-top:0px;
}

/* rotate caret on hover */
.dropdown-menu > li > a:hover:after {
    text-decoration: underline;
    transform: rotate(-90deg);
} 
</style>
 
</head>
<body ng-app="mainApp">
    <div>
   		<nav class="navbar navbar-expand-md navbar-light bg-light">
		    <a class="navbar-brand pb-2" href="#">Home</a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
		        <ul class="navbar-nav">
		            <!-- <li class="nav-item">
		                <a class="nav-link" href="#">Link</a>
		            </li>
		            <li class="nav-item">
		                <a class="nav-link" href="#">Link</a>
		            </li> -->
		            <li class="nav-item dropdown">
		                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Main Menu </a>
		                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		                    <li class="dropdown-submenu"><a class="dropdown-item dropdown-toggle" href="#">Phase 1</a>
		                        <ul class="dropdown-menu">
		                            <li><a class="dropdown-item" href="#!searchmod1">Search</a></li>
		                            <li><a class="dropdown-item" href="#!reportmod1">Report</a></li>
		                            <li><a class="dropdown-item" href="#!manageappmod1">Manage App</a></li>
		                        </ul>
		                    </li>
		                    <li class="dropdown-submenu"><a class="dropdown-item dropdown-toggle" href="#">Phase 2</a>
		                        <ul class="dropdown-menu">
		                            <li><a class="dropdown-item" href="#!searchmod2">Search</a></li>
		                            <li><a class="dropdown-item" href="#!reportmod2">Report</a></li>
		                            <li><a class="dropdown-item" href="#!manageappmod2">Manage App</a></li>
		                        </ul>
		                    </li>
		                    <li class="dropdown-submenu"><a class="dropdown-item dropdown-toggle" href="#">Contract Signing</a>
		                        <ul class="dropdown-menu">
		                            <li><a class="dropdown-item" href="#!signatories">Signatories</a></li>
		                            <li><a class="dropdown-item" href="#!profile">Profile</a></li>
		                            <li><a class="dropdown-item" href="#!uploadfile">Upload File</a></li>
		                            <li><a class="dropdown-item" href="#!approve">Approve Contract</a></li>
		                        </ul>
		                    </li>
		                </ul>
		            </li>
		            
		        </ul>
		    </div>
		</nav>	
	</div>

<div ng-view></div>

</body>

</html>