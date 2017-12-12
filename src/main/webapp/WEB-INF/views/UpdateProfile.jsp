<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Job Applicants</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body style="background-color:#D8D8D8">
	
	<div class="container" style="margin:auto; margin-top:50px;"> 

	<h2>My Profile</h2>
	
		<div style="float:left; width:200px; ">
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="SeekerHomePage" method="post">
                 <input type="Submit" value="Candidate Home" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="myJobs" method="post">
                 <input type="Submit" value="My Applied Jobs"  class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a style="color: black">Update Profile</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="Logout" method="get">
                 <input type="Submit" value="Logout"  class="btn btn-default btn-block" />
            </form:form>
		</ul>
	</div>
		<form:form action="SaveUpdate" method="post">	
	<table class="table table-hover table-bordered">
	
		<tr>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Phone No</b></td>
			<td><b>Qualification</b></td>
			<td><b>Work Experience</b></td>
		</tr>
		<tr>
			<td><input name ="firstname" type="text" value="${jobseeker.firstname}"/></td>
			<td><input name ="lastname" type="text" value="${jobseeker.lastname}"/></td>
			<td><input name ="phoneno" type="text" value="${jobseeker.phoneno}"/></td>
			<td><input name ="qualification" type="text" value="${jobseeker.qualification}"/></td>
			<td><input name ="workexperience" type="text" value="${jobseeker.workexperience}"/></td>
		</tr>

	</table>
	
	
          <input type="Submit" value="Save" class="btn btn-primary" style="margin-left: 15px;"/>
    </form:form>

</div>	
</body>
</html>