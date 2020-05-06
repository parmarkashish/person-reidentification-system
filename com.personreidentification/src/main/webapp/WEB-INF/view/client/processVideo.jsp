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

<title>Process Video</title>

<!-- vendor css -->
<link href="<%=request.getContextPath() %>/adminResources/css/font-awesome.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/ionicons.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/perfect-scrollbar.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/toggles-full.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/github.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/adminResources/css/select2.min.css" rel="stylesheet">

<!-- Amanda CSS -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/amanda.css">

<style>
	.lds-ring {
  display: inline-block;
  position: relative;
  width: 80px;
  height: 80px;
}
.lds-ring div {
  box-sizing: border-box;
  display: block;
  position: absolute;
  width: 64px;
  height: 64px;
  margin: 8px;
  border: 8px solid #fff;
  border-radius: 50%;
  animation: lds-ring 1.2s cubic-bezier(0.5, 0, 0.5, 1) infinite;
  border-color: #57b957 transparent transparent transparent;
 	position: absolute;
    left: 50%;
    top: 20%;
}
.lds-ring div:nth-child(1) {
  animation-delay: -0.45s;
}
.lds-ring div:nth-child(2) {
  animation-delay: -0.3s;
}
.lds-ring div:nth-child(3) {
  animation-delay: -0.15s;
}
@keyframes lds-ring {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

</style>
	
</head>

<body onload="callService()">


	<jsp:include page="header.jsp"></jsp:include>

	<jsp:include page="menu.jsp"></jsp:include>
	<%-- <div class="am-pagetitle">
		<h5 class="am-title">Manage Comaplain</h5>
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
				<h6 class="card-body-title">Manage Video / Process Video</h6>
					<div id="notice">Do not press any link.</div>
					
				<div class="lds-ring" id="loader"><div></div><div></div><div></div><div></div></div>
			</div>
			
			<!-- card -->
			
			

		</div>
		<%--  <jsp:include page="footer.jsp"></jsp:include> --%>
	</div>
	<!-- am-mainpanel -->
	<script type="text/javascript"> 
	
		function callService(){
			var data="${videoVO.getInputLink()}";
			
			$.ajax({
	            url: 'http://127.0.0.1:5000/reid?videopath='+data,
	            type: "GET",
	            success: function (response) {
	            	onsucess(response);  
	            },
	            error: function () {
	               onerror();
	            }
	        });
		}
		
		function onsucess(response){
						
			var id="${videoVO.getId()}"
			$.ajax({
        	    url: "/client/processVideo?id="+id+"&link="+response
        	});
        	window.open ("/client/loadVideo",'_self',true);  
		}
		
		function onerror(){
			
			var id="${videoVO.getId()}"
			$.ajax({
        	    url: "/client/deleteVideo?id="+id
        	});
			document.getElementById("notice").innerHTML = "Error! try again.";
			document.getElementById("loader").style.display = "none";
		}
		
		
 	//+${model.videoVO.inputLink}	 
	</script>  
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
