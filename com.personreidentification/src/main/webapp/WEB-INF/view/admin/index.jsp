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
    
    <link rel="icon" type="image/png" sizes="192x192" href="<%=request.getContextPath() %>/clientResources/image/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath() %>/clientResources/image/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=request.getContextPath() %>/clientResources/image/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/clientResources/image/favicon-16x16.png">


    <title>Admin Index</title>

    <!-- vendor css -->
    <link href="<%=request.getContextPath() %>/adminResources/css/font-awesome.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/ionicons.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/perfect-scrollbar.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/toggles-full.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/rickshaw.min.css" rel="stylesheet">
	

    <!-- Amanda CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/amanda.css">
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
                    <h6 class="tx-12 tx-uppercase tx-inverse tx-bold mg-b-5">Total Number of uploaded videos</h6>
                    <p class="tx-12"><%=BaseMethod.getDate()%></p>
                  </div>
                  <a href="" class="tx-gray-600 hover-info"><i class="icon ion-more tx-16 lh-0"></i></a>
                </div><!-- d-flex -->
                <h2 class="mg-b-5 tx-inverse tx-lato">${number}</h2>
                <p class="tx-12 mg-b-0"></p>
              </div>
            </div><!-- card -->
          </div><!-- col-4 -->
          <div class="col-lg-4 mg-t-15 mg-sm-t-20 mg-lg-t-0">
            <div class="card">
              <div id="rs2" class="wd-100p ht-200"></div>
              <div class="overlay-body pd-x-20 pd-t-20">
                <div class="d-flex justify-content-between">
                  <div>
                    <h6 class="tx-12 tx-uppercase tx-inverse tx-bold mg-b-5">Total users</h6>
                    <p class="tx-12"><%=BaseMethod.getDate()%></p>
                  </div>
                  <a href="" class="tx-gray-600 hover-info"><i class="icon ion-more tx-16 lh-0"></i></a>
                </div><!-- d-flex -->
                <h2 class="mg-b-5 tx-inverse tx-lato">${users}</h2>
                <p class="tx-12 mg-b-0"></p>
              </div>
            </div><!-- card -->
          </div><!-- col-4 -->
          <!-- <div class="col-lg-4 mg-t-15 mg-sm-t-20 mg-lg-t-0">
            <div class="card">
              <div id="rs3" class="wd-100p ht-200"></div>
              <div class="overlay-body pd-x-20 pd-t-20">
                <div class="d-flex justify-content-between">
                  <div>
                    <h6 class="tx-12 tx-uppercase tx-inverse tx-bold mg-b-5">This Month's Earnings</h6>
                    <p class="tx-12">November 1 - 30, 2017</p>
                  </div>
                  <a href="" class="tx-gray-600 hover-info"><i class="icon ion-more tx-16 lh-0"></i></a>
                </div>d-flex
                <h2 class="mg-b-5 tx-inverse tx-lato">$72,118</h2>
                <p class="tx-12 mg-b-0">Earnings before taxes.</p>
              </div>
            </div>card
          </div>col-4 -->
        </div><!-- row -->

         <%-- <div class="row row-sm mg-t-15 mg-sm-t-20">
          <div class="col-md-6">
            <div class="card pd-20 pd-sm-40">
              <h6 class="card-body-title">Bar Chart</h6>
              <p class="mg-b-20 mg-sm-b-30">A bar chart or bar graph is a chart with rectangular bars with lengths proportional to the values that they represent.</p>
              <div id="f2" class="ht-200 ht-sm-300"></div>
            </div><!-- card -->
          </div><!-- col-6 -->
          <div class="col-md-6 mg-t-15 mg-sm-t-20 mg-md-t-0">
            <div class="card pd-20 pd-sm-40">
              <h6 class="card-body-title">Line Chart</h6>
              <p class="mg-b-20 mg-sm-b-30">The stacked charts are used when data sets have to be broken down into their constituents.</p>
              <div id="f1" class="ht-200 ht-sm-300"></div>
            </div><!-- card -->
          </div><!-- col-6 -->
        </div><!-- row -->

        <div class="row row-sm mg-t-15 mg-sm-t-20">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-header bg-transparent pd-20">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">User Transaction History</h6>
              </div><!-- card-header -->
              <div class="table-responsive">
                <table class="table table-white mg-b-0 tx-12">
                  <tbody>
                    <tr>
                      <td class="pd-l-20 tx-center">
                        <img src="<%=request.getContextPath() %>/adminResources/image/img1.jpg" class="wd-36 rounded-circle" alt="Image">
                      </td>
                      <td>
                        <a href="" class="tx-inverse tx-14 tx-medium d-block">Mark K. Peters</a>
                        <span class="tx-11 d-block">TRANSID: 1234567890</span>
                      </td>
                      <td class="tx-12">
                        <span class="square-8 bg-success mg-r-5 rounded-circle"></span> Email verified
                      </td>
                      <td>Just Now</td>
                    </tr>
                    <tr>
                      <td class="pd-l-20 tx-center">
                        <img src="<%=request.getContextPath() %>/adminResources/image/img2.jpg" class="wd-36 rounded-circle" alt="Image">
                      </td>
                      <td>
                        <a href="" class="tx-inverse tx-14 tx-medium d-block">Karmen F. Brown</a>
                        <span class="tx-11 d-block">TRANSID: 1234567890</span>
                      </td>
                      <td class="tx-12">
                        <span class="square-8 bg-warning mg-r-5 rounded-circle"></span> Pending verification
                      </td>
                      <td>Apr 21, 2017 8:34am</td>
                    </tr>
                    <tr>
                      <td class="pd-l-20 tx-center">
                        <img src="<%=request.getContextPath() %>/adminResources/image/img3.jpg" class="wd-36 rounded-circle" alt="Image">
                      </td>
                      <td>
                        <a href="" class="tx-inverse tx-14 tx-medium d-block">Gorgonio Magalpok</a>
                        <span class="tx-11 d-block">TRANSID: 1234567890</span>
                      </td>
                      <td class="tx-12">
                        <span class="square-8 bg-success mg-r-5 rounded-circle"></span> Purchased success
                      </td>
                      <td>Apr 10, 2017 4:40pm</td>
                    </tr>
                    <tr>
                      <td class="pd-l-20 tx-center">
                        <img src="<%=request.getContextPath() %>/adminResources/image/img5.jpg" class="wd-36 rounded-circle" alt="Image">
                      </td>
                      <td>
                        <a href="" class="tx-inverse tx-14 tx-medium d-block">Ariel T. Hall</a>
                        <span class="tx-11 d-block">TRANSID: 1234567890</span>
                      </td>
                      <td class="tx-12">
                        <span class="square-8 bg-warning mg-r-5 rounded-circle"></span> Payment on hold
                      </td>
                      <td>Apr 02, 2017 6:45pm</td>
                    </tr>
                    <tr>
                      <td class="pd-l-20 tx-center">
                        <img src="<%=request.getContextPath() %>/adminResources/image/img4.jpg" class="wd-36 rounded-circle" alt="Image">
                      </td>
                      <td>
                        <a href="" class="tx-inverse tx-14 tx-medium d-block">John L. Goulette</a>
                        <span class="tx-11 d-block">TRANSID: 1234567890</span>
                      </td>
                      <td class="tx-12">
                        <span class="square-8 bg-pink mg-r-5 rounded-circle"></span> Account deactivated
                      </td>
                      <td>Mar 30, 2017 10:30am</td>
                    </tr>
                    <tr>
                      <td class="pd-l-20 tx-center">
                        <img src="<%=request.getContextPath() %>/adminResources/image/img5.jpg" class="wd-36 rounded-circle" alt="Image">
                      </td>
                      <td>
                        <a href="" class="tx-inverse tx-14 tx-medium d-block">John L. Goulette</a>
                        <span class="tx-11 d-block">TRANSID: 1234567890</span>
                      </td>
                      <td class="tx-12">
                        <span class="square-8 bg-pink mg-r-5 rounded-circle"></span> Account deactivated
                      </td>
                      <td>Mar 30, 2017 10:30am</td>
                    </tr>
                  </tbody>
                </table>
              </div><!-- table-responsive -->
              <div class="card-footer tx-12 pd-y-15 bg-transparent bd-t bd-gray-200">
                <a href=""><i class="fa fa-angle-down mg-r-5"></i>View All Transaction History</a>
              </div><!-- card-footer -->
            </div><!-- card -->
          </div><!-- col-8 -->
          <div class="col-lg-4 mg-t-15 mg-sm-t-20 mg-lg-t-0">
            <div class="card pd-20">
              <h6 class="tx-12 tx-uppercase tx-inverse tx-bold mg-b-15">Sales Report</h6>
              <div class="d-flex mg-b-10">
                <div class="bd-r pd-r-10">
                  <label class="tx-12">Today</label>
                  <p class="tx-lato tx-inverse tx-bold">1,898</p>
                </div>
                <div class="bd-r pd-x-10">
                  <label class="tx-12">This Week</label>
                  <p class="tx-lato tx-inverse tx-bold">32,112</p>
                </div>
                <div class="pd-l-10">
                  <label class="tx-12">This Month</label>
                  <p class="tx-lato tx-inverse tx-bold">72,067</p>
                </div>
              </div><!-- d-flex -->
              <div class="progress mg-b-10">
                <div class="progress-bar wd-50p" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
              </div>
              <p class="tx-12 mg-b-0">Maecenas tempus, tellus eget condimentum rhoncus</p>
            </div><!-- card -->

            <ul class="list-group widget-list-group bg-info mg-t-20">
              <li class="list-group-item rounded-top-0">
                <p class="mg-b-0"><i class="fa fa-cube tx-white-7 mg-r-8"></i><strong class="tx-medium">Retina: 13.3-inch</strong> <span class="text-muted">Display</span></p>
              </li>
              <li class="list-group-item">
                <p class="mg-b-0"><i class="fa fa-cube tx-white-7 mg-r-8"></i><strong class="tx-medium">Intel Iris Graphics 6100</strong> <span class="text-muted">Graphics</span></p>
              </li>
              <li class="list-group-item">
                <p class="mg-b-0"><i class="fa fa-cube tx-white-7 mg-r-8"></i><strong class="tx-medium">500 GB</strong> <span class="text-muted">Flash Storage</span></p>
              </li>
              <li class="list-group-item">
                <p class="mg-b-0"><i class="fa fa-cube tx-white-7 mg-r-8"></i><strong class="tx-medium">3.1 GHz Intel Core i7</strong> <span class="text-muted">Processor</span></p>
              </li>
              <li class="list-group-item rounded-bottom-0">
                <p class="mg-b-0"><i class="fa fa-cube tx-white-7 mg-r-8"></i><strong class="tx-tx-medium">16 GB 1867 MHz DDR3</strong> <span class="text-muted">Memory</span></p>
              </li>
            </ul>
          </div><!-- col-4 -->
        </div><!-- row -->
 --%>
      </div> <!-- am-pagebody -->
     <%--  <jsp:include page="footer.jsp"></jsp:include> --%>
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
