<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<div class="card" style="padding: 20px">

	<div class="row">
		<div class="col-sm-5 text-center">
			<img class="detail-img" src="/resources/images/products/${product.image}" />
		</div>
		<div class="col-sm-7">
			<h2>${product.name}</h2>
			<ul class="detail-info">
				<li>Price: <f:formatNumber value="${product.price}"
						pattern="###,###,###" /> VNĐ
				</li>
				<li>Date: <f:formatDate value="${product.productDate}"
						pattern="dd/MM/yyyy" /></li>
				<li>Discount: <f:formatNumber value="${product.discount}"
						type="percent" /></li>
				<li>Quantity: ${product.quantity}</li>
				<li>View count: ${product.viewCount}</li>
				<li>Available: ${product.available?'Yes':'No'}</li>
				<li>Special: ${product.special?'Yes':'No'}</li>
			</ul>
		</div>
	</div>
	<p>${product.description}</p>

	<div class="card-header">
		<h3>Sản phẩm</h3>
	</div>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#tab1" role="tab" aria-controls="tab1" aria-selected="true">Cùng loại</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2" aria-selected="false">Yêu thích</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#tab3" role="tab" aria-controls="tab3" aria-selected="false">Đã xem</a>
  </li>
</ul>
<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="home-tab">
  	<div class="row">
			<c:forEach var="p" items="${listProduct}">
			<div class="col-xs-3">
				<a href="/product/detail/${p.id}"> <img class="thumb-img"
					src="/resources/images/products/${p.image}" />
				</a>
			</div>
		</c:forEach>
	</div>
  </div>
  <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="profile-tab">
  	<div class="row">
			<c:forEach var="p" items="${listFav}">
			<div class="col-xs-3">
				<a href="/product/detail/${p.id}"> <img class="thumb-img"
					src="/resources/images/products/${p.image}" />
				</a>
			</div>
		</c:forEach>
	</div>
  </div>
  <div class="tab-pane fade" id="tab3" role="tabpanel" aria-labelledby="contact-tab">
  	<div class="row">
			<c:forEach var="p" items="${listViewed}">
			<div class="col-xs-3">
				<a href="/product/detail/${p.id}"> <img class="thumb-img"
					src="/resources/images/products/${p.image}" />
				</a>
			</div>
		</c:forEach>
	</div>
  </div>
</div>
</div>