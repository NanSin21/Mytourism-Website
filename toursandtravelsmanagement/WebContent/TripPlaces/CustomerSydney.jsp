<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sydney Trip Package</title>
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
   <h2>Special Offers for Sydney Trip</h2>
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