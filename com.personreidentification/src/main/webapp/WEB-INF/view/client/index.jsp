<%@page import="com.personreidentification.utils.BaseMethod" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Twitter -->
    <meta name="twitter:site" content="@themepixels">
    <meta name="twitter:creator" content="@themepixels">
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:title" content="Amanda">
    <meta name="twitter:description" content="Premium Quality and Responsive UI for Dashboard.">
    <meta name="twitter:image" content="http://themepixels.me/amanda/img/amanda-social.png">

    <!-- Facebook -->
    <meta property="og:url" content="http://themepixels.me/amanda">
    <meta property="og:title" content="Bracket">
    <meta property="og:description" content="Premium Quality and Responsive UI for Dashboard.">

    <meta property="og:image" content="http://themepixels.me/amanda/img/amanda-social.png">
    <meta property="og:image:secure_url" content="http://themepixels.me/amanda/img/amanda-social.png">
    <meta property="og:image:type" content="image/png">
    <meta property="og:image:width" content="1200">
    <meta property="og:image:height" content="600">

    <!-- Meta -->
    <meta name="description" content="Premium Quality and Responsive UI for Dashboard.">
    <meta name="author" content="ThemePixels">


    <title>Client Index</title>

    <!-- vendor css -->
    <link href="<%=request.getContextPath() %>/adminResources/css/font-awesome.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/ionicons.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/perfect-scrollbar.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/toggles-full.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/rickshaw.min.css" rel="stylesheet">
	
	<link rel="icon" type="image/png" sizes="192x192" href="<%=request.getContextPath() %>/clientResources/image/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath() %>/clientResources/image/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=request.getContextPath() %>/clientResources/image/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/clientResources/image/favicon-16x16.png">
    <!-- Amanda CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/amanda.css">
    <%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/clientResources/css/style.css"> --%>
  </head>

  <body>

    
    
    <jsp:include page="header.jsp"></jsp:include>
    
    
    
    <!-- am-header -->

    <jsp:include page="menu.jsp"></jsp:include>
    <div class="am-mainpanel">
      <!-- <div class="am-pagetitle">
        <h5 class="am-title">Dashboard</h5>
        <form id="searchBar" class="search-bar" action="index.html">
          <div class="form-control-wrapper">
            <input type="search" class="form-control bd-0" placeholder="Search...">
          </div>form-control-wrapper
          <button id="searchBtn" class="btn btn-orange"><i class="fa fa-search"></i></button>
        </form>search-bar
      </div> --> <!-- am-pagetitle -->
     	<div class="am-pagebody">
        <div class="row row-sm">
          <div class="col-lg-4">
            <div class="card">
              <div id="rs1" class="wd-100p ht-200"></div>
              <div class="overlay-body pd-x-20 pd-t-20">
                <div class="d-flex justify-content-between">
                  <div>
                    <h6 class="tx-12 tx-uppercase tx-inverse tx-bold mg-b-5">Number of uploaded videos</h6>
                    <p class="tx-12"><%=BaseMethod.getDate()%></p>
                  </div>
                  <a href="" class="tx-gray-600 hover-info"><i class="icon ion-more tx-16 lh-0"></i></a>
                </div><!-- d-flex -->
                <h2 class="mg-b-5 tx-inverse tx-lato">${number}</h2>
                <p class="tx-12 mg-b-0"></p>
              </div>
            </div><!-- card -->
          </div><!-- col-4 -->
        </div><!-- row -->
       </div> <!-- am-pagebody -->      

    <%-- <jsp:include page="footer.jsp"> </jsp:include>  --%>
    </div><!-- am-mainpanel -->

    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/popper.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/perfect-scrollbar.jquery.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/toggles.min.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/d3.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/rickshaw.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?key=AIzaSyAEt_DBLTknLexNbTVwbXyq2HSf2UbRBU8"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/gmaps.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.flot.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.flot.pie.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.flot.resize.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.flot.spline.js"></script>

    <script src="<%=request.getContextPath() %>/adminResources/js/amanda.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/ResizeSensor.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/dashboard.js"></script>
  </body>
</html>
