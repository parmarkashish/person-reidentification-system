<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Twitter -->
<meta name="twitter:site" content="@themepixels">
<meta name="twitter:creator" content="@themepixels">
<meta name="twitter:card" content="summary_large_image">
<meta name="twitter:title" content="Amanda">
<meta name="twitter:description"
	content="Premium Quality and Responsive UI for Dashboard.">
<meta name="twitter:image"
	content="http://themepixels.me/amanda/img/amanda-social.png">

<!-- Facebook -->
<meta property="og:url" content="http://themepixels.me/amanda">
<meta property="og:title" content="Bracket">
<meta property="og:description"
	content="Premium Quality and Responsive UI for Dashboard.">

<meta property="og:image"
	content="http://themepixels.me/amanda/img/amanda-social.png">
<meta property="og:image:secure_url"
	content="http://themepixels.me/amanda/img/amanda-social.png">
<meta property="og:image:type" content="image/png">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="600">

<!-- Meta -->
<meta name="description"
	content="Premium Quality and Responsive UI for Dashboard.">
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
<link href="<%=request.getContextPath() %>/adminResources/css/select2.min.css" rel="stylesheet">

<!-- Amanda CSS -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/amanda.css">
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<%-- <div class="am-pagetitle">
		<h5 class="am-title">Manage State</h5>
		<form id="searchBar" class="search-bar" action="index.html">
			<div class="form-control-wrapper">
				<input type="search" class="form-control bd-0"
					placeholder="Search...">
			</div>
			<!-- form-control-wrapper -->
			<button id="searchBtn" class="btn btn-orange">
				<i class="fa fa-search"></i>
			</button>
		</form>
		<!-- search-bar -->
	</div>
	 --%><!-- am-pagetitle -->

	<div class="am-mainpanel">
		<div class="am-pagebody">

			<div class="card pd-20 pd-sm-40">
				<h6 class="card-body-title">Manage State / Add State</h6>
				<p class="mg-b-20 mg-sm-b-30"></p>

				<f:form action="/admin/addState"
					data-parsley-validate="data-parsley-validate"
					modelAttribute="stateVO">
					<div class="wd-300">
						<div class="d-md-block mg-b-30">

							<div id="slWrapper" class="parsley-select wd-200 wd-xs-1000">
								<label>Country Name: <span class="tx-danger">*</span></label>
								<f:select class="form-control select2" path="countryVO.id"
									data-placeholder="Choose one"
									data-parsley-class-handler="#slWrapper"
									data-parsley-errors-container="#slErrorContainer"
									required="required">

									<c:forEach items="${countryList}" var="country">
										<f:option value="${country.id}">${country.countryName}</f:option>
									</c:forEach>

								</f:select>
								<div id="slErrorContainer"></div>
							</div>
							<br />
							<f:hidden path="id" />
							<div class="form-group mg-b-0">
								<label>State Name: <span class="tx-danger">*</span></label>
								<f:input path="stateName" class="form-control wd-200 wd-sm-1000"
									placeholder="Enter state name" required="required"></f:input>
							</div>
							<!-- form-group -->
							<br />
							<div class="form-group mg-b-0 mg-t-20 mg-md-t-0">
								<label>State Description: <span class="tx-danger">*</span></label>
								<f:textarea path="stateDescription"
									class="form-control wd-200 wd-sm-1000"
									placeholder="Enter state desciption"></f:textarea>
							</div>
							<!-- form-group -->
						</div>
						<!-- d-flex -->
						<input type="submit" class="btn btn-info" value="Submit">
					</div>
				</f:form>
			</div>
			<!-- card -->






		</div>
		<!-- am-pagebody -->
		<%--<jsp:include page="footer.jsp"></jsp:include> --%>
	</div>
	<!-- am-mainpanel -->

	<script src="<%=request.getContextPath() %>/adminResources/js/jquery.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/popper.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/bootstrap.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/perfect-scrollbar.jquery.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/toggles.min.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/highlight.pack.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/select2.min.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/parsley.js"></script>

	<script src="<%=request.getContextPath() %>/adminResources/js/amanda.js"></script>
	<script>
      $(function(){
        'use strict';
        $('.select2').select2({
          minimumResultsForSearch: Infinity
        });

        $('#selectForm').parsley();
      })
    </script>
</body>
</html>
