<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-columns-3">
	<div class="card">
		<div class="card-header">Danh mục</div>
		<div class="card-body" style="padding: 0px;">

			<div class="list-group">
				<c:forEach var="category" items="${cates}">
					<a href="/product/list-by-category/${category.id}"
						class="list-group-item">${category.nameVN}</a>
				</c:forEach>
			</div>
		</div>
	</div>

	<div class="card">
		<div class="card-header">Đặc biệt</div>
		<div class="card-body" style="padding: 0px;">

			<div class="list-group">

				<a href="/product/list-by-special/0" class="list-group-item">Hàng mới</a>
				<a href="/product/list-by-special/1" class="list-group-item">Bán chạy</a>
				<a href="/product/list-by-special/2" class="list-group-item">Xem nhiều</a>
				<a href="/product/list-by-special/3" class="list-group-item">Giảm giá</a>
			</div>
		</div>
	</div>

</div>