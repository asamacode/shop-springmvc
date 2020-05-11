
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="#">
			<h4>A SaMa Shop</h4>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/home/index">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/home/about">About</a></li>
				<li class="nav-item"><a class="nav-link" href="/home/services">Services</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/home/contact">Contact</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Account </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/account/login">Đăng nhập</a> 
						<a class="dropdown-item" href="/account/register">Đăng ký</a>
						<a class="dropdown-item" href="#">Quên mật khẩu</a>
						<a class="dropdown-item" href="#">Đổi mật khẩu</a>
						<a class="dropdown-item" href="#">Cập nhật tài khoản</a>
						<a class="dropdown-item" href="#">Đơn hàng</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="/account/logout">Đăng xuất</a>
					</div></li>
			</ul>

			<ul class="navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="#">Tiếng
						Việt</a></li>
				<li class="nav-item"><a class="nav-link" href="#">English</a></li>
			</ul>
		</div>
	</div>
</nav>
