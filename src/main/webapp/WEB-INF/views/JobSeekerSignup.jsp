<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html>
<head>
    <title>Job Seeker Sign Up</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<style>
.test{
float = right;
}
</style>
<body style="background-color:#D8D8D8">

    <div class="container" style="margin:auto">    	
      
         <h1 id="h1">Job Seeker SignUp</h1>
          <form:form name="registration-form" action="RegisterUser" method="post" class="registration-form" commandName="jobseeker">
            
            
            <h3>Create Login</h3>
			
			<div class="form-group">
				<label for="Email" class="col-sm-2 control-label">Email</label>
					<div class="row"><div class="col-md-4">
					<form:input path="users.emailid" type="text" id="textbox" class="form-control" placeholder="Email@email.com"/>
					<font color="red"><form:errors path="users.emailid"></form:errors></font></div></div>
			</div>
			
			  <div class="form-group">
				<label for="Password" class="col-sm-2 control-label">Password</label>
				  <div class="row"><div class="col-md-4">
				  <form:input path="users.password" type="password" id="textbox" class="form-control" placeholder="Password"/>
				  <font color="red"><form:errors path="users.password"></form:errors></font></div></div>
			  </div>
			  
			<h3>Personal Information</h3>
				
			<div class="form-group">
				<label  class="col-sm-2 control-label">First Name</label>
					<div class="row"><div class="col-md-4">
					<form:input path="firstname" type="text" id="textbox" class="form-control" placeholder="First Name"/><font color="red"><form:errors path="firstname"></form:errors></font></div></div>
										
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Last Name</label>
					<div class="row"><div class="col-md-4">
					<form:input path="lastname" type="text" id="textbox" class="form-control" placeholder="Last Name"/>
					<font color="red"><form:errors path="lastname"></form:errors></font></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Mobile</label>
					<div class="row"><div class="col-md-4">
					<form:input path="phoneno" type="number" id="textbox" class="form-control"/><font color="red"><form:errors path="phoneno">
					</form:errors></font></div></div>
			</div>
						
			<div class="form-group">
				<label class="col-sm-2 control-label">Street</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.street" type="text" id="textbox" class="form-control" placeholder="street Name, Apt Number"/>
					<font color="red"><form:errors path="address.street"></form:errors></font></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">City</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.city" type="text" id="textbox" class="form-control" placeholder="city"/>
					<font color="red"><form:errors path="address.city"></form:errors></font></div></div>
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">State</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.state" type="text" id="textbox" class="form-control" placeholder="state"/>
					<font color="red"><form:errors path="address.state"></form:errors></font></div></div>
			</div>
            
            <div class="form-group">
				<label class="col-sm-2 control-label">Country</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.country" type="text" id="textbox" class="form-control" placeholder="country"/>
					<font color="red"><form:errors path="address.country"></form:errors></font></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Zip Code</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.zipcode" type="number" id="textbox" class="form-control" placeholder="e.g.02120"/>
					<font color="red"><form:errors path="address.zipcode"></form:errors></font></div></div>
			</div>
			
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Qualification</label>
					<div class="row"><div class="col-md-4">
						<form:input path="qualification" type="text" id="textbox" class="form-control" placeholder="e.g. Master of Science"/>
						<font color="red"><form:errors path="qualification"></form:errors></font>
					</div></div>
			</div>
            
            		
			<div class="form-group">
				<label class="col-sm-2 control-label">Work Experience</label>
					<div class="row"><div class="col-md-4">
					<form:input path="workexperience"  type="number" id="textbox" class="form-control" placeholder="in months"/>
					<font color="red"><form:errors path="workexperience"></form:errors></font>
					</div></div>
			</div>
 
			
			<input type="submit" value="Submit" class="btn btn-success btn-lg" style="font-weight:bold"/>
			
        </form:form>

     </div>
     
	
    </body>
</html>