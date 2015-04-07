<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log IN</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/main.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="position: relative; top: 40%; ">
<form class="form-horizontal" role="form"  action="/WorkTime/time/index_action" method="post">
							<c:if test="${not empty errors}">
							<div class="form-group">
							<div class="alert alert-danger" role="alert">
							<label  class="control-label">${errors}</label>
							</div>
							</div>
							</c:if>
   <div class="form-group">
      <label for="login" class="col-md-5 control-label">Login:</label>
      <div class="col-md-3" >
         <input type="text" class="form-control"  id="login" 
            placeholder="Enter Login" name="login">
      </div>
   </div>
   <div class="form-group">
      <label for="password" class="col-md-5 control-label">Password:</label>
      <div class="col-md-3">
         <input type="text"  id="password" class="form-control"
            placeholder="Enter Password" name="password">
      </div>
   </div>
   <div class="form-group">
      <div class="col-md-offset-5 col-md-5">
         <div class="checkbox">
            <label>
               <input type="checkbox" name="remember"> Remember me
            </label>
         </div>
      </div>
   </div>
   <div class="form-group">
   <div class="col-md-offset-5 col-md-5">
   <div class="col-md-3">
	
        <input type="submit" class="btn btn-primary" name="signIn" value="Sign In">
   </div>
    
    
        <input type="submit" class="btn btn-primary" name="register" value="Register">
    </div>
   
</div>
</div>

 </form>
  

</body>
</html>