<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<div class="row">
	<h2>REVENUE</h2>
	<jsp:include page="_revenue_customer_chart.jsp"></jsp:include>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Customer</th>
				<th>Quantity</th>
				<th>Value</th>
				<th>Min Price</th>
				<th>Max Price</th>
				<th>Average Price</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${data}">
			<tr>
				<td>${c[0]}</td>
				<td>${c[1]}</td>
				<td><f:formatNumber value="${c[2]}" pattern="###,###,###" /> VNĐ</td>
				<td><f:formatNumber value="${c[3]}" pattern="###,###,###" /> VNĐ</td>
				<td><f:formatNumber value="${c[4]}" pattern="###,###,###" /> VNĐ</td>
				<td><f:formatNumber value="${c[5]}" pattern="###,###,###.00" /> VNĐ</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>