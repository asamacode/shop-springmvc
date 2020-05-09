<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card">
	<div class="card-header">
		<h5>Danh sách sản phẩm</h5>
	</div>
	<!-- Product list -->
	<div class="row">
		<c:forEach var="product" items="${listProduct}">
			<div class="col-sm-4 product">
				<div class="card">
					<div class="thumbnail">
						<a href="/product/detail/${product.id}">
						<img class="col-sm-12" src="${product.image}" />
						</a>
						<div class="caption">
							<p>${product.name}</p>
							<div class="pull-right">
							<button class="btn btn-primary">
								<i class="fa fa-cart-plus" aria-hidden="true"></i>
							</button>
							<button class="btn btn-success">
								<i class="fa fa-star" aria-hidden="true"></i>
							</button>
							<button class="btn btn-info">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</button>
						</div>
							<p><span class="price">${product.price}</span></p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<!-- End product list -->