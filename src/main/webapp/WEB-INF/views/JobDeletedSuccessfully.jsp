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
                 <input type="Submit" value="HR Home" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="CreateOpening" method="post">
                 <input type="Submit" value="Post Job Opening" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a style="color: black"><a>Delete Posted Job</a></li>
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
	
	<h1>Job Deleted Successfully!</h1>
 
</div>
    </body>
</html>