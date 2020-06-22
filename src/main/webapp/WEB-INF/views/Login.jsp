<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>Welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />

<script type="text/javascript" src="resources/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="resources/assets/js/bootstrap.min.js"></script>

<SCRIPT language=javascript>
function submitEnter(e) {
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else 
		if (e) keycode = e.which;
	else 
		return true;
	if (keycode == 13) {
		document.loginForm.submit();
		return false;
	} else {
		return true;
	}
	
	return true;
}

function loginButtonClicked() {
	document.loginForm.submit();
}


</SCRIPT>


<STYLE type=text/css>
@font-face { font-family: tatasky; src: url('styles/token/Sky_Reg.ttf'); }
.error {
	FONT-SIZE: 11px;
	COLOR: #ffffff;
	FONT-FAMILY: tatasky, Helvetica, sans-serif
}

.input-group {
	padding-top: 10px;
}

body {
	FONT-FAMILY: tatasky, Helvetica, sans-serif
}

#box {
	border: 1px solid rgb(200, 200, 200);
	box-shadow: rgba(0, 0, 0, 0.1) 0px 5px 5px 5px;
	/*  background: rgba(200, 200, 200, 0.1); */
/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#064497+0,e5007d+99 */
background: #064497; /* Old browsers */
background: -moz-linear-gradient(left, #064497 0%, #e5007d 99%); /* FF3.6-15 */
background: -webkit-linear-gradient(left, #064497 0%,#e5007d 99%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to right, #064497 0%,#e5007d 99%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#064497', endColorstr='#e5007d',GradientType=1 ); /* IE6-9 */
	border-radius: 4px;
	padding-bottom: 10px;
	
}

h2 {
	text-align: center;
	color: #fff;
}
</STYLE>
<META content="MSHTML 6.00.2900.3660" name=GENERATOR>
</HEAD>

<BODY>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
			<%-- <center>	
			<img alt=""
					src="<%=request.getContextPath() %>/images/tataskylogo.png"
					width="350px"></center> --%>
				

				<FORM name='loginForm' id="box" action='validateuser' method=POST>
					<h5 style="color: white;text-align: center;">Online Tariff Submit</h5>
					<fieldset>
						<!-- Form Name -->


						<!-- Text input-->

						<div class="row form-group">
                             
							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> 
										<input type="text" placeholder="User ID" class="form-control" required name="userId">
								</div>
							</div>
						</div>
						<!-- Text input-->
						<div class="row form-group">

							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> 
										<input type="password" placeholder="Password" required class="form-control" name="password">
								</div>
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col-md-12 text-center">
								<button type="submit" class="btn btn-md btn-primary" style="width: 90px"
									onclick="loginButtonClicked()">Login</button>
							</div>
						</div>
						
					</fieldset>
				</form>
			</div>
			<c:if test = "${not empty error}">
			 	<div class="col-md-6 col-md-offset-3" style="padding-top: 10px;">
					<div class="row ">
						<div class="alert-group">
							<div class="alert alert-success alert-dismissable">
								<button type="button" class="close" data-dismiss="alert">×</button>
								<c:choose>
									<c:when test = "${error=='user'}">
										<strong>Alert! </strong> Invalid UserID or password.
									</c:when>
									<c:when test = "${error=='attempts'}">
										<strong>Alert! </strong> You have exceeded the number of login attempts. Please contact administrator.
									</c:when>
									<c:when test = "${error=='inactive'}">
										<strong>Alert! </strong> Your user id is not active. Please contact administrator.
									</c:when>
									<c:when test = "${error=='password'}">
										<strong>Alert! </strong> Invalid Password. You are left with <c:out value="${count}"/>  more attempts.
									</c:when>
									<c:when test = "${error=='expired'}">
										<strong>Alert! </strong>Your password has expired.
										<a href="/Termcell/form/changepasswordnine">Click Here</a> to change the password
									</c:when>
									<c:when test = "${error=='captcha'}">
										<strong>Alert! </strong> Wrong Captcha.
									</c:when>
									<c:otherwise>
								      <br />
								    </c:otherwise>
								
								</c:choose>
							</div>
						</div>
					</div>
				</div>
	 		</c:if>
			
		</div>
	</div>
	 
	</BODY>
</div>
</html>