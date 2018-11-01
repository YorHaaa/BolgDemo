<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Dao.ArticleDao.ArticleDaoImpl"%>
<%@ page import="Entity.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.bind.annotation.SessionAttribute" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- META DATA -->
	<meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="Free Bootstrap Themes by HTML5XCSS3 dot com - Free Responsive Html5 Templates">
    <meta name="author" content="#">

	<title></title>
  
	<!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css"  type="text/css">
	
	<!-- Owl Carousel Assets -->
    <link href="../owl-carousel/owl.carousel.css" rel="stylesheet">
    <!-- <link href="owl-carousel/owl.theme.css" rel="stylesheet"> -->
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="../css/style.css">
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="../font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Asap:400,700' rel='stylesheet' type='text/css'>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="../js/html5shiv.js"></script>
        <script src="../js/respond.min.js"></script>
    <![endif]-->
	
</head>

 <body class="index-page">

	<!-- /////////////////////////////////////////Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
				<a class="navbar-brand page-scroll" href="index.jsp"><font face="微软雅黑"><%=session.getAttribute("username")%>的博客</font></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<li>
						<a class="page-scroll" href="index.jsp"><font face="微软雅黑">首页</font></a>
                    </li>
					<li>
						<a class="page-scroll" href="archive.jsp"><font face="微软雅黑">我的文章</font></a>
                    </li>
                    <li>
                        <%
                            if (session.getAttribute("username") == null){
                        %>
                        <%
                        }
                        else
                        {
                        %>
						<a class="page-scroll" href="add.jsp"><font face="微软雅黑">写文章</font></a>
                        <%
                            }
                        %>
                    </li>
                    <li>
                        <%
                            if (session.getAttribute("username") == null){
                        %>
						<a class="page-scroll" href="login.jsp"><font face="微软雅黑">登录</font></a>
                        <%
                            }
                            else
                            {
                        %>
                        <%
                            }
                        %>
                    </li>
					<li>
                        <%
                            if (session.getAttribute("username") == null){
                        %>
                        <%
                            }
                            else
                            {
                        %>
						<a class="page-scroll" href="info.jsp"><font face="微软雅黑">修改个人信息</font></a>
                        <%
                            }
                        %>
					</li>
                    <li>
                        <%
                            if (session.getAttribute("username") == null){
                        %>

                        <%
                        }
                        else
                        {
                        %>
						<a class="page-scroll" href="logout.jsp"><font face="微软雅黑">注销</font></a>
                        <%
                            }
                        %>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
	<!-- Navigation -->
	<!-- CAROUSEL -->
	<div id="carousel-example-generic" class="carousel slide hidden-xs" data-ride="carousel" data-interval="4000">
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="/images/banner1.jpg" alt="..." height="1920" width="1080">
				<!-- Static Header -->
				<div class="container">
				<div class="header-text hidden-xs">
					<div class="col-md-12 text-center">
						<h1>欢迎登陆</h1>
						<hr>
						<p><font face="微软雅黑">你好，<%=session.getAttribute("username")%> </font></p>
					</div>
				</div><!-- /header-text -->
				</div>
			</div>
			<div class="item">
				<img src="/images/banner2.jpg" alt="..." height="1920" width="1080">
				<!-- Static Header -->
				<div class="header-text hidden-xs">
					<div class="col-md-12 text-center">
						<h1>博客系统</h1>
						<hr>
						<p><font face="微软雅黑">施工中...</font>
						</p>
						<br>
					</div>
				</div><!-- /header-text -->
			</div>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div> <!-- Carousel -->
	
	<header class="container">
		<div class="site-branding">
			<h1 class="site-title">
				<a href="index.jsp">
					<span><%=session.getAttribute("username")%>的博客</span>
				</a>
			</h1>
			<h2 class="site-description">欢迎呀 !</h2>
		</div>
		<div class="social-links">
			<ul class="list-inline">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-vimeo"></i></a></li>
				<li><a href="#"><i class="fa fa-rss"></i></a></li>
			</ul>
		</div>
	</header>
    
	
	<!-- /////////////////////////////////////////Content -->
	<div id="page-content">
	
		<!-- ////////////Content Box 01 -->
		<section class="box-content box-1">
			<div class="container">
				<div class="row">
                        <%
                        ArticleDaoImpl articleDao = new ArticleDaoImpl();
                        List<Article> article = articleDao.findall();
                        request.setAttribute("Art",article);
                        %>
                        <c:forEach var="article" items="${requestScope.Art}">
					<div class="col-md-4">
                            <div class="box-item">
                                <div class="content">
                                    <h3>${article.title}</h3>
                                    <a href="single.jsp?id=${article.id}">更多...</a>
                                    <br><br>
                                    <span>${article.pub_date}</span><br>
                                </div>
                            </div>
					</div>
                        </c:forEach>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- FOOTER -->
	<footer>
		<div class="wrap-footer">
			<div class="container">
				<div class="row"> 
					<div class="col-footer col-md-3">
						<h2 class="footer-title"><font face="微软雅黑">关于我</font></h2>
						<div class="textwidget">null
						</div>
					</div> 

					<div class="col-footer col-md-3">
						<h2 class="footer-title"><font face="微软雅黑">标签</font></h2>
						<div class="footer-tags">
							<a href="#"><font face="微软雅黑">建设中...</font></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="bottom-footer">
			<div class="container">
				<div class="row">
					
					<div class="col-md-4">
						<ul class="list-inline social-buttons">
							<li><a href="#"><i class="fa fa-twitter"></i></a>
							</li>
							<li><a href="#"><i class="fa fa-facebook"></i></a>
							</li>
							<li><a href="#"><i class="fa fa-linkedin"></i></a>
							</li>
							<li><a href="#"><i class="fa fa-pinterest"></i></a>
							</li>
						</ul>
					</div>
					<div class="col-md-4">
						<ul class="list-inline quicklinks">
							<li><font color="black" face="微软雅黑"><%=session.getAttribute("username")%>的博客</font>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
 
	<!-- jQuery -->
	<script type="text/javascript" src="../js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="../js/agency.js"></script>
	<!-- Plugin JavaScript -->
	<script src="../js/jquery.easing.min.js"></script>
	<script src="../js/classie.js"></script>
	<script src="../js/cbpAnimatedHeader.js"></script>
	<script src="../js/cbpAnimatedHeader.js"></script>
	<script src="../js/cbpAnimatedHeader.js"></script>
</body>
</html>