<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
<title>Add Feedback</title>

<!-- vendor css -->
<link href="<%=request.getContextPath() %>/adminResources/css/font-awesome.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/ionicons.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/perfect-scrollbar.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/toggles-full.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/github.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/select2.min.css" rel="stylesheet">

<!-- Amanda CSS -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/amanda.css">
<style type="text/css">

.rating {
    float:left;
}

/* :not(:checked) is a filter, so that browsers that don’t support :checked don’t 
   follow these rules. Every browser that supports :checked also supports :not(), so
   it doesn’t make the test unnecessarily selective */
.rating:not(:checked) > input {
    position:absolute;
    top:-9999px;
    clip:rect(0,0,0,0);
}

.rating:not(:checked) > label {
    float:right;
    width:1.5em;
    padding:1em;
    overflow:hidden;
    white-space:nowrap;
    cursor:pointer;
    font-size:200%;
    line-height:1.2;
    color:#fff;
    text-shadow:1px 1px #bbb, 2px 2px #666, .1em .1em .2em rgba(0,0,0,.5);
}

.rating:not(:checked) > label:before {
    content: ' ';
}

.rating > input:checked ~ label {
    color: #f70;
    text-shadow:1px 1px #c60, 2px 2px #940, .1em .1em .2em rgba(0,0,0,.5);
}

.rating:not(:checked) > label:hover,
.rating:not(:checked) > label:hover ~ label {
    color: gold;
    text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
}

.rating > input:checked + label:hover,
.rating > input:checked + label:hover ~ label,
.rating > input:checked ~ label:hover,
.rating > input:checked ~ label:hover ~ label,
.rating > label:hover ~ input:checked ~ label {
    color: #ea0;
    text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
}

.rating > label:active {
    position:relative;
    top:2px;
    left:2px;
}

</style>
</head>

<body>


	<jsp:include page="header.jsp"></jsp:include>

	<jsp:include page="menu.jsp"></jsp:include>
	<%-- <div class="am-pagetitle">
		<h5 class="am-title">Manage Feedback</h5>
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
	</div> --%>
	<!-- am-pagetitle -->

	<div class="am-mainpanel">
		<div class="am-pagebody">

			<div class="card pd-20 pd-sm-40">
				<h6 class="card-body-title">Post Feedback / Send Feedback</h6>
				<p class="mg-b-20 mg-sm-b-30"></p>

				<f:form action="/client/addFeedback"
					data-parsley-validate="data-parsley-validate"
					modelAttribute="feedbackVO" enctype="multipart/form-data">
					<div class="wd-300">
						<f:hidden path="id" />
						<div class="d-md-block mg-b-30">
							
							<div class="form-group mg-b-0 mg-t-20 mg-md-t-0">
								<label>Feedback: <span class="tx-danger">*</span></label>
								<f:textarea path="feedback"
									class="form-control wd-200 wd-sm-1000"
									placeholder="Enter feedback here"></f:textarea>
							</div>
							<br/>
							<div class="rating">
								Rating:
								<br/>
								<f:radiobutton id="star5" path="rating" value="5" />
								<label for="star5" title="Rocks!"><span
									class="fa fa-star checked"></span></label>
								<f:radiobutton id="star4" path="rating" value="4" />
								<label for="star4" title="Pretty good"><span
									class="fa fa-star checked"></span></label>
								<f:radiobutton id="star3" path="rating" value="3" />
								<label for="star3" title="Meh"><span
									class="fa fa-star checked"></span></label>
								<f:radiobutton id="star2" path="rating" value="2" />
								<label for="star2" title="Kinda bad"><span
									class="fa fa-star checked"></span></label>
								<f:radiobutton id="star1" path="rating" value="1" />
								<label for="star1" title="Sucks big time"><span
									class="fa fa-star checked"></span></label>
							</div>

						</div>
						<br/>
						<br/>
						<br/>
						<!-- d-flex -->
						<!-- <button type="submit" class="btn btn-info">Save</button> -->
						<input type="submit" class="btn btn-info" value="Submit">
					</div>
				</f:form>
			</div>
			<!-- card -->

		</div>
		<%--  <jsp:include page="footer.jsp"></jsp:include> --%>
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

</body>
</html>
