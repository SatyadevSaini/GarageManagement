<%@page import="java.util.HashMap"%>
<%
HashMap garageDetails=(HashMap)session.getAttribute("garageDetails");
if(garageDetails==null){
	session.setAttribute("msg", "sessionError");
	response.sendRedirect("GarageOwner.jsp");
}else{
%>
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
	%>
		<div class="alert alert-warning" role="alert">
		  <%=m %>
		</div>
	<%
	session.setAttribute("msg", null);
	}
	%>
    <nav class="navbar navbar-expand-sm bg-light sticky-top px-4">
        <a class="navbar-brand" href="GarageOwnerHome.jsp">
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
                    <a class="nav-link" href="GarageOwnerHome.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="GarageOwnerServices.jsp">Services</a>
                </li>
            </ul>
            <div>
                Welcome: <b> <%= garageDetails.get("name")%> </b>
                <a href="Logout">Logout</a>
            </div>
        </div>
    </nav>
    
    <section class="container p-2">
    
    	<% 
		String status=(String)garageDetails.get("status");
    	if(status.equalsIgnoreCase("pending")){
    		%>
    		<h3 class='bg-warning text-white p-2'> <%= status%> </h3>
    		<%
    	}else if(status.equalsIgnoreCase("rejected")){
    		%>
	    	<h3 class='bg-danger text-white p-2'> <%= status%> </h3>
    		<%
    	}else{
    		%>
	    	<h3 class='bg-success text-white p-2'> <%= status%> </h3>
	    	<hr/>
	    	
   			<form action="AddService" method="post" >
	            <div class="py-2">
	                <input name="service" class="form-control" type="text" placeholder="Your service" required />
	            </div>
	            <div class="py-2">
	            	<input type="hidden" name="email" value="<%= garageDetails.get("email")%>" />
	                <button class="btn btn-primary">Add Service</button>
	            </div>
	        </form>
    		<%
    	}
		%>
    	
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
<%} %>

