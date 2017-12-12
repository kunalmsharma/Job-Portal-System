<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Job Portal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  
  .second{
  float:right;
    width: 20%;
  }
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 80%;
      margin: auto;
  }

  .container{
  margin-top:20%;
      width: 60%;
      margin: auto;
  }
  
 
  </style>
</head>
<body style="background-color:#D8D8D8">
		
									
					<div class="content">
						
						
							<form action="JobSeekerRegistration" method="post">
								<input type="submit" value="Job Seeker Sign up" class="btn btn-success" style="float:left;margin-right:15px"/>
							</form>
							
							 <form action="ManagerLogin.htm" method="post">
								<input type="submit" value="Manager Sign up" class="btn btn-success" style="float:left;"/>
							</form>
						
					</div>
					
<div class="second">
  <h1>Sign In</h1>
				<form:form action="LoginSuccess" method="post" commandName="users">
					<div class="content">
						<form:input path="emailid"  type="text" class="form-control" id="input" placeholder="Email ID"/>
						<font color="red"><form:errors path="emailid"></form:errors></font><br/>
						<form:input path="password" type="password" class="form-control" id="input" placeholder="Password"/>
						<font color="red"><form:errors path="password"></form:errors></font><br/>
					</div>

					<div class="footer">
						<input type="submit" value="Login" class="btn btn-success btn-lg btn-block" style="font-weight:bold"/>
					</div>
				</form:form>
	</div>
	
	<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="${pageContext.request.contextPath}/resources/images/image.jpg" alt="job portal">
        <div class="carousel-caption">
        </div>
      </div>
  
	  <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/jobjob.jpg" alt="job portal" >
        <div class="carousel-caption">
        </div>
      </div>
	  
	  <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/job.jpg" alt="job portal" >
        <div class="carousel-caption">
        </div>
      </div>
  
    </div>
	

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  </div>
</body>
</html>