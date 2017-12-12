<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>My Applied Jobs</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body style="background-color:#D8D8D8">
	
	<div class="container" style="margin:auto; margin-top:50px;">   
	<div style="float:left; width:200px; ">

		<ul class="nav nav-pills nav-justified">
			<form action="SeekerHomePage" method="post">
                 <input type="Submit" value="Candidate Home" class="btn btn-default btn-block" />
            </form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a style="color: black">My Applied Jobs</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="myUpdate" method="post">
                 <input type="Submit" value="Update Profile" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="Logout" method="get">
                 <input type="Submit" value="Logout" class="btn btn-default btn-block" />
            </form:form>
		</ul>
	</div>


	
	<div style="float:left; margin-left:30px; ">
		<h1 >Jobs you have applied :</h1>
	
		<table class="table table-hover table-bordered">
				
			<tr>
				<td>Job ID</td>
				<td>Job Title</td>
				<td>Company Name</td>
			</tr>
		<c:forEach var="jobApplication" items="${myJobApplicationsList}">
			<tr>
				<td>${jobApplication.jobpost.jobpostid}</td>
				<td>${jobApplication.jobpost.title}</td>
				<td>${jobApplication.jobpost.manager.company.companyName}</td>
			</tr>
	  	</c:forEach>
		</table>
		<br/><br/><br/><br/>	
	</div>
	
	</div>

</body>
</html>