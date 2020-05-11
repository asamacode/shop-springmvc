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
							<div class="pull-right" data-id="${product.id}">
							<button class="btn btn-primary">
								<i class="fa fa-cart-plus btn-add-to-cart" aria-hidden="true"></i>
							</button>
							<button class="btn btn-success btn-star">
								<i class="fa fa-star" aria-hidden="true"></i>
							</button>
							<button class="btn btn-info btn-open-dialog" data-toggle="modal" data-target="#exampleModal">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</button>
						</div>
							<p><span class="price">${product.price}</span></p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<jsp:include page="dialog.jsp"></jsp:include>
		
	</div>
</div>
<!-- End product list -->