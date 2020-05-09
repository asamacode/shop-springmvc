<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-columns-3">
	<div class="card">
		<div class="card-header">Danh mục</div>
		<div class="card-body" style="padding: 0px;">

			<div class="list-group">
				<c:forEach var="category" items="${cates}">
					<a href="/product/list-by-category/${category.id}" class="list-group-item">${category.nameVN}</a>
				</c:forEach>
			</div>
		</div>
	</div>

</div>