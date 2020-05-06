<%@page import="com.personreidentification.utils.BaseMethod" %>
<div class="am-header">
      <div class="am-header-left">
        <a id="naviconLeft" href="" class="am-navicon d-none d-lg-flex"><i class="icon ion-navicon-round"></i></a>
        <a id="naviconLeftMobile" href="" class="am-navicon d-lg-none"><i class="icon ion-navicon-round"></i></a>
        <a href="index.html" class="am-logo">
        	
        </a>
      </div><!-- am-header-left -->

      <div class="am-header-right">
                <div class="dropdown dropdown-profile">
          <a href="" class="nav-link nav-link-profile" data-toggle="dropdown">
        <!-- <img src="<%=request.getContextPath() %>/adminResources/image/img3.jpg" class="wd-32 rounded-circle" alt="">   -->
             <i class="fa fa-user-circle-o user" aria-hidden="true"></i>
             
            <span class="logged-name"><span class="hidden-xs-down"><%=BaseMethod.getUserName()%></span> <i class="fa fa-angle-down mg-l-3"></i></span>
          </a>
          <div class="dropdown-menu wd-200">
            <ul class="list-unstyled user-profile-nav">
                 <li><a href="/logout"><i class="icon ion-power"></i> Sign Out</a></li>
            </ul>
          </div><!-- dropdown-menu -->
        </div><!-- dropdown -->
      </div><!-- am-header-right -->
    </div>