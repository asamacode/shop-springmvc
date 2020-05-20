<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Discount</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${details}">
			<tr>
				<td>${c.product.id}</td>
				<td>${c.product.name}</td>
				<td>${c.unitPrice}</td>
				<td>${c.discount}</td>
				<td>${c.quantity}</td>
				<td>${c.unitPrice * c.quantity * (1 - c.discount)}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>