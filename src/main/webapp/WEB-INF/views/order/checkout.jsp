<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">

<h2>Cart</h2>
<table class="table">
	<thead>
	<tr>
		<th scope="col">Id</th>
	    <th scope="col">Name</th>
	    <th scope="col">Price</th>
	    <th scope="col">Discount</th>
		<th scope="col">Quantity</th>
		<th scope="col">Amount</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${sessionScope['scopedTarget.cartService'].items}">
			<tr data-id="${product.id}" data-price="${product.price}" data-discount="${product.discount}">
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.discount}</td>
				<td>${product.quantity}</td>
				<td id="amount">${product.quantity * product.price * (1-p.discount)}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	<div class="col-sm-4">
	<h2>Check out</h2>
<h4>${message}</h4>
	<form:form action="/order/checkout" modelAttribute="order">
<div class="form-group">
	<label>Customer: </label>
	<form:input path="customer.id" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Order date: </label>
	<form:input path="orderDate" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Shipping address: </label>
	<form:input path="address" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Total amount: </label>
	<form:input path="amount" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Note: </label>
	<form:textarea path="description" rows="3" class="form-control" />
</div>

<div class="form-group">
	<button class="btn btn-primary">Purchase</button>
</div>
</form:form>
</div>
</div>