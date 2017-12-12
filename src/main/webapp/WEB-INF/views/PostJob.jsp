<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
			<li class="active"><a>Post Job Opening</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="DeleteJobPosted" method="post">
                 <input type="Submit" value="Delete Posted Job" class="btn btn-default btn-block" />
            </form:form>
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
	
    <div class="center-block" style="float:left">
         <h1 id="h1" style="margin-top:-20px">Post a New Job</h1>
	
	<form:form action="JobPosting" method="post" commandName="job" style="margin-left:30px;width:320px">
		  <div class="form-group">
				<label for="exampleInputEmail1">Job Title</label>
				<div class="row"><div class="col-md-12">
				<form:input type="text" path="title" class="form-control" id="textbox" required="true"/></div></div>
		  </div>
		  
		  <div class="form-group">
				<label for="exampleInputEmail1">Job Description</label>
				<div class="row"><div class="col-sm-12">
				<form:textarea path="description" class="form-control" rows="5" id="textbox" required="true"></form:textarea></div></div>
		  </div>
		  
		  <div class="form-group">
				<label for="exampleInputEmail1">Job Requirement</label>
				<div class="row"><div class="col-sm-12">
				<form:textarea path="requirement" class="form-control" rows="5" id="textbox" required="true"></form:textarea></div></div>
		  </div>
		  
		  <input type="submit" value="Submit" class="btn btn-success btn-lg" style="font-weight:bold"/>
	</form:form>
	<br/><br/><br/><br/>
	</div>
</div>
    </body>
</html>