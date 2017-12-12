<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Post New Job</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
	
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body style="background-color:#D8D8D8">
	<div class="container" style="margin:auto; margin-top:50px;"> 
	
	<div style="float:left; width:200px; margin-top:20px">
		<ul class="nav nav-pills nav-justified">
			<form:form action="HomePage" method="post">
                 <input type="Submit" value="Manager Home" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="CreateOpening" method="post">
                 <input type="Submit" value="Post Job Opening" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a>Delete Posted Job</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="ViewApplicants" method="post">
                 <input type="Submit" value="View Applications" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="Logout" method="get">
                 <input type="Submit" value="Logout" class="btn btn-default btn-block" />
            </form:form>
		</ul>
	</div>
	
	<div style="float:left; margin-left:30px; ">
	
		<h1 id="h1" style="margin-top: -20px; margin-bottom: -5px">All Posted Jobs :</h1>
		
		<table class="table table-hover table-bordered">
			
		<tr>
			<td><b>Job ID</b></td>
			<td><b>Job Title</b></td>
			<td><b>Company Name</b></td>
			</tr>
		
			<c:forEach var="job" items="${jobList}">
				<tr >
					<td>${job.jobpostid}</td>
					<td>${job.title}</td>
					<td>${job.manager.company.companyName}</td>
					<td  style="border: none;">
						<form:form action="delete" method="post">
		                 	<input type="Submit" value="Delete" class="btn btn-default" />
		                 	<input type="hidden" value="${job.jobpostid}" name="delete" />
	            		</form:form>
					</td>
				</tr>
		  	</c:forEach>
	  	
		</table>
	</div>
	
 
</div>
    </body>
</html>