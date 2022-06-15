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

	<%-- Getting the value from the Session ... --%>
	
	<%
	String m=(String)session.getAttribute("msg");
	if(m!=null){
	%>
		<div class="alert alert-success" role="alert">
		  <%=m %>
		</div>
		
	<%
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
    <header>
        <div  data-aos="fade-right" data-aos-duration="1000" >
            <h3>
                Best Service. Best Products.
                <br />
                Be Happy & Be Safe.
            </h3>
            <p>
                <i class="fas fa-check-circle"></i> VERY LOW COST PRICE AVAILABLE.
                <br />
                <i class="fas fa-check-circle"></i> GET LOW PRICE FOR PRODUCTS AND SERVICES.
            </p>
        </div>
        <form action="AddEnquiry" method="post"  class="row"  data-aos="fade-left" data-aos-duration="1000">
            <div class="col-md-3 py-1">
                <input name="Name" class="form-control" type="text" pattern="[a-zA-Z ]+" placeholder="Your Name" maxlength="50"
                    required />
            </div>
            <div class="col-md-3 py-1">
                <input name="Phone" class="form-control" type="tel" pattern="[0-9]+" placeholder="Your Phone" maxlength="10"
                    minlength="10" required />
            </div>
            <div class="col-md-3 py-1">
                <input name="Email" class="form-control" type="email" placeholder="Your Email" maxlength="80" required />
            </div>
            <div class="col-md-3 py-1">
                <button class="btn btn-success">Request CallBack</button>
            </div>
        </form>
    </header>
    <section id="cards" class="container">
        <div class="row">
            <div class="col-md c-card">
                <div class="card">
                    <h5>Feature 1</h5>
                    <p>This is a feature</p>
                </div>
            </div>
            <div class="col-md c-card">
                <div class="card">
                    <h5>Feature 2</h5>
                    <p>This is a feature</p>
                </div>
            </div>
            <div class="col-md c-card">
                <div class="card">
                    <h5>Feature 3</h5>
                    <p>This is a feature</p>
                </div>
            </div>
        </div>
    </section>
    <section class="mt-2 p-4 bg-light">
        <div class="row align-items-center">
            <div class="col-md">
                <img class="img-fluid" src="resource/garage.jpg" alt="" />
            </div>
            <div class="col-md">
                <h5>PAY LESS & GET MORE</h5>
                <p>Very low payment option available. Very low payment option available Very low payment option
                    available Very low payment option available Very low payment option available. Very low payment
                    option available. </p>
                 <p>Very low payment option available Very low payment option available Very low
                    payment option available Very low payment option available</p>
                
            </div>
        </div>
    </section>
    <section>
        <div id="carouselExample" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExample" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExample" data-slide-to="1"></li>
                <li data-target="#carouselExample" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="resource/slide1.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>First slide label</h5>
                        <p>Some representative placeholder content for the first slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="resource/slide2.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Second slide label</h5>
                        <p>Some representative placeholder content for the second slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="resource/slide3.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Third slide label</h5>
                        <p>Some representative placeholder content for the third slide.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExample" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
                <!-- <i class="fas fa-arrow-left text-danger"></i> -->
            </a>
            <a class="carousel-control-next" href="#carouselExample" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>
    </section>
    <section class="c-staff">
        <div class="row">
            <div class="col-sm p-2" data-aos="fade-up" data-aos-delay="100" data-aos-duration="1000">
                <img src="resource/person1.jpg" alt="">
                <h5>Kamlesh Kapoor</h5>
                <p>r grgrekgk rrkejkkgkjrejkg rehbg</p>
            </div>
            <div class="col-sm p-2" data-aos="fade-up" data-aos-delay="400" data-aos-duration="1000">
                <img src="resource/person2.jpg" alt="">
                <h5>Kamlesh Kapoor</h5>
                <p>r grgrekgk rrkejkkgkjrejkg rehbg</p>
            </div>
            <div class="col-sm p-2" data-aos="fade-up" data-aos-delay="800" data-aos-duration="1000">
                <img src="resource/person3.jpg" alt="">
                <h5>Kamlesh Kapoor</h5>
                <p>r grgrekgk rrkejkkgkjrejkg rehbg</p>
            </div>
        </div>
    </section>
    <section class="c-gallery text-center my-1 ">
        <a href="resource/garage1.jpg"  data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage1.jpg" alt="" />
        </a>
        <a href="resource/garage2.jpg" data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage2.jpg" alt="" />
        </a>
        <a href="resource/garage3.jpg" data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage3.jpg" alt="" />
        </a>
        <a href="resource/garage4.jpg" data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage4.jpg" alt="" />
        </a>
        <a href="resource/garage5.jpg" data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage5.jpg" alt="" />
        </a>
        <a href="resource/garage1.jpg" data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage1.jpg" alt="" />
        </a>
        <a href="resource/garage2.jpg" data-toggle="lightbox" data-gallery="example-gallery">
            <img src="resource/garage2.jpg" alt="" />
        </a>
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

