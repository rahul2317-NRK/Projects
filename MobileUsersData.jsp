<!DOCTYPE html>

<%@page import="com.dao.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<html lang="en" class="no-js">
   
    <head>
        <meta charset="utf-8"/>
        <title>FlameOnePage Free Template by FairTech</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta content="FlameOnePage freebie theme for web startups by FairTech SEO." name="description"/>
        <meta content="FairTech" name="author"/>
        <link href="http://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet">
        <link href="vendor/swiper/css/swiper.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/layout.min.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="favicon.ico"/>
    </head>
   
  
    <body id="body" data-spy="scroll" data-target=".header">

          <header class="header navbar-fixed-top">
              <nav class="navbar" role="navigation">
                <div class="container">
                      <div class="menu-container js_nav-item">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="toggle-icon"></span>
                        </button>

                    </div>

                    <div class="collapse navbar-collapse nav-collapse">
					
					<!--div class="language-switcher">
					  <ul class="nav-lang">
                        <li><a class="active" href="#">EN</a></li>
					    <li><a href="#">DE</a></li>
						<li><a href="#">FR</a></li>
					  </ul>
					</div---> 
					
                        <div class="menu-container">
                             <ul class="nav navbar-nav navbar-nav-right">
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="CloudServerHome.jsp">Home</a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="AddUsers.jsp">Add M.Users</a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="GetRecoveryReq.jsp">Recovery Req</a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="UsersPK1.jsp">Mobile Users PK 1</a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="CSReq.jsp">CS Req</a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="MobileUsersData.jsp">M.Users Data</a></li>
								<li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="CloudUsersInfo.jsp">M.Users Details</a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="index.html">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
			</header>
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <div class="container">
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                </ol>
            </div>

            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="img-responsive" src="img/1920x1080/01.jpg" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h1 class="carousel-title">Mobile Users Data</h1>
                    <br><br>
                  <table class="w3-table w3-blue" style="width:1150px;text-align: center;font-size: 16px;" border="1">
											<thead>
												<tr style="color: white;">
												    <th>Cloud Server Name</th>
												    <th>File ID</th>
													<th>File Name</th>
													<th>Mobile User ID</th>
													<th>Date</th>
													<th>Send</th>
												</tr>
											</thead>
											<tbody>
											
											<% 
											String uname=(String)session.getAttribute("CloudServer1");
											ResultSet r=DBConnection.getUserDataDetails(uname);
											System.out.println("uname:"+uname);
			while(r.next())
			{
					 %>
										 		<tr style="color: white;">
										 			<td><%= r.getString("cserver") %></td>
										 			<td><%= r.getString("fid") %></td>
										 			<td><%= r.getString("file") %></td>
													<td><%= r.getString("userid") %></td>
													<td><%= r.getString("date1") %></td>
					<td><a href="SendData?fid=<%= r.getString("fid") %>&&userid=<%= r.getString("userid") %>">Send</a></td>
												</tr>
					 <%
				}
											%>
											</tbody>
										</table> 
										   </div>
                            <a href="#" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Details</a>
                        </div>
                    </div>
                </div>
                </div>
                </div>
        <!-- End About -->

        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="js-back-to-top back-to-top">Top</a>

        <!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
        <!-- CORE PLUGINS -->
        <script src="vendor/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/jquery-migrate.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL PLUGINS -->
        <script src="vendor/jquery.easing.js" type="text/javascript"></script>
        <script src="vendor/jquery.back-to-top.js" type="text/javascript"></script>
        <script src="vendor/jquery.smooth-scroll.js" type="text/javascript"></script>
        <script src="vendor/jquery.wow.min.js" type="text/javascript"></script>
        <script src="vendor/swiper/js/swiper.jquery.min.js" type="text/javascript"></script>
        <script src="vendor/masonry/jquery.masonry.pkgd.min.js" type="text/javascript"></script>
        <script src="vendor/masonry/imagesloaded.pkgd.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL SCRIPTS -->
        <script src="js/layout.min.js" type="text/javascript"></script>
        <script src="js/components/wow.min.js" type="text/javascript"></script>
        <script src="js/components/swiper.min.js" type="text/javascript"></script>
        <script src="js/components/masonry.min.js" type="text/javascript"></script>

    </body>
    <!-- END BODY -->
</html>