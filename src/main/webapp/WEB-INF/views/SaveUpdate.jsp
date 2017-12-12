<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
	<title>Candidate Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body style="background-color:#D8D8D8">

	
<div class="container" style="margin:auto; margin-top:30px;">   
	<div style="float:left; width:200px; ">
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a>Candidate Home</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="myJobs" method="post">
                 <input type="Submit" value="My Applied Jobs" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="myUpdate" method="post">
                 <input type="Submit" value="Update Profile" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="Logout" method="get">
                 <input type="Submit" value="Logout"/>
            </form:form>
		</ul>
	</div>

<h2>Profile Updated Successfully</h2>
	
</body>
</html>