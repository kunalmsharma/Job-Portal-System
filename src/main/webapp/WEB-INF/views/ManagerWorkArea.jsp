<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
	<title>Manager Work Area</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
	
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body style="background-color:#D8D8D8">
	
<div class="container" style="margin:auto; margin-top:50px;">   
<h1>Welcome to your work area</h1>
	<div style="float:left; width:200px; ">
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a>Manager Home</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="CreateOpening" method="post">
                 <input type="Submit" value="Post Job Opening" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="ViewApplicants" method="post">
                 <input type="Submit" value="View Applications" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="DeleteJobPosted" method="post">
                 <input type="Submit" value="Delete Posted Job" class="btn btn-default btn-block" />
            </form:form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="Logout" method="get">
                 <input type="Submit" value="Logout" class="btn btn-default btn-block" />
            </form:form>
		</ul>
	</div>
	
	</div>
</body>
</html>