<!DOCTYPE html>
<html>

<head>
    <title>GarageWorks</title>
    <link rel="icon" href="resource/autoworks-logo.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>

    <!-- fontawesome -->
    <link rel="stylesheet" href="resource/fontawesome/fontawesome.min.css">
    <script src="resource/fontawesome/fontawesome.min.js"></script>
    <!-- fontawesome END -->

    <!-- Lightbox CSS & Script -->
    <script src="resource/lightbox/ekko-lightbox.js"></script>
    <link rel="stylesheet" href="resource/lightbox/ekko-lightbox.css" />

    <!-- AOS CSS & Script -->
    <script src="resource/aos/aos.js"></script>
    <link rel="stylesheet" href="resource/aos/aos.css"/>

    <!-- custom css-->
    <link rel="stylesheet" href="resource/custom.css" />
    <!-- custom css END-->

    <meta name="author" content="Rahul Chauhan" />
    <meta name="description" content="This is a Auto Service website" />
    <meta name="keywords" content="best Auto Service comapny in noida" />
</head>

<body>
	
	<%
	String m=(String)session.getAttribute("msg");
	if(m!=null){
		if(m.equalsIgnoreCase("success")){
	%>
		<div class="alert alert-success" role="alert">
		  User Registered Successfully!
		</div>
	<%
		}else if(m.equalsIgnoreCase("failed")){
	%>
		<div class="alert alert-danger" role="alert">
		  User Email ID Already Exist!
		</div>
	<%		
		}else if(m.equalsIgnoreCase("invalid")){
			%>
			<div class="alert alert-danger" role="alert">
			  User Email ID or Password INVALID!
			</div>
		<%		
		}else if(m.equalsIgnoreCase("sessionError")){
			%>
			<div class="alert alert-danger" role="alert">
			  Please Login First!
			</div>
		<%		
			}
	session.setAttribute("msg", null);
	}
	%>

    <nav class="navbar navbar-expand-sm bg-light sticky-top px-4">
        <a class="navbar-brand" href="index.jsp">
            Garage<strong class="c-logo">Works</strong>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <i class="fas fa-bars"></i> Menu
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav ml-auto">
                <!-- <ul class="navbar-nav mr-auto"> -->
                <!-- <ul class="navbar-nav mx-auto"> -->
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="User.jsp">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Admin.jsp">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="GarageOwner.jsp">GarageOwner</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>
            <div>
                <a class="font-weight-bold" href="tel:1800-234-9999"> <i class="fas fa-phone-alt"></i>1800-234-9999</a>
            </div>
        </div>
    </nav>
    
    <section class="container">
    	<div class="row">
    		<div class="col-sm p-3 my-4 border">
    			<h3>User Sign IN</h3>
    			<hr/>
    			<form action="UserLogin" method="post" >
		            <div class="py-2">
		                <input name="email" class="form-control" type="email" placeholder="Your Email" maxlength="80" required />
		            </div>
		            <div class="py-2">
		                <input name="password" class="form-control" type="password" placeholder="Your Password" required />
		            </div>
		            <div class="py-2">
		                <button class="btn btn-success">Sign IN</button>
		            </div>
		        </form>
    		</div>
    		<div class="col-sm p-3 my-4 border">
    			<h3>User Sign UP</h3>
    			<hr/>
    			<form action="AddUser" method="post" enctype="multipart/form-data" >
		            <div class="py-2">
		                <input name="email" class="form-control" type="email" placeholder="Your Email" maxlength="80" required />
		            </div>
		            <div class="py-2">
		                <input name="name" class="form-control" type="text"  pattern="[a-zA-Z ]+" placeholder="Your Name" maxlength="80" required />
		            </div>
		            <div class="py-2">
		                <input name="phone" class="form-control" type="tel" pattern="[0-9]+" placeholder="Your Phone" maxlength="10" minlength="10" required />
		            </div>
		            <div class="py-2">
		                <input name="password" class="form-control" type="password" placeholder="Your Password" required />
		            </div>
		            <div class="py-2">
		                <input name="photo" class="form-control" type="file" accept=".jpg,.png" />
		            </div>
		            <div class="py-2">
		                <button class="btn btn-primary">Sign UP</button>
		            </div>
		        </form>
    		</div>
    	</div>
    </section>
    
    <footer>
            Design & Develop by Satyadev</a> &nbsp;&nbsp;&nbsp; 
            Social Media:
            <a href="https://www.facebook.com/profile.php?id=100081599204400" target="_blank" ><i class="fab fa-facebook"></i></a>
            <a href="https://www.instagram.com/satyadev_dharwal/" target="_blank" ><i class="fab fa-instagram"></i></a>
            
    </footer>

    <a id="myTopBtn"><i class="fas fa-arrow-circle-up"></i></a>
</body>
<script>
    AOS.init();
</script>

<script>
    //script for light box
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
          event.preventDefault();
          $(this).ekkoLightbox();
      });
  </script>

<script>
    //script for scroll to top
    $("#myTopBtn").click(function () {
        $("html, body").animate({scrollTop: 0}, 1000);
      });
  </script>


</html>

