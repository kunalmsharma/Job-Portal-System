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

	<h2 id="h1">Job Applications</h2><br/>
			
	<table class="table table-hover table-bordered">
			
		<tr>
			<td>Applicant First Name</td>
			<td>Applicant Last Name</td>
			<td>Mobile</td>
			<td>Qualification</td>
			<td>Work Experience</td>
		</tr>
	<c:forEach var="job_Seeker" items="${job_SeekerList}">
	
		<tr>
		<td>${job_Seeker.firstname}</td>
			<td>${job_Seeker.lastname}</td>
			<td>${job_Seeker.phoneno}</td>
			<td>${job_Seeker.qualification}</td>
			<td>${job_Seeker.workexperience}</td>
				
		</tr>
  	</c:forEach>
	</table>
	
	<form:form action="HomePage" method="post">
          <input type="Submit" value="Go Back" class="btn btn-primary" style="margin-left: 15px;"/>
    </form:form>

</div>	
</body>
</html>