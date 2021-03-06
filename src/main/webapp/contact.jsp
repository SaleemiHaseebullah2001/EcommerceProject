<%--
  Created by IntelliJ IDEA.
  User: mehar
  Date: 05/01/2022
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Checkout Page - CellsHouse Demo</title>

  <!-- Google Fonts -->
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

  <!-- Bootstrap -->
  <link rel="stylesheet" href="css/bootstrap.min.css">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/font-awesome.min.css">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="css/owl.carousel.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/responsive.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

<div class="header-area">
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div class="user-menu">
          <ul>
            <li><a href="profile.jsp"><i class="fa fa-user"></i> My Account</a></li>
            <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
            <li><a href="cart.jsp"><i class="fa fa-user"></i> My Cart</a></li>
            <li><a href="checkout.jsp"><i class="fa fa-user"></i> Checkout</a></li>
            <li><a href="login.jsp"><i class="fa fa-user"></i> Login</a></li>
          </ul>
        </div>
      </div>

      <div class="col-md-4">
        <div class="header-right">
          <ul class="list-unstyled list-inline">
            <li class="dropdown dropdown-small">
              <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">USD</a></li>
                <li><a href="#">INR</a></li>
                <li><a href="#">GBP</a></li>
              </ul>
            </li>

            <li class="dropdown dropdown-small">
              <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">English</a></li>
                <li><a href="#">French</a></li>
                <li><a href="#">German</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div> <!-- End header area -->

<div class="site-branding-area">
  <div class="container">
    <div class="row">
      <div class="col-sm-6">
        <div class="logo">
          <h1><a href="index.jsp"><img src="img/Cells_House_LogoWeb.png" alt=""></a></h1>
        </div>
      </div>

      <div class="col-sm-6">
        <div class="shopping-item">
          <a href="cart.jsp">Cart - <span class="cart-amunt">$100</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
        </div>
      </div>
    </div>
  </div>
</div> <!-- End site branding area -->

<div class="mainmenu-area">
  <div class="container">
    <div class="row">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="index.jsp">Home</a></li>
          <li><a href="<%=request.getContextPath()%>/shop">Shop page</a></li>

          <li><a href="cart.jsp">Cart</a></li>
          <li><a href="checkout.jsp">Checkout</a></li>
          <li><a href="#">Category</a></li>
          <li class="active"><a href="contact.jsp">Contact</a></li>
        </ul>
      </div>
    </div>
  </div>
</div> <!-- End mainmenu area -->

<div class="product-big-title-area">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="product-bit-title text-center">
          <h2>Contact</h2>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="single-product-area">
  <div class="zigzag-bottom"></div>
  <div class="container">
    <div class="row">
      <div class="col-md-4">

        <!-- Contact form area -->
      <div class="col-md-8">
        <div class="product-content-right">
          <div class="woocommerce">

            <form id="login-form-wrap" method="post">


              <p>We'll reply you as soon as possible.</p>

              <p class="form-row form-row-first">
                <label for="email">email <span class="required">*</span>
                </label>
                <input type="text" id="email" name="email" class="input-text">
              </p>
              <p class="form-row form-row-second">
                <label for="name">Full name <span class="required">*</span>
                </label>
                <input type="text" id="name" name="name" class="input-text">
              </p>
              <p class="form-row form-row-third">
                <label for="subject">Subject <span class="required">*</span>
                </label>
                <input type="text" id="subject" name="subject" class="input-text">
              </p>
              <p class="form-row form-row-fourth">
                <label for="message">Message <span class="required">*</span>
                </label>
                <textarea id="message" name="message" class="input-text" style="height: 200px; width: 300px"></textarea>
              </p>
              <div class="clear"></div>


              <p class="form-row">
                <input type="submit" value="Send" name="send" class="button">
              </p>

              <div class="clear"></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="footer-top-area">
  <div class="zigzag-bottom"></div>
  <div class="container">
    <div class="row">
      <div class="col-md-3 col-sm-6">
        <div class="footer-about-us">
          <h2>cells<span>House</span></h2>
          <p>We have the best service and prices in the world</p>
          <div class="footer-social">
            <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
            <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
            <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
            <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
          </div>
        </div>
      </div>

      <div class="col-md-3 col-sm-6">
        <div class="footer-menu">
          <h2 class="footer-wid-title">User Navigation </h2>
          <ul>
            <li><a href="">My account</a></li>
            <li><a href="">Order history</a></li>
            <li><a href="">Wishlist</a></li>
            <li><a href="">Vendor contact</a></li>
            <li><a href="">Front page</a></li>
          </ul>
        </div>
      </div>

      <div class="col-md-3 col-sm-6">
        <div class="footer-menu">
          <h2 class="footer-wid-title">Categories</h2>
          <ul>
            <li><a href="">Mobile Phone</a></li>
            <li><a href="">Home accesseries</a></li>
            <li><a href="">LED TV</a></li>
            <li><a href="">Computer</a></li>
            <li><a href="">Gadets</a></li>
          </ul>
        </div>
      </div>

      <div class="col-md-3 col-sm-6">
        <div class="footer-newsletter">
          <h2 class="footer-wid-title">Newsletter</h2>
          <p>Sign up to our newsletter and get exclusive deals you wont find anywhere else straight to your inbox!</p>
          <div class="newsletter-form">
            <input type="email" placeholder="Type your email">
            <input type="submit" value="Subscribe">
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="footer-bottom-area">
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div class="copyright">
          <p>&copy;CellsHouse. All Rights Reserved. <a href="" target="_blank"></a></p>
        </div>
      </div>

      <div class="col-md-4">
        <div class="footer-card-icon">
          <i class="fa fa-cc-discover"></i>
          <i class="fa fa-cc-mastercard"></i>
          <i class="fa fa-cc-paypal"></i>
          <i class="fa fa-cc-visa"></i>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>
</body>
</html>
