<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Order List</h2>
<table class="table">
	<thead>
	<tr>
		<th scope="col">Id</th>
	    <th scope="col">Order date</th>
		<th scope="col">Address</th>
		<th scope="col">Amount</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="o" items="${orders}">
		<tr>
			<td>${o.id}</td>
			<td>${o.orderDate}</td>
			<td>${o.address}</td>
			<td>${o.amount}</td>
			<td>
				<a href="/order/detail/${o.id}" class="btn btn-sm btn-info">Detail</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
