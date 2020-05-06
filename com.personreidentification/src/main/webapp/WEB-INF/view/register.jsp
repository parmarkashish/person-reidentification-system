<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register Page</title>
    <link rel="apple-touch-icon" sizes="57x57" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="<%=request.getContextPath() %>/clientResources/image/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="<%=request.getContextPath() %>/clientResources/image/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath() %>/clientResources/image/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=request.getContextPath() %>/clientResources/image/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/clientResources/image/favicon-16x16.png">
    <link rel="manifest" href="<%=request.getContextPath() %>/clientResources/image/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/clientResources/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/clientResources/css/responsive.css">
</head>
<body>
<div class="preloader"></div><!-- /.preloader -->
    <div class="page-wrapper">
        <header class="main-header header-style-one">
            <div class="top-header">
                <div class="container">
                    <div class="left-info">
                        <p><i class="cameron-icon-email"></i><a href="#">Person Re-identification For Video Surveillance</a></p>
                    </div><!-- /.left-info -->
                    <div class="right-info">
                        <ul class="info-block">
                            <li><i class="cameron-icon-support"></i><a href="#"></a></li>
                            <!-- <li><a href="cart.html" class="cart-btn"><i class="cameron-icon-shopping-bag"></i><span class="count-text">(0)</span></a></li> -->
                        </ul>
                    </div><!-- /.right-info -->
                </div><!-- /.container -->
            </div><!-- /.top-header -->
            <nav class="navbar navbar-expand-lg navbar-light header-navigation stricky">
                <div class="container clearfix">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="logo-box clearfix">
                        <a class="navbar-brand" href="index.html">
                            <img src="<%=request.getContextPath() %>/clientResources/image/logo-1-1.png" class="main-logo" alt="Awesome Image" />
                            <img src="<%=request.getContextPath() %>/clientResources/image/logo-1-2.png" class="stricky-logo" alt="Awesome Image" />
                        </a>
                        <button class="menu-toggler" data-target=".header-style-one .main-navigation">
                            <span class="fa fa-bars"></span>
                        </button>
                    </div><!-- /.logo-box -->
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="main-navigation">
                        <ul class=" navigation-box">
                            <!-- <li>
                                <a href="/loadRegister">Home</a>
                            </li>
                            
                            <li>
                                <a href="/loadRegister">Services</a>
                            </li>
                            <li>
                                <a href="/loadRegister">Pages</a>
                            </li>
                            <li>
                                <a href="/loadRegister">Shop</a>
                            </li> -->
                            <li>
                                <a href="/loadRegister">About</a>
                            </li>
                            <li class="current">
                                <a href="/loadRegister">Register</a>
                            </li>
                            <li><a href="/login">Login</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                    
                </div>
                <!-- /.container -->
            </nav>
        </header><!-- /.main-header header-style-one -->
        <!--<section class="page-title-block text-center">
            <div class="container">
                <h2>Register</h2>
                <div class="thm-breadcrumb">
                    <a href="index.html">Home</a>
                    <span class="sep">/</span>
                    <span class="page-title">Register</span>
                </div>
            </div>
        </section>-->
        <section class="contact-form-wrapper">
            <div class="container">
                
                    <div class="row no-gutters justify-content-center d-flex">
                        
                        <div class="col-lg-6 d-flex">
                            <div class="contact-form-block my-auto">
                                <div class="title-block">
                                   <span class="tag-line"></span><!-- /.tag-line -->
                                    <h2>Register</h2>
                                </div><!-- /.title-block -->
                                <f:form action="/addClient" method="post" modelAttribute="registerVO" class="contact-form-one" name="register" onSubmit="return validateregister();">
                                    
                                    <f:input path="ownerName" name="ownerName" placeholder="Your name"></f:input>
                                    <span class="error"><p id="ownerNameError"></p></span>
									
                                    <f:input path="email" name="email" placeholder="Your email"></f:input>
                                    <span class="error"><p id="emailError"></p></span>
                                    
                                    <f:input path="ownerContactNumber" name="ownerContactNumber" placeholder="Your contact number"></f:input>
									<span class="error"><p id="ownerContactNumberError"></p></span>
									<f:input path="premisesAddress" name="premisesAddress" placeholder="Your address"></f:input>
									<span class="error"><p id="premisesAddressError"></p></span>
								
									<f:select path="countryVO.id" name="country" onchange="fncountry()" id="country">
										<option selected disabled>Choose country</option>
              							<c:forEach items="${countryList}" var="country" >
											<f:option value="${country.id}" >${country.countryName}</f:option>
										</c:forEach>
              						</f:select>
              						
									<f:select path="stateVO.id" name="state" id="state" onchange="fnstate()">
									<option selected disabled>Choose state</option>
										<%-- <c:forEach items="${stateList}" var="state" >
											<f:option value="${state.id}">${state.stateName}</f:option>
										</c:forEach> --%>
									</f:select>	
									<f:select path="cityVO.id" name="city" id="city">
										<option selected disabled>Choose city</option>
										<%-- <c:forEach items="${cityList}" var="city" >
											<f:option value="${city.id}">${city.cityName}</f:option>
										</c:forEach> --%>
									</f:select>	
									<center>
                                    <input type="submit" value="Submit Now" style="width:200px;"></center>
                                </f:form>
                            </div><!-- /.contact-form-block --> 
                        </div><!-- /.col-lg-6 -->
                    </div><!-- /.row -->
                
            </div><!-- /.container -->
        </section><!-- /.contact-form-wrapper -->
        
    </div><!-- /.page-wrapper -->
    <a href="#" data-target="html" class="scroll-to-target scroll-to-top"><i class="fa fa-angle-up"></i></a>
    <!-- /.scroll-to-top -->
    <script src="<%=request.getContextPath() %>/clientResources/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/waypoints.min.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/jquery.counterup.min.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/wow.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/theme.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/formvalidation.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBk25E4mNfVIEt3tNl3K1HwNZVruVoFBlA"></script>
    <!-- google map helper -->
    <script src="<%=request.getContextPath() %>/clientResources/js/gmaps.js"></script>
    <script src="<%=request.getContextPath() %>/clientResources/js/map-helper.js"></script>
    
    <script>
    
    function fncountry() {
		var x = document.getElementById("country");
		var y = document.getElementById("state");

		var htp = new XMLHttpRequest();
		htp.onreadystatechange = function() {
			if (htp.readyState == 4) {
				y.innerHTML = "";
				var op = JSON.parse(htp.responseText);
				for (var i = 0; i < op.length; i++) {
					var o = document.createElement("option");
					o.text = op[i].stateName;
					o.value = op[i].id;

					y.options.add(o);
				}
				fnstate();

			}

		}
		htp.open("get", "/admin/listState?id=" + x.value, true);
		htp.send();
	}
    
    function fnstate() {
		var y = document.getElementById("state");
		var z = document.getElementById("city");

		var htp = new XMLHttpRequest();
		htp.onreadystatechange = function() {
			if (htp.readyState == 4) {
				z.innerHTML = "";
				var op = JSON.parse(htp.responseText);
				for (var i = 0; i < op.length; i++) {
					var o = document.createElement("option");
					o.text = op[i].cityName;
					o.value = op[i].id;

					z.options.add(o);
				}

			}

		}
		htp.open("get", "/admin/listCity?id=" + y.value, true);
		htp.send();
	}
    </script>
</body>
</html>