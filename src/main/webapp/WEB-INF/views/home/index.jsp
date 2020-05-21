<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value='/slideshow/css/style.css' />" />
		<script src="<c:url value='/slideshow/js/modernizr.custom.63321.js' /> "></script>
		<script src="<c:url value='/slideshow/js/jquery.catslider.js' /> "></script>
<div class="list-product">

	<div id="carouselId" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselId" data-slide-to="0" class="active"></li>
			<li data-target="#carouselId" data-slide-to="1"></li>
			<li data-target="#carouselId" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="carousel-item active">
				<img
					src="https://cdn.tgdd.vn/2020/04/banner/a31-hot-800-300-800x300.png"
					alt="First slide">
			</div>
			<div class="carousel-item">
				<img
					src="https://cdn.tgdd.vn/2020/05/banner/oppoa91-800-300-800x300-1.png"
					alt="Second slide">
			</div>
			<div class="carousel-item">
				<img src="https://cdn.tgdd.vn/2020/05/banner/800-300-800x300-7.png"
					alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselId" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselId" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>
	<div class="card">
		<!-- Product list -->
		<div id="mi-slider" class="mi-slider">
			<c:forEach var="c" items="${rands}">
					<ul>
						<c:forEach var="p" items="${c.products}">
						<li><a href="/product/detail/${p.id}"><img src="/resources/images/products/${p.image}" alt="img01"><h4>${p.name}</h4></a></li>
						</c:forEach>
					</ul>
			</c:forEach>
			
			<nav>
				<c:forEach var="c" items="${rands}">
				<a href="#">${c.nameVN}</a>
				</c:forEach>
			</nav>
		</div>
			
	</div>
	<!-- End product list -->
	<jsp:include page="../product/list.jsp" />
</div>
<script>
			$(function() {

				$( '#mi-slider' ).catslider();

			});
</script>