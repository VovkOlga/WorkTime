<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>New User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/font-awesome.min.css" />
	<!-- Latest compiled and minified JavaScript -->

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 
 <script src="${pageContext.request.contextPath}/js/bootstrap-filestyle.js"></script>
<style>
@font-face {
	font-family: 'FontAwesome';
	src:
		url('${pageContext.request.contextPath}/fonts/fontawesome-webfont.eot?v=4.1.0');
	src:
		url('${pageContext.request.contextPath}/fonts/fontawesome-webfont.eot?#iefix&v=4.1.0')
		format('embedded-opentype'),
		url('${pageContext.request.contextPath}/fonts/fontawesome-webfont.woff?v=4.1.0')
		format('woff'),
		url('${pageContext.request.contextPath}/fonts/fontawesome-webfont.ttf?v=4.1.0')
		format('truetype'),
		url('${pageContext.request.contextPath}/fonts/fontawesome-webfont.svg?v=4.1.0#fontawesomeregular')
		format('svg');
	font-weight: normal;
	font-style: normal
}
</style>

</head>
<body>

	<div class="container">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h3>Work Time Registration Page</h3>
			</div>
		</div>
		<div class="row  pad-top">

			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Register Yourself </strong>
					</div>
					<div class="panel-body">
						<form role="form" action="/WorkTime/time/user_profile" enctype="multipart/form-data" method="post">
							<br />
							<c:if test="${not empty registerMap.errors}">
							
							<div class="alert alert-danger" role="alert">
							<label  class="control-label">${registerMap.errors}</label>
							</div>
							</c:if>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span> <input type="text"
									class="form-control" placeholder="Your Name" name="name" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span> <input type="text"
									class="form-control" placeholder="Your Surname" name="surname" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span> <input type="text"
									class="form-control" placeholder="Login" name="login" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon">@</span> <input type="text"
									class="form-control" placeholder="Your Email" name="email"/>
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control"
									placeholder="Enter Password" name="password"/>
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control"
									placeholder="Retype Password" name="re_password"/>
							</div>
							<div class="form-group input-group"><span class="input-group-addon"><i class="fa fa-users"></i></span>
							<select class="form-control" name="roleName">
							<c:forEach items="${registerMap.roles}" var="role">
  								<option value="${role.id}">${role.name}</option>
  							</c:forEach>
							</select>
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-camera"></i></span>
								<input type="file" class="filestyle" accept="image/*" data-buttonText="Photo File" name="photo"/>							
							</div>
							
	
							
							<input type="submit" class="btn btn-primary" value="Register Me">
						</form>
						<hr />

						<form class="form-inline" role="form"
							action="/WorkTime/time/index_main" method="post">
							<div class="form-group">
								<label for="butregister" class="control-label">Already
									Registered ? </label> <input type="submit" class="btn btn-link"
									value="Login here" id="butregister">

							</div>
						</form>
					</div>


				</div>

			</div>
		</div>


	</div>
	</div>

</body>
</html>