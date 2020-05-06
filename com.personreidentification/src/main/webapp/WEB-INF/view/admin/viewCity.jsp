<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    
    <title>Amanda Responsive Bootstrap 4 Admin Template</title>

    <!-- vendor css -->
    <link href="<%=request.getContextPath() %>/adminResources/css/font-awesome.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/ionicons.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/perfect-scrollbar.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/toggles-full.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/github.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/jquery.dataTables.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/adminResources/css/select2.min.css" rel="stylesheet">

    <!-- Amanda CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/amanda.css">
  </head>

  <body>

    
    
     <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
    <!-- <div class="am-pagetitle">
      <h5 class="am-title">Manage City</h5>
      <form id="searchBar" class="search-bar" action="index.html">
        <div class="form-control-wrapper">
          <input type="search" class="form-control bd-0" placeholder="Search...">
        </div>form-control-wrapper
        <button id="searchBtn" class="btn btn-orange"><i class="fa fa-search"></i></button>
      </form>search-bar
    </div> --><!-- am-pagetitle -->

    <div class="am-mainpanel">
      <div class="am-pagebody">

        <div class="card pd-20 pd-sm-40">
          <h6 class="card-body-title">Manage City / View City</h6>
          <p class="mg-b-20 mg-sm-b-30"></p>

          <div class="table-wrapper">
            <table id="datatable1" class="table-white display responsive nowrap">
              <thead>
                <tr>
                  <th class="wd-10p">City Id</th>
                  <th class="wd-10p">City Name</th>
                   <th class="wd-10p">State Name</th>
                  <th class="wd-10p">Country Name</th>           
                  <th class="wd-15p">Description</th>
                  <th class="wd-20p">Action</th>
                 
                </tr>
              </thead>
              <tbody>
                 <c:if test="${cityList ne null}">

								<c:forEach items="${cityList}" var="r" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${r.cityName}</td>
										<td>${r.stateVO.stateName}</td>
										<td>${r.countryVO.countryName}</td>
										<td>${r.cityDescription}</td>
										
										<td><a href="/admin/editCity?id=${r.id}">Edit</a> | <a
											href="/admin/deleteCity?id=${r.id}">Delete</a></td>
									</tr>

								</c:forEach>
				</c:if>
               </tbody>
            </table>
          </div><!-- table-wrapper -->
        </div><!-- card -->

       
        
        

      </div><!-- am-pagebody -->
      <%-- <jsp:include page="footer.jsp"></jsp:include> --%>
    </div><!-- am-mainpanel -->

    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/popper.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/perfect-scrollbar.jquery.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/toggles.min.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/highlight.pack.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/jquery.dataTables.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/dataTables.responsive.js"></script>
    <script src="<%=request.getContextPath() %>/adminResources/js/select2.min.js"></script>

    <script src="<%=request.getContextPath() %>/adminResources/js/amanda.js"></script>
    <script>
      $(function(){
        'use strict';

        $('#datatable1').DataTable({
          responsive: true,
          language: {
            searchPlaceholder: 'Search...',
            sSearch: '',
            lengthMenu: '_MENU_ items/page',
          }
        });

        $('#datatable2').DataTable({
          bLengthChange: false,
          searching: false,
          responsive: true
        });

        // Select2
        $('.dataTables_length select').select2({ minimumResultsForSearch: Infinity });

      });
    </script>
  </body>
</html>
