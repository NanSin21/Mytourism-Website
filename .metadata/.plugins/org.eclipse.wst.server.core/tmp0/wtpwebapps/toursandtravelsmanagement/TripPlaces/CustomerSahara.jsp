<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sahara Trip Package</title>
<!-- <meta charset="utf-8"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .navbar{
  margin-nottom= 50px;
  border-radius= 0;
  }
  .jumbotron{
   margin-bottom= 0;
   }
   footer{
   background: green;
   padding: 25px;
   }
   </style>
</head>
<body>

<div class="jumbotron" style="background-image: url('data:image/jpeg;base64,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'); color: black;">
  <div class="container text-center">
   <h2>Special Offers for Sahara Trip</h2>
     <p>Holiday plans, exciting budgets and delicious meals</p>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>  
        </button>
        <h1><a class="navbar-brand" href="CustomerHome.jsp">Trip Planner</a></h1>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="TripPlaces/CustomerLondon.jsp">Home</a></li>
       <!--  <li><a href="registration.jsp">Register</a></li>
        <li><a href="login.jsp">Login</a></li> -->
        <li><a href="contact.jsp">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="profile.jsp"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
       <!--  <li><a href="budget.html">Budget Details</a></li> -->
      <!--   <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li> -->
      </ul>
    </div>
  </div>
</nav>
   
   
   <div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">GOLDEN DEAL</div>
        <div class="panel-body"><img src="images/ban_img2.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Get free breakfast and a gift card.</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading">BIG COMBO OFFER</div>
        <div class="panel-body"><img src="images/ban_img1.jpg" class="img-responsive" style="width:95%" alt="Image"></div>
        <div class="panel-footer">Book for minimum two families and get a free ride to tourist places.</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading">BONANZA FRIDAY DEAL</div>
        <div class="panel-body"><img src="images/ban_img3.jpg" class="img-responsive" style="width:95%" alt="Image"></div>
        <div class="panel-footer">Book a hotel on Friday and get free dinner for one night.</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">BUSINESS TOUR</div>
        <div class="panel-body"><img src="images/londonhelp.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Tie up your company and beneficial offers for next tour from your company.</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading">LUXURIOUS HOTEL OFFER</div>
        <div class="panel-body"><img src="images/2.jpg" class="img-responsive" style="width:80%" alt="Image"></div>
        <div class="panel-footer">Book a high rated hotel for minimum 4 days and 3 nights and get luxuries suites and delicious food to savor.</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading">WEDDING SEASON SPECIAL</div>
        <div class="panel-body"><img src="images/page4_img2.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Book for your wedding and enjoy our experienced hospitality</div>
      </div>
    </div>
  </div>
</div><br><br>

<footer class="container-fluid text-center">
  <p>Trip Planner Copyright</p>  
 <!--  <form action="LoginServlet" method="post" class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" name="email" placeholder="Email Address">
     <input type="password" placeholder="Enter Password" name="password" required>
    <button type="submit" class="btn btn-danger">Sign Up</button>
  </form> -->
</footer>
</body>
</html>