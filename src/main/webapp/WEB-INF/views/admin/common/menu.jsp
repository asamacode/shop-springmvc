<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navigation -->
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="/home/index">
			<h5>A SaMa Shop - Quản trị</h5>
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
					 <li class="nav-item dropdown">
					    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Quản lý</a>
						    <div class="dropdown-menu">
						      <a class="dropdown-item" href="/admin/category/index">Loại</a>
						      <a class="dropdown-item" href="/admin/product/index">Sản phẩm</a>
						      <a class="dropdown-item" href="/admin/customer/index">Khách hàng</a>
						      <a class="dropdown-item" href="/admin/order/index">Đơn hàng</a>					      
						    </div>
					</li>
				 <li class="nav-item dropdown">
					    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Thống kê</a>
						    <div class="dropdown-menu">
						      <a class="dropdown-item" href="/admin/inventory/index">Tồn kho theo loại</a>
						      <a class="dropdown-item" href="/admin/revenue/index">Doanh số theo loại</a>
						      <a class="dropdown-item" href="/admin/revenue/customer">Doanh số theo khách hàng</a>
						      <a class="dropdown-item" href="/admin/revenue/year">Doanh số theo năm</a>
						      <a class="dropdown-item" href="/admin/revenue/quarter">Doanh số theo quý</a>
						      <a class="dropdown-item" href="/admin/revenue/month">Doanh số theo tháng</a>					      
						    </div>
					</li>
				<li class="nav-item"><a class="nav-link" href="#">Tài khoản</a>
					
				</li>
			</ul>
		</div>
	</div>
</nav>
