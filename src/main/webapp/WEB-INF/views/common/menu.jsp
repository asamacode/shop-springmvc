<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!-- Navigation -->
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="/home/index">
			<h5>A SaMa Shop</h5>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/home/index">
						<s:message code="lyt.menu.home" />
					 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/home/about">About</a></li>
				<li class="nav-item"><a class="nav-link" href="/home/services">Services</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/home/contact">Contact</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Account </a>
					<c:choose>
						<c:when test="${empty sessionScope.user}">
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/account/login">Đăng nhập</a> 
							<a class="dropdown-item" href="/account/register">Đăng ký</a>
							<a class="dropdown-item" href="/account/forget">Quên mật khẩu</a>
						</div>
						</c:when>
						<c:otherwise>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/account/change">Đổi mật khẩu</a>
								<a class="dropdown-item" href="/account/edit">Cập nhật tài khoản</a> 
								<a class="dropdown-item" href="/order/list">Đơn hàng</a>
								<a class="dropdown-item" href="/order/items">Hàng đã mua</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/account/logout">Đăng xuất</a>
							</div>
						</c:otherwise>
					</c:choose>	
					</li>
			</ul>

			<ul class="navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="#" data-lang="vi">Tiếng Việt</a></li>
				<li class="nav-item"><a class="nav-link" href="#" data-lang="en">English</a></li>
			</ul>
		</div>
	</div>
</nav>
<script>
    	$(function(){
    		$("a[data-lang]").click(function() {
    			var lang = $(this).attr("data-lang");
    			
    			$.ajax({
    				url: "/home/language?lang="+lang,
    				success: function() {
    					location.reload();
    				}
    			});
    			return false;
    			
    		});
    	});
</script>
